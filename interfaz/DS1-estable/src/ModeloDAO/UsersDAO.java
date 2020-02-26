package ModeloDAO;
import Modelo.Users;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsersDAO {
    Acceso access;
    
    public UsersDAO(Acceso access){
        this.access =  access;
    }
    
    public String login (String user, String pass) {
        String QuerySQL = "SELECT * FROM Users WHERE idUser = '" + user + "' AND password = '"+ pass + "' AND stateUser='Activo'";
        System.out.println(QuerySQL);
        Connection coneccion= this.access.getConnetion();
        System.out.println("Connection: "+coneccion);
        
        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: "+sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: "+resultado);
            if(resultado.next()){
                String cargo = resultado.getString("work_position");
                System.out.println("cargo: "+cargo);
                if(cargo.equals("Gerente")){
                    return "Gerente";
                }
                else if(cargo.equals("Jefe de Taller")){
                    return "Jefe de Taller";
                }
                else if(cargo.equals("Vendedor")){
                    return "Vendedor";
                }
                else if(cargo.equals("admin")){
                    return "Admin";
                }
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
        String QuerySQL = "INSERT INTO Users VALUES ("+ aUser.getId() + ", '"+aUser.getFname()+ "', '"+aUser.getLname()+ "', '"
                +aUser.getTel()+"', '"+aUser.getDir()+"', '"+aUser.getPosition()+ "', '"+aUser.getPass()+ "', '"+aUser.getState()+ "')";
        String QuerySQLaux = "SELECT idUser FROM Users WHERE idUser = '"+aUser.getId()+"'"; //AND (work_position='Jefe de Taller' OR work_position='Vendedor')";
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
    
    public Users consultProfile(String userID){
        String QuerySQL = "SELECT * FROM Users WHERE idUser = '"+userID+"'";
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
                
                return new Users(iduser, fname, lname, tel, dir, wp, pass);
            }else{
                return new Users(null, null, null, null, null, null, null);
            }
            
        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return new Users(null, null, null, null, null, null, null);
    }
    
    
    public ArrayList<String[]> consultUsers(){
        String QuerySQL = "select iduser, first_name, last_name, telefono, direccion, work_position from users where work_position='Jefe de Taller' and stateuser='Activo' union select iduser, first_name, last_name, telefono, direccion, work_position from users where work_position='Vendedor' and stateuser='Activo'";
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
    
    public ArrayList<String[]> consultGerente(){
        String QuerySQL = "select iduser, first_name, last_name, telefono, direccion, work_position from users where work_position='Gerente' and stateuser='Activo'";
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

    public boolean updateUser(Users aUser) {
            String QuerySQL = "UPDATE Users SET first_name='"+aUser.getFname()+ "', last_name='"+aUser.getLname()
                    +"', telefono='"+aUser.getTel()+"', direccion='"+aUser.getDir()+"', work_position='"+aUser.getPosition()+"' WHERE iduser = '"+aUser.getId()+"' AND (work_position='Jefe de Taller' OR work_position='Vendedor')";
            
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
    
    public boolean updateGerente(Users aUser) {
            String QuerySQL = "UPDATE Users SET first_name='"+aUser.getFname()+ "', last_name='"+aUser.getLname()
                    +"', telefono='"+aUser.getTel()+"', direccion='"+aUser.getDir()+"' WHERE iduser = '"+aUser.getId()+"' AND work_position='Gerente'";
            
        String QuerySQLaux = "SELECT idUser FROM Users WHERE idUser = '"+aUser.getId()+"' AND work_position='Gerente'";
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
        String QuerySQL = "UPDATE Users SET stateUser = 'Inactivo' where idUser = "+idUser;  
        String QuerySQLaux = "SELECT idUser,work_position FROM Users WHERE idUser = "+idUser+" AND (work_position='Jefe de Taller' OR work_position='Vendedor')";
        String QueryDelete = "DELETE FROM vendedoresSede WHERE idUser= "+idUser;
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
                String cargo = resultado.getString("work_position");
                int res = sentencia.executeUpdate(QuerySQL);
                int res2 = sentencia.executeUpdate(QueryDelete);
                if(res==1 && (res2==1 || cargo.equals("Jefe de Taller"))){
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
        String QuerySQL = "UPDATE Users SET stateUser = 'Inactivo' where idUser = "+idUser;           
        String QuerySQLaux = "SELECT idUser FROM Users WHERE idUser = "+idUser+" AND work_position='Gerente'";
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

    public ArrayList<String[]> consultUsersJefes() {
        String QuerySQL = "select iduser, first_name, last_name, telefono, direccion, work_position from users where work_position='Jefe de Taller'";
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
    
    public ArrayList<String[]> consultUsersVendedores() {
        String QuerySQL = "select iduser, first_name, last_name, telefono, direccion, work_position from users where work_position='Vendedor'";
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

    public ArrayList<String[]> consultUsersCoincidencia_tabla(String busqueda) {
        String QuerySQL = "SELECT * FROM (select iduser, first_name, last_name, telefono, direccion, work_position from users where work_position='Jefe de Taller' "
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
     
    
}
