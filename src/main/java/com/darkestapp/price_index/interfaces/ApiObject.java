package com.darkestapp.price_index.interfaces;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public interface ApiObject<P extends Price> {

    P getPrice();
}
