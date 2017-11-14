package com.darkestapp.price_index.api.coindesk.util;

import com.darkestapp.price_index.api.coindesk.enums.CoindeskCurrency;
import com.darkestapp.price_index.interfaces.ApiObject;

import java.util.HashMap;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 07/11/17.
 */
public class CoindeskObject implements ApiObject<CoindeskCurrency, CoindeskPrice> {

    private HashMap<CoindeskCurrency, CoindeskPrice> prices;

    public CoindeskObject(HashMap<CoindeskCurrency, CoindeskPrice> prices) {
        this.prices = prices;
    }

    @Override
    public HashMap<CoindeskCurrency, CoindeskPrice> getPrices() {
        return this.prices;
    }
}
