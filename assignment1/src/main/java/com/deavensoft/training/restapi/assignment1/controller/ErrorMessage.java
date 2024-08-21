package com.deavensoft.training.restapi.assignment1.controller;

import java.time.OffsetDateTime;

public class ErrorMessage {
    private int statusCode;
    private OffsetDateTime timestamp;
    private String message;
    private String description;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // implement builder pattern
    public static class ErrorMessageBuilder {
        private int statusCode;
        private OffsetDateTime timestamp;
        private String message;
        private String description;

        public ErrorMessageBuilder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ErrorMessageBuilder timestamp(OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorMessageBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorMessageBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ErrorMessage build() {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setStatusCode(statusCode);
            errorMessage.setTimestamp(timestamp);
            errorMessage.setMessage(message);
            errorMessage.setDescription(description);
            return errorMessage;
        }
    }

    public static ErrorMessageBuilder builder() {
        return new ErrorMessageBuilder();
    }


    @Override
    public String toString() {
        return "ErrorMessage{" +
                "statusCode=" + statusCode +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
