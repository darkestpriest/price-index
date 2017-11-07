package com.darkestapp.price_index.enums;

import com.darkestapp.price_index.annotation.Supported;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public enum Currency {

    @Supported
    BTC ("BTC", "Bitcoin");

    private String friendlyName;
    private String code;

    Currency(String code, String friendlyName) {

        this.code = code;
        this.friendlyName = friendlyName;
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
