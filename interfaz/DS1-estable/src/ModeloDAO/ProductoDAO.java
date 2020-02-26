package ModeloDAO;

import Modelo.Producto;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.postgresql.util.PSQLException;

/**
 *
 * @author carban
 */
public class ProductoDAO {

    Acceso access;
    String sSql = "";

    public ProductoDAO(Acceso access) {
        this.access = access;
    }

    public boolean crearNuevoProducto(Producto prod) {
        String QuerySQL = "INSERT INTO producto (nombre, descripcion, color, alto, largo, ancho, precio) VALUES ('" + prod.getNombre() + "', '" + prod.getDescripcion() + "', '" + prod.getColor() + "', '" + prod.getAlto() + "', '" + prod.getLargo() + "', '" + prod.getAncho() + "', '" + prod.getPrecio() + "')";
        System.out.println(QuerySQL);
        Connection coneccion = this.access.getConnetion();
        System.out.println("Connection: " + coneccion);

        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: " + sentencia);
            int resultado = sentencia.executeUpdate(QuerySQL);
            System.out.println("resultado: " + resultado);
            if (resultado == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<String[]> consultProductos() {
        String QuerySQL = "Select idproducto, idsedes, nombre, descripcion, color, alto, largo, ancho, precio, cantidad from (select * from inventario order by idsedes, idproducto) as foo natural join (select * from producto) as goo";
        System.out.println(QuerySQL);
        Connection coneccion = this.access.getConnetion();
        System.out.println("Connection: " + coneccion);

        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: " + sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: " + resultado);

            ArrayList<String[]> matrixList = new ArrayList<String[]>();
            int cont = 0;
            while (resultado.next()) {

                String a1 = resultado.getString("idproducto");
                String a2 = resultado.getString("idsedes");
                String a3 = resultado.getString("nombre");
                String a4 = resultado.getString("descripcion");
                String a5 = resultado.getString("color");
                String a6 = resultado.getString("alto");
                String a7 = resultado.getString("largo");
                String a8 = resultado.getString("ancho");
                String a9 = resultado.getString("precio");
                String a10 = resultado.getString("cantidad");
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

    public ArrayList<String[]> consultProductosCoincidencia_tabla(String busqueda) {
        
        String QuerySQL = "SELECT * FROM "
                + "(Select idproducto, idsedes, nombre, descripcion, color, alto, largo, ancho, precio, cantidad from "
                + "(select * from inventario order by idsedes, idproducto) as foo natural join (select * from producto) as goo) "
                + "as cons WHERE LOWER (cons.nombre)  LIKE LOWER ( '%" + busqueda + "%') OR "
                + "CAST(cons.idProducto AS TEXT) LIKE '" + busqueda + "%' ";

        Connection coneccion = this.access.getConnetion();
//        System.out.println("Connection: " + coneccion);

        try {
            Statement sentencia = coneccion.createStatement();
//            System.out.println("sentencia: " + sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
//            System.out.println("resultado: " + resultado);

            ArrayList<String[]> matrixList = new ArrayList<String[]>();
            int cont = 0;
            while (resultado.next()) {

                String a1 = resultado.getString("idproducto");
                String a2 = resultado.getString("idsedes");
                String a3 = resultado.getString("nombre");
                String a4 = resultado.getString("descripcion");
                String a5 = resultado.getString("color");
                String a6 = resultado.getString("alto");
                String a7 = resultado.getString("largo");
                String a8 = resultado.getString("ancho");
                String a9 = resultado.getString("precio");
                String a10 = resultado.getString("cantidad");
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
    
    public Producto consultProducto(String codigoProdu) {
        String QuerySQL = "SELECT * FROM Producto WHERE idproducto = '" + codigoProdu + "'";
        System.out.println(QuerySQL);
        Connection coneccion = this.access.getConnetion();
        System.out.println("Connection: " + coneccion);

        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: " + sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: " + resultado);
            if (resultado.next()) {
                String idproducto = resultado.getString("idproducto");
                String nombreprodu = resultado.getString("nombre");
                String colorprodu = resultado.getString("color");
                int altoprodu = Integer.parseInt(resultado.getString("alto"));
                int largoprodu = Integer.parseInt(resultado.getString("largo"));
                int anchoprodu = Integer.parseInt(resultado.getString("ancho"));
                int precioprodu = Integer.parseInt(resultado.getString("precio"));

                return new Producto(idproducto, nombreprodu, "", colorprodu, altoprodu, largoprodu, anchoprodu, precioprodu);
            } else {
                return new Producto(null, null, null, null, 0, 0, 0, 0);
            }

        } catch (PSQLException ps) {

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return new Producto(null, null, null, null, 0, 0, 0, 0);
    }

    public ResultSet comboOptions() {
        String QuerySQL = "select * from users where work_position='Vendedor' and stateuser='Inactivo';";
        System.out.println(QuerySQL);
        Connection coneccion = this.access.getConnetion();
        System.out.println("Connection: " + coneccion);

        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: " + sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: " + resultado);
            return resultado;

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<String[]> consultProductosDelJefe(String sedeid) {
        String QuerySQL = "Select idproducto, idsedes, nombre, descripcion, color, alto, largo, ancho, precio, cantidad from (select * from inventario order by idsedes, idproducto) as foo natural join (select * from producto) as goo WHERE idsedes = '" + sedeid + "'";
        System.out.println(QuerySQL);
        Connection coneccion = this.access.getConnetion();
        System.out.println("Connection: " + coneccion);

        try {
            Statement sentencia = coneccion.createStatement();
            System.out.println("sentencia: " + sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            System.out.println("resultado: " + resultado);

            ArrayList<String[]> matrixList = new ArrayList<String[]>();
            int cont = 0;
            while (resultado.next()) {

                String a1 = resultado.getString("idproducto");
                String a2 = resultado.getString("idsedes");
                String a3 = resultado.getString("nombre");
                String a4 = resultado.getString("descripcion");
                String a5 = resultado.getString("color");
                String a6 = resultado.getString("alto");
                String a7 = resultado.getString("largo");
                String a8 = resultado.getString("ancho");
                String a9 = resultado.getString("precio");
                String a10 = resultado.getString("cantidad");
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

    public Producto consultProductosCoincidencia(String nombre) {
        String QuerySQL = "SELECT * FROM producto WHERE LOWER (nombre)  LIKE LOWER ( '%" + nombre + "%') OR "
                + "CAST(idProducto AS TEXT) LIKE '" + nombre + "%' ";
        Connection coneccion = this.access.getConnetion();

        try {
            Statement sentencia = coneccion.createStatement();
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
            String idproducto = "";
            String nombreprodu = "";
            String colorprodu = "";
            int altoprodu = 0;
            int largoprodu = 0;
            int anchoprodu = 0;
            int precioprodu = 0;

            if (nombre.length() != 0) {

                if (resultado.next()) {

                    idproducto = resultado.getString("idproducto");
                    nombreprodu = resultado.getString("nombre");
                    colorprodu = resultado.getString("color");
                    altoprodu = resultado.getInt("alto");
                    largoprodu = resultado.getInt("largo");
                    anchoprodu = resultado.getInt("ancho");
                    precioprodu = resultado.getInt("precio");

                    return new Producto(idproducto, nombreprodu, "", colorprodu, altoprodu, largoprodu, anchoprodu, precioprodu);

                } else {
                    return new Producto("", "Sin resultados...", null, null, 0, 0, 0, 0);
                }
            } else {
                return new Producto("", null, null, null, 0, 0, 0, 0);
            }
        } catch (PSQLException psqe) {

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return new Producto("", "Sin resultados...", null, null, 0, 0, 0, 0);
    }

    public Producto productosDisponibles() {
        String QuerySQL = "SELECT p.nombre, p.precio, p.color, i.cantidad\n"
                + "FROM PRODUCTO p, INVENTARIO i WHERE i.cantidad > 0;";
        Connection coneccion = this.access.getConnetion();
        try {
            Statement sentencia = coneccion.createStatement();
            ResultSet resultado = sentencia.executeQuery(QuerySQL);

        } catch (PSQLException psqe) {

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return new Producto("", "Sin resultados...", null, null, 0, 0, 0, 0);

    }

    public DefaultTableModel mostrarACTIVOS(String sede) {
        DefaultTableModel modelo;
        Connection coneccion = this.access.getConnetion();
        String[] titulos = {"Codigo", "Nombre", "Color", "Cantidad", "Precio"};

        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        sSql = "SELECT p.idproducto, p.nombre, p.precio, p.color, i.cantidad "
                + "FROM PRODUCTO p, INVENTARIO i  WHERE i.cantidad > 0 AND i.idsedes = '" + sede + "' AND p.idproducto = i.idproducto ";

        try {

            Statement st = coneccion.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("idproducto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("color");
                registro[3] = rs.getString("cantidad");
                registro[4] = rs.getString("precio");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean RestarCantidadProductos(String codigo, String cantidad, String idsede) {
        String QuerySQL = "UPDATE inventario  "
                + "SET cantidad = cantidad - '" + cantidad + "' "
                + "WHERE  idproducto = '" + codigo + "' and idsedes = '" + idsede + "'";
        Connection coneccion = this.access.getConnetion();

        try {
            Statement sentencia = coneccion.createStatement();
            int res = sentencia.executeUpdate(QuerySQL);

            if (res == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    public boolean SumarCantidadProductos(String codigo, String cantidad, String idsede) {
        String QuerySQL = "UPDATE inventario  "
                + "SET cantidad = cantidad + '" + cantidad + "' "
                + "WHERE  idproducto = '" + codigo + "' and idsedes = '" + idsede + "'";
        Connection coneccion = this.access.getConnetion();

        try {
            Statement sentencia = coneccion.createStatement();
            int res = sentencia.executeUpdate(QuerySQL);

            if (res == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    public ResultSet maxIDventa() throws PSQLException, SQLException {
        ResultSet rs;
        String SQL = "SELECT MAX(idventa) FROM venta ";
        Connection coneccion = this.access.getConnetion();
        Statement sentencia = coneccion.createStatement();
        rs = sentencia.executeQuery(SQL);

        return rs;
    }

    public boolean agregarVenta(String idventa, String iduser, String preciototal, String fecha, String idsedes) {
        String QuerySQL = "INSERT INTO venta (idventa,iduser,preciototal,fecha,idsedes) "
                + "VALUES ('" + idventa + "', '" + iduser + "', '" + preciototal + "', '" + fecha + "', '" + idsedes + "')";
        Connection coneccion = this.access.getConnetion();

        try {
            Statement sentencia = coneccion.createStatement();
            int resultado = sentencia.executeUpdate(QuerySQL);
            if (resultado == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("---- Problema en la ejecucion.");
            ex.printStackTrace();
        }
        return false;
    }

    public DefaultTableModel mostrarRegistrosDeVentaVendedor(String iduser) {
        DefaultTableModel modelo;
        Connection coneccion = this.access.getConnetion();
        String[] titulos = {"Código Venta", "Código Vendedor", "Sede ", "Fecha", "Precio Total"};

        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        sSql = " SELECT v.idventa, u.iduser ,s.city,v.fecha,v.preciototal "
                + "FROM venta v ,users u, sedes s, vendedoressede ven "
                + "WHERE u.iduser = '" + iduser + "' and u.iduser = ven.iduser and v.idsedes = s.idsedes and  ven.idsedes  =   s.idsedes ;  ";

        try {

            Statement st = coneccion.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("iduser");
                registro[2] = rs.getString("city");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("preciototal");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel BuscarRegistrosDeVentaVendedor(String iduser, String fechaInicio, String fechaFinal) {
        DefaultTableModel modelo;
        Connection coneccion = this.access.getConnetion();
        String[] titulos = {"Código Venta", "Código Vendedor", "Sede ", "Fecha", "Precio Total"};

        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        sSql = " SELECT v.idventa, u.iduser ,s.city,v.fecha,v.preciototal "
                + "FROM venta v ,users u, sedes s, vendedoressede ven "
                + "WHERE u.iduser = '" + iduser + "' and u.iduser = ven.iduser and v.idsedes = s.idsedes and  ven.idsedes  =   s.idsedes  and  v.fecha between '" + fechaInicio + "' and '" + fechaFinal + "';  ";

        try {

            Statement st = coneccion.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("iduser");
                registro[2] = rs.getString("city");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("preciototal");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel BuscarRegistrosDeVentaGerente(String fechaInicio, String fechaFinal) {
        DefaultTableModel modelo;
        Connection coneccion = this.access.getConnetion();
        String[] titulos = {"Código Venta", "Código Vendedor", "Sede ", "Fecha", "Precio Total"};

        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);
        System.out.println(fechaInicio);
        System.out.println(fechaFinal);
        sSql = " SELECT v.idventa, u.iduser ,s.city,v.fecha,v.preciototal "
                + "FROM venta v ,users u, sedes s, vendedoressede ven "
                + " WHERE  u.iduser = ven.iduser and v.iduser = u.iduser and v.idsedes = s.idsedes and  ven.idsedes  =   s.idsedes  and  v.fecha between '" + fechaInicio + "' and '" + fechaFinal + "';  ";

        try {

            Statement st = coneccion.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("iduser");
                registro[2] = rs.getString("city");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("preciototal");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrarRegistrosDeVentaGerente() {
        DefaultTableModel modelo;
        Connection coneccion = this.access.getConnetion();
        String[] titulos = {"Código Venta", "Código Vendedor", "Sede ", "Fecha", "Precio Total"};

        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        sSql = " SELECT v.idventa, u.iduser ,s.city,v.fecha,v.preciototal "
                + "FROM venta v ,users u, sedes s, vendedoressede ven "
                + " WHERE  u.iduser = ven.iduser and v.iduser = u.iduser and v.idsedes = s.idsedes and  ven.idsedes  =   s.idsedes   ";

        try {

            Statement st = coneccion.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("iduser");
                registro[2] = rs.getString("city");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("preciototal");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrarRegistrosDeVentaJefeTaller(String idsede) {
        DefaultTableModel modelo;
        Connection coneccion = this.access.getConnetion();
        String[] titulos = {"Código Venta", "Código Vendedor", "Sede ", "Fecha", "Precio Total"};

        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        sSql = " SELECT v.idventa, u.iduser ,s.city,v.fecha,v.preciototal "
                + "FROM venta v ,users u, sedes s, vendedoressede ven "
                + "WHERE  u.iduser = ven.iduser and v.iduser = u.iduser  and v.idsedes = s.idsedes and  ven.idsedes  =  '" + idsede + "' ";

        try {

            Statement st = coneccion.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("iduser");
                registro[2] = rs.getString("city");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("preciototal");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel BuscarRegistrosDeVentaJefeTaller(String idsede, String fechaInicio, String fechaFinal) {
        DefaultTableModel modelo;
        Connection coneccion = this.access.getConnetion();
        String[] titulos = {"Código Venta", "Código Vendedor", "Sede ", "Fecha", "Precio Total"};

        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        sSql = " SELECT v.idventa, u.iduser ,s.city,v.fecha,v.preciototal "
                + "FROM venta v ,users u, sedes s, vendedoressede ven "
                + "WHERE  u.iduser = ven.iduser and v.iduser = u.iduser and v.idsedes = s.idsedes and  ven.idsedes  =   '" + idsede + "'  and  v.fecha between '" + fechaInicio + "' and '" + fechaFinal + "';  ";

        try {

            Statement st = coneccion.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("iduser");
                registro[2] = rs.getString("city");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("preciototal");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ArrayList<String[]> consulProductosCoincidenciaDelJefe(String idSede, String busqueda) {
                
        String QuerySQL = "SELECT * FROM "
                + "(Select idproducto, idsedes, nombre, descripcion, color, alto, largo, ancho, precio, cantidad from "
                + "(select * from inventario order by idsedes, idproducto) as foo natural join (select * from producto) as goo) "
                + "as cons WHERE cons.idsedes = '"+idSede+"' AND (LOWER (cons.nombre)  LIKE LOWER ( '%" + busqueda + "%') OR "
                + "CAST(cons.idProducto AS TEXT) LIKE '" + busqueda + "%') ";

        Connection coneccion = this.access.getConnetion();
//        System.out.println("Connection: " + coneccion);

        try {
            Statement sentencia = coneccion.createStatement();
//            System.out.println("sentencia: " + sentencia);
            ResultSet resultado = sentencia.executeQuery(QuerySQL);
//            System.out.println("resultado: " + resultado);

            ArrayList<String[]> matrixList = new ArrayList<String[]>();
            int cont = 0;
            while (resultado.next()) {

                String a1 = resultado.getString("idproducto");
                String a2 = resultado.getString("idsedes");
                String a3 = resultado.getString("nombre");
                String a4 = resultado.getString("descripcion");
                String a5 = resultado.getString("color");
                String a6 = resultado.getString("alto");
                String a7 = resultado.getString("largo");
                String a8 = resultado.getString("ancho");
                String a9 = resultado.getString("precio");
                String a10 = resultado.getString("cantidad");
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

    public void generarReporte(String Finicio, String Ffinal) throws JRException {
        Connection coneccion = this.access.getConnetion();
        String report = "C:/Users/Acer/DS1/src/Reportes/report1.jrxml";
        Map parametro = new HashMap();
        parametro.put("fechaInicio", Finicio);
        parametro.put("fechaFin", Ffinal);
        JasperReport jr = JasperCompileManager.compileReport(report);
        JasperPrint jp = JasperFillManager.fillReport(jr, parametro, coneccion);
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setTitle("Reporte de ventas");
        jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jv.setVisible(true);
        
        
//        JasperReport reporte = (JasperReport) JRLoader.loadObject("/home/carban/NetBeansProjects/DS6/DS1/src/Reportes/newReport.jasper");
////        URL path = this.getClass().getResource("src/Reportes/newReport.jasper");
//        JasperPrint print = JasperFillManager.fillReport(reporte, null, coneccion);
//        JasperViewer jv = new JasperViewer(print, false);
//        jv.setTitle("Reporte de ventas");
//        jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        jv.setVisible(true);
        


//        String REPORT = "/home/carban/Desktop/report1.jrxml";
//        JasperReport rep = JasperCompileManager.compileReport(REPORT);
//        JasperPrint print = JasperFillManager.fillReport(rep, null, coneccion);
//        JasperViewer.viewReport(print);
    }

    public void generarReporteVentasJefeDeTaller(String sede, String fechaInicio, String fechaFinal) throws JRException {
        Connection coneccion = this.access.getConnetion();
        String report = "C:/Users/Acer/DS1/src/Reportes/report2.jrxml";
        Map parametro = new HashMap();
        parametro.put("fechaInicio", fechaInicio);
        parametro.put("fechaFin", fechaFinal);
        parametro.put("sede", sede);
        JasperReport jr = JasperCompileManager.compileReport(report);
        JasperPrint jp = JasperFillManager.fillReport(jr, parametro, coneccion);
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setTitle("Reporte de ventas");
        jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jv.setVisible(true);
    }

}
