package Modelo;

/**
 *
 * @author carban
 */
public class Vendedor {

    String id;
    String fname;
    String lname;
    String pass;
    String position;
    String tel;
    String dir;
    String state;
    String sede;
    String idsede;

    public Vendedor(String id, String fname, String lname, String tel, String dir, String wp, String pass, String state, String sede, String idsede) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.pass = pass;
        this.position = wp;
        this.tel = tel;
        this.dir = dir;
        this.state = state;
        this.sede = sede;
        this.idsede = idsede;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getIdsede() {
        return idsede;
    }

    public void setIdsede(String idsede) {
        this.idsede = idsede;
    }

}
