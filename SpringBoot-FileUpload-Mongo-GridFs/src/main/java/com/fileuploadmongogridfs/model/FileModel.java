package com.fileuploadmongogridfs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileModel {
    private String filename;
    private String fileType;
    private String fileSize;
    private byte[] file;
}
