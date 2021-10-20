
package gym_managment_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.*;
import database.user;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.Date;

public class admin extends user{
    public admin(){ 
    }
   public void date(){
   SimpleDateFormat dFormat=new SimpleDateFormat();
   Date date = new Date();    
   String strDate= dFormat.format(date); 
      }
     public static Date addDays(Date d)
    {
        //30*1000*60*60*
        d.setTime(d.getTime() + 30 * 1000 * 60 * 60 * 24);
        return d;
    }
   public void send_notification() throws SQLException {
       Connection con=user.connect(); 
       PreparedStatement p=con.prepareStatement("select Date_of_subscription from member"); 
       ResultSet rs=p.executeQuery();
       String d;
       while(rs.next())
           {
            d=rs.getString("Date_of_subscription");  
            
           }
} 
}
        
    

