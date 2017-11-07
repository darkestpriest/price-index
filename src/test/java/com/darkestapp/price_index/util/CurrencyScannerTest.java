package com.darkestapp.price_index.util;

import com.darkestapp.price_index.enums.Currency;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public class CurrencyScannerTest {
    @Test
    public void getSupportedCurrencyCodeList() throws Exception {
        List<String> result = CurrencyScanner.getSupportedCurrencyCodeList(Currency.class, this.getClass());
        assertNotNull(result);
        assertThat(result.size(), greaterThan(0));
    }

}