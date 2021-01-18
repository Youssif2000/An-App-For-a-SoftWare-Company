
package beans;


import javax.faces.bean.ManagedBean;


@ManagedBean
public class employee {
    private int empid;
    private String name;
    private int salary;
    private String address;
    private String hiringDate;
    private int age;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public employee(int empid, String name, int salary, String address, String hiringDate, int age) {
        this.empid = empid;
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.hiringDate = hiringDate;
        this.age = age;
    }

   
   
    public employee(){
        
    }

    
}
