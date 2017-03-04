package com.sfl.coolmonkey.translations.service.common.exception;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/25/16
 * Time: 8:05 PM
 */
public class ServicesRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -8710986180320271380L;

    public ServicesRuntimeException(final Throwable cause) {
        super(cause);
    }

    public ServicesRuntimeException(final String message) {
        super(message);
    }

    public ServicesRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }
}