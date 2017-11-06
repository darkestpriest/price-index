package com.darkestapp.price_index.interfaces;

import com.darkestapp.price_index.enums.Currency;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public interface PriceIndexApi {

    Price getPrice(Currency currency);
}
