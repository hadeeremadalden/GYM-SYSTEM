/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class coach extends user{
 public  coach(){
       
   }
     @Override
     public int login(String name,String password){
        int x=0;
        try{
       Connection con=user.connect(); 
       PreparedStatement p=con.prepareStatement("select * from coach");
       ResultSet rs=p.executeQuery();
       while(rs.next())
        {
       if(name.equals(rs.getString(2))&&password.equals(rs.getString(1))){
            x=1;
            break;
        }
        }
        }catch(Exception ee){
        JOptionPane.showMessageDialog(null,ee);    
        }
        return x;
    } 
 @Override
 public  void update(String id,String name,String father_name, String email,String mobil,String coach_name,String gymtime,String age,String amount){
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
     }

