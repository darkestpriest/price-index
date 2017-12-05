package com.darkestapp.price_index.api.coindesk.processors;

import com.darkestapp.price_index.api.coindesk.enums.CoindeskCurrency;
import com.darkestapp.price_index.api.coindesk.util.CoindeskPrice;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 07/11/17.
 */
public class CoindeskJsonParserTest {
    @Test
    public void getApiObject() throws Exception {
        CoindeskJsonParser c = new CoindeskJsonParser(CoindeskJsonParserTest.class);
        HashMap<CoindeskCurrency, CoindeskPrice> prices = c.getApiObject().getPrices();
        assertNotNull(prices);
        assertThat(prices.size(), greaterThan(0));
    }

}