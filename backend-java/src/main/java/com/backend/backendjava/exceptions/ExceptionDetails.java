package com.backend.backendjava.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionDetails {
    private LocalDateTime localDateTime;
    private Integer status;
    private String message;
    private String path;
}
