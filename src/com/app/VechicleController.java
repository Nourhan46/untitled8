package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
@Component
public class VechicleController {
DatabaseOperations databaseOperations;
@Autowired
    public VechicleController(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }


    public void Save(Vechicle vechicle) throws SQLException {
    databaseOperations.Save(vechicle);


    }


    public void Delete(Vechicle vechicle) throws SQLException {
databaseOperations.delete(vechicle);
    }


    public void update(Vechicle vechicle) {

    }

    public void searchbyid(Vechicle vechicle) {

    }


    public void getAllvehicles(Vechicle vechicle) {

    }
}
