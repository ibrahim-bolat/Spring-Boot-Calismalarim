package com.minios3.service;

import io.minio.*;
import io.minio.messages.Item;
import io.minio.PutObjectOptions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;


import java.io.*;
import java.util.LinkedList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MinioS3Service {

    private final MinioClient minioClient;

    public void uploadFile(String bucketName, String originalFilename, byte[] bytes) throws Exception {
        File file = upload(bucketName, originalFilename, bytes);
        minioClient.putObject(bucketName, originalFilename, new FileInputStream(file), new PutObjectOptions(file.length(), -1));

    }


    public byte[] downloadFile(String bucketName, String fileUrl) throws Exception {
        return getFile(bucketName, fileUrl);
    }

    public void deleteFile(String bucketName, String fileUrl) throws Exception {
        minioClient.removeObject(bucketName, fileUrl);
    }


    public List<String> listFiles(String bucketName) throws Exception {
        List<String> list = new LinkedList<>();
        Iterable<Result<Item>> buckets = minioClient.listObjects(bucketName);
        for (Result<Item> itemResult : buckets) {
            Item item = itemResult.get();
            System.out.println(item.userMetadata());
            System.out.println(item.objectName());
            System.out.println(item.storageClass());
            list.add(item.objectName());
        }
        return list;
    }


    public File upload(String bucketName, String name, byte[] content) throws Exception {
        File file = new File("/tmp/" + name);
        file.canWrite();
        file.canRead();
        FileOutputStream iofs = null;
        iofs = new FileOutputStream(file);
        iofs.write(content);
        return file;
    }

    public byte[] getFile(String bucketName, String key) throws Exception {
        InputStream stream = minioClient.getObject(bucketName, key);
        try {
            byte[] content = IOUtils.toByteArray(stream);
            stream.close();
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
