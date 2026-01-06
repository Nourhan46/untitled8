package com.app;

public class Developer {
    private String name;
    private int DeveloperId;

    public Developer(String name, int developerId) {
        this.name = name;
        DeveloperId = developerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeveloperId() {
        return DeveloperId;
    }

    public void setDeveloperId(int developerId) {
        DeveloperId = developerId;
    }
}
