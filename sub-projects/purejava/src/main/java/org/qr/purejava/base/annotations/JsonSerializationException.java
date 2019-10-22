package org.qr.purejava.base.annotations;

public class JsonSerializationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public JsonSerializationException(String message) {
        super(message);
    }
}