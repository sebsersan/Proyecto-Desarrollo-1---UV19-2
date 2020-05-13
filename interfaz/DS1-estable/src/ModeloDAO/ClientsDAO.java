package ModeloDAO;

import Modelo.Clients;
import Modelo.Factura;
import Modelo.Telefono;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
            String QuerySQL = "INSERT INTO Telefono VALUES(" + aUser.getId() + ", '" + aUser.getTel() + "', '" + aUser.getPlan() + "',TRUE)";

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
                
                String cedula = resultado.getString("cedula").trim();
                String nombrePersona = resultado.getString("nombre_persona").trim();
                String paternoPersona = resultado.getString("paterno_persona").trim();
                String maternoPersona = resultado.getString("materno_persona").trim();
                String direccionPersona = resultado.getString("direccion_persona").trim();
                String tipoCliente = resultado.getString("tipo_cliente").trim();
                String numeroTelefono = resultado.getString("numero_telefono").trim();
                String costo = resultado.getString("costo").trim();
                String minutos = resultado.getString("minutos").trim();
                this.ActualizarConsumo(Long.parseLong(numeroTelefono));
                String a9 = resultado.getString("minutos_consumo").trim();
                String minutosAdicionales =resultado.getString("minutos_adicionales").trim();
                String a11=resultado.getString("datos_consumo").trim();
                String a12=resultado.getString("mensajes_consumo").trim();
                String a14=resultado.getString("recarga_igual").trim();
                //String a15=resultado.getString("deuda_anterior").trim();
                //String a16=resultado.getString("deuda_trasanterior").trim();
                cont++;
                
                 double valorMinuto=Integer.parseInt(minutos)/Integer.parseInt(costo);
                 double costoMinutoAdicional = valorMinuto*Double.parseDouble(minutosAdicionales);
                 double serviciosAdicional = costoMinutoAdicional + (Integer.parseInt(a14)*(Double.parseDouble(costo)/2));
                 
                 double facturasPendientes=0;
                 //double facturasPendientes=Double.parseDouble(a15)+Double.parseDouble(a16);
                 System.out.println(Double.toString(facturasPendientes));
                 double totalaPagar=serviciosAdicional+Double.parseDouble(costo);
                //String[] niu = {a1, a2, a3, a4, a5, a6, a7, a8, Integer.toString(cont)}; //Es importante crear un nuevo arreglo cada vez
                
                
                java.util.Date date = new java.util.Date(); // This object contains the current date value
                java.sql.Date Date = new java.sql.Date(date.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String fechaActual=formatter.format(Date);
                
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DAY_OF_YEAR, 30);
                date = calendar.getTime();
                java.sql.Date Date2 = new java.sql.Date(date.getTime());
                String fechaLimite=formatter.format(Date2);
                
                
                String id_factura;
                String total_a_pagar;
                String estado_financiero;
                String deuda_ante = "0";
                String deuda_trasante = "0";
                ResultSet resultadoFactura1 = null;
                ResultSet resultadoFactura2 = null;
                
                
                String QueryHabilitarTelefono  = "UPDATE Telefono SET estado_del_servicio = TRUE"+
                " WHERE numero_telefono = " + Long.parseLong(numeroTelefono);     
            
            
                String QueryBuscarFacturas = "SELECT id_factura, total_a_pagar, estado_financiero, deuda_anterior, deuda_trasanterior"
                        + " FROM Factura WHERE factura.numero_telefono ="+ numeroTelefono;
                
                String QueryInsertarFacturas = "INSERT INTO Factura Values ('"+numeroTelefono.concat(fechaActual)+"',"+ totalaPagar +", "
                        + "'"+fechaLimite+"', "
                           + "FALSE, "+ Long.parseLong(numeroTelefono) +", 0, 0)";
                
                ResultSet resultadoBuscarFactura;
                try ( //Coneccion para manejo de tablas factura en la base de datos
                        Statement sentenciaFactura = coneccion.createStatement
        (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                    System.out.println("sentenciaFACTURA: "+sentencia);
                    resultadoBuscarFactura = sentenciaFactura.executeQuery(QueryBuscarFacturas);
                    System.out.println("resultadoFACTURA: "+resultadoBuscarFactura);
                    
                    if(resultadoBuscarFactura.next()){
                        
                        
                        
                        if(resultadoBuscarFactura.next()){
                            
                            if(resultadoBuscarFactura.next()){
                                id_factura = resultadoBuscarFactura.getString("id_factura").trim();
                                estado_financiero = resultadoBuscarFactura.getString("estado_financiero").trim();
                                deuda_trasante = resultadoBuscarFactura.getString("deuda_trasanterior").trim();

                                
                                if(!estado_financiero.equals("f")){
                                    String QueryEliminarFacturaPagada = "DELETE FROM Factura WHERE id_factura = '"+ id_factura+"'";
                                    
                                    sentenciaFactura.executeUpdate(QueryHabilitarTelefono);            
                                    sentenciaFactura.executeUpdate(QueryEliminarFacturaPagada);
                                    
                                }
                            }
                            resultadoBuscarFactura = sentenciaFactura.executeQuery(QueryBuscarFacturas);
                            resultadoFactura2 = resultadoBuscarFactura;
                            resultadoFactura2.first();
                            resultadoFactura2.next();
                            
                            
                            id_factura = resultadoFactura2.getString("id_factura").trim();
                            estado_financiero = resultadoFactura2.getString("estado_financiero").trim();
                            deuda_ante = resultadoBuscarFactura.getString("deuda_anterior").trim();
                            
                            if(!estado_financiero.equals("f")){
                                String QueryEliminarFacturaPagada = "DELETE FROM Factura WHERE id_factura = '"+ id_factura+"'";
                                
                                sentenciaFactura.executeUpdate(QueryHabilitarTelefono);
                                sentenciaFactura.executeUpdate(QueryEliminarFacturaPagada);
                            }
                            
                            
                        }
                        
                        resultadoBuscarFactura = sentenciaFactura.executeQuery(QueryBuscarFacturas);
                        resultadoFactura1 = resultadoBuscarFactura;
                        resultadoFactura2 = resultadoBuscarFactura;
                        
                        
                        if(resultadoFactura1.first()){
                            

                                id_factura = resultadoFactura1.getString("id_factura").trim();
                                estado_financiero = resultadoFactura1.getString("estado_financiero").trim();


                            if(!estado_financiero.equals("f")){
                                String QueryEliminarFacturaPagada = "DELETE FROM Factura WHERE id_factura = '"+ id_factura+"'";
                                String QueryInsertarFactura1 = "INSERT INTO Factura Values ('"+numeroTelefono.concat(fechaActual)+"',"+ totalaPagar +", "
                                        + "'"+fechaLimite+"', "
                                    + "FALSE, "+ Long.parseLong(numeroTelefono) +", "+ Integer.parseInt(deuda_ante) +", "
                                        + ""+Integer.parseInt(deuda_trasante)+")";
                                
                                sentenciaFactura.executeUpdate(QueryHabilitarTelefono);
                                sentenciaFactura.executeUpdate(QueryEliminarFacturaPagada);
                                sentenciaFactura.executeUpdate(QueryInsertarFactura1);
                                
                            }
                        
                            
                            if(!resultadoFactura2.next()){
                                if(resultadoBuscarFactura.next()){

                                    deuda_ante =  resultadoBuscarFactura.getString("deuda_trasanterior").trim();
                                    String QueryUpdateDeduda3 = "UPDATE Factura SET deuda_trasanterior = 0, deuda_anterior ="+ Integer.parseInt(deuda_ante)
                                            + " WHERE numero_telefono ="
                                        + Long.parseLong(numeroTelefono) +" and deuda_trasanterior != 0";
                                    sentenciaFactura.executeUpdate(QueryUpdateDeduda3);
                                } else {
                                    resultadoFactura1.first();
                                    
                                    deuda_ante =  resultadoFactura1.getString("total_a_pagar").trim();
                                    
                                    String QueryInsertarSegundaFactura = "INSERT INTO Factura Values ('"+numeroTelefono.concat(fechaActual)+"d1',"
                                    + ""+ totalaPagar +","
                                        + " '"+fechaLimite+"', "
                                        + "FALSE, "+ Long.parseLong(numeroTelefono) +", "+ Integer.parseInt(deuda_ante) +" , "
                                        + " 0)";    

                                    sentenciaFactura.executeUpdate(QueryInsertarSegundaFactura);
                                    
                                    
                                }

                            } else {
                                if(resultadoBuscarFactura.next()){
                                    String QuerySuspenderServicio = "UPDATE Telefono SET estado_del_servicio = FALSE WHERE numero_telefono ="+ 
                                        Long.parseLong(numeroTelefono);
                                    sentenciaFactura.executeUpdate(QuerySuspenderServicio);
                                    
                                }
                                resultadoBuscarFactura = sentenciaFactura.executeQuery(QueryBuscarFacturas);
                                resultadoFactura1 = resultadoBuscarFactura;
                                resultadoFactura2 = resultadoBuscarFactura;
                        
                                resultadoFactura2.first();
                                resultadoFactura2.next();
                                
                                deuda_ante =  resultadoFactura2.getString("total_a_pagar").trim();
                                deuda_trasante = resultadoFactura2.getString("deuda_anterior").trim();

                                String QueryInsertarTerceraFactura = "INSERT INTO Factura Values ('"+numeroTelefono.concat(fechaActual)+"d2',"
                                    + ""+ totalaPagar +","
                                        + " '"+fechaLimite+"', "
                                        + "FALSE, "+ Long.parseLong(numeroTelefono) +", "+ Integer.parseInt(deuda_ante) +" , "
                                        + ""+Integer.parseInt(deuda_trasante)+")";    

                                sentenciaFactura.executeUpdate(QueryInsertarTerceraFactura);
                                
                            }
                            
                            }



                        } else {
                            sentenciaFactura.executeUpdate(QueryInsertarFacturas); // Crea primera factura del telefono

                        }
                }

                
            

                
                
                
                
                //Direccion donde se guardan las facturas
                String rutaGuardar="C:\\Users\\User\\Desktop\\Facturas\\Fatura "+numeroTelefono+".pdf";
                Factura g=new Factura();
                g.generarPDF(rutaImagen, nombrePersona+" "+paternoPersona+" "+maternoPersona, direccionPersona, cedula, rutaGuardar, 
                        serviciosAdicional, facturasPendientes, costo, Double.toString(totalaPagar));
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
    
    
    public boolean pagarTelefono(Long telefono, int mes) {
        
        String QueryBuscarFacturas = "SELECT id_factura"
                        + " FROM Factura WHERE factura.numero_telefono ="+ telefono;
        System.out.println(QueryBuscarFacturas);
        Connection coneccion = this.access.getConnetion();
        System.out.println("Connection: " + coneccion);
           
          try {
                Statement sentencia = coneccion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                System.out.println("sentencia: " + sentencia);
                ResultSet resultado = sentencia.executeQuery(QueryBuscarFacturas);
                System.out.println("resultado: " + resultado);
                
                
                
                if (resultado.next()) {
                    
                    if (resultado.next()){
                        
                        if (resultado.next()){
                        
                            String id_factura = resultado.getString("id_factura").trim();
                            
                            String[] parts = id_factura.split("-");
                            String mesFecha = parts[1];
                            int mesFechaInt = Integer.parseInt(mesFecha);
                            
                            System.out.println(mesFecha);
                            if(mesFechaInt == mes){
                                String QueryPagarSegundaDeuda  = "UPDATE Factura SET estado_financiero = TRUE"+
                                " WHERE numero_telefono = " + telefono + "and id_factura = '" +id_factura+"' and estado_financiero != TRUE";
                                

                                sentencia.executeUpdate(QueryPagarSegundaDeuda);
                                return true;
                            }
                            
                        
                    
                        }
                        
                        resultado.first();
                        resultado.next();
                       String id_factura = resultado.getString("id_factura").trim();
                            
                            String[] parts = id_factura.split("-");
                            String mesFecha = parts[1];
                            int mesFechaInt = Integer.parseInt(mesFecha);
                            
                            System.out.println(mesFecha);
                            if(mesFechaInt == mes){
                                String QueryPagarSegundaDeuda  = "UPDATE Factura SET estado_financiero = TRUE"+
                                " WHERE numero_telefono = " + telefono + "and id_factura = '" +id_factura+"' and estado_financiero != TRUE";
                                sentencia.executeUpdate(QueryPagarSegundaDeuda);
                                return true;
                            }
                        

                    
                    }
                    
                    resultado.first();
                String id_factura = resultado.getString("id_factura").trim();
                            
                            String[] parts = id_factura.split("-");
                            String mesFecha = parts[1];
                            int mesFechaInt = Integer.parseInt(mesFecha);
                            
                            System.out.println(mesFecha);
                            if(mesFechaInt == mes){
                                String QueryPagarSegundaDeuda  = "UPDATE Factura SET estado_financiero = TRUE"+
                                " WHERE numero_telefono = " + telefono + "and id_factura = '" +id_factura+"' and estado_financiero != TRUE";
                                sentencia.executeUpdate(QueryPagarSegundaDeuda);
                                return true;
                            }  
                    

                } else {
                    return false;
                   
                }

            } catch (SQLException ex) {
                System.out.println("---- Problema en la ejecucion.");
                ex.printStackTrace();
            }
        return false;
    }

    public ArrayList<String[]> listarFacturas(Long Telefono) {
        String QuerySQL = "SELECT nombre_persona, paterno_persona, "
                + "id_factura, total_a_pagar FROM Cliente_Telefono_Factura WHERE numero_telefono ="+Telefono +
                "and estado_financiero = FALSE";
        System.out.println(QuerySQL);
        Connection coneccion = this.access.getConnetion();
        System.out.println("Connection: " + coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            

            ArrayList<String[]> matrixList = new ArrayList<String[]>();
            int cont = 0;
            while (resultado.next()) {
                
                String a1 = resultado.getString("nombre_persona").trim();
                String a2 = resultado.getString("paterno_persona").trim();
                String a3 = Long.toString(Telefono);
                String a4 = resultado.getString("id_factura").trim();
                String a5 = resultado.getString("total_a_pagar").trim();
                
                String[] parts = a4.split("-");
                String mes = parts[1];
                
                String[] niu = {a1, a2, a3, mes, a5}; //Es importante crear un nuevo arreglo cada vez
                
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
