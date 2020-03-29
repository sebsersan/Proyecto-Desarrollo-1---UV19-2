package Vista;

import Controladora.*;
import ModeloDAO.Acceso;
import ModeloDAO.UsersDAO;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import org.postgresql.util.PSQLException;

public class login2 extends javax.swing.JFrame {

    Controladora control = new Controladora();
    

    public login2() {
        this.setResizable(false);
        initComponents();

        Image icon = new ImageIcon(getClass().getResource("/Recursos/xyzicon.png")).getImage();
        super.setIconImage(icon);
        Ingresar ingresar = new Ingresar();
        passwordInput.addActionListener(ingresar);
        signIn.addActionListener(ingresar);
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        userInput = new javax.swing.JTextField();
        passwordInput = new javax.swing.JPasswordField();
        signIn = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/users.png"))); // NOI18N

        userInput.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        userInput.setForeground(new java.awt.Color(204, 204, 204));
        userInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userInput.setText("USUARIO");
        userInput.setToolTipText("");
        userInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        userInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userInputMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                userInputMouseReleased(evt);
            }
        });
        userInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userInputKeyPressed(evt);
            }
        });

        passwordInput.setForeground(new java.awt.Color(204, 204, 204));
        passwordInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordInput.setText("•••••••••••••••");
        passwordInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        passwordInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordInputMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                passwordInputMouseReleased(evt);
            }
        });
        passwordInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordInputKeyPressed(evt);
            }
        });

        signIn.setBackground(new java.awt.Color(255, 255, 255));
        signIn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        signIn.setForeground(new java.awt.Color(255, 255, 255));
        signIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Bton Login.png"))); // NOI18N
        signIn.setBorderPainted(false);
        signIn.setContentAreaFilled(false);
        signIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signIn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/bton login cursor oscuro.png"))); // NOI18N

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/bton salida.png"))); // NOI18N
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/bton salida cursor oscuro.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(signIn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)
                        .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(signIn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("INICIAR SESION");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 380, 100));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cabecera.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 111));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void userInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userInputMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {

            if (passwordInput.getText().length() == 0) {
                passwordInput.setText("•••••••••••••••");
            } else {

                if (userInput.getText().equalsIgnoreCase("USUARIO")) {
                    userInput.setText(null);

                } else {
                }
            }
        }

    }//GEN-LAST:event_userInputMouseClicked

    private void userInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInputKeyPressed
        // TODO add your handling code here:

        if (passwordInput.getText().length() == 0) {
            passwordInput.setText("•••••••••••••••");
        } else {

            if (userInput.getText().equalsIgnoreCase("USUARIO")) {
                userInput.setText(null);

            } else {
            }
        }

    }//GEN-LAST:event_userInputKeyPressed

    private void passwordInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordInputMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            if (userInput.getText().length() == 0) {
                userInput.setText("USUARIO");
            } else {

                if (passwordInput.getText().equalsIgnoreCase("•••••••••••••••")) {
                    passwordInput.setText(null);
                } else {
                }
            }
        }
    }//GEN-LAST:event_passwordInputMouseClicked

    private void passwordInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordInputKeyPressed
        // TODO add your handling code here:
        if (userInput.getText().length() == 0) {
            userInput.setText("USUARIO");
        } else {

            if (passwordInput.getText().equalsIgnoreCase("•••••••••••••••")) {
                passwordInput.setText(null);

            } else {
            }
        }
    }//GEN-LAST:event_passwordInputKeyPressed

    private void userInputMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userInputMouseReleased
        // TODO add your handling code here:

        if (passwordInput.getText().length() == 0) {
            passwordInput.setText("•••••••••••••••");
        } else {

            if (userInput.getText().equalsIgnoreCase("USUARIO")) {
                userInput.setText(null);

            } else {
            }
        }
    }//GEN-LAST:event_userInputMouseReleased

    private void passwordInputMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordInputMouseReleased
        // TODO add your handling code here:

        if (userInput.getText().length() == 0) {
            userInput.setText("USUARIO");
        } else {

            if (passwordInput.getText().equalsIgnoreCase("•••••••••••••••")) {
                passwordInput.setText(null);
            } else {
            }
        }


    }//GEN-LAST:event_passwordInputMouseReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                login2 log = new login2();
                log.setLocationRelativeTo(null);
                log.setVisible(true);

            }

        });
    }

    public class Ingresar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String user = userInput.getText();
            String pass = passwordInput.getText();
            String aux = control.login(user, pass); //esto lo hago para que no se ejecute varias veces el llamado a este metodo
            if (user.equals("USUARIO") || pass.equals("•••••••••••••••") || user.length() == 0 || pass.length() == 0) {
                JOptionPane.showMessageDialog(null, "Error, campos por llenar.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int userint = Integer.parseInt(user);
                    if (userint < 0) {
                        JOptionPane.showMessageDialog(null, "Informacion incorrecta, prueba otra vez", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (aux.equals("Gerente")) {
                        Gerente viGerente = new Gerente(user);
                        viGerente.setLocationRelativeTo(null);
                        viGerente.setVisible(true);
                        dispose();
                    } else if (aux == "Operador") {
                        Operador viVendedor = new Operador(user);
                        viVendedor.setLocationRelativeTo(null);
                        viVendedor.setVisible(true);
                        dispose();
                    } else if (aux.equals("Vendedor")) {
                        vistaVendedor viJefeTaller = new vistaVendedor(user);
                        viJefeTaller.setLocationRelativeTo(null);
                        viJefeTaller.setVisible(true);
                        dispose();
                    } else if (aux.equals("Administrador")) {
                        Administrador viAdmin = new Administrador(user);
                        viAdmin.setLocationRelativeTo(null);
                        viAdmin.setVisible(true);
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(null, "Informacion incorrecta, prueba otra vez", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El usuario tiene que ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JButton signIn;
    private javax.swing.JTextField userInput;
    // End of variables declaration//GEN-END:variables
}
