package com.app;

import java.sql.SQLException;

public interface VehicleDAO {
    public void Save(Vechicle vechicle) throws SQLException;
    public  void Delete(Vechicle vechicle) throws SQLException;
    public  void update (Vechicle vechicle);
    public  void searchbyid(Vechicle vechicle);
    public  void getAllvehicles(Vechicle vechicle);
}
