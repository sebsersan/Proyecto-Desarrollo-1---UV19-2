/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Orden;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author invitado
 */
public class OrdenDAO {

    Acceso access;

    public OrdenDAO(Acceso access) {
        this.access = access;
    }
    
    
    public boolean crearOrden(Orden aOrden) {
        String QuerySQL = "INSERT INTO Orden(cantidad_pedido, estado_pedido, idProducto, idSedes) VALUES ("+ aOrden.getCantidadFabricar() + ", '"+aOrden.getEstado()+ "', '"+aOrden.getIdProducto()+ "', '"
                +aOrden.getIdSede()+"')";
        System.out.println(QuerySQL);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            int res = sentencia.executeUpdate(QuerySQL);
            System.out.println("resultado: "+res);
            if(res==1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<String[]> consultOrders(String sedeid) {
        String QuerySQL = "select * from (orden natural join producto) where idsedes='"+sedeid+"' and estado_pedido='t' ORDER BY idorden";
        System.out.println(QuerySQL);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            

            ArrayList<String[]> matrixList = new ArrayList<String[]>();
            int cont = 0;
            while (resultado.next()) {
                
                String a1 = resultado.getString("idorden");
                String a2 = resultado.getString("cantidad_pedido");
                String a3 = resultado.getString("idproducto");
                String a4 = resultado.getString("nombre");
                String a5 = resultado.getString("descripcion");
                String a6 = resultado.getString("color");
                String a7 = resultado.getString("alto");
                String a8 = resultado.getString("largo");
                String a9 = resultado.getString("ancho");
                String a10 = resultado.getString("precio");
                
                String[] niu = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10}; //Es importante crear un nuevo arreglo cada vez
                matrixList.add(niu);
                cont++;
            }
            return matrixList;

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return null;
    }

    public boolean finalizarOrden(String idOrden, String idProd, String sedeid) {
        String QuerySQL = "UPDATE orden set estado_pedido='f' where idorden='"+idOrden+"'";
        String QueryTransaccion = "UPDATE inventario SET cantidad = (select cantidad from inventario where idproducto='"+idProd+"' and idsedes='"+sedeid+"') + (select cantidad_pedido from orden where idorden='"+idOrden+"') where idproducto='"+idProd+"' and idsedes='"+sedeid+"'";
        System.out.println(QuerySQL);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            int res = sentencia.executeUpdate(QuerySQL);
            System.out.println("resultado: "+res);
            if(res==1){
                int res2 = sentencia.executeUpdate(QueryTransaccion);
                if (res2==1) {
                    return true;   
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<String[]> consultOrdenesCoincidencia(String idSede, String busqueda) {
        String QuerySQL = "SELECT * FROM (select * from (orden natural join producto) where idsedes='"+idSede+"' and estado_pedido='t' ORDER BY idorden) AS ordens WHERE LOWER (ordens.nombre)  LIKE LOWER ( '%" + busqueda + "%') OR "
                + "CAST(ordens.idOrden AS TEXT) LIKE '" + busqueda + "%'";
        System.out.println(QuerySQL);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            

            ArrayList<String[]> matrixList = new ArrayList<String[]>();
            int cont = 0;
            while (resultado.next()) {
                
                String a1 = resultado.getString("idorden");
                String a2 = resultado.getString("cantidad_pedido");
                String a3 = resultado.getString("idproducto");
                String a4 = resultado.getString("nombre");
                String a5 = resultado.getString("descripcion");
                String a6 = resultado.getString("color");
                String a7 = resultado.getString("alto");
                String a8 = resultado.getString("largo");
                String a9 = resultado.getString("ancho");
                String a10 = resultado.getString("precio");
                
                String[] niu = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10}; //Es importante crear un nuevo arreglo cada vez
                matrixList.add(niu);
                cont++;
            }
            return matrixList;

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return null;
    }
    
    
    
}
