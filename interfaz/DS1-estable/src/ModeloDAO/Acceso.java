package ModeloDAO;
import java.sql.*;

public class Acceso {
    String url, usuario, password;
    Connection conexion = null;
    
    public Acceso() {
        //this.url = "jdbc:postgresql://otto.db.elephantsql.com:5432/vvpcnayj";
        //this.usuario = "vvpcnayj";
        //this.password = "LaDK1W0ZNGd-S-TQCRVRd0Z7F5Qm6DUY";
        this.url = "jdbc:postgresql://localhost:5432/DS1_BaseDeDatos";
        this.usuario = "postgres";
        this.password = "SuperSecret";
    }
    
    public Connection conectar(){
        try {
            //Se carga el driver
            Class.forName("org.postgresql.Driver");
            System.out.println( "Driver Cargado" );
        } catch( Exception e ) {
            System.out.println( "No se pudo cargar el Driver." );
        }
        try{
        //Crear el objeto de conexion a la base de datos
        conexion = DriverManager.getConnection(this.url, this.usuario, this.password);
        System.out.println( "Conexion Abierta" );
        return conexion;
        
        } catch( Exception e ) {
            System.out.println( "No se pudo abrir la base de datos." );
            return null;
        }
    }
    
    public Connection getConnetion(){
        if (conexion == null) {
            return this.conectar();
        }else{
            return conexion;
        }
    }
    
    public void closeConection(Connection c){
        try{
            if (conexion != null){
                c.close();
                System.out.println( "Conexion cerrada exitosamente ." );
            } 
        } catch( Exception e ) {
            System.out.println( "No se pudo cerrar la conexion a la base de datos." );
            }
        }
}
