
package Modelo;

public class Telefono {
    String id;
    String tel;
    String plan;
    
    public Telefono (String id, String tel, String plan){
        this.id = id;
        this.tel = tel;
        this.plan = plan;

    }

    public String getId() {
        return id;
    }

    public String getPlan() {
        return plan;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }    
  
}
