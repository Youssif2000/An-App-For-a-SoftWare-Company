/*
 * To change this license header, choose License Headers in project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Business.EmployeeProcess;
import Business.EntryProcess;

import beans.employee;

import beans.entry;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author framawy
 */
@ManagedBean
public class formController {
     public String checkUserAndPass() throws SQLException{
        
         //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
        // store the "get" values in an object
        entry en = context.getApplication().evaluateExpressionGet(context,"#{entry}", entry.class);
        
        EntryProcess ep = new EntryProcess();
        
         boolean Check = ep.check(en);
         if(Check){
             
             return "Main.xhtml";
         }  else{
             
             return "Errorpage";
         }
       
    }
     
     public String GoToEmployeepage(){
    
    return "Employee.xhtml";
}
 public String GoToDepartementpage(){
    
    return "Department.xhtml";
}   
 public String GoToProjectpage(){
    
    return "Project.xhtml";
}   
 public  ArrayList<employee> GetAll() throws SQLException{
        EmployeeProcess e = new EmployeeProcess();
        
        return e.readALl();
    }
 
   public String OnShow(employee em){
        
        System.out.println("The Object you Choose is : " + em.getName());
         FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("employee", em);
        return "Employee.xhtml";    
    }    
    
   
 //////////////////////////////////////////////////////ٍStart of Employee Section/////////////////////
    public String OnSubmitEdit() throws SQLException{
        // when the users creates a new item
        
        
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
       // store the "get" values in an object 
       employee e = context.getApplication().evaluateExpressionGet(context,"#{employee}", employee.class);
       
       //hold the value of the object that was in the web page
       
       System.out.println("The Object you Edited is : " + e.getName());
       
        EmployeeProcess ea = new EmployeeProcess();
          ea.update(e);
       
       //show the response page.
        
       return "Employee.xhtml";
}
       public String OnSubmitAdd() throws SQLException{
        // when the users creates a new item
        
        
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
       // store the "get" values in an object 
       employee e = context.getApplication().evaluateExpressionGet(context,"#{employee}", employee.class);
       
       //hold the value of the object that was in the web page
       
       System.out.println("The Object you wanna add is : " + e.getName());
       
        EmployeeProcess ea = new EmployeeProcess();
          ea.add(e);
       
       //show the response page.
        
       return "Employee.xhtml";
}
public String deleteon() throws SQLException{
        // when the users creates a new item
        
        
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
       // store the "get" values in an object 
       employee e = context.getApplication().evaluateExpressionGet(context,"#{employee}", employee.class);
       
       //hold the value of the object that was in the web page
       
       System.out.println("The Object you wanna delete is : " + e.getName());
       
        EmployeeProcess ea = new EmployeeProcess();
          ea.delete(e);
       
       //show the response page.
        
       return "Employee.xhtml";
       
}
//////////////////////////////////////////////////////End of Employee Section/////////////////////



}