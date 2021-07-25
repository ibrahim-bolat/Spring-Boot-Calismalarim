package com.awss3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.LinkedList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AWSS3Service {

    private final AmazonS3 s3;

    public void uploadFile(String bucketName, String originalFilename, byte[] bytes) throws Exception {
        File file = upload(bucketName, originalFilename, bytes);
        s3.putObject(bucketName, originalFilename, file);

    }


    public byte[] downloadFile(String bucketName, String fileUrl) throws Exception {
        return getFile(bucketName, fileUrl);
    }


    public void deleteFile(String bucketName, String fileUrl) throws Exception {
        s3.deleteObject(bucketName, fileUrl);
    }

    public List<String> listFiles(String bucketName) throws Exception {
        List<String> list = new LinkedList<>();
        s3.listObjects(bucketName).getObjectSummaries().forEach(itemResult -> {
            list.add(itemResult.getKey());
            System.out.println(itemResult.getKey());
        });
        return list;
    }


    public File upload(String bucketName, String name, byte[] content) throws Exception{
        File file = new File("/tmp/" + name);
        file.canWrite();
        file.canRead();
        FileOutputStream iofs = null;
        iofs = new FileOutputStream(file);
        iofs.write(content);
        return file;
    }


    public byte[] getFile(String bucketName, String key) throws Exception {
        S3Object obj = s3.getObject(bucketName, key);
        S3ObjectInputStream stream = obj.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(stream);
            obj.close();
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}