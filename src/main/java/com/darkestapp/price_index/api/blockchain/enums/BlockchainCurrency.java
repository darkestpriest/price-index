package com.darkestapp.price_index.api.blockchain.enums;

import com.darkestapp.price_index.annotation.Supported;
import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.Currency;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 07/12/17.
 */
public enum BlockchainCurrency implements Currency {

    @Supported
    USD ("USD", "US Dollar"),
    @Supported
    AUD ("AUD", "Australia Dollar"),
    @Supported
    BRL ("BRL", "Brazil Real"),
    @Supported
    CAD ("CAD", "Canada Dollar"),
    @Supported
    CHF ("CHF", "Swiss Franc"),
    @Supported
    CLP ("CLP", "Chile Peso"),
    @Supported
    CNY ("CNY", "China Yuan"),
    @Supported
    DKK ("DKK", "Denmark Krone"),
    @Supported
    EUR ("EUR", "Euro"),
    @Supported
    GBP ("GBP", "British Pound"),
    @Supported
    HKD ("HKD", "Hong Kong Dollar"),
    @Supported
    INR ("INR", "India Rupee"),
    @Supported
    ISK ("ISK", "Iceland Krona"),
    @Supported
    JPY ("JPY", "Japanese Yen"),
    @Supported
    KRW ("KRW", "South Korean Won"),
    @Supported
    NZD ("NZD", "New Zealand Dollar"),
    @Supported
    PLN ("PLN", "Polish Zloty"),
    @Supported
    RUB ("RUB", "Russian Rouble"),
    @Supported
    SEK ("SEK", "Swedish Krona"),
    @Supported
    SGD ("SGD", "Singapore Dollar"),
    @Supported
    THB ("THB", "Thailand Baht"),
    @Supported
    TWD ("TWD", "Taiwan New Dollar")
    ;

    private String code;
    private String friendlyName;

    BlockchainCurrency(String code, String friendlyName) {

        this.code = code;
        this.friendlyName = friendlyName;
    }

    public static BlockchainCurrency getByCode(String code) throws PriceIndexException {
        for (BlockchainCurrency value : values()) {
            if (value.getCode().equals(code)) return value;
        }
        throw new PriceIndexException(
                "Cannot find the code",
                null, "Code Received: " + code,
                "This Code Is Not Valid for the ExposureLevel enum.");
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
