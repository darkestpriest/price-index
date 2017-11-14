package com.darkestapp.price_index.interfaces;

import java.util.HashMap;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public interface ApiObject<C extends Currency, P extends Price> {

    HashMap<C, P> getPrices();
}
