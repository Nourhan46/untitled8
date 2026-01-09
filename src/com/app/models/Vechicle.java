package com.app.models;



public interface Vechicle {

    default String getDetails() {
        return "Vehicle Info: [ID=" + getId() + ", Model=" + getModel() + "]";
    }
    int getId();

    String getModel();
Type getType();

    void setId(int id);
    void setModel(String model);

}