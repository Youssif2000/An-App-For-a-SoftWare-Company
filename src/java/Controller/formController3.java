/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.EDprocess;
import beans.employeeisdepart;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author framawy
 */
@ManagedBean
public class formController3 {
    
    //////////////////////////////////////////////////////Start of ED  Section/////////////////////
public String OnSubmitEditED() throws SQLException{
        // when the users creates a new item
        
        
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
       // store the "get" values in an object 
       employeeisdepart ed = context.getApplication().evaluateExpressionGet(context,"#{employeeisdepart}", employeeisdepart.class);
       
       //hold the value of the object that was in the web page
       
       System.out.println("The Object you Edited is : " + ed.getName());
       
        EDprocess ep = new EDprocess();
          ep.update(ed);
       
       //show the response page.
        
       return "Department.xhtml";
}
       public String OnSubmitAddED() throws SQLException{
        // when the users creates a new item
        
        
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
       // store the "get" values in an object 
       employeeisdepart ed = context.getApplication().evaluateExpressionGet(context,"#{employeeisdepart}", employeeisdepart.class);
       
       //hold the value of the object that was in the web page
       
       System.out.println("The Object you wanna add is : " +ed.getName() );
       
        EDprocess ep = new EDprocess();
         ep.add(ed); 
       
       //show the response page.
        
       return "Department.xhtml";
}
public String deleteonED() throws SQLException{
        // when the users creates a new item
        
        
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
       // store the "get" values in an object 
       employeeisdepart ed = context.getApplication().evaluateExpressionGet(context,"#{employeeisdepart}", employeeisdepart.class);
       
       //hold the value of the object that was in the web page
       
       System.out.println("The Object you wanna delete is : " + ed.getName());
       
       EDprocess ep = new EDprocess();
          ep.delete(ed);
       
       //show the response page.
        
       return "Department.xhtml";
       
}
public  ArrayList<employeeisdepart> GetAllED() throws SQLException{
        EDprocess ep = new EDprocess();
        
        return ep.readALl();
    }
public String OnShowED(employeeisdepart ed){
        
        System.out.println("The Object you Choose is : " + ed.getName());
         FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("employeeisdepart", ed);
        return "Department.xhtml";    
    }  

}


