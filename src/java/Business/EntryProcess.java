/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import beans.entry;
import java.sql.SQLException;

/**
 *
 * @author framawy
 */
public class EntryProcess {
    
    
     public boolean check(entry ep) throws SQLException {
        
        
        boolean Checked = database.go.checkUserAndPass(ep.getUser() , ep.getPass() );
        return Checked;
                
    }
}
