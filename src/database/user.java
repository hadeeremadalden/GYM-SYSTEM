package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;

public abstract class  user{
    Scanner input=new Scanner(System.in);
    //function commect
   public static Connection connect() throws SQLException{
       return DriverManager.getConnection("jdbc:mysql://localhost/gym_data", "root", ""); 
    }
   abstract public int login(String name,String password);  
   abstract public void update(String id,String name,String father_name, String email,String mobil,String coach_name,String gymtime,String age,String amount);
}
        


