package com.transactionalmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseModel {
    private LocalDateTime timeStamp;
    private String exceptionCode;
    private String exceptionMessage;
}
