package com.darkestapp.price_index.interfaces;

import com.darkestapp.price_index.exceptions.PriceIndexException;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public interface PriceIndexApi<P extends ApiObject> {

    /**
     * Returns an ApiId, useful to show the Api id or the Api friendly name.
     * @return
     */
    ApiId getApiId();
    
    /**
     * Returns the ApiObject, according the currency pair.
     *
     * @See {@link ApiObject}
     * @return
     */
    P getApiObject() throws PriceIndexException;
}
