package com.darkestapp.price_index.api.coindesk.util;

import com.darkestapp.price_index.exceptions.PriceIndexException;
import org.json.JSONObject;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 04/12/17.
 */
public class CoindeskPriceTest {

    private static final String JSON_STRING_TEST =
                    "{\"code\":\"USD\"" +
                    ",\"symbol\":\"&#36;\"" +
                    ",\"rate\":\"11,240.8675\"" +
                    ",\"description\":\"United States Dollar\"" +
                    ",\"rate_float\":11240.8675}";
    private static final String EXPECTED_CODE = "USD";
    private static final String EXPECTED_SYMBOL = "&#36;";
    private static final float EXPECTED_RATE_FLOAT = 11240.8675f;
    private static final BigDecimal EXPECTED_FLOAT = new BigDecimal("11240.8675");
    private static final String EXPECTED_DESCRIPTION = "United States Dollar";

    @Test
    public void buildTest() throws Exception {
        JSONObject jsonObject = new JSONObject(JSON_STRING_TEST);
        CoindeskPrice price = CoindeskPrice.build(jsonObject);
        assertNotNull(price);
        assertEquals(EXPECTED_CODE, price.getCode());
        assertEquals(EXPECTED_SYMBOL, price.getSymbol());
        assertTrue(EXPECTED_RATE_FLOAT == price.getRateFloat());
        assertEquals(EXPECTED_FLOAT, price.getRate());
        assertEquals(EXPECTED_DESCRIPTION, price.getDescription());
        System.out.println(price);
    }

    @Test(expected = PriceIndexException.class)
    public void failedBuild() throws Exception {
        CoindeskPrice.build(null);
    }

}