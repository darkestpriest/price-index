package com.darkestapp.price_index.api.coindesk;

import com.darkestapp.price_index.annotation.Api;
import com.darkestapp.price_index.api.coindesk.processors.CoindeskJsonParser;
import com.darkestapp.price_index.api.coindesk.util.CoindeskObject;
import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.PriceIndexApi;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 07/11/17.
 */
@Api(enabled = true, name = "Coindesk API")
public class CoindeskApi implements PriceIndexApi<CoindeskObject> {

    private static final Class CONTEXT = CoindeskApi.class;

    @Override
    public CoindeskObject getApiObject() throws PriceIndexException {
        CoindeskJsonParser parser = new CoindeskJsonParser(CONTEXT);
        return parser.getApiObject();
    }
}
