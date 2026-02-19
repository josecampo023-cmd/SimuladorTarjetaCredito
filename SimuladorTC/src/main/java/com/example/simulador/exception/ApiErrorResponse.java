package com.example.simulador.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class ApiErrorResponse {
    private Meta meta;
    private int status;
    private String title;
    private List<ErrorDetail> errors;

    public ApiErrorResponse(HttpStatus httpStatus, List<ErrorDetail> errors) {
        this.meta = new Meta(UUID.randomUUID().toString(), ZonedDateTime.now(), "simulador-api");
        this.status = httpStatus.value();
        this.title = httpStatus.getReasonPhrase();
        this.errors = errors;
    }

    // Getters y setters
    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ErrorDetail> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDetail> errors) {
        this.errors = errors;
    }

    public static class Meta {
        private String _messageId;
        private ZonedDateTime _requestDateTime;
        private String _applicationId;

        public Meta(String messageId, ZonedDateTime requestDateTime, String applicationId) {
            this._messageId = messageId;
            this._requestDateTime = requestDateTime;
            this._applicationId = applicationId;
        }

        public String get_messageId() {
            return _messageId;
        }

        public void set_messageId(String _messageId) {
            this._messageId = _messageId;
        }

        public ZonedDateTime get_requestDateTime() {
            return _requestDateTime;
        }

        public void set_requestDateTime(ZonedDateTime _requestDateTime) {
            this._requestDateTime = _requestDateTime;
        }

        public String get_applicationId() {
            return _applicationId;
        }

        public void set_applicationId(String _applicationId) {
            this._applicationId = _applicationId;
        }
    }

    public static class ErrorDetail {
        private String code;
        private String detail;

        public ErrorDetail(String code, String detail) {
            this.code = code;
            this.detail = detail;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
