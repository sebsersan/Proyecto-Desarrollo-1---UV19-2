package Controladora;

import Modelo.Sedes;
import Modelo.Users;
import Modelo.Jefes;
import Modelo.Orden;
import Modelo.Producto;
import Modelo.Vendedor;
import ModeloDAO.Acceso;
import ModeloDAO.JefesDAO;
import ModeloDAO.OrdenDAO;
import ModeloDAO.ProductoDAO;
import ModeloDAO.UsersDAO;
import ModeloDAO.SedesDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

public class Controladora {

    Acceso access;
    UsersDAO usersDao;
    SedesDAO sedesDao;
    JefesDAO jefesDao;
    ProductoDAO productoDao;
    OrdenDAO ordenDao;

    public Controladora() {
        access = new Acceso();
        this.usersDao = new UsersDAO(access);
        this.sedesDao = new SedesDAO(access);
        this.jefesDao = new JefesDAO(access);
        this.productoDao = new ProductoDAO(access);
        this.ordenDao = new OrdenDAO(access);
    }

    public String login(String user, String pass) {
        return usersDao.login(user, pass);
    }

    public Users consultProfile(String userID) {
        return usersDao.consultProfile(userID);
    }

    public Jefes consultProfileJefe(String userID) {
        return jefesDao.consultProfile(userID);
    }

    public Vendedor consultProfileVENDEDOR(String userID) {
        //CAMBIAR A VENDEDOR DAO
        return jefesDao.consultProfileVENDEDOR(userID);
    }

    public Producto consultProducto(String codigo) {
        return productoDao.consultProducto(codigo);
    }

    public Producto consultProductCoincidencia(String valor) {

        return productoDao.consultProductosCoincidencia(valor);
    }

    public DefaultTableModel mostrarActivos(String sede) {
        return productoDao.mostrarACTIVOS(sede);
    }

    public ResultSet maxVenta() throws SQLException {
        return productoDao.maxIDventa();
    }

    public void alterComboJefeEditing(JComboBox combo, String[] firstPersonOnCombo) {//NO C

        System.err.println(firstPersonOnCombo);
        combo.removeAllItems();
        combo.addItem(firstPersonOnCombo[0] + "," + firstPersonOnCombo[1]);
        try {
            ResultSet res = sedesDao.comboOptions();

            while (res.next()) {
                combo.addItem(res.getString("idUser") + ", " + res.getString("first_name") + " " + res.getString("last_name"));
            }
        } catch (Exception e) {
            System.out.println("---- Problema en la ejecucion.");
        }

    }

    public void alterComboJefe(JComboBox combo) {
        combo.removeAllItems();
        try {
            ResultSet res = sedesDao.comboOptions();
            int c = 0;
            while (res.next()) {
                c++;
                combo.addItem(res.getString("idUser") + ", " + res.getString("first_name") + ", " + res.getString("last_name"));
            }
            if (c == 0) {
                combo.addItem("Seleccione");
            }
        } catch (Exception e) {
            System.out.println("---- Problema en la ejecucion.");
            e.printStackTrace();
        }

    }

    //Funcion para crear usuarios desde el gerente
    public boolean createUser(String id, String fname, String lname, String telefono, String direccion, String position, String pass) {
        Users aU = new Users(id, fname, lname, telefono, direccion, position, pass);
        if(position.equals("Gerente")){
            aU.setState("Activo");
        }else{
            aU.setState("Inactivo");
        }
        return usersDao.createNewUser(aU);
    }

    //Funcion para crear usuarios vendedor desde la vista del Jefe de taller
    public boolean createUserVendedor(String id, String fname, String lname, String telefono, String direccion, String pass, String idSede) {
        Users aU = new Users(id, fname, lname, telefono, direccion, "Vendedor", pass);
        aU.setState("Activo");
        return jefesDao.createNewUser(aU, idSede);
    }

    //Funcion para actualizar usuarios desde el gerente
    public boolean updateUser(String id, String fname, String lname, String telefono, String direccion, String position) {
        Users aU = new Users(id, fname, lname, telefono, direccion, position);
        return usersDao.updateUser(aU);
    }
    
    //Actualizar un gerente desde el Administrador del Sistema
    public boolean updateGerente(String id, String fname, String lname, String telefono, String direccion, String position) {
        Users aU = new Users(id, fname, lname, telefono, direccion, position);
        return usersDao.updateGerente(aU);
    }

    //Funcion para actualizar usuarios desde el gerente
    public boolean updateUserVendedor(String id, String fname, String lname, String telefono, String direccion) {
        Users aU = new Users(id, fname, lname, telefono, direccion, "Vendedor");
        return jefesDao.updateUserVendedor(aU);
    }

    //Funcion para actualizar sedes desde el gerente
    public boolean updateSede(String idSede, String city, String address, String state, String placeid, String jefeActual) {
        Sedes aS = new Sedes(city, address, state, placeid);
        aS.setId(idSede);
        return sedesDao.updateSede(aS, jefeActual);
    }

    //Funcion para consultar usuarios desde el gerente
    public ArrayList<String[]> consultUsers() {
        return usersDao.consultUsers();
    }
    
    public ArrayList<String[]> consultGerente() {
        return usersDao.consultGerente();
    }
    
    public boolean despedirUsuario(String idUser){
        return usersDao.despedirUsuario(idUser);
    }
    
    public boolean despedirGerente(String idUser){
        return usersDao.despedirGerente(idUser);
    }
    
    //Funcion para consultar vendedores desde el Jefe de taller
    public ArrayList<String[]> consultUsersVendedores(String idSede) {
        return jefesDao.consultUsersVendedores(idSede);
    }

