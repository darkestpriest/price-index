package com.darkestapp.price_index.api.blockchain.enums;

import com.darkestapp.price_index.annotation.Supported;
import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.Currency;

public enum BlockchainCurrency implements Currency {

    @Supported
    USD ("USD", "US Dollar");

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
