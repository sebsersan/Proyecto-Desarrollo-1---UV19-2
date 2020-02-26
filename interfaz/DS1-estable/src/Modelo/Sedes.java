/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author juancamilo
 */
public class Sedes {
    String id;
    String ciudad;
    String direccion;
    String estado;
    String jefe;

    public Sedes(String ciudad, String direccion,String estado, String jefe) {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.estado = estado;
        this.jefe = jefe;
    }

    public String getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getJefe() {
        return jefe;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
