package com.darkestapp.price_index;

import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.PriceIndexApi;
import com.darkestapp.price_index.util.ApiScanner;
import java.util.HashMap;
import java.util.List;

/**
 * This class will manage all the available API in the library.
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/12/17.
 */
public class ApiManager {
    
    private final HashMap<String, PriceIndexApi> availableApiMap;
    
    /**
     * Default constructor
     * @throws PriceIndexException
     */
    public ApiManager() throws PriceIndexException {
        List<PriceIndexApi> availableApiList = ApiScanner.getAvailableApiList();
        this.availableApiMap = new HashMap<>();
        availableApiList.forEach(
                api -> availableApiMap.put(
                        api
                                .getApiId()
                                .getShortName(), 
                        api)
                );
    }
    
    /**
     * This method returns the available api identified by a Api Code.
     * @return
     */
    public HashMap<String, PriceIndexApi> getAvailableApiMap() {

        return this.availableApiMap;
    }
    
    public static HashMap<String, PriceIndexApi> getApiMap() 
            throws PriceIndexException {
        
        return new ApiManager().getAvailableApiMap();
    }
}
