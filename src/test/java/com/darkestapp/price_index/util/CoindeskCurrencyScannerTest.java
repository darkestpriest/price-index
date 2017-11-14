package com.darkestapp.price_index.util;

import com.darkestapp.price_index.api.coindesk.enums.CoindeskCurrency;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public class CoindeskCurrencyScannerTest {
    @Test
    public void getSupportedCurrencyCodeList() throws Exception {
        List<String> result = CurrencyScanner.getSupportedCurrencyCodeList(CoindeskCurrency.class, this.getClass());
        assertNotNull(result);
        assertThat(result.size(), greaterThan(0));
    }

}