package com.darkestapp.price_index.api.blockchain.util;

import com.darkestapp.price_index.api.blockchain.enums.BlockchainCurrency;
import com.darkestapp.price_index.interfaces.ApiObject;

import java.util.HashMap;

public class BlockchainObject implements ApiObject<BlockchainCurrency, BlockchainPrice> {

    private HashMap<BlockchainCurrency, BlockchainPrice> prices;

    public BlockchainObject(HashMap<BlockchainCurrency, BlockchainPrice> prices) {
        this.prices = prices;
    }

    @Override
    public HashMap<BlockchainCurrency, BlockchainPrice> getPrices() {
        return this.prices;
    }
}
