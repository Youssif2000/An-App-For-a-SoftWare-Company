
package beans;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class employeeisdepart {
    private int id;
    private String name;
    private String value;
    private int empId;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    
    
    public employeeisdepart(int id, String name , String value , int empId) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.empId = empId;
    }
    
    
    public employeeisdepart(){
    
}
    
    
    
    
}
