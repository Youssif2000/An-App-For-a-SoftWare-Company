
package database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class go {
    
 private static String url = "";
 private static Connection con;
 
 public static void setUrl(){
     
     url="jdbc:mysql://localhost:3306/softwarecompany" +
             "?zeroDateTimeBehavior=convertToNull";
      
     
 }
 public static void setConnection(){
     
     try {
         setUrl();
         con = DriverManager.getConnection(url, "root", "");
     } catch (SQLException ex) {
         System.out.println("Error Communication with database");
            ex.printStackTrace();
     }
     
     
 }
 public static boolean checkUserAndPass(String username , String Password){
     
     setConnection();
     try {
         Statement  stmt =  con.createStatement();
         String strCheck = "select * from `entry licence` where " 
                 + "username='" +  username +"' and " + "pass= '" + Password + "'";
         stmt.executeQuery(strCheck);
         while( stmt.getResultSet().next()){
          con.close();
          return  true;   
         }
                   con.close();

     } catch (SQLException ex) {
         System.out.println(ex.getMessage());
     }
     
    return false;
 }
 
 public static boolean runNonQuery(String  sqlStatement){
    
     try {
         setConnection();
        Statement stmt = con.createStatement();
        stmt.execute(sqlStatement);
        con.close();
        return true;
     } catch (SQLException ex) {
         
         System.out.println(ex.getMessage());
              return false;
                             
     }
     
 }
 /*
 public static void fillCombo(String tableName , String columnName , JComboBox combo){
    
     
     try {
         setConnection();
         Statement stmt = con.createStatement();
         ResultSet rs;
         
         String strSelect = "select " +columnName+" from " + tableName;
       rs= stmt.executeQuery(strSelect);
       
       rs.last();
       int c = rs.getRow();
       rs.beforeFirst();
       
       String Values[] = new String[c];
       
       int i = 0; 
       while (rs.next()){
           Values[i]  = rs.getString(1);
           i++;
       }
       con.close();
       combo.setModel(new DefaultComboBoxModel(Values));
     } catch (SQLException ex) {
         Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
     }
          
     
     
 }
*/

 
 
 }

 

