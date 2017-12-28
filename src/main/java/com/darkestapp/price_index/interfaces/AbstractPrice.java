package com.darkestapp.price_index.interfaces;

import com.darkestapp.price_index.exceptions.PriceIndexException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.math.BigDecimal;

public abstract class AbstractPrice implements Price {

    protected static void setParameter(
            String parameter,
            JSONObject marketPrices,
            Price price) throws PriceIndexException {
        Class coindeskPriceClass = price.getClass();
        try {
            String value = marketPrices.get(parameter).toString();
            Method method = price.getClass().getMethod(
                    "set"+toUpperCaseFirstChar(parameter),
                    String.class);
            method.invoke(price, value);
        } catch (Exception e) {
            throw new PriceIndexException(
                    "Parsing error",
                    e,
                    coindeskPriceClass.getSimpleName(),
                    "Cannot get the " + parameter +" from " + marketPrices);
        }
    }

    private static String toUpperCaseFirstChar(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
