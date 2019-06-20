package com.scumm.bdd;

import com.scumm.bdd.category.CategoryScenario;
import com.scumm.bdd.dish.DishScenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class GlobalHooks {
    private static boolean dunit = false;

    @Before
    public void beforeAll() {
        if(!dunit) {
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                BddMicroPublisher.getInstance().close();
            }));
            dunit = true;
            try {
                BddMicroPublisher.getInstance().connect();
                MongoConnection.getInstance();
                ScummApi.getInstance();
            } catch (NoSuchAlgorithmException | KeyManagementException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void cleanData(){
        CategoryScenario.clean();
        DishScenario.clean();
    }
}
