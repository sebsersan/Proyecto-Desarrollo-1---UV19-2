/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author invitado
 */
public class Jefes {
    String id;
    String fname;
    String lname;
    String pass;
    String position;
    String tel;
    String dir;
    String state;
    String idSede;
    String ciudadSede;
    String dirSede;

    public Jefes(String id, String fname, String lname, String tel, String dir, String wp, String pass, String state, String idSede, String ciudad, String dirSede) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.pass = pass;
        this.position = wp;
        this.tel = tel;
        this.dir = dir;
        this.state = state;
        this.idSede = idSede;
        this.ciudadSede = ciudad;
        this.dirSede = dirSede;
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

    public String getPass() {
        return pass;
    }

    public String getPosition() {
        return position;
    }

    public String getTel() {
        return tel;
    }

    public String getDir() {
        return dir;
    }

    public String getState() {
        return state;
    }

    public String getIdSede() {
        return idSede;
    }

    public String getCiudadSede() {
        return ciudadSede;
    }

    public String getDirSede() {
        return dirSede;
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

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setIdSede(String idSede) {
        this.idSede = idSede;
    }

    public void setCiudadSede(String ciudadSede) {
        this.ciudadSede = ciudadSede;
    }

    public void setDirSede(String dirSede) {
        this.dirSede = dirSede;
    }
    
}
