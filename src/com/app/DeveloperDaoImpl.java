package com.app;

import java.util.ArrayList;
import java.util.List;

public class DeveloperDaoImpl implements DeveloperDao {
    List<Developer> Developers;

    public DeveloperDaoImpl() {
        Developers = new ArrayList<>();
        Developer developer1 = new Developer("Ahmed" ,0);
        Developers.add(developer1);
        Developer developer2 = new Developer("nourhan",1);
        Developers.add(developer2);

    }

    @Override
    public List<Developer> getAllDevelopers() {
        return Developers;
    }

    @Override
    public Developer getDeveloper(int DeveloperId) {
        return Developers.get(DeveloperId);
    }

    @Override
    public void updateDeveloper(Developer Developer) {
Developers.get(Developer.getDeveloperId()).setName(Developer.getName());

    }

    @Override
    public void deleteDeveloper(Developer Developer) {

    }
}
