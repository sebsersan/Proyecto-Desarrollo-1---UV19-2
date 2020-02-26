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
public class Orden {
    String idOrden;
    String cantidadFabricar;
    boolean estado;
    String idProducto;
    String idSede;

    public Orden(String cantidadFabricar, boolean estado, String idProducto,String idSede) {
        this.cantidadFabricar = cantidadFabricar;
        this.estado = estado;
        this.idProducto = idProducto;
        this.idSede = idSede;
    }

    public String getIdOrden() {
        return idOrden;
    }

    public String getCantidadFabricar() {
        return cantidadFabricar;
    }

    public boolean getEstado() {
        return estado;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getIdSede() {
        return idSede;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public void setCantidadFabricar(String cantidadFabricar) {
        this.cantidadFabricar = cantidadFabricar;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setIdSede(String idSede) {
        this.idSede = idSede;
    }
    
    
}
