/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Users;
import java.awt.event.MouseEvent;
import Controladora.Controladora;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Operador extends javax.swing.JFrame {
    Controladora control = new Controladora();
    /**
     * Creates new form Operador
     */
    public Operador(String userID) {
        initComponents();
        this.setLocationRelativeTo(null);
        panelRegistrarPago.setVisible(false);
        
        Users profileInfo = control.consultProfile(userID);
        this.cc_operador.setText(profileInfo.getId());
        this.nombre_operador.setText(profileInfo.getFname());
        this.apellido_operador.setText(profileInfo.getLname());
        this.telefono_operador.setText(profileInfo.getTel());
        this.direccion_operador.setText(profileInfo.getDir());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        crearCliente = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelRegistrarPago = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        SignOut1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        panelPerfil = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cc_operador = new javax.swing.JTextField();
        nombre_operador = new javax.swing.JTextField();
        apellido_operador = new javax.swing.JTextField();
        direccion_operador = new javax.swing.JTextField();
        telefono_operador = new javax.swing.JTextField();
        SignOut = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        panelCrearCliente = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldCedula = new javax.swing.JTextField();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldPaterno = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextFieldMaterno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(15, 60, 235));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Perfil");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setDefaultCapable(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Registrar Pago");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setDefaultCapable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        crearCliente.setForeground(new java.awt.Color(255, 255, 255));
        crearCliente.setText("Crear Cliente");
        crearCliente.setBorderPainted(false);
        crearCliente.setContentAreaFilled(false);
        crearCliente.setDefaultCapable(false);
        crearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(crearCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crearCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRegistrarPago.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("ID");

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        jLabel8.setText("Registrar Pago");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Confirmar");

        jLabel9.setText("Monto");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        SignOut1.setBackground(new java.awt.Color(255, 255, 255));
        SignOut1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        SignOut1.setForeground(new java.awt.Color(255, 255, 255));
        SignOut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/salida.png"))); // NOI18N
        SignOut1.setBorderPainted(false);
        SignOut1.setContentAreaFilled(false);
        SignOut1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignOut1.setFocusable(false);
        SignOut1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignOut1MouseClicked(evt);
            }
        });

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Multiply_25px.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRegistrarPagoLayout = new javax.swing.GroupLayout(panelRegistrarPago);
        panelRegistrarPago.setLayout(panelRegistrarPagoLayout);
        panelRegistrarPagoLayout.setHorizontalGroup(
            panelRegistrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrarPagoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelRegistrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(panelRegistrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton3)
                        .addGroup(panelRegistrarPagoLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(49, 49, 49)
                            .addGroup(panelRegistrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                .addComponent(jTextField7)))))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistrarPagoLayout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(panelRegistrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistrarPagoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistrarPagoLayout.createSequentialGroup()
                        .addComponent(SignOut1)
                        .addGap(159, 159, 159))
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        panelRegistrarPagoLayout.setVerticalGroup(
            panelRegistrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrarPagoLayout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addGap(47, 47, 47)
                .addGroup(panelRegistrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelRegistrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(SignOut1)
                .addGap(42, 42, 42))
        );

        panelPerfil.setBackground(new java.awt.Color(255, 255, 255));
        panelPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelPerfil.setForeground(new java.awt.Color(255, 255, 255));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        jLabel1.setText("Perfil Operador");

        jLabel2.setText("Cedula:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido:");

        jLabel5.setText("Direccion:");

        jLabel6.setText("Telefono:");

        cc_operador.setEditable(false);
        cc_operador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cc_operador.setBorder(null);
        cc_operador.setOpaque(false);

        nombre_operador.setEditable(false);
        nombre_operador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombre_operador.setBorder(null);
        nombre_operador.setOpaque(false);

        apellido_operador.setEditable(false);
        apellido_operador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        apellido_operador.setBorder(null);
        apellido_operador.setOpaque(false);

        direccion_operador.setEditable(false);
        direccion_operador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        direccion_operador.setBorder(null);
        direccion_operador.setOpaque(false);

        telefono_operador.setEditable(false);
        telefono_operador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        telefono_operador.setBorder(null);
        telefono_operador.setOpaque(false);

        SignOut.setBackground(new java.awt.Color(255, 255, 255));
        SignOut.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        SignOut.setForeground(new java.awt.Color(255, 255, 255));
        SignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/salida.png"))); // NOI18N
        SignOut.setBorderPainted(false);
        SignOut.setContentAreaFilled(false);
        SignOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignOut.setFocusable(false);
        SignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignOutActionPerformed(evt);
            }
        });

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/icons8_Multiply_25px.png"))); // NOI18N
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPerfilLayout = new javax.swing.GroupLayout(panelPerfil);
        panelPerfil.setLayout(panelPerfilLayout);
        panelPerfilLayout.setHorizontalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPerfilLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cc_operador)
                            .addComponent(nombre_operador)
                            .addComponent(apellido_operador)
                            .addComponent(direccion_operador)
                            .addComponent(telefono_operador, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)))
                    .addGroup(panelPerfilLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel18))
                    .addGroup(panelPerfilLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(SignOut)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPerfilLayout.createSequentialGroup()
                .addGap(0, 184, Short.MAX_VALUE)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPerfilLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(65, 65, 65))
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        panelPerfilLayout.setVerticalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(26, 26, 26)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cc_operador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombre_operador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(apellido_operador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(direccion_operador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(telefono_operador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(SignOut)
                .addGap(41, 41, 41))
        );

        panelCrearCliente.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel10.setText("Nombre");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        jLabel11.setText("Crear Cliente");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel13.setText("Teléfono");

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel14.setText("Dirección");

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel15.setText("Tipo de Usuario");

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel16.setText("Cedula");

        jButton5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jButton5.setText("Crear Cliente");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextFieldNombre.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N

        jTextFieldTelefono.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N

        jTextFieldDireccion.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N

        jTextFieldCedula.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N

        jComboBoxTipo.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Natural", "Corporativo" }));

        jLabel17.setText("Apellido Paterno");
        jLabel17.setAlignmentX(1.0F);

        jTextFieldPaterno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPaterno.setAlignmentX(1.0F);
        jTextFieldPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPaternoActionPerformed(evt);
            }
        });

        jLabel29.setText("Apellido Materno");
        jLabel29.setAlignmentX(1.0F);

        jTextFieldMaterno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldMaterno.setAlignmentX(1.0F);

        javax.swing.GroupLayout panelCrearClienteLayout = new javax.swing.GroupLayout(panelCrearCliente);
        panelCrearCliente.setLayout(panelCrearClienteLayout);
        panelCrearClienteLayout.setHorizontalGroup(
            panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearClienteLayout.createSequentialGroup()
                .addGroup(panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearClienteLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel11))
                    .addGroup(panelCrearClienteLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel29))
                        .addGap(62, 62, 62)
                        .addGroup(panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTelefono)
                            .addComponent(jTextFieldDireccion)
                            .addComponent(jTextFieldCedula)
                            .addComponent(jComboBoxTipo, 0, 141, Short.MAX_VALUE)
                            .addComponent(jTextFieldPaterno)
                            .addComponent(jTextFieldNombre)
                            .addComponent(jTextFieldMaterno))))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(154, 154, 154))
        );
        panelCrearClienteLayout.setVerticalGroup(
            panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearClienteLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearClienteLayout.createSequentialGroup()
                        .addGroup(panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addComponent(jTextFieldPaterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(19, 19, 19)
                .addGroup(panelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(84, 84, 84)
                .addComponent(jButton5)
                .addGap(72, 72, 72))
        );

        jLayeredPane1.setLayer(panelRegistrarPago, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelPerfil, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelCrearCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelRegistrarPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelCrearCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelRegistrarPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelCrearCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (panelPerfil.isVisible()){
            panelPerfil.setVisible(false);
        }
         if (panelCrearCliente.isVisible()){
            panelCrearCliente.setVisible(false);
        }
        
        panelRegistrarPago.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (panelRegistrarPago.isVisible()){
            panelRegistrarPago.setVisible(false);
        }
        if (panelCrearCliente.isVisible()){
            panelCrearCliente.setVisible(false);
        }
        
        panelPerfil.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        cerrarVentana();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void SignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignOutActionPerformed
        volverALogin();
    }//GEN-LAST:event_SignOutActionPerformed

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        cerrarVentana();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void SignOut1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignOut1MouseClicked
        volverALogin();
    }//GEN-LAST:event_SignOut1MouseClicked

    private void crearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearClienteActionPerformed
        // TODO add your handling code here:
        if (panelRegistrarPago.isVisible()){
            panelRegistrarPago.setVisible(false);
        }
        if (panelPerfil.isVisible()){
            panelPerfil.setVisible(false);
        }
        
        panelCrearCliente.setVisible(true);
    }//GEN-LAST:event_crearClienteActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        if (jTextFieldCedula.getText().equals("") || jTextFieldNombre.getText().equals("") || jTextFieldPaterno.getText().equals("") || jTextFieldMaterno.getText().equals("") || jTextFieldTelefono.getText().equals("") || jTextFieldDireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Error, tienes elementos vacios");
        } else {
            try {
                int identification = Integer.parseInt(jTextFieldCedula.getText());
                if (identification < 0) {
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos \nIntentalo Nuevamente");
                } else if (control.createCliente(jTextFieldCedula.getText(), jTextFieldNombre.getText(), jTextFieldPaterno.getText(), jTextFieldMaterno.getText(),jTextFieldTelefono.getText(), jTextFieldDireccion.getText(), jComboBoxTipo.getItemAt(jComboBoxTipo.getSelectedIndex()))) {
                    this.cleanCreateSection();
                    JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos \nIntentalo Nuevamente");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La Cedula debe ser un entero");
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cleanCreateSection() {
        jTextFieldCedula.setText("");
        jTextFieldNombre.setText("");
        jTextFieldPaterno.setText("");
        jTextFieldMaterno.setText("");
        jTextFieldTelefono.setText("");
        jTextFieldDireccion.setText("");                
    }
    
    private void jTextFieldPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPaternoActionPerformed

    private void cerrarVentana(){
        this.dispose();
    }
    
    private void volverALogin(){
        login2 log = new login2();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SignOut;
    private javax.swing.JButton SignOut1;
    private javax.swing.JTextField apellido_operador;
    private javax.swing.JTextField cc_operador;
    private javax.swing.JButton crearCliente;
    private javax.swing.JTextField direccion_operador;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextFieldCedula;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldMaterno;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPaterno;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField nombre_operador;
    private javax.swing.JPanel panelCrearCliente;
    private javax.swing.JPanel panelPerfil;
    private javax.swing.JPanel panelRegistrarPago;
    private javax.swing.JTextField telefono_operador;
    // End of variables declaration//GEN-END:variables
}
