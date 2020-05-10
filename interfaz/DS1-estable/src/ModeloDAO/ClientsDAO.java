package ModeloDAO;

import Modelo.Clients;
import Modelo.Factura;
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
                + "INSERT INTO Telefono VALUES("+ aClient.getId() + ", '"+aClient.getTel()+ "', '"+aClient.getPlan()+"', true )";
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
        String QuerySQLaux = "SELECT COUNT(cedula) FROM cliente_telefono WHERE cedula='" + aUser.getId() + "' and tipo_cliente='Natural'";
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
            String QuerySQL = "INSERT INTO Telefono VALUES(" + aUser.getId() + ", '" + aUser.getTel() + "', '" + aUser.getPlan() + "',true)";

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
    
    public int numeroAleatorio(int consumo, int limiteconsumo){
      int numero = (int)(Math.random()*(consumo-limiteconsumo+1)+limiteconsumo);
      return numero;
    }
    
    public void ActualizarConsumo(Long numero){
        String QuerySQL = "SELECT minutos_consumo, minutos_adicionales, datos_consumo, mensajes_consumo, recarga_igual,"
                + "minutos,datos,mensajes From consumo_telefono_plan where consumo_telefono_plan.numero_telefono=" + numero;
        System.out.println(QuerySQL);
        Connection coneccion = this.access.getConnetion();
        System.out.println("Connection: " + coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            

            ArrayList<String[]> matrixList = new ArrayList<String[]>();
                resultado.next();
                String a1 = resultado.getString("minutos_consumo").trim();
                String a2 = resultado.getString("minutos_adicionales").trim();
                String a3 = resultado.getString("datos_consumo").trim();
                String a4 = resultado.getString("mensajes_consumo").trim();
                String a5 = resultado.getString("recarga_igual").trim();
                String a6 = resultado.getString("minutos").trim();
                String a7 = resultado.getString("datos").trim();
                String a8 = resultado.getString("mensajes").trim();
                
                //String[] niu = {a1, a2, a3, a4, a5, a6, a7, a8, Integer.toString(cont)}; //Es importante crear un nuevo arreglo cada vez
                
                int minutos_c=this.numeroAleatorio(Integer.parseInt(a1), Integer.parseInt(a6));
                int datos_c=this.numeroAleatorio(Integer.parseInt(a3), Integer.parseInt(a7));
                int mensajes_c=this.numeroAleatorio(Integer.parseInt(a4), Integer.parseInt(a8));
                
                
                String QuerySQLUpdate = "update consumo set minutos_consumo ="+ minutos_c+
                        ", datos_consumo=" + datos_c + ",mensajes_consumo=" + mensajes_c + "where "
                        + "numero_telefono=" + numero;
                
        System.out.println(QuerySQLUpdate);
        System.out.println("Connection: " + coneccion);
        
            Statement sentencia1 = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia1);
            sentencia1.execute(QuerySQLUpdate);
            //ResultSet resultadoUpdate = sentencia1.executeQuery(QuerySQLUpdate);
            //System.out.println("resultado: "+resultadoUpdate);
                
         
                
                //matrixList.add(niu);
                
            

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
    }
    public String[] generarFacturaClientes() {
        
        String QuerySQL = "SELECT cedula, nombre_persona, paterno_persona, materno_persona"
                + ",direccion_persona, tipo_cliente, numero_telefono, costo, minutos, minutos_consumo,minutos_adicionales,datos_consumo,mensajes_consumo"
                + ",recarga_igual from Cliente_telefono_plan_consumo";
        System.out.println(QuerySQL);
        Connection coneccion = this.access.getConnetion();
        System.out.println("Connection: " + coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            

            ArrayList<String[]> matrixList = new ArrayList<String[]>();
            int cont = 0;//guarda el numero de factura generado. En un archivo txt
            
            
            //Direccion donde esta la imagen del logo
            String rutaImagen="C:\\Users\\User\\Desktop\\Facturas\\Logotelefonica1.jpeg";
            
            while (resultado.next()) {
                
                String a1 = resultado.getString("cedula").trim();
                String a2 = resultado.getString("nombre_persona").trim();
                String a3 = resultado.getString("paterno_persona").trim();
                String a4 = resultado.getString("materno_persona").trim();
                String a5 = resultado.getString("direccion_persona").trim();
                String a6 = resultado.getString("tipo_cliente").trim();
                String a7 = resultado.getString("numero_telefono").trim();
                String a8 = resultado.getString("costo").trim();
                String a13 = resultado.getString("minutos").trim();
                this.ActualizarConsumo(Long.parseLong(a7));
                String a9 = resultado.getString("minutos_consumo").trim();
                String a10=resultado.getString("minutos_adicionales").trim();
                String a11=resultado.getString("datos_consumo").trim();
                String a12=resultado.getString("mensajes_consumo").trim();
                String a14=resultado.getString("recarga_igual").trim();
                //String a15=resultado.getString("deuda_anterior").trim();
                //String a16=resultado.getString("deuda_trasanterior").trim();
                cont++;
                
                 double valorMinuto=Integer.parseInt(a13)/Integer.parseInt(a8);
                 double minutoAdicional=valorMinuto*Double.parseDouble(a10);
                 double serviciosAdicional=minutoAdicional + (Integer.parseInt(a14)*(Double.parseDouble(a8)/2));
                 
                 double facturasPendientes=0;
                 //double facturasPendientes=Double.parseDouble(a15)+Double.parseDouble(a16);
                 System.out.println(Double.toString(facturasPendientes));
                 double totalaPagar=serviciosAdicional+Double.parseDouble(a8);
                //String[] niu = {a1, a2, a3, a4, a5, a6, a7, a8, Integer.toString(cont)}; //Es importante crear un nuevo arreglo cada vez
           
                
                //Direccion donde se guardan las facturas
                String rutaGuardar="C:\\Users\\User\\Desktop\\Facturas\\fatura"+a1+".pdf";
                Factura g=new Factura();
                g.generarPDF(rutaImagen, a2+" "+a3+" "+a4, a5, a1, rutaGuardar, serviciosAdicional, facturasPendientes, a8, Double.toString(totalaPagar));
                //matrixList.add(niu);
                
            }
            

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean recargarCliente(Long telefono) {
        
        String QuerySQL = "SELECT recarga_igual FROM consumo WHERE numero_telefono = " + telefono;
        System.out.println(QuerySQL);
        Connection coneccion = this.access.getConnetion();
        System.out.println("Connection: " + coneccion);
        
          try {
                Statement sentencia = coneccion.createStatement();
                System.out.println("sentencia: " + sentencia);
                ResultSet resultado = sentencia.executeQuery(QuerySQL);
                System.out.println("resultado: " + resultado);
                
                
                
                if (resultado.next()) {
                    int recargas_actuales = Integer.parseInt(resultado.getString("recarga_igual").trim());
                
                     String QueryAux = "UPDATE consumo SET recarga_igual = "+ (recargas_actuales + 1) +
                            ", minutos_consumo = 0 ,datos_consumo = 0, mensajes_consumo = 0" + 
                            " WHERE numero_telefono = " + telefono;
                    System.out.println(QueryAux);
                    int res = sentencia.executeUpdate(QueryAux);
                    if (res == 1) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El telefono no existe \nIntentelo nuevamente");
                   
                }

            } catch (SQLException ex) {
                System.out.println("---- Problema en la ejecucion.");
                ex.printStackTrace();
            }
        return false;
    }
    
}
