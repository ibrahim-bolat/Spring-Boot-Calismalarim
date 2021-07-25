package com.fileuploadmongogridfs.api;

import com.fileuploadmongogridfs.model.FileModel;
import com.fileuploadmongogridfs.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileApi {


    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileService.addFile(file));
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
        FileModel fileModel = fileService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileModel.getFileType() ))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileModel.getFilename() + "\"")
                .body(new ByteArrayResource(fileModel.getFile()));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) throws IOException {
        fileService.deleteFile(id);
        return ResponseEntity.ok().build();
    }

}
