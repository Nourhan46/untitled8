package com.app.dao;

import com.app.models.Car;
import com.app.models.Vechicle;
import com.app.models.plane;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class DatabaseOperations {
    @Value("${db.url}")
    String url;
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    String password;
    Connection con;
    @PostConstruct
    public  void BeginConnecting() throws SQLException {

con = DriverManager.getConnection(url,username,password);
        System.out.println("connected to database");
}
@PreDestroy
public void CloseConnection() throws SQLException {
    System.out.println("disconnected to database");

    con.close();



}
public  void Save( Vechicle vechicle) throws SQLException {
        String query = "insert into vehicle ( model, type) values(?,?)";

  PreparedStatement st = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
  st.setString(1,vechicle.getModel());
  st.setString(2,vechicle.getType().toString());
st.executeUpdate();
ResultSet rs = st.getGeneratedKeys();
if(rs.next())
{
    int id = rs.getInt(1);
    System.out.println(">> DB generated ID: " + id);
    vechicle.setId(id);
}

    System.out.println("successful  added");


}

    public void delete(Vechicle vechicle) throws SQLException {
        String query = "delete from vehicle where id= ? ";
        PreparedStatement st = con.prepareStatement(query);
        System.out.println("id =" + vechicle.getId());
        st.setInt(1,vechicle.getId());
        st.executeUpdate();
        System.out.println("deleted successfully");

    }
    public void update(Vechicle vechicle , String [] params ) throws SQLException {
String query = "update vehicle set model =? , type = ? where id= ?";
PreparedStatement st = con.prepareStatement(query);
st.setString(1,params[0]);
st.setString(2,params[1]);
st.setInt(3,vechicle.getId());

        st.executeUpdate();
        System.out.println("updated successfully");




    }
    public void searchById(int searchId) throws SQLException {
        String query = "select * from vehicle where id = ? ";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,searchId);

        st.executeQuery();
        System.out.println("found successfully");
    }
    public List<Vechicle> getAllvehicles() throws SQLException {
        List<Vechicle> vechicles = new ArrayList<>();
        String query = "select * from vehicle  ";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String type = rs.getString("type");
            if (type.equalsIgnoreCase("car")) {
                Vechicle vechicle = new Car();
                vechicle.setId(rs.getInt("id"));
                vechicle.setModel(rs.getString("model"));
                vechicles.add(vechicle);


            } else if (type.equalsIgnoreCase("plane")) {
                Vechicle vechicle = new plane();
                vechicle.setId(rs.getInt("id"));
                vechicle.setModel(rs.getString("model"));
                vechicles.add(vechicle);
            } else if (type.equalsIgnoreCase("plane")) {
                Vechicle vechicle = new plane();
                vechicle.setId(rs.getInt("id"));
                vechicle.setModel(rs.getString("model"));
                vechicles.add(vechicle);
            }
        }

        return vechicles;
    }}
