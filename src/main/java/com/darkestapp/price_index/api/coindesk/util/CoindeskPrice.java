package com.darkestapp.price_index.api.coindesk.util;

import com.darkestapp.price_index.annotation.Supported;
import com.darkestapp.price_index.exceptions.ParseException;
import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.Price;
import com.darkestapp.price_index.util.CurrencyScanner;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 07/11/17.
 */
public class CoindeskPrice implements Price {

    @Supported
    private String code;

    @Supported
    private BigDecimal rate;

    @Supported
    private float rate_float;

    @Supported
    private String symbol;

    @Supported
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRate(String rate) {
        this.rate = new BigDecimal(
                rate.replaceAll(",", ""));
    }

    public float getRateFloat() {
        return rate_float;
    }

    public void setRate_float(String rateFloat) {
        this.rate_float = Float.parseFloat(rateFloat);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public BigDecimal getRate() {
        return rate;
    }

    public static CoindeskPrice build(JSONObject marketPrices) throws ParseException {
        try {
            List<String> parameters = CurrencyScanner.getSupportedCurrencyCodeList(CoindeskPrice.class, CoindeskPrice.class);
            CoindeskPrice price = new CoindeskPrice();
            for (String p : parameters) {
                setParameter(p, marketPrices, price);
            }
            return price;
        } catch(PriceIndexException e) {
            throw new ParseException(
                    e,
                    CoindeskPrice.class.getSimpleName(),
                    "Cannot build CoindeskPrice from json response");
        }

    }

    private static void setParameter(
            String parameter,
            JSONObject marketPrices,
            CoindeskPrice price) throws PriceIndexException {
        Class coindeskPriceClass = price.getClass();
        try {
            String value = marketPrices.get(parameter).toString();
            Method method = price.getClass().getMethod(
                    "set"+toUpperCaseFirstChar(parameter),
                    String.class);
            method.invoke(price, value);
        } catch (Exception e) {
            throw new PriceIndexException(
                    "Parsing error",
                    e,
                    coindeskPriceClass.getSimpleName(),
                    "Cannot get the " + parameter +" from " + marketPrices);
        }
    }

    private static String toUpperCaseFirstChar(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    @Override
    public String toString() {
        return "CoindeskPrice{" +
                "code='" + code + '\'' +
                ", rate=" + rate +
                ", rate_float=" + rate_float +
                ", symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
