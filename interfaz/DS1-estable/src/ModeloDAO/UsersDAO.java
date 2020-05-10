package ModeloDAO;
import Modelo.Users;
import Modelo.Telefono;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsersDAO {
    Acceso access;
    
    public UsersDAO(Acceso access){
        this.access =  access;
    }
    
    public String login (String user, String pass) {
        String QuerySQL = "SELECT * FROM usuarios"
                + " WHERE cedula = '" + user + "' AND password_usuario = '"+ pass + "' AND estado_usuario = 'Activo'";
        System.out.println(QuerySQL);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            if(resultado.next()){
                String cargo = resultado.getString("tipo_usuario").trim();
                System.out.println("cargo: "+cargo);
                return cargo;
            }else{
                return "error";
            }

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return "error";
    }
    
    public boolean createNewUser(Users aUser){
        String QuerySQL = "INSERT INTO Persona VALUES ("+ aUser.getId() + ", '"+aUser.getFname()+ "', '"+aUser.getLname()+ "', '"
                +aUser.getLname2()+"', '"+aUser.getDir()+ "');"
                + "INSERT INTO Usuario VALUES ("+ aUser.getId() + ", '"+aUser.getPosition()+ "', '"+aUser.getPass()+ "', '"+aUser.getTel()+ "', 'Activo')";
        String QuerySQLaux = "SELECT cedula FROM Persona WHERE cedula = '"+aUser.getId()+"'"; //AND (work_position='Jefe de Taller' OR work_position='Vendedor')";
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
    
    public Users consultProfile(String userID){
        String QuerySQL = "SELECT * FROM usuarios WHERE cedula = '"+userID+"'";
        System.out.println(QuerySQL);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            if(resultado.next()){
                String iduser = resultado.getString("cedula");
                String fname = resultado.getString("nombre_persona");
                String lname = resultado.getString("paterno_persona").trim();
                String lname2 = resultado.getString("materno_persona");
                String tel = resultado.getString("telefono_usuario");
                String dir = resultado.getString("direccion_persona");
                String wp = resultado.getString("tipo_usuario");
                String pass = resultado.getString("password_usuario");
                String state = resultado.getString("estado_usuario");
                
                return new Users(iduser, fname, lname, lname2, tel, dir, wp, pass, state);
            }else{
                return new Users(null, null, null, null, null, null, null,null);
            }
            
        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return new Users(null, null, null, null, null, null, null, null);
    }
    
    
    public ArrayList<String[]> consultUsers(){
        String QuerySQL = "select cedula, nombre_persona, paterno_persona, materno_persona, telefono_persona, "
                        + "direccion_persona, cargo_persona from usuario where cargo_persona='Gerente' and estado_persona='Activo' "
                        + "union select cedula, nombre_persona, paterno_persona, materno_persona, telefono_persona, "
                        + "direccion_persona, cargo_persona from usuario where cargo_persona='Operador' and estado_persona='Activo'";
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
                
                String a1 = resultado.getString("cedula");
                String a2 = resultado.getString("nombre_persona");
                String a3 = resultado.getString("paterno_persona");
                String a4 = resultado.getString("materno_persona");
                String a5 = resultado.getString("telefono_persona");
                String a6 = resultado.getString("direccion_persona");
                String a7 = resultado.getString("cargo_persona");
                String[] niu = {a1, a2, a3, a4, a5, a6, a7}; //Es importante crear un nuevo arreglo cada vez
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
    
    public ArrayList<String[]> consultGerente(){
        String QuerySQL = "select cedula, nombre_persona, paterno_persona, materno_persona, telefono_persona, "
                        + "direccion_persona, cargo_persona from usuario where cargo_persona='Gerente' and estado_persona='Activo'";
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
                
                String a1 = resultado.getString("cedula");
                String a2 = resultado.getString("nombre_persona");
                String a3 = resultado.getString("paterno_persona");
                String a4 = resultado.getString("materno_persona");
                String a5 = resultado.getString("telefono_persona");
                String a6 = resultado.getString("direccion_persona");
                String a7 = resultado.getString("cargo_persona");
                String[] niu = {a1, a2, a3, a4, a5, a6, a7}; //Es importante crear un nuevo arreglo cada vez
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

    public boolean updateUser(String cedula, String atributo, String nuevoValor) {   
        String QuerySQL = "";
        if (atributo.equals("tipo_usuario")||atributo.equals("password_usuario")||atributo.equals("telefono_usuario") || atributo.equals("estado_usuario")){
                    QuerySQL = "UPDATE usuario SET "+ atributo+ "=" + "'" + nuevoValor + "'" + " WHERE cedula = '"+cedula + "'";
        }
        else {
                    QuerySQL = "UPDATE persona SET "+ atributo+ "=" + "'" + nuevoValor + "'" + " WHERE cedula = '"+cedula + "'";
        }
            
        String QuerySQLaux = "SELECT cedula FROM Usuario WHERE cedula = '"+Integer.parseInt(cedula)+ "'";
        String QuerySQLTipo = "SELECT tipo_usuario FROM Usuario WHERE cedula = "+cedula + "AND tipo_usuario = 'Administrador'";
        System.out.println(QuerySQL);
        System.out.println(QuerySQLaux);
        System.out.println(QuerySQLTipo);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQLaux);
            System.out.println("resultado: "+resultado);
            Statement sentenciaTipo = coneccion.createStatement();
            System.out.println("sentenciaTipo: "+sentenciaTipo);
            ResultSet resultadoTipo = sentenciaTipo.executeQuery(QuerySQLTipo);
            System.out.println("resultado de tipo: "+resultadoTipo);
            if (resultadoTipo.next()){
                JOptionPane.showMessageDialog(null, "No se puede modificar un administrador \nIntentelo con otro usuario");
                return false;
            }
            else if(resultado.next()){
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
    
    public boolean updateGerente(Users aUser) {
            String QuerySQL = "UPDATE Usuario SET nombre_persona='"+aUser.getFname()+ "', paterno_persona='"+aUser.getLname()
                    +"', telefono_persona='"+aUser.getTel()+"', direccion_persona='"+aUser.getDir()+"' WHERE cedula = '"+aUser.getId()+"' AND cargo_persona='Gerente'";
            
        String QuerySQLaux = "SELECT cedula FROM Usuario WHERE cedula = '"+aUser.getId()+"' AND cargo_persona='Gerente'";
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
    
    public boolean despedirUsuario(String idUser){
        String QuerySQL = "UPDATE Usuario SET estado_persona = 'Inactivo' where cedula = "+idUser;  
        String QuerySQLaux = "SELECT cedula,work_position FROM Usuario WHERE cedula = "+idUser+" AND cargo_persona='Vendedor'";
        System.out.println(QuerySQL);
        System.out.println(QuerySQLaux);
        Connection coneccion = this.access.getConnetion();
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
    
    public boolean despedirGerente(String idUser){
        String QuerySQL = "UPDATE Usuario SET estado_persona = 'Inactivo' where cedula = "+idUser;           
        String QuerySQLaux = "SELECT cedula FROM Usuario WHERE cedula = "+idUser+" AND cargo_persona='Gerente'";
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
    
    public ArrayList<String[]> consultUsersVendedores() {
        String QuerySQL = "select cedula, nombre_persona, paterno_persona, materno_persona, telefono_persona, direccion_persona, cargo_persona from usuarios where cargo_persona='Operador'";
        System.out.println(QuerySQL);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            
            int cont=0;
            ArrayList<String[]> matrixList = new ArrayList<String[]>();
            while (resultado.next()) {
                
                String a1 = resultado.getString("cedula");
                String a2 = resultado.getString("nombre_persona");
                String a3 = resultado.getString("paterno_persona");
                String a4 = resultado.getString("materno_persona");
                String a5 = resultado.getString("telefono_persona");
                String a6 = resultado.getString("direccion_persona");
                String a7 = resultado.getString("cargo_persona");
                String[] niu = {a1, a2, a3, a4, a5, a6, a7}; //Es importante crear un nuevo arreglo cada vez
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

    public ArrayList<String[]> consultUsersCoincidencia_tabla(String busqueda) {
        String QuerySQL = "SELECT * FROM (select cedula, nombre_persona, paterno_persona, materno_persona, telefono_persona, direccion_persona, cargo_persona from usuario where work_position='Gerente' "
                + "union select iduser, first_name, last_name, telefono, direccion, work_position from users where work_position='Vendedor') as persons WHERE LOWER (persons.iduser::text)  LIKE LOWER ( '" + busqueda + "%')";
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
     
    public ArrayList<String[]> listarUsuarios() {
        String QuerySQL = "SELECT cedula, nombre_persona, paterno_persona, "
                + "direccion_persona, tipo_usuario, estado_usuario from usuarios";
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
                
                String a1 = resultado.getString("cedula").trim();
                String a2 = resultado.getString("nombre_persona").trim();
                String a3 = resultado.getString("paterno_persona").trim();
                String a4 = resultado.getString("direccion_persona").trim();
                String a5 = resultado.getString("tipo_usuario").trim();
                String a6 = resultado.getString("estado_usuario").trim();
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
