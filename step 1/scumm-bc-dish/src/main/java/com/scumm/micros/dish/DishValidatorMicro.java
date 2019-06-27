package com.scumm.micros.dish;

import com.clitellum.MicroServiceBase;
import com.clitellum.annotations.DeadLetterChannel;
import com.clitellum.annotations.Microservice;
import com.clitellum.annotations.MicroserviceHandlers;

@Microservice(id = "Validator", type = "Validator", bc = "Dish", publishBc = "Scumm")
@MicroserviceHandlers(packageName = "com.scumm.micros.dish.validators.handlers")
@DeadLetterChannel(value="ScummErrors")
public class DishValidatorMicro extends MicroServiceBase {

    public DishValidatorMicro(String uri) {
        super(uri);
    }

    public DishValidatorMicro(String uri, String user, String password) {
        super(uri, user, password);
    }

    public DishValidatorMicro(String host, int port) {
        super(host, port);
    }

    public DishValidatorMicro(String host, int port, String user, String password) {
        super(host, port, user, password);
    }

    public DishValidatorMicro(String host, int port, String user, String password, String virtualHost) {
        super(host, port, user, password, virtualHost);
    }
}
