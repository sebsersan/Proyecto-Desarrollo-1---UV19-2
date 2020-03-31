
package Modelo;

public class Users {
    String id;
    String fname;
    String lname;
    String lname2;
    String pass;
    String position;
    String tel;
    String dir;
    String state;
    
    public Users (String id, String fname, String lname, String lname2, String tel, String dir, String position, String pass, String state){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.lname2 = lname2;
        this.pass = pass;
        this.position = position;
        this.tel = tel;
        this.dir = dir;
        this.state = state;
    }

    public Users(String id, String fname, String lname, String lname2, String tel, String dir, String tipo_cliente) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.lname2 = lname2;
        this.tel = tel;
        this.dir = dir;
        this.position = tipo_cliente;
    }

    public String getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
    
    public String getLname2() {
        return lname2;
    }

    public String getPass() {
        return pass;
    }

    public String getPosition() {
        return position;
    }

    public String getState() {
        return state;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    public void setLname2(String lname2) {
        this.lname2 = lname2;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    
  
}
