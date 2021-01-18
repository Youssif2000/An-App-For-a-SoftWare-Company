/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import beans.employeeisdepart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author framawy
 */
public class EDprocess {
    
    
    public void add(employeeisdepart db) {
        String Insert = " insert into employeeisdepart values (" 
                + db.getId() + ","
                + "'" + db.getName() + "', " +
                 "'" + db.getValue() + "', " +
                 "'"+ db.getEmpId() + "')";
        
        boolean isAdded = database.go.runNonQuery(Insert);
                if(isAdded){
                    System.out.println("Department is Added");
                }
    }

    public void update(employeeisdepart db) {
        String Update = "update employeeisdepart set "
                + "name= '" + db.getName() + "', "
        + "value= '" + db.getValue() + "', " 
        + "empId= '" + db.getEmpId() + "' " 
               + "where id =" + db.getId();
        
        boolean isUbdated = database.go.runNonQuery(Update);
        
        if(isUbdated){
             System.out.println("Department is Ubdated");
        }
        
    }

   
    public void delete(employeeisdepart db) {
        String delete = " delete from employeeisdepart "
               +  "where id =" + db.getId();
        boolean isdeleted =database.go.runNonQuery(delete);
        if(isdeleted){
            
             System.out.println("Dept is Deleted");
        }
    }
    
    public ArrayList<employeeisdepart> readALl(){
        ArrayList<employeeisdepart> everyone = new ArrayList<>();
        employeeisdepart ed;
        //databaseWork
         try {
            // Connect
            Connection c = null;
            Statement stmt = null;
            ResultSet rs;
           String dburl ="jdbc:mysql://localhost:3306/softwarecompany" +
             "?zeroDateTimeBehavior=convertToNull";
            c = DriverManager.getConnection(dburl, "root", "");
            stmt = c.createStatement();
         
            
            //execute the statement
            rs = stmt.executeQuery("SELECT * FROM `employeeisdepart`");
            //process the rows in in the result set
            while(rs.next()){
           
       ed = new employeeisdepart(rs.getInt("id") , rs.getString("name"), rs.getString("value") , rs.getInt("empId"));
                
                everyone.add(ed);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error Communication with database");
            ex.printStackTrace();
        } 
        
        return everyone;
    }
 
}
