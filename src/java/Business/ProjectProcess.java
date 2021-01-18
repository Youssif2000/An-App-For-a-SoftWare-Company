/*
 * To change this license header, choose License Headers in project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;



import beans.app;
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

public class ProjectProcess {
    
    public void add(app p) {
        String strInsert = " insert into project values( "+
                p.getProjId() + ",'" + p.getProjName() + "'," +
              "'" +  p.getProjManger()  + "'," + "'" + p.getClientName() + "')";
        boolean isAdded = database.go.runNonQuery(strInsert);
        if(isAdded){
            System.out.println("Project is Added");
        }
    }

    
   
    public void update(app p) {

        String strUpdate = "update project set " +
                "projectName= '" + p.getProjName() + "'," +
              "projectManager= '" + p.getProjManger() + "'," +
                      "clientName= '" + p.getClientName() + "'" +
                " where projectId = " + p.getProjId();
        boolean isupdated = database.go.runNonQuery(strUpdate);
        if(isupdated){
            System.out.println("Project is Updated");
        }
        
                      
    }

   
    public void delete(app p) {
        String strdelete = " delete from project " +
                " where ProjectId= " + p.getProjId();
        boolean isdeleted = database.go.runNonQuery(strdelete);
        if(isdeleted){
            System.out.println("Project is Deleted");
        }
    }
    public ArrayList<app> readALl(){
        ArrayList<app> everyone = new ArrayList<>();
        app pro;
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
            rs = stmt.executeQuery("SELECT * FROM `project`");
            //process the rows in in the result set
            while(rs.next()){
            
       pro = new app(rs.getInt("projectId") , rs.getString("projectName"), rs.getString("projectManager") , rs.getString("clientName"));
                
                everyone.add(pro);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error Communication with database");
            ex.printStackTrace();
        } 
        
        return everyone;
    }

}
