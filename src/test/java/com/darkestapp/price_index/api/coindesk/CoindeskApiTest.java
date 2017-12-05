package com.darkestapp.price_index.api.coindesk;

import com.darkestapp.price_index.api.coindesk.util.CoindeskObject;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 04/12/17.
 */
public class CoindeskApiTest {
    @Test
    public void getApiObject() throws Exception {
        CoindeskApi api = new CoindeskApi();
        CoindeskObject object = api.getApiObject();
        assertNotNull(object);
    }

}