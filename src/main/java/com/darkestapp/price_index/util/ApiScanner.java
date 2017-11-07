package com.darkestapp.price_index.util;

import com.darkestapp.price_index.annotation.Api;
import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.PriceIndexApi;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.darkestapp.price_index.config.Constants.API_CLASSPATH;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public class ApiScanner {

    private static final String CONTEXT = ApiScanner.class.getSimpleName();
    private static final String EXCEPTION_MESSAGE = "An error has occurred scanning the api objects";

    private ApiScanner() {
        //Just to avoid public instantiation
    }

    public static List<PriceIndexApi> getAvailableApiList() throws PriceIndexException {

        Reflections reflections = new Reflections(API_CLASSPATH);
        Set<Class<?>> apiClasses =
                reflections.getTypesAnnotatedWith(Api.class);

        return retrieveClasses(apiClasses);

    }

    private static List<PriceIndexApi> retrieveClasses(Set<Class<?>> apiClasses)
            throws PriceIndexException {

        Api apiEnabled;

        List<PriceIndexApi> apiList = new ArrayList<>();

        for(Class apiClass : apiClasses) {

            apiEnabled = getAnnotation(apiClass);
            if(apiEnabled.enabled()) {

                Class<?>[] interfaces = apiClass.getInterfaces();
                if(isValidInterfacePresent(interfaces)) {
                    apiList.add(getExchangeRaterApi(apiClass));
                }
            }
        }
        return apiList;
    }

    private static Api getAnnotation(Class apiClass) {
        Annotation annotation = apiClass.getAnnotation(Api.class);
        return (Api) annotation;
    }

    private static PriceIndexApi getExchangeRaterApi(Class apiClass) throws PriceIndexException {
        try {

            Object apiObject = apiClass.getClassLoader().loadClass(apiClass.getName()).newInstance();
            return (PriceIndexApi) apiObject;
        } catch (ClassNotFoundException e) {
            throw new PriceIndexException(
                    EXCEPTION_MESSAGE,
                    e,
                    CONTEXT,
                    "Cannot find the class");
        } catch (IllegalAccessException e) {
            throw new PriceIndexException(
                    EXCEPTION_MESSAGE,
                    e,
                    CONTEXT,
                    "Cannot access the class");
        } catch (InstantiationException e) {
            throw new PriceIndexException(
                    EXCEPTION_MESSAGE,
                    e,
                    CONTEXT,
                    "Cannot instantiate the class");
        }

    }

    private static boolean isValidInterfacePresent(Class<?>[] interfaces) {

        for(Class interfaceElement : interfaces) {

            if(interfaceElement.isAssignableFrom(PriceIndexApi.class)) {
                return true;
            }
        }
        return false;
    }
}
