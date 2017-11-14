package com.darkestapp.price_index.exceptions;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 07/11/17.
 */
public class ParseException extends PriceIndexException {

    private static final String DEFAULT_MESSAGE = "Cannot parse data";

    public ParseException(Exception cause, String context, String possibleReason) {
        super(DEFAULT_MESSAGE, cause, context, possibleReason);
    }

    public ParseException(String context, String possibleReason) {
        super(DEFAULT_MESSAGE, null, context, possibleReason);
    }
}
