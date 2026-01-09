package com.app.controllers;

import com.app.dao.DatabaseOperations;
import com.app.models.Vechicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

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


    public void update(Vechicle vechicle , String [] params) throws SQLException {
databaseOperations.update(vechicle,params);
    }

    public void searchbyid(int id) throws SQLException {
databaseOperations.searchById(id);
    }


    public void getAllvehicles() throws SQLException {
      List<Vechicle> vechicles = databaseOperations.getAllvehicles();
      for(Vechicle v : vechicles)
      {
          System.out.println(v.getDetails());
      }


    }
}
