package com.minios3.controller;


import com.minios3.service.MinioS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/minio")
public class MinioS3Controller {

    private final MinioS3Service minioS3Service;


    @PostMapping(value = "/{bucketName}/files", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Map<String, String> upload(@PathVariable("bucketName") String bucketName, @RequestPart(value = "file") MultipartFile files) throws Exception {
        minioS3Service.uploadFile(bucketName, files.getOriginalFilename(), files.getBytes());
        Map<String, String> result = new HashMap<>();
        result.put("key", files.getOriginalFilename());
        return result;
    }

    @GetMapping(value = "/{bucketName}/{keyName}", consumes = "application/octet-stream")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("bucketName") String bucketName, @PathVariable("keyName") String keyName) throws Exception {
        byte[] data = minioS3Service.downloadFile(bucketName, keyName);
        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + keyName + "\"")
                .body(resource);
    }

    @DeleteMapping("/{bucketName}/files/{keyName}")
    public void delete(@PathVariable("bucketName") String bucketName, @PathVariable(value = "keyName") String keyName) throws Exception {
        minioS3Service.deleteFile(bucketName, keyName);
    }

    @GetMapping("/{bucketName}/files")
    public List<String> listObjects(@PathVariable("bucketName") String bucketName) throws Exception {
        return minioS3Service.listFiles(bucketName);
    }
}
