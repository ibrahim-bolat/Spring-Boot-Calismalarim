package com.minios3.config;


import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioS3Config {

    @Value("${minio.s3.url}")
    private String minioUrl;
    @Value("${minio.s3.access-key}")
    private String accessKey;
    @Value("${minio.s3.secret-key}")
    private String secretKey;

    @Bean
    public MinioClient mClient() throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(minioUrl, accessKey, secretKey);
    }
}
