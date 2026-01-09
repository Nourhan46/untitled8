package com.app.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Bike  implements Vechicle {
    int id;
    String model;
    Type type = Type.bike;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setId(int id) {
        this.id =id;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }
}