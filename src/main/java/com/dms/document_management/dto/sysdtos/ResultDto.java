package com.dms.document_management.dto.sysdtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ResultDto<T> {

    private final boolean success;
    private final T data;
    private final String errorMessage;

    private ResultDto(boolean success, T data, String errorMessage) {
        this.success = success;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public static <T> ResultDto<T> success(T data) {
        Objects.requireNonNull(data, "Data must not be null for a successful result.");
        return new ResultDto<>(true, data, null);
    }

    public static <T> ResultDto<T> failure(String errorMessage) {
        Objects.requireNonNull(errorMessage, "Error message must not be null for a failed result.");
        return new ResultDto<>(false, null, errorMessage);
    }

}
