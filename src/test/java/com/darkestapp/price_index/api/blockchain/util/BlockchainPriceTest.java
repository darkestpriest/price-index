package com.darkestapp.price_index.api.blockchain.util;

import com.darkestapp.price_index.exceptions.PriceIndexException;
import org.json.JSONObject;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class BlockchainPriceTest {

    private static final String JSON_STRING_TEST =
                    "{\"15m\" : 13839.21," +
                    " \"last\" : 13839.21, " +
                    "\"buy\" : 13844.9, " +
                    "\"sell\" : 13833.51, " +
                    "\"symbol\" : \"$\"}";
    private static final String CODE_TEST = "USD";
    private static final String EXPECTED_CODE = "USD";
    private static final String EXPECTED_SYMBOL = "$";
    private static final BigDecimal EXPECTED_RATE = new BigDecimal("13839.21");
    private static final BigDecimal EXPECTED_LAST = new BigDecimal("13839.21");
    private static final BigDecimal EXPECTED_BUY = new BigDecimal("13844.9");
    private static final BigDecimal EXPECTED_SELL = new BigDecimal("13833.51");

    @Test
    public void buildTest() throws Exception {
        JSONObject jsonObject = new JSONObject(JSON_STRING_TEST);
        BlockchainPrice price = BlockchainPrice.build(jsonObject, CODE_TEST);
        assertNotNull(price);
        assertEquals(EXPECTED_CODE, price.getCode());
        assertEquals(EXPECTED_SYMBOL, price.getSymbol());
        assertEquals(EXPECTED_RATE, price.getRate());
        assertEquals(EXPECTED_LAST, price.getLast());
        assertEquals(EXPECTED_BUY, price.getBuy());
        assertEquals(EXPECTED_SELL, price.getSell());
        System.out.println(price);
    }

    @Test(expected = PriceIndexException.class)
    public void failedBuild() throws Exception {
        BlockchainPrice.build(null, CODE_TEST);
    }
}