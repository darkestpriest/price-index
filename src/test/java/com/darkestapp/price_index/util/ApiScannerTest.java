package com.darkestapp.price_index.util;

import com.darkestapp.price_index.interfaces.PriceIndexApi;
import org.junit.Test;

import java.util.List;

import static com.darkestapp.price_index.util.ApiScanner.getAvailableApiList;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
public class ApiScannerTest {
    @Test
    public void getAvailableApiListTest() throws Exception {
        List<PriceIndexApi> apiList = getAvailableApiList();
        assertNotNull(apiList);
        assertThat((long)apiList.size(), greaterThan(0L));
    }
}