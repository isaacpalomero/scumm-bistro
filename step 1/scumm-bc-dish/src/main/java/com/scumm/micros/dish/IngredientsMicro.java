package com.scumm.micros.dish;

import com.clitellum.MicroServiceBase;
import com.clitellum.annotations.Microservice;
import com.clitellum.annotations.MicroserviceHandlers;

@Microservice(id = "Updater", type = "Ingredients", bc = "Dish", publishBc = "Scumm")
@MicroserviceHandlers(packageName = "com.scumm.micros.dish.ingredients.handlers")
public class IngredientsMicro extends MicroServiceBase {
    public IngredientsMicro(String uri) {
        super(uri);
    }

    public IngredientsMicro(String uri, String user, String password) {
        super(uri, user, password);
    }

    public IngredientsMicro(String host, int port) {
        super(host, port);
    }

    public IngredientsMicro(String host, int port, String user, String password) {
        super(host, port, user, password);
    }

    public IngredientsMicro(String host, int port, String user, String password, String virtualHost) {
        super(host, port, user, password, virtualHost);
    }
}
