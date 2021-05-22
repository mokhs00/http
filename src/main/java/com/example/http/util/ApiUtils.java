package com.example.http.util;

import org.springframework.http.HttpStatus;

public class ApiUtils {

    public static <T> ApiResult<T> success(T response) {
        return new ApiResult<>(true, response, null);
    }

    public static ApiResult<?> error(Throwable throwable, HttpStatus status) {
        return new ApiResult<>(false, null, new ApiError(throwable, status));
    }

    public static ApiResult<?> error(String massage, HttpStatus status) {
        return new ApiResult<>(false, null, new ApiError(massage, status));
    }


    public static class ApiResult<T> {
        private final boolean success;
        private final T response;
        private final ApiError error;

        public ApiResult(boolean success, T response, ApiError error) {
            this.success = success;
            this.response = response;
            this.error = error;
        }

        public boolean isSuccess() {
            return success;
        }

        public T getResponse() {
            return response;
        }

        public ApiError getError() {
            return error;
        }

        @Override
        public String toString() {
            return "ApiResult{" +
                    "success=" + success +
                    ", response=" + response +
                    ", error=" + error +
                    '}';
        }
    }

    public static class ApiError {
        private final String message;
        private final HttpStatus status;

        public ApiError(String message, HttpStatus status) {
            this.message = message;
            this.status = status;
        }

        public ApiError(Throwable throwable, HttpStatus status) {
            this(throwable.getMessage(), status);
        }

        public String getMessage() {
            return message;
        }

        public HttpStatus getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "ApiError{" +
                    "message='" + message + '\'' +
                    ", status=" + status +
                    '}';
        }
    }
}

