package com.fileuploadmongogridfs.service;

import com.fileuploadmongogridfs.model.FileModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class FileService {


    private final GridFsTemplate template;

    private final GridFsOperations operations;

    public String addFile(MultipartFile file) throws IOException {

        DBObject customMetaData = new BasicDBObject();
        customMetaData.put("fileSize", file.getSize());
        customMetaData.put("filename", file.getOriginalFilename());
        customMetaData.put("contentType", file.getContentType());
        customMetaData.put("size", file.getSize());
        customMetaData.put("userId", UUID.randomUUID().toString());
        Object fileID = template.store(file.getInputStream(),file.getOriginalFilename(),file.getContentType(),customMetaData);
        return fileID.toString();
    }


    public FileModel downloadFile(String id) throws IOException {
        GridFSFile gridFSFile = template.findOne( new Query(Criteria.where("_id").is(id)) );
        FileModel fileModel = new FileModel();
        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            fileModel.setFilename( gridFSFile.getFilename() );
            fileModel.setFileType( gridFSFile.getMetadata().get("_contentType").toString() );
            fileModel.setFileSize( gridFSFile.getMetadata().get("fileSize").toString() );
            fileModel.setFile( IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()) );
        }

        return fileModel;
    }
    public void deleteFile(String id) throws IOException {
        template.delete( new Query(Criteria.where("_id").is(id)) );
    }
}