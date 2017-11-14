package com.darkestapp.price_index.interfaces;

import com.darkestapp.price_index.exceptions.PriceIndexException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import static com.darkestapp.price_index.config.Constants.DEFAULT_READ_TIMEOUT;
import static com.darkestapp.price_index.config.Constants.DEFAULT_USER_AGENT;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public abstract class AbstractJsonParser<A extends ApiObject> {

    private static final int SUCCESS_CODE = 200;
    private static final String EXCEPTION_MESSAGE = "Json Parser error";
    private static final String EXCEPTION_MESSAGE_PREFIX = "The URL ";

    protected final String CONTEXT;

    public AbstractJsonParser(Class contextClass) {
        this.CONTEXT = contextClass.getSimpleName();
    }

    public abstract A getApiObject() throws PriceIndexException;

    public abstract A getApiObject(String url) throws PriceIndexException;

    protected JSONObject getRequest(String stringURL) throws PriceIndexException {

        try {

            URL url = new URL(stringURL);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setReadTimeout(DEFAULT_READ_TIMEOUT);
            connection.addRequestProperty("User-Agent", DEFAULT_USER_AGENT);
            if(connection == null) {

                throw new PriceIndexException(
                        EXCEPTION_MESSAGE,
                        null,
                        CONTEXT,
                        "The Https connection is null");
            }

            int responseCode = connection.getResponseCode();
            if(responseCode != SUCCESS_CODE) {

                throw new PriceIndexException(
                        EXCEPTION_MESSAGE,
                        null,
                        CONTEXT,
                        EXCEPTION_MESSAGE_PREFIX + stringURL + " respond with " + responseCode + " code");
            }

            String response = getStringResponse(connection);

            if(response == null || response.isEmpty()) {

                throw new PriceIndexException(
                        EXCEPTION_MESSAGE,
                        null,
                        CONTEXT,
                        EXCEPTION_MESSAGE_PREFIX + stringURL + " respond is empty or null");
            }

            return new JSONObject(response);
        } catch (MalformedURLException e) {
            throw new PriceIndexException(
                    EXCEPTION_MESSAGE,
                    e,
                    CONTEXT,
                    EXCEPTION_MESSAGE_PREFIX + stringURL + " is malformed");
        } catch (IOException e) {
            throw new PriceIndexException(
                    EXCEPTION_MESSAGE,
                    e,
                    CONTEXT,
                    EXCEPTION_MESSAGE_PREFIX + stringURL + " request gets an IOException.");
        }
    }

    private String getStringResponse(HttpsURLConnection connection) throws IOException {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null){
            response.append(input);
        }
        br.close();

        return response.toString();
    }
}
