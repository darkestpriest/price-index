package com.darkestapp.price_index.api.blockchain.processors;

import com.darkestapp.price_index.api.blockchain.enums.BlockchainCurrency;
import com.darkestapp.price_index.api.blockchain.util.BlockchainObject;
import com.darkestapp.price_index.api.blockchain.util.BlockchainPrice;
import com.darkestapp.price_index.exceptions.ParseException;
import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.AbstractJsonParser;
import com.darkestapp.price_index.util.CurrencyScanner;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import static com.darkestapp.price_index.api.blockchain.config.BlockchainConstants.CURRENT_PRICE_URL;

public class BlockchainJsonParser extends AbstractJsonParser<BlockchainObject> {

    public BlockchainJsonParser(Class contextClass) {
        super(contextClass);
    }

    @Override
    public BlockchainObject getApiObject() throws PriceIndexException {
        return getApiObject(CURRENT_PRICE_URL);
    }

    @Override
    public BlockchainObject getApiObject(String url) throws PriceIndexException {
        try{

            JSONObject marketPrices = getRequest(url);
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

    private BlockchainObject getApiObject(JSONObject marketPrices) throws PriceIndexException {
        List<String> currencies =
                CurrencyScanner.getSupportedCurrencyCodeList(
                        BlockchainCurrency.class,
                        BlockchainJsonParser.class);
        HashMap<BlockchainCurrency, BlockchainPrice> prices = new HashMap<>();
        BlockchainPrice price;
        for (String currency : currencies) {
            price = BlockchainPrice.build(marketPrices.getJSONObject(currency), currency);
            prices.put(BlockchainCurrency.getByCode(currency), price);
        }
        return new BlockchainObject(prices);
    }
}
