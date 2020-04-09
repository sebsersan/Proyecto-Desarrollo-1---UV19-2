package ModeloDAO;

import Modelo.Clients;
import Modelo.Telefono;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesús
 */
public class ClientsDAO {
    Acceso access;
    
    public ClientsDAO(Acceso access){
        this.access =  access;
    }
    
    public boolean createNewClient(Clients aClient){
        String QuerySQL = "INSERT INTO Persona VALUES ("+ aClient.getId() + ", '"+aClient.getFname()+ "', '"+aClient.getLname()+ "', '"
                +aClient.getLname2()+"', '"+aClient.getDir()+"' );"
                + "INSERT INTO Cliente VALUES ('"+ aClient.getId() +"', '"+aClient.getTipocliente()+"');"
                + "INSERT INTO Telefono VALUES("+ aClient.getId() + ", '"+aClient.getTel()+ "', '"+aClient.getPlan()+"')";
        String QuerySQLaux = "SELECT cedula FROM Cliente WHERE cedula = '"+aClient.getId()+"'";
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
                JOptionPane.showMessageDialog(null, "El cliente ya existe \nIntentelo nuevamente");
            }else{
                int res = sentencia.executeUpdate(QuerySQL);
                if(res==1){
                    return true;
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
    
    public boolean limitarTelefonosClienteNatural(Telefono aUser){
        String QuerySQLaux = "SELECT COUNT(cedula) FROM cliente_telefonos WHERE cedula='" + aUser.getId() + "' and tipo_cliente='Natural'";
        Connection coneccion = this.access.getConnetion();
        int cantidad =0;
        try {
            Statement sentencia = coneccion.createStatement();
            ResultSet resultado = sentencia.executeQuery(QuerySQLaux);         
            if(resultado.next()){
                cantidad = Integer.parseInt(resultado.getString("count").trim());
            }
            if (cantidad >= 3) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return false;
    }

    public boolean createTelefono(Telefono aUser) {
        if (!limitarTelefonosClienteNatural(aUser)) {
            JOptionPane.showMessageDialog(null, "El cliente ha superado el limite de telefonos \nIntentelo nuevamente con otro cliente");
            return false;
        } else {
            String QuerySQL = "INSERT INTO Telefono VALUES(" + aUser.getId() + ", '" + aUser.getTel() + "', '" + aUser.getPlan() + "')";

            String QuerySQLaux = "SELECT numero_telefono FROM Telefono WHERE numero_telefono = '" + aUser.getTel() + "'";
            System.out.println(QuerySQL);
            System.out.println(QuerySQLaux);
            Connection coneccion = this.access.getConnetion();
            System.out.println("Connection: " + coneccion);

            try {
                Statement sentencia = coneccion.createStatement();
                System.out.println("sentencia: " + sentencia);
                ResultSet resultado = sentencia.executeQuery(QuerySQLaux);
                System.out.println("resultado: " + resultado);
                if (resultado.next()) {
                    JOptionPane.showMessageDialog(null, "El telefono ya existe \nIntentelo nuevamente");
                } else {
                    int res = sentencia.executeUpdate(QuerySQL);
                    if (res == 1) {
                        return true;
                    } else {
                        return false;
                    }
                }

            } catch (SQLException ex) {
                System.out.println("---- Problema en la ejecucion.");
                ex.printStackTrace();
            }
            return false;
        }
    }
    
/*  No tenemos sedes.
    public ResultSet comboOptions(){
        String QuerySQL = "SELECT * FROM Sedes";
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
*/
}
