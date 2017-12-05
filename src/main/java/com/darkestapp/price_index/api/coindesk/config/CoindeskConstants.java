package com.darkestapp.price_index.api.coindesk.config;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 07/11/17.
 */
public class CoindeskConstants {

    private CoindeskConstants() {
        //Just to avoid public instantiation.
    }

    public static String CHART_NAME = "chartName";
    public static final String CURRENT_PRICE_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";
    public static String DEFAULT_CHART_NAME = "Bitcoin";
    public static final String MARKET_PRICES_RESULT_KEY = "bpi";
}
