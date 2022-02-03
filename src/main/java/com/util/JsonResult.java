package com.util;

import java.io.Serializable;

// Json response model

public class JsonResult<E> implements Serializable {
    // Result Code
    private Integer state;
    // Result Message
    private String message;

    private E data;

    public JsonResult() {

    }

    public JsonResult(Integer state) {
        this.state = state;
    }
    public JsonResult(Throwable e){
        this.message = e.getMessage();
    }
    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
