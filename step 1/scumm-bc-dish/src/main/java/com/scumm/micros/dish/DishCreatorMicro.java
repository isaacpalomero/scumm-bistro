package com.scumm.micros.dish;

import com.clitellum.MicroServiceBase;
import com.clitellum.annotations.Microservice;
import com.clitellum.annotations.MicroserviceHandlers;

@Microservice(id = "Creator", type = "Dish", bc = "Dish", publishBc = "Scumm")
@MicroserviceHandlers(packageName = "com.scumm.micros.dish.creator.handlers")
public class DishCreatorMicro extends MicroServiceBase {
    public DishCreatorMicro(String uri) {
        super(uri);
    }

    public DishCreatorMicro(String uri, String user, String password) {
        super(uri, user, password);
    }

    public DishCreatorMicro(String host, int port) {
        super(host, port);
    }

    public DishCreatorMicro(String host, int port, String user, String password) {
        super(host, port, user, password);
    }

    public DishCreatorMicro(String host, int port, String user, String password, String virtualHost) {
        super(host, port, user, password, virtualHost);
    }
}
