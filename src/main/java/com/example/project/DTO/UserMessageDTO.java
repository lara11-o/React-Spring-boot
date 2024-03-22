package com.example.project.DTO;

public class UserMessageDTO {
    public String message;

    public UserMessageDTO(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public boolean success;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
