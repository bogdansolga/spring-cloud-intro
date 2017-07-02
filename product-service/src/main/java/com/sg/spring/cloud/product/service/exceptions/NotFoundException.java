package com.sg.spring.cloud.product.service.exceptions;

/**
 * A runtime exception thrown when an entity was not found
 *
 * @author bogdan.solga
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(final String message) {
        super(message);
    }
}
