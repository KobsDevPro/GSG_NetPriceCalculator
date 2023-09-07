package com.gsg.calculator.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorDto {
    private Date timestamp;
    private int status;
    private String path;
    private List<String> errors = new ArrayList<>();

    public void addError(String message) {
        this.errors.add(message);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
