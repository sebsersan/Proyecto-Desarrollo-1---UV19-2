/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;
import Modelo.Sedes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;
/**
 *
 * @author juancamilo
 */
public class SedesDAO {
    Acceso access;

    public SedesDAO(Acceso access) {
        this.access = access;
    }
    
    public boolean createNewSede(Sedes aSede){
        String querySQL = "INSERT INTO Sedes(city,address,stateSede,idUser) VALUES ('"+aSede.getCiudad()+ "', '"+aSede.getDireccion()+ "', '"
                +aSede.getEstado()+ "', '"+aSede.getJefe()+ "')";
        String querySQLaux = "SELECT idSedes FROM Sedes WHERE city = '"+aSede.getCiudad()+"' and address = '"+aSede.getDireccion()+"'";
        String queryActivo = "UPDATE users SET stateuser='Activo' WHERE idUser = '"+aSede.getJefe()+"'";
        System.out.println(querySQL);
        System.out.println(querySQLaux);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(querySQLaux);
            System.out.println("resultado: "+resultado);
            
            if(resultado.next()){
                JOptionPane.showMessageDialog(null, "La sede ya existe \nIntenta de nuevo");
            }else{
                int res = sentencia.executeUpdate(querySQL);
                int active = sentencia.executeUpdate(queryActivo);
                if(res==1 && active==1){
                    return true;
                }else{
                    return false;
                }
            }

        } catch (PSQLException exe) {
            System.out.println("---- Problema en la ejecucion.");
            exe.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return false;
    }
 
    public ResultSet comboOptions(){
        String QuerySQL = "SELECT * FROM Users WHERE work_position = 'Jefe de Taller' AND stateuser='Inactivo'";
        System.out.println(QuerySQL);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            return resultado;

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return null;
    }
    
        public ResultSet comboJefeAsignado(){
            String QuerySQL = "SELECT * FROM Users WHERE work_position = 'Jefe de Taller' AND stateuser='Inactivo'";
            System.out.println(QuerySQL);
            Connection coneccion= this.access.getConnetion();
            System.out.println("Connection: "+coneccion);

            try {
                Statement sentencia = coneccion.createStatement();
                System.out.println("sentencia: "+sentencia);
                ResultSet resultado = sentencia.executeQuery(QuerySQL);
                System.out.println("resultado: "+resultado);
                return resultado;

            } catch (SQLException ex) {
                System.out.println("---- Problema en la ejecucion.");
                ex.printStackTrace();
            }
            return null;
    }
    
    public boolean updateSede(Sedes aSede, String jefeActual) {
            String QuerySQL = "UPDATE Sedes SET city='"+aSede.getCiudad()+
                    "', address='"+aSede.getDireccion()+ "', stateSede='"+aSede.getEstado()
                    + "', idUser='"+aSede.getJefe()+"' WHERE idSedes = '"+aSede.getId()+"'";
            
        String QuerySQLaux = "SELECT idSedes FROM Sedes WHERE idSedes = '"+aSede.getId()+"'";
        String queryActivo = "UPDATE users SET stateuser='Activo' WHERE idUser = '"+aSede.getJefe()+"'";
        String queryInactivo = "UPDATE users SET stateuser='Inactivo' WHERE idUser = '"+jefeActual+"'";

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
                //VALIDACION DE CAMBIO DE USUARIO
                int active = 0;
                int inactive = 0;
                System.out.println("Current"+jefeActual);
                System.out.println("Other:" +aSede.getJefe());
                if(!aSede.getJefe().equals(jefeActual)){
                    System.out.println("HOLIWI");
                    active = sentencia.executeUpdate(queryActivo);
                    inactive = sentencia.executeUpdate(queryInactivo);
                    if(res==1 && (active==1 || inactive==1)){ //Esta condicion es necesaria para que funcione todo 
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    if(res==1){
                        return true;
                    }
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
       
    public ArrayList<String[]> consultSede(){
        String QuerySQL = "select idSedes, city, address, stateSede, idUser, first_name, last_name from sedes NATURAL JOIN users";
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
                
                String a1 = resultado.getString("idSedes");
                String a2 = resultado.getString("city");
                String a3 = resultado.getString("address");
                String a4 = resultado.getString("stateSede");
                String a5 = resultado.getString("idUser")+", "+resultado.getString("first_name")+" "+resultado.getString("last_name");
                String[] niu = {a1, a2, a3, a4, a5}; //Es importante crear un nuevo arreglo cada vez
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

    public ArrayList<String[]> consultSedesCoincidencia_tabla(String busqueda) {
        String QuerySQL = "select * from (select idSedes, city, address, stateSede, idUser, first_name, last_name from sedes NATURAL JOIN users) as sedes where LOWER (city) LIKE LOWER ('" + busqueda + "%');";
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
                
                String a1 = resultado.getString("idSedes");
                String a2 = resultado.getString("city");
                String a3 = resultado.getString("address");
                String a4 = resultado.getString("stateSede");
                String a5 = resultado.getString("idUser")+", "+resultado.getString("first_name")+" "+resultado.getString("last_name");
                String[] niu = {a1, a2, a3, a4, a5}; //Es importante crear un nuevo arreglo cada vez
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
