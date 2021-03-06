/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.Controladora;
import Modelo.Producto;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.postgresql.util.PSQLException;

/**
 *
 * @author Santiago
 */
public class ProductosDisponibles extends javax.swing.JFrame implements WindowFocusListener {

    Controladora control = new Controladora();
    private Producto coincidencia;

    public ProductosDisponibles() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.addWindowFocusListener(this);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTproductosDis = new javax.swing.JTable();
        btnAgregarProducto = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jtfIDproducto1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jtfproducto1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Productos Disponibles");

        jTproductosDis.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTproductosDis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Color", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTproductosDis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTproductosDisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTproductosDis);

        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/agregarVenta.png"))); // NOI18N
        btnAgregarProducto.setBorderPainted(false);
        btnAgregarProducto.setContentAreaFilled(false);
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.setFocusable(false);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("ID  Producto");

        jtfIDproducto1.setEditable(false);
        jtfIDproducto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfIDproducto1KeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Producto");

        jtfproducto1.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cantidad");

        jTCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTCantidad.setText("1");
        jTCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfIDproducto1)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfproducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarProducto)))
                .addGap(26, 26, 26))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfIDproducto1)
                            .addComponent(jtfproducto1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfIDproducto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIDproducto1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIDproducto1KeyReleased

    private void jTproductosDisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTproductosDisMouseClicked
        // TODO add your handling code here:
        String codigo = jTproductosDis.getValueAt(jTproductosDis.getSelectedRow(), 0).toString();
        String nombre = jTproductosDis.getValueAt(jTproductosDis.getSelectedRow(), 1).toString();
        jtfIDproducto1.setText(codigo);
        jtfproducto1.setText(nombre);
    }//GEN-LAST:event_jTproductosDisMouseClicked

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel modelo;
            modelo = null;
            String[] titulos = {"Código", "Nombre", "Color", "Cantidad", "Precio"};

            coincidencia = control.consultProducto(jtfIDproducto1.getText());
            int cantidad = Integer.parseInt(jTCantidad.getText());
            String[] registro = new String[5];

            if (Integer.parseInt(jTCantidad.getText()) > Integer.parseInt(jTproductosDis.getValueAt(jTproductosDis.getSelectedRow(), 3).toString())
                    || Integer.parseInt(jTCantidad.getText()) < 1) {

                JOptionPane.showMessageDialog(null, "No hay productos suficientes.", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (jtfIDproducto1.getText().length() == 0) {

                JOptionPane.showMessageDialog(null, "Seleccione un producto.", "Error", JOptionPane.ERROR_MESSAGE);

            } else {

                if (vistaVendedor.jtDispoVen.getRowCount() > 0) {

                    modelo = (DefaultTableModel) vistaVendedor.jtDispoVen.getModel();

                } else {

                    modelo = new DefaultTableModel(null, titulos);
                }

                registro[0] = coincidencia.getId();
                registro[1] = coincidencia.getNombre();
                registro[2] = coincidencia.getColor();
                registro[3] = Integer.toString(cantidad);
                registro[4] = Integer.toString(coincidencia.getPrecio());

                modelo.addRow(registro);
                vistaVendedor.jtDispoVen.setModel(modelo);

                for (int c = 0; c < vistaVendedor.jtDispoVen.getColumnCount(); c++) {
                    Class<?> col_class = vistaVendedor.jtDispoVen.getColumnClass(c);
                    vistaVendedor.jtDispoVen.setDefaultEditor(col_class, null); // remove editor
                }
                control.updateCantidadResta(jtfIDproducto1.getText(), Integer.toString(cantidad), vistaVendedor.elVendedor.getIdsede());

                total();
                reiniciar();
            }

        } catch (NumberFormatException nfe) {

            JOptionPane.showMessageDialog(null, "Digite valores numéricos en cantidad.");

        } catch (NullPointerException npe) {

            JOptionPane.showMessageDialog(null, "Seleccione un producto.");

        } catch (ArrayIndexOutOfBoundsException aoi) {

            JOptionPane.showMessageDialog(null, "Seleccione un producto.");

        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    public void total() {

        int tamanio = vistaVendedor.jtDispoVen.getRowCount();
        int resultado = 0;

        for (int i = 0; i < tamanio; i++) {

            resultado += Integer.parseInt(vistaVendedor.jtDispoVen.getValueAt(i, 4).toString()) * Integer.parseInt(vistaVendedor.jtDispoVen.getValueAt(i, 3).toString());

        }

        vistaVendedor.jtTotal.setText(Integer.toString(resultado));

    }

    public void mostrarPdtos() {

        DefaultTableModel modelo;
        String sede = vistaVendedor.elVendedor.getIdsede();
        modelo = control.mostrarActivos(sede);
        jTproductosDis.setModel(modelo);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        jTproductosDis.getColumnModel().getColumn(1).setCellRenderer(tcr);

    }

    public void reiniciar() {

        jtfIDproducto1.setText(null);
        jtfproducto1.setText(null);
        jTCantidad.setText("1");
        mostrarPdtos();

    }


    private void jTCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCantidad;
    public static javax.swing.JTable jTproductosDis;
    private javax.swing.JTextField jtfIDproducto1;
    private javax.swing.JTextField jtfproducto1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowGainedFocus(WindowEvent e) {
        mostrarPdtos();
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        mostrarPdtos();
    }
}
