package com.darkestapp.price_index;

import com.darkestapp.price_index.exceptions.PriceIndexException;
import com.darkestapp.price_index.interfaces.PriceIndexApi;
import java.util.HashMap;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/12/17.
 */
public class ApiManagerTest {
    
    @Test
    public void getApiTest() throws PriceIndexException {
        
        HashMap<String, PriceIndexApi> apiMap = ApiManager.getApiMap();
        assertNotNull(apiMap);
        assertThat((long)apiMap.size(), greaterThan(0L));
    }
}
