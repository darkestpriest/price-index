package com.darkestapp.price_index.api.coindesk.processors;

import com.darkestapp.price_index.api.coindesk.enums.CoindeskCurrency;
import com.darkestapp.price_index.api.coindesk.util.CoindeskObject;
import com.darkestapp.price_index.api.coindesk.util.CoindeskPrice;
import com.darkestapp.price_index.exceptions.ParseException;
import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.AbstractJsonParser;
import com.darkestapp.price_index.util.CurrencyScanner;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import static com.darkestapp.price_index.api.coindesk.config.CoindeskConstants.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 07/11/17.
 */
public class CoindeskJsonParser extends AbstractJsonParser<CoindeskObject> {

    public CoindeskJsonParser(Class contextClass) {
        super(contextClass);
    }

    @Override
    public CoindeskObject getApiObject() throws PriceIndexException {
        return getApiObject(CURRENT_PRICE_URL);
    }

    @Override
    public CoindeskObject getApiObject(String url) throws PriceIndexException {
        try{

            JSONObject jsonObject = getRequest(url);

            if(!jsonObject.getString(CHART_NAME).equals(DEFAULT_CHART_NAME)) {
                throw new ParseException(
                        null,
                        CONTEXT,
                        "Market not supported");
            }

            JSONObject marketPrices = jsonObject.getJSONObject(
                    MARKET_PRICES_RESULT_KEY);
            return getApiObject(marketPrices);

        } catch (JSONException e) {
            throw new ParseException(
                    e,
                    CONTEXT,
                    "Cannot parse the json object");
        } catch (Exception e) {
            throw new ParseException(
                    e,
                    CONTEXT,
                    "An error has occurred parsing a json object");
        }
    }

    private CoindeskObject getApiObject(JSONObject marketPrices) throws PriceIndexException {
        List<String> currencies =
                CurrencyScanner.getSupportedCurrencyCodeList(
                        CoindeskCurrency.class,
                        CoindeskJsonParser.class);
        HashMap<CoindeskCurrency, CoindeskPrice> prices = new HashMap<>();
        CoindeskPrice price;
        for (String currency : currencies) {
            price = CoindeskPrice.build(marketPrices.getJSONObject(currency));
            prices.put(CoindeskCurrency.getByCode(currency), price);
        }
        return new CoindeskObject(prices);
    }
}
