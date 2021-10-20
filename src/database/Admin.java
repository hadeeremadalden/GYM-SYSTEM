package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//............................................
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Admin extends user{
   public Admin(){     
   }
    //login...................
     @Override
     public int login(String name,String password){
        int x=0;
        try{
       Connection con=user.connect(); 
       PreparedStatement p=con.prepareStatement("select * from admin");
       ResultSet rs=p.executeQuery();
       while(rs.next())
        {
       if(name.equals(rs.getString(1))&&password.equals(rs.getString(2))){
            x=1;
            break;
        }
        }
        }catch(Exception ee){
        JOptionPane.showMessageDialog(null,ee);    
        }
        return x;
    } 
    //function alter.................
    public static int alter(String name,String password){
        int x=0;
        try{
       Connection con=user.connect(); 
       PreparedStatement p=con.prepareStatement("select * from admin");
       ResultSet rs=p.executeQuery();
       while(rs.next())
        {
       if(name.equals(rs.getString(1))&&password.equals(rs.getString(2))){
         x=1;
         break;
            }  
        }
        }catch(Exception ee){
        JOptionPane.showMessageDialog(null,ee);    
        }
        return x;
 }
    //admin add member.................
    public static void add_member(String id,String name,String father_name, String email,String gender,String mobil,String coach_name,String gymtime,String date_substraction,String age,String amount){
        try{
       Connection con=user.connect(); 
       PreparedStatement p=con.prepareStatement("insert into member values (?,?,?,?,?,?,?,?,?,?,?)"); 
       p.setString(1, id);
       p.setString(2, name);
       p.setString(3, father_name);
       p.setString(4, email);
       p.setString(5, gender);
       p.setString(6, mobil);
       p.setString(7, coach_name);
       p.setString(8, gymtime);
       p.setString(9, date_substraction);
       p.setString(10, age);
       p.setString(11, amount);
       p.executeUpdate();
       JOptionPane.showMessageDialog(null,"successfully saved");
        }catch(Exception ee){
             JOptionPane.showMessageDialog(null,ee);
        }       
    }
    //admin add coach.........................
  public static void add_coach(String id,String name,String father_name, String email,String gender,String mobil,String coach_name,String gymtime,String date_substraction,String age,String amount){  
        try{
            Connection con=user.connect();
            PreparedStatement p=con.prepareStatement("insert into coach values (?,?,?,?,?,?,?,?,?,?,?)");
            p.setString(1, id);
            p.setString(2, name);
            p.setString(3, father_name);
            p.setString(4, email);
            p.setString(5, gender);
            p.setString(6, mobil);
            p.setString(7, coach_name);
            p.setString(8, gymtime);
            p.setString(9, date_substraction);
            p.setString(10, age);
            p.setString(11, amount);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null,"successfully saved");
        }catch(Exception ee){
            JOptionPane.showMessageDialog(null,ee);
        }
}
 //admin delete coach..........
  public static void delete_member(String id){
 int a=JOptionPane.showConfirmDialog(null,"Do you really want to delete this member","select",JOptionPane.YES_NO_OPTION);
        if(a==0){     
            try{
       Connection con=user.connect(); 
       PreparedStatement p=con.prepareStatement("delete from member where id='"+id+"'"); 
       p.executeUpdate();
       JOptionPane.showMessageDialog(null,"Successfully deleted");
            }catch(Exception ee){
                JOptionPane.showMessageDialog(null,ee);
            }
        }    
 }
 //admin delete coach.............
 public static void delete_coach(String id){
     int a=JOptionPane.showConfirmDialog(null,"Do you really want to delete this coach","select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            try{
                Connection con=user.connect();
                PreparedStatement p=con.prepareStatement("delete from coach where id='"+id+"'");
                p.executeUpdate();
                JOptionPane.showMessageDialog(null,"Successfully deleted");
            }catch(Exception ee){
                JOptionPane.showMessageDialog(null,ee);
            }
 }
}
 //admin update member................
 public static void update_Member(String id,String name,String father_name, String email,String mobil,String coach_name,String gymtime,String age,String amount){
     try{
       Connection con=user.connect(); 
       PreparedStatement p=con.prepareStatement("update member set Name=?,Father_name=?,Email=?,Mobil=?,Coach_name=?,Gym_time=?,Age=?,amount_to_pay=? where id=?"); 

       p.setString(1, name);
       p.setString(2, father_name);
       p.setString(3, email);
       p.setString(4, mobil);
       p.setString(5, coach_name);
       p.setString(6, gymtime);
       p.setString(7, age);
       p.setString(8, amount);
       p.setString(9, id);
       p.executeUpdate();
       JOptionPane.showMessageDialog(null,"successfully saved");
        }catch(Exception ee){
             JOptionPane.showMessageDialog(null,ee);
        }       
    }
 //admin update coach......................................
 public static void update_coach(String id,String name,String father_name, String email,String mobil,String coach_name,String gymtime,String age,String amount){
     try{
       Connection con=user.connect(); 
       PreparedStatement p=con.prepareStatement("update coach set Name=?,Father_name=?,Email=?,Mobil=?,member_name=?,Gym_time=?,Age=?,amount_to_pay=? where id=?"); 
       p.setString(1, name);
       p.setString(2, father_name);
       p.setString(3, email);
       p.setString(4, mobil);
       p.setString(5, coach_name);
       p.setString(6, gymtime);
       p.setString(7, age);
       p.setString(8, amount);
       p.setString(9, id);
       p.executeUpdate();
       JOptionPane.showMessageDialog(null,"successfully saved");
        }catch(Exception ee){
             JOptionPane.showMessageDialog(null,ee);
        }       
    }
//admid list member........................................
 public static void list_member(DefaultTableModel models) {
     DefaultTableModel model=models;
        try{
        Connection con=user.connect(); 
       PreparedStatement p=con.prepareStatement("select *from member"); 
       ResultSet rs=p.executeQuery();
       while(rs.next()){
          model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
          
       }
            }catch(Exception ee){
                JOptionPane.showMessageDialog(null,ee);
            }
}
 //admin list coach........................................
 public static void list_coach(DefaultTableModel models) {
     DefaultTableModel model=models;
        try{
        Connection con=user.connect(); 
       PreparedStatement p=con.prepareStatement("select *from coach"); 
       ResultSet rs=p.executeQuery();
       while(rs.next()){
          model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
          
       }
            }catch(Exception ee){
                JOptionPane.showMessageDialog(null,ee);
            }
}
//admin make reports.....................................
 public static void reports(String id,String reports){
        try{
            Connection con=user.connect();
            PreparedStatement p=con.prepareStatement("insert into reports values (?,?)");
            p.setString(1, id);
            p.setString(2, reports);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null,"successfully saved");
        }catch(Exception ee){
            JOptionPane.showMessageDialog(null,ee);
        }
 }
 //admin send message..................................
 public static void send_message(String sendfrom,String password,String sendto,String text){
                    Properties props = new Properties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");
                    Session session = Session.getInstance(props,
                      new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(sendfrom, password);
                        }
                      });

                    try {
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(sendfrom));
                        message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(sendto));
                        message.setSubject("Hello");
                        message.setText(text);

                        Transport.send(message);
                        JOptionPane.showMessageDialog(null,"successfully saved");
                        System.out.println("Done");

                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
 }
}