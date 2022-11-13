package com.reservekeys.reservekeys.exceptions.advice;


import com.reservekeys.reservekeys.exceptions.service.ServiceException;
import com.reservekeys.reservekeys.exceptions.service.SeviceErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ControllerAdviceApi {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<SeviceErro> resourceNotFound(ServiceException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        SeviceErro err = new SeviceErro(String.valueOf(status), e.getMessage());
        return ResponseEntity.status(status).body(err);
    }

}