    //Funcion para consultar sedes desde el gerente
    public ArrayList<String[]> consultSedes() {
        return sedesDao.consultSede();
    }

    //Funcion para crear sedes desde el gerente
    public boolean createSede(String ciudad, String direccion, String estado, String jefe) {
        Sedes sede = new Sedes(ciudad, direccion, estado, jefe);
        return sedesDao.createNewSede(sede);
    }

    //Funcion para crear usuarios desde el gerente
    public boolean crearProducto(String nombre, String descripcion, String color, int alto, int largo, int ancho, int precio) {
        Producto prod = new Producto("TEMPORAL", nombre, descripcion, color, alto, largo, ancho, precio);
        return productoDao.crearNuevoProducto(prod);
    }

    //Funcion para consultar productos desde el gerente
    public ArrayList<String[]> consultProductos() {
        return productoDao.consultProductos();
    }
    
    public ArrayList<String[]> consultProductosCoincidencia_tabla(String busqueda) {
       return productoDao.consultProductosCoincidencia_tabla(busqueda);
    }

    public void AlterComboVendedoresDisponibles(JComboBox<String> comboVendedoresDisponibles) {
        comboVendedoresDisponibles.removeAllItems();
        try {
            ResultSet res = productoDao.comboOptions();
            int c = 0;
            while (res.next()) {
                c++;
                comboVendedoresDisponibles.addItem(res.getString("idUser") + ", " + res.getString("first_name") + " " + res.getString("last_name"));
            }
            if (c == 0) {
                comboVendedoresDisponibles.addItem("Seleccione");
            }
        } catch (Exception e) {
            System.out.println("---- Problema en la ejecucion.");
            e.printStackTrace();
        }
    }

    public boolean AsignarUnVendedor(String id, String sedeid) {
        return jefesDao.asignarUnVendedor(id, sedeid);
    }

    public ArrayList<String[]> consultProductosDelJefe(String sedeid) {
        return productoDao.consultProductosDelJefe(sedeid);
    }
    public boolean crearOrden(String cantidad, boolean estado, String idProducto, String idSede) {
        Orden ao = new Orden(cantidad, estado, idProducto, idSede);
        return ordenDao.crearOrden(ao);
    }

    public ArrayList<String[]> consultOrders(String sedeid) {
        return ordenDao.consultOrders(sedeid);
    }

    public boolean finalizarOrden(String idOrden, String idProd, String sedeid) {
        return ordenDao.finalizarOrden(idOrden, idProd, sedeid);
    }

    public boolean updateCantidadResta(String codigo, String cantidad, String idsede) {
        return productoDao.RestarCantidadProductos(codigo, cantidad, idsede);
    }

    public boolean updateCantidadSuma(String codigo, String cantidad, String idsede) {
        return productoDao.SumarCantidadProductos(codigo, cantidad, idsede);
    }

    public boolean agregarVenta(String idventa, String iduser, String preciototal, String fecha, String idsedes) {
        return productoDao.agregarVenta(idventa, iduser, preciototal, fecha, idsedes);
    }

    public DefaultTableModel agregarRegistroVentaVendedor(String iduser) {
        return productoDao.mostrarRegistrosDeVentaVendedor(iduser);
    }

    public DefaultTableModel consultarRegistroVentasVendedor(String iduser, String fechaInicio, String fechaFinal) {
        return productoDao.BuscarRegistrosDeVentaVendedor(iduser, fechaInicio, fechaFinal);
    }

    public DefaultTableModel agregarRegistroVentaGerente() {
        return productoDao.mostrarRegistrosDeVentaGerente();
    }

    public DefaultTableModel consultarRegistroVentasGerente(String fechaInicio, String fechaFinal) {
        return productoDao.BuscarRegistrosDeVentaGerente(fechaInicio, fechaFinal);
    }

    public DefaultTableModel agregarRegistroVentaJefeTaller(String idsede) {
        return productoDao.mostrarRegistrosDeVentaJefeTaller(idsede);
    }

    public DefaultTableModel consultarRegistroVentasJefeTaller(String idsede, String fechaInicio, String fechaFinal) {
        return productoDao.BuscarRegistrosDeVentaJefeTaller(idsede, fechaInicio, fechaFinal);
    }

    public ArrayList<String[]> consultUsersJefes() {
        return usersDao.consultUsersJefes();
    }
    
    public ArrayList<String[]> consultUsersVendedores() {
        return usersDao.consultUsersVendedores();
    }

    public ArrayList<String[]> consultUsersCoincidencia_tabla(String busqueda) {
        return usersDao.consultUsersCoincidencia_tabla(busqueda);
    }

    public ArrayList<String[]> consultSedesCoincidencia_tabla(String busqueda) {
        return sedesDao.consultSedesCoincidencia_tabla(busqueda);
    }

    public ArrayList<String[]> consultProductosCoincidenciaDelJefe(String idSede, String busqueda) {
        return productoDao.consulProductosCoincidenciaDelJefe(idSede, busqueda);
    }

    public ArrayList<String[]> consultUsersVendedoresCoincidencia(String idSede, String busqueda) {
        return jefesDao.consultUsersVendedoresCoincidencia(idSede, busqueda);
    }

    public void generarReporte(String finicio, String ffinal) throws JRException {
        productoDao.generarReporte(finicio, ffinal);
    }

    public ArrayList<String[]> consultOrdenesCoincidencia(String idSede, String busqueda) {
        return ordenDao.consultOrdenesCoincidencia(idSede, busqueda);
    }

    public void generarReporteVentasJefeDeTaller(String sede, String fechaInicio, String fechaFinal) throws JRException {
        productoDao.generarReporteVentasJefeDeTaller(sede, fechaInicio, fechaFinal);
    }


}
