package com.darkestapp.price_index.interfaces;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 20/04/17.
 */
public class ApiId {
    
    private final String shortName;
    private final String friendlyName;

    public ApiId(final String shortName, final String friendlyName) {
        this.shortName = shortName;
        this.friendlyName = friendlyName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }
    
    public static ApiId build(String shortName, String friendlyName) {
        return new ApiId(shortName, friendlyName);
    }
}
