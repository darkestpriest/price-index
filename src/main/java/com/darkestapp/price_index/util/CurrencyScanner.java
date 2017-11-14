package com.darkestapp.price_index.util;

import com.darkestapp.price_index.annotation.Supported;
import com.darkestapp.price_index.exceptions.PriceIndexException;
import org.reflections.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.reflections.ReflectionUtils.withAnnotation;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public class CurrencyScanner {

    private static final String EXCEPTION_MESSAGE = "An error has occurred scanning the api objects";

    private CurrencyScanner() {
        //Just to avoid public instantiation.
    }

    /**
     * Returns a List with the codes retrieved from the currency Class.
     * This list contains all the enum parameters marked with the annotation Supported using its default value.
     * @param currency enum that contains the currency code
     * @param context The class that executes this object.
     * @return
     * @throws PriceIndexException
     */
    public static List<String> getSupportedCurrencyCodeList(
            Class currency,
            Class context) throws PriceIndexException{

        try {

            Set<Field> enumElements =
                    ReflectionUtils.getAllFields(
                            currency,
                            withAnnotation(Supported.class));

            List<String> codeList = new ArrayList<>();
            for(Field field : enumElements) {
                if(getAnnotation(field).value()) {

                    codeList.add(field.getName());
                }
            }

            return codeList;
        } catch (Exception e) {
            throw new PriceIndexException(
                    EXCEPTION_MESSAGE,
                    e,
                    context.getSimpleName(),
                    "An error has occurred while scanning the CoindeskCurrency Code List");
        }
    }

    private static Supported getAnnotation(Field field) {
        Annotation annotation = field.getAnnotation(Supported.class);
        return (Supported) annotation;
    }
}
