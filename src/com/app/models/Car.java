package com.app.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car implements Vechicle {

    int id;
    String model;
    Type type = Type.car;

//    public Car( String model, Type type) {
//
//        this.model = model;
//        this.type = type;
//    }

    public int getId() {
        return id;
    }



    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    @Override
    public void setId(int id) {
        this.id =id;

    }


}