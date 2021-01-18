/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.ProjectProcess;
import beans.app;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author framawy
 */
@ManagedBean
public class formController2 {
    //////////////////////////////////////////////////////Start of project Section/////////////////////

  public String OnSubmitEditproj() throws SQLException{
        // when the users creates a new item
        
        
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
       // store the "get" values in an object 
       app p = context.getApplication().evaluateExpressionGet(context,"#{app}", app.class);
       
       //hold the value of the object that was in the web page
       
       System.out.println("The Object you Edited is : " + p.getProjName());
       
        ProjectProcess pp = new ProjectProcess();
          pp.update(p);
       
       //show the response page.
        
       return "Project.xhtml";
}
       public String OnSubmitAddproj() throws SQLException{
        // when the users creates a new item
        
        
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
       // store the "get" values in an object 
       app p = context.getApplication().evaluateExpressionGet(context,"#{app}", app.class);
       
       //hold the value of the object that was in the web page
       
       System.out.println("The Object you wanna add is : " + p.getProjName());
       
        ProjectProcess pp = new ProjectProcess();
         pp.add(p); 
       
       //show the response page.
        
       return "Project.xhtml";
}
public String deleteonproj() throws SQLException{
        // when the users creates a new item
        
        
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
       // store the "get" values in an object 
       app p = context.getApplication().evaluateExpressionGet(context,"#{app}", app.class);
       
       //hold the value of the object that was in the web page
       
       System.out.println("The Object you wanna delete is : " + p.getProjName());
       
       ProjectProcess pp = new ProjectProcess();
          pp.delete(p);
       
       //show the response page.
        
       return "Project.xhtml";
       
}
public  ArrayList<app> GetAllproj() throws SQLException{
        ProjectProcess pp = new ProjectProcess();
        
        return pp.readALl();
    }
public String OnShowproj(app p){
        
        System.out.println("The Object you Choose is : " + p.getProjName());
         FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("app", p);
        return "Project.xhtml";    
    }  

//////////////////////////////////////////////////////End of project Section/////////////////////


}
