package com.darkestapp.price_index.interfaces;

import com.darkestapp.price_index.exceptions.PriceIndexException;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public interface PriceIndexApi<P extends ApiObject> {

    P getApiObject() throws PriceIndexException;
}
