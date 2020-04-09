/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jesús
 */
public class Clients {
    String id;
    String fname;
    String lname;
    String lname2;
    String tipocliente;
    String tel;
    String dir;
    String plan;

    public Clients(String id, String fname, String lname, String lname2, String tel, String dir, String tipo_cliente, String plan) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.lname2 = lname2;
        this.tel = tel;
        this.dir = dir;
        this.tipocliente = tipo_cliente;
        this.plan = plan;
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
    
    public String getTel() {
        return tel;
    }
    
    public String getDir() {
        return dir;
    }
    
    public String getTipocliente() {
        return tipocliente;
    }

    public String getPlan() {
        return plan;
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


    public void setTel(String tel) {
        this.tel = tel;
    }


    public void setDir(String dir) {
        this.dir = dir;
    }
    
    public void setTipocliente(String tipocliente) {
        this.tipocliente = tipocliente;
    }
  
}
