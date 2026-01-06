package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
public  class Main {
  public static   void main (String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config.class);



        VechicleController  controller = context.getBean(VechicleController.class);

        Vechicle car =(Car) context.getBean(Car.class);
      System.out.println(car.getId());
        car.setModel("BMW");
       // db.Save(car);
     // System.out.println(car.getId());

//      car.setId(11);
//      db.delete(car);
      Vechicle plane = context.getBean(plane.class);
      plane.setModel("lolo");
      controller.Save(plane);




context.close();
    }
}

