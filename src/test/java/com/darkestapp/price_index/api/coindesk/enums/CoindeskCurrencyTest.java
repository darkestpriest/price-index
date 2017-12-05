package com.darkestapp.price_index.api.coindesk.enums;

import com.darkestapp.price_index.exceptions.PriceIndexException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 04/12/17.
 */
public class CoindeskCurrencyTest {

    private static final CoindeskCurrency TEST = CoindeskCurrency.USD;
    private static final String TEST_FRIENDLY_NAME = "US Dollar";
    private static final String TEST_CODE = "USD";
    private static final String TEST_LOWERCASE_CODE = "usd";

    @Test
    public void getByCodeTest() throws Exception {
        CoindeskCurrency result = CoindeskCurrency.getByCode("USD");
        assertEquals(TEST, result);
    }

    @Test(expected = PriceIndexException.class)
    public void getByCodeFailedTest() throws Exception{
        CoindeskCurrency result = CoindeskCurrency.getByCode("BTC");
        assertEquals(TEST, result);
    }

    @Test
    public void getFriendlyName() throws Exception {
        String result = TEST.getFriendlyName();
        assertEquals(TEST_FRIENDLY_NAME, result);
    }

    @Test
    public void getCode() throws Exception {
        String result = TEST.getCode();
        assertEquals(TEST_CODE, result);
    }

    @Test
    public void getLowerCaseCode() throws Exception {
        String result = TEST.getLowerCaseCode();
        assertEquals(TEST_LOWERCASE_CODE, result);
    }

}