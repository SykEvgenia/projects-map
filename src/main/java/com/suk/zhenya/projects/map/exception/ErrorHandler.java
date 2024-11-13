package com.suk.zhenya.projects.map.exception;

import com.suk.zhenya.projects.map.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {GroupNotFoundException.class, ProjectNotFoundException.class,
            MethodArgumentNotValidException.class})
    public ErrorDto handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return new ErrorDto(ex.getMessage());
    }
}
