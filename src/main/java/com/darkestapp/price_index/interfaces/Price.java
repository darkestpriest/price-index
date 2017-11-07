package com.darkestapp.price_index.interfaces;

import com.darkestapp.price_index.enums.Currency;

import java.math.BigDecimal;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public interface Price {
    BigDecimal getRate(Currency currency);
}
