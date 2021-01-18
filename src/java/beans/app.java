/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class app {
    
    
    private int projId;
    private String projName;
    private String projManger;
    private String clientName;

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjManger() {
        return projManger;
    }

    public void setProjManger(String projManger) {
        this.projManger = projManger;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public app(int projId, String projName, String projManger, String clientName) {
        this.projId = projId;
        this.projName = projName;
        this.projManger = projManger;
        this.clientName = clientName;
    }

    public app() {
    }
    
    
}
  class ap2 {


}
