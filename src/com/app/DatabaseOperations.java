package com.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
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


}
