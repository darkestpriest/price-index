package com.darkestapp.price_index.api.blockchain.config;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 07/12/17.
 */
public class BlockchainConstants {

    private BlockchainConstants() {
        //Just to avoid public instantiation.
    }

    public static final String API_SHORT_NAME = "BLK";
    public static final String API_FRIENDLY_NAME = "Blockchain";
    public static final String CURRENT_PRICE_URL = "https://blockchain.info/es/ticker";
    public static final String RATE_JSON_STRING = "15m";
}
