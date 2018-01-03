package com.darkestapp.price_index.api.blockchain;

import com.darkestapp.price_index.annotation.Api;
import com.darkestapp.price_index.api.blockchain.processors.BlockchainJsonParser;
import com.darkestapp.price_index.api.blockchain.util.BlockchainObject;
import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.ApiId;
import com.darkestapp.price_index.interfaces.PriceIndexApi;

import static com.darkestapp.price_index.api.blockchain.config.BlockchainConstants.API_FRIENDLY_NAME;
import static com.darkestapp.price_index.api.blockchain.config.BlockchainConstants.API_SHORT_NAME;

@Api(enabled = true, name = "Blockchain API")
public class BlockchainApi implements PriceIndexApi<BlockchainObject> {

    private static final Class CONTEXT = BlockchainApi.class;

    @Override
    public ApiId getApiId() {
        return new ApiId(API_SHORT_NAME, API_FRIENDLY_NAME);
    }

    @Override
    public BlockchainObject getApiObject() throws PriceIndexException {
        BlockchainJsonParser parser = new BlockchainJsonParser(CONTEXT);
        return parser.getApiObject();
    }
}
