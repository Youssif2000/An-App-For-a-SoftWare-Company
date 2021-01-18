/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import beans.employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author framawy
 */
@ManagedBean
public class EmployeeProcess {
    
  
    
    
     public void add(employee em) {
        String Insert = " insert into employee values ( " 
                  + em.getEmpid() + ", " 
                +"'" +em.getName() + "', "
                + em.getSalary() + ", " +
                "'" + em.getAddress()  + "', " 
               + "'" + em.getHiringDate() + "', " 
               + em.getAge() +")";
                 
                
       boolean isAdded = database.go.runNonQuery(Insert);
                if(isAdded){
                    System.out.println("Employee is Added");
                }
    }

     
    public void update(employee em) {
        String Update = "UPDATE employee SET " 
                + "Name= '" + em.getName() +"', " 
                + "Salary= " + em.getSalary() + ", " +
        "Address= '" + em.getAddress() + "', "
        + "HiringDate='" + em.getHiringDate() + "', " 
                + "Age=" + em.getAge() 
               + " WHERE Id= " + em.getEmpid();
        boolean isUpdated = database.go.runNonQuery(Update);
        if(isUpdated) {
          System.out.println("Employee  is Updated");
        }
        
    }

    
    public void delete(employee em) {
        String delete = " delete from employee where " +
                "Id= " + em.getEmpid();
        boolean isdeleted = database.go.runNonQuery(delete);
        if(isdeleted){
           System.out.println("The info is Deleted");
        }
    }
    
     public ArrayList<employee> readALl(){
        ArrayList<employee> everyone = new ArrayList<>();
        employee emp;
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
            rs = stmt.executeQuery("SELECT * FROM `employee`");
            //process the rows in in the result set
            while(rs.next()){
            
       emp = new employee(rs.getInt("Id") , rs.getString("Name"), rs.getInt("Salary") , rs.getString("Address") , rs.getString("HiringDate") , rs.getInt("Age"));
                
                everyone.add(emp);
            }
            
           
            
        } catch (SQLException ex) {
            System.out.println("Error Communication with database");
            ex.printStackTrace();
        } 
        
        return everyone;
    }

}
