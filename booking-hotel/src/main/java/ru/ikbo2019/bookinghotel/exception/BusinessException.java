package ru.ikbo2019.bookinghotel.exception;

/**
 * todo Document type BusinessException
 */
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
