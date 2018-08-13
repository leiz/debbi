package org.dl.debbi.common.error;

public class DebbiException extends RuntimeException {

    private ErrorType type;
    private String data;

    public DebbiException() {
    }

    public DebbiException(ErrorType type) {
        super(type.getCode() + " " + type.getName());
        this.type = type;
    }

    public DebbiException(ErrorType type, String data) {
        super(type.getCode() + " " + type.getName());
        this.type = type;
        this.data = data;
    }

    public static DebbiException of(ErrorType errorType) {
        return new DebbiException(errorType);
    }

    public static DebbiException of(ErrorType errorType, String data) {
        return new DebbiException(errorType, data);
    }
}