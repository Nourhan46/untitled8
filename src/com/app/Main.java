package com.app;

import com.app.config.Config;
import com.app.models.Car;
import com.app.models.Vechicle;
import com.app.models.plane;
import com.app.controllers.VechicleController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
public  class Main {
  public static   void main (String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);



        VechicleController controller = context.getBean(VechicleController.class);

        Vechicle car =(Car) context.getBean(Car.class);
      System.out.println(car.getId());
        car.setModel("BMW");
       // db.Save(car);
     // System.out.println(car.getId());

//      car.setId(11);
//      db.delete(car);
      Vechicle plane = context.getBean(plane.class);
      plane.setModel("lolo");
      //controller.Save(plane);
      plane.setId(15);
      controller.update(plane, new String[] {"nour Pro max" ,"plane"} );

 controller.searchbyid(14);

 controller.getAllvehicles();


context.close();
    }
}

