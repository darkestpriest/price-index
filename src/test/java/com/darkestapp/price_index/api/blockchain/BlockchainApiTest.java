package com.darkestapp.price_index.api.blockchain;

import com.darkestapp.price_index.api.blockchain.util.BlockchainObject;
import com.darkestapp.price_index.interfaces.ApiId;
import org.junit.Test;

import static com.darkestapp.price_index.api.blockchain.config.BlockchainConstants.API_FRIENDLY_NAME;
import static com.darkestapp.price_index.api.blockchain.config.BlockchainConstants.API_SHORT_NAME;
import static org.junit.Assert.*;

public class BlockchainApiTest {

    @Test
    public void getApiIdTest() {
        BlockchainApi api = new BlockchainApi();
        ApiId id = api.getApiId();
        assertEquals(API_SHORT_NAME, id.getShortName());
        assertEquals(API_FRIENDLY_NAME, id.getFriendlyName());
    }

    @Test
    public void getApiObject() throws Exception {
        BlockchainApi api = new BlockchainApi();
        BlockchainObject object = api.getApiObject();
        assertNotNull(object);
    }
}