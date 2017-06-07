package com.thieunv.business.service.entity;

/**
 * Created by thieunv on 07/06/2017.
 */
import java.util.List;

public class ServiceResult<T> {

    private T data;
    private boolean successful;
    private List<String> messages;
    private String message;


    public ServiceResult(T data, boolean successful, String message) {
        super();
        this.data = data;
        this.successful = successful;
        this.message = message;
    }
    public ServiceResult(T data, boolean successful) {
        super();
        this.data = data;
        this.successful = successful;
    }
    public ServiceResult() {

    }

    public ServiceResult(T data, boolean successful, List<String> messages) {
        super();
        this.data = data;
        this.successful = successful;
        this.messages = messages;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
