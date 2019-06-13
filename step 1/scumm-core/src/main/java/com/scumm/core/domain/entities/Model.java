package com.scumm.core.domain.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Model {
    @Id
    private ObjectId id;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
