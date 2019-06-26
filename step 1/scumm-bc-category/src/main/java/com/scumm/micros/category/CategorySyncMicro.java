package com.scumm.micros.category;

import com.clitellum.MicroServiceBase;
import com.clitellum.annotations.Microservice;
import com.clitellum.annotations.MicroserviceHandlers;

@Microservice(id = "Sync", type = "Category", bc = "Category", publishBc = "Scumm")
@MicroserviceHandlers(packageName = "com.scumm.micros.category.sync.handlers")
public class CategorySyncMicro extends MicroServiceBase {
    public CategorySyncMicro(String uri) {
        super(uri);
    }

    public CategorySyncMicro(String uri, String user, String password) {
        super(uri, user, password);
    }

    public CategorySyncMicro(String host, int port) {
        super(host, port);
    }

    public CategorySyncMicro(String host, int port, String user, String password) {
        super(host, port, user, password);
    }

    public CategorySyncMicro(String host, int port, String user, String password, String virtualHost) {
        super(host, port, user, password, virtualHost);
    }
}
