package com.darkestapp.price_index.api.coindesk.enums;

import com.darkestapp.price_index.annotation.Supported;
import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.Currency;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public enum CoindeskCurrency implements Currency {

    @Supported
    USD ("USD", "US Dollar");

    private String friendlyName;
    private String code;

    CoindeskCurrency(String code, String friendlyName) {

        this.code = code;
        this.friendlyName = friendlyName;
    }

    public static CoindeskCurrency getByCode(String code) throws PriceIndexException {
        for (CoindeskCurrency value : values()) {
            if (value.getCode().equals(code)) return value;
        }
        throw new PriceIndexException(
                "Cannot find the code",
                null, "Code Received: " + code,
                "This Code Is Not Valid for the ExposureLevel enum.");
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public String getCode() {
        return code;
    }

    public String getLowerCaseCode () {
        return this.getCode().toLowerCase();
    }
}
