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
    AUD ("AUD", "Australia Dollar"),
    BRL ("BRL", "Brazil Real"),
    CAD ("CAD", "Canada Dollar"),
    CHF ("CHF", "Swiss Franc"),
    CLP ("CLP", "Chile Peso"),
    CNY ("CNY", "China Yuan"),
    DKK ("DKK", "Denmark Krone"),
    EUR ("EUR", "Euro"),
    GBP ("GBP", "British Pound"),
    HKD ("HKD", "Hong Kong Dollar"),
    INR ("INR", "India Rupee"),
    ISK ("ISK", "Iceland Krona"),
    JPY ("JPY", "Japanese Yen"),
    KRW ("KRW", "South Korean Won"),
    NZD ("NZD", "New Zealand Dollar"),
    PLN ("PLN", "Polish Zloty"),
    RUB ("RUB", "Russian Rouble"),
    SEK ("SEK", "Swedish Krona"),
    SGD ("SGD", "Singapore Dollar"),
    THB ("THB", "Thailand Baht"),
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
