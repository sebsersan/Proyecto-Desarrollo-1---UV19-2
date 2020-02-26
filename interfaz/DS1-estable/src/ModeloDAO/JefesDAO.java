/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Users;
import Modelo.Jefes;
import Modelo.Vendedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;

/**
 *
 * @author invitado
 */
public class JefesDAO {
    Acceso access;

    public JefesDAO(Acceso access) {
        this.access = access;
    }
    
public Jefes consultProfile(String userID){
        String QuerySQL = "SELECT * FROM Users NATURAL JOIN Sedes WHERE idUser = '"+userID+"'";
        System.out.println(QuerySQL);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            if(resultado.next()){
                String iduser = resultado.getString("iduser");
                String fname = resultado.getString("first_name");
                String lname = resultado.getString("last_name");
                String tel = resultado.getString("telefono");
                String dir = resultado.getString("direccion");
                String wp = resultado.getString("work_position");
                String pass = resultado.getString("password");
                String state = resultado.getString("stateuser");
                String idSede = resultado.getString("idSedes");
                String ciudad = resultado.getString("city");
                String dirSede = resultado.getString("address");
                
                return new Jefes(iduser, fname, lname, tel, dir, wp, pass, state, idSede, ciudad, dirSede);
            }else{
                return new Jefes(null, null, null, null, null, null, null,null,null,null,null);
            }
            
        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return new Jefes(null, null, null, null, null, null, null,null,null,null,null);
    }

    public boolean createNewUser(Users aUser, String idSede){
        String QuerySQL = "INSERT INTO Users VALUES ("+ aUser.getId() + ", '"+aUser.getFname()+ "', '"+aUser.getLname()+ "', '"
                +aUser.getTel()+"', '"+aUser.getDir()+"', '"+aUser.getPosition()+ "', '"+aUser.getPass()+ "', '"+aUser.getState()+ "')";
        String QuerySQLaux = "SELECT idUser FROM Users WHERE idUser = '"+aUser.getId()+"' ";//AND work_position='Vendedor'";
        String QueryAddVendedorSede = "INSERT INTO vendedoresSede VALUES ('"+idSede+"' , '"+aUser.getId()+"')";
        System.out.println(QuerySQL);
        System.out.println(QuerySQLaux);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQLaux);
            System.out.println("resultado: "+resultado);
            if(resultado.next()){
                JOptionPane.showMessageDialog(null, "El usuario ya existe \nIntentelo nuevamente");
            }else{
                int res = sentencia.executeUpdate(QuerySQL);
                if(res==1){
                    int resVendedoresSede = sentencia.executeUpdate(QueryAddVendedorSede);
                    if (resVendedoresSede==1) {
                        return true;
                    }
                }else{
                    return false;
                }
            }

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<String[]> consultUsersVendedores(String idSede){
        String QuerySQL = "select iduser, first_name, last_name, telefono, direccion, work_position from (select * from users where work_position = 'Vendedor') as foo natural join (select * from vendedoressede where idsedes='"+idSede+"') as foo2";
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
                
                String a1 = resultado.getString("iduser");
                String a2 = resultado.getString("first_name");
                String a3 = resultado.getString("last_name");
                String a4 = resultado.getString("telefono");
                String a5 = resultado.getString("direccion");
                String a6 = resultado.getString("work_position");
                String[] niu = {a1, a2, a3, a4, a5, a6}; //Es importante crear un nuevo arreglo cada vez
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
    
    public boolean updateUserVendedor(Users aUser) {
            String QuerySQL = "UPDATE Users SET first_name='"+aUser.getFname()+ "', last_name='"+aUser.getLname()
                    +"', telefono='"+aUser.getTel()+"', direccion='"+aUser.getDir()+"' WHERE iduser = '"+aUser.getId()+"'";
            
        String QuerySQLaux = "SELECT idUser FROM Users WHERE idUser = '"+aUser.getId()+"' AND (work_position='Jefe de Taller' OR work_position='Vendedor')";
        System.out.println(QuerySQL);
        System.out.println(QuerySQLaux);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQLaux);
            System.out.println("resultado: "+resultado);
            if(resultado.next()){
                int res = sentencia.executeUpdate(QuerySQL);
                if(res==1){
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

    public boolean asignarUnVendedor(String id, String sedeid) {
        String QuerySQL = "UPDATE Users SET stateuser='Activo' WHERE iduser='"+id+"'";    
        String QuerySQLaux = "INSERT INTO vendedoressede VALUES ('"+sedeid+"', '"+id+"')";
        System.out.println(QuerySQL);
        System.out.println(QuerySQLaux);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            int res = sentencia.executeUpdate(QuerySQL);
            if(res==1){
                int res2 = sentencia.executeUpdate(QuerySQLaux);
                if (res2==1) {
                    return true;
                }
                else{
                    return false;
                }
            }else{
                return false;
            }

        } catch (PSQLException e){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un vendedor");
        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return false;  
    }

    public Vendedor consultProfileVENDEDOR(String userID) {
        String QuerySQL = "SELECT u.stateuser, u.password, u.idUser, u.first_name, u.last_name, u.telefono, u.direccion, u.work_position, s.city, s.idsedes"
                + " FROM Users u,vendedoresSede v, sedes s WHERE u.idUser = '"+userID+"'  AND u.idUser = v.idUser "
                + "AND v.idsedes = s.idsedes";
        
        System.out.println(QuerySQL);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            if(resultado.next()){
                String iduser = resultado.getString("iduser");
                String fname = resultado.getString("first_name");
                String lname = resultado.getString("last_name");
                String tel = resultado.getString("telefono");
                String dir = resultado.getString("direccion");
                String wp = resultado.getString("work_position");
                String pass = resultado.getString("password");
                String state = resultado.getString("stateuser");
                String sede = resultado.getString("city");
                String idsede = resultado.getString("idsedes");
                
                return new Vendedor(iduser, fname, lname, tel, dir, wp, pass, state, sede, idsede);
            }else{
                return new Vendedor(null, null, null, null, null, null, null,null, null, null);
            }
            
        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return new Vendedor(null, null, null, null, null, null, null,null, null, null);
    }

    public ArrayList<String[]> consultUsersVendedoresCoincidencia(String idSede, String busqueda) {
        
        String QuerySQL = "SELECT * FROM (select iduser, first_name, last_name, telefono, direccion, work_position from (select * from users where work_position = 'Vendedor') as foo natural join (select * from vendedoressede where idsedes='"+idSede+"') as foo2) AS cons WHERE LOWER (cons.iduser::text)  LIKE LOWER ( '" + busqueda + "%')";
       // System.out.println(QuerySQL);
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
                
                String a1 = resultado.getString("iduser");
                String a2 = resultado.getString("first_name");
                String a3 = resultado.getString("last_name");
                String a4 = resultado.getString("telefono");
                String a5 = resultado.getString("direccion");
                String a6 = resultado.getString("work_position");
                String[] niu = {a1, a2, a3, a4, a5, a6}; //Es importante crear un nuevo arreglo cada vez
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
