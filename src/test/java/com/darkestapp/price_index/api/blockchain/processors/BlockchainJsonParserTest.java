package com.darkestapp.price_index.api.blockchain.processors;

import com.darkestapp.price_index.api.blockchain.enums.BlockchainCurrency;
import com.darkestapp.price_index.api.blockchain.util.BlockchainPrice;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class BlockchainJsonParserTest {

    @Test
    public void getApiObjectTest() throws Exception {

        BlockchainJsonParser c = new BlockchainJsonParser(BlockchainJsonParserTest.class);
        HashMap<BlockchainCurrency, BlockchainPrice> prices = c.getApiObject().getPrices();
        assertNotNull(prices);
        assertThat(prices.size(), greaterThan(0));
    }
}