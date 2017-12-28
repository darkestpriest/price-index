package com.darkestapp.price_index.api.blockchain.util;

import com.darkestapp.price_index.annotation.Supported;
import com.darkestapp.price_index.exceptions.ParseException;
import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.AbstractPrice;
import com.darkestapp.price_index.interfaces.Price;
import com.darkestapp.price_index.util.CurrencyScanner;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.List;

import static com.darkestapp.price_index.api.blockchain.config.BlockchainConstants.RATE_JSON_STRING;

public class BlockchainPrice extends AbstractPrice {

    @Supported(value = false)
    private String code;

    @Supported(value = false)
    private BigDecimal rate;

    @Supported
    private BigDecimal last;

    @Supported
    private BigDecimal buy;

    @Supported
    private BigDecimal sell;

    @Supported
    private String symbol;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRate(String rate) {
        this.rate = new BigDecimal(
                rate);
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = new BigDecimal(
                last);
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = new BigDecimal(
                buy);
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = new BigDecimal(
                sell);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public BigDecimal getRate() {
        return rate;
    }

    public static BlockchainPrice build(JSONObject marketPrices, String code) throws ParseException {
        try {
            List<String> parameters = CurrencyScanner.getSupportedCurrencyCodeList(BlockchainPrice.class, BlockchainPrice.class);
            BlockchainPrice price = new BlockchainPrice();
            for (String p : parameters) {
                setParameter(p, marketPrices, price);
            }
            String rate = marketPrices.get(RATE_JSON_STRING).toString();
            price.setRate(rate);
            price.setCode(code);
            return price;
        } catch(PriceIndexException e) {
            throw new ParseException(
                    e,
                    BlockchainPrice.class.getSimpleName(),
                    "Cannot build BlockchainPrice from json response");
        }
    }

    @Override
    public String toString() {
        return "BlockchainPrice{" +
                "code='" + code + '\'' +
                ", rate=" + rate +
                ", last=" + last +
                ", buy=" + buy +
                ", sell=" + sell +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
