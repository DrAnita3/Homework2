package com.progmatic.homework.Homework2.returnModels;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class ReturnModel<T> {

    @Getter
    @Setter
    private boolean success;

    @Getter
    @Setter
    private HttpStatus statusCode;

    @Getter
    @Setter
    private T object;

    public ReturnModel() {
        success = true;
        statusCode = HttpStatus.OK;
    }

    private ReturnModel (boolean success, HttpStatus statusCode, T object) {
        this.success = success;
        this.statusCode = statusCode;
        this.object = object;
    }



}
