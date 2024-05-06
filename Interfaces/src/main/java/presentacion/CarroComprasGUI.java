/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import co.com.hyunseda.market.entities.Item;
import co.com.hyunseda.market.entities.Order;
import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.infra.Observer;
import co.com.hyunseda.market.service.ProductService;
import co.com.hyunseda.market.service.ShoppingCartService;
import co.com.hyunseda.market.service.OrderService;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author JUAN CARLOS MELO
 */
public class CarroComprasGUI extends javax.swing.JFrame implements Observer {
    ShoppingCartService shoppingCartService;
    ProductService productService;
    OrderService orderService;
    
    /**
     * Creates new form CarroComprasGUI
     */
    public CarroComprasGUI(ShoppingCartService shoppingCartService,ProductService productService,OrderService orderService) {
        initComponents();
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.orderService = orderService ;
        setLocationRelativeTo(null);
        setSize(500, 600);
        initiazeTable();
    }
    
    private void initiazeTable(){
        tblCarrito.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "idProducto","name","description","Category","stock","price","eliminar"
                }
        ){
            //Hace que la tabla no se pueda editar(que al presionar eliminar o modificar no salga la direccion del Boton)
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
    }
    
    private void fillTable(List<Product> listProducts){
        initiazeTable();
        tblCarrito.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel model = (DefaultTableModel) tblCarrito.getModel();
        JButton btn1 = new JButton("Eliminar");
        btn1.setName("delete");
        Object rowData[] = new Object[7];
        for(int i = 0; i < listProducts.size();i++){
            rowData[0] = listProducts.get(i).getProduct_id();
            rowData[1] = listProducts.get(i).getName();
            rowData[2] = listProducts.get(i).getDescription();
            rowData[3] = listProducts.get(i).obtenerCategoriasConFormato();
            rowData[4] = listProducts.get(i).getStock();
            rowData[5] = listProducts.get(i).getPrice();
            rowData[6] = btn1;
            model.addRow(rowData);
        } 
    }
        
        private void totalPrecio(List<Product> listProducts){
            double total=0;
            for(int i = 0; i < listProducts.size();i++){
                total += listProducts.get(i).getPrice();
            }
            lblTotal.setText(String.valueOf(total));
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlSur = new javax.swing.JPanel();
        pnlSurDer = new javax.swing.JPanel();
        txtCodigoCuenta = new javax.swing.JTextField();
        btnComprar = new javax.swing.JButton();
        pnlSurCen = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbxMetodoPago = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        pnlCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrito = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnlNorte.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setText("Carrito de Compras");
        pnlNorte.add(jLabel2);

        getContentPane().add(pnlNorte, java.awt.BorderLayout.PAGE_START);

        pnlSur.setLayout(new java.awt.BorderLayout());

        pnlSurDer.setLayout(new java.awt.BorderLayout());

        txtCodigoCuenta.setText("Codigo de cuenta");
        txtCodigoCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoCuentaKeyTyped(evt);
            }
        });
        pnlSurDer.add(txtCodigoCuenta, java.awt.BorderLayout.CENTER);

        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        pnlSurDer.add(btnComprar, java.awt.BorderLayout.PAGE_END);

        pnlSur.add(pnlSurDer, java.awt.BorderLayout.LINE_END);

        pnlSurCen.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setText("Metodo de pago: ");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlSurCen.add(jLabel3);

        cbxMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PayPal", "GooglePay", "Stripe" }));
        cbxMetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMetodoPagoActionPerformed(evt);
            }
        });
        pnlSurCen.add(cbxMetodoPago);

        jLabel6.setText("Pagar :");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlSurCen.add(jLabel6);

        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("0");
        lblTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlSurCen.add(lblTotal);

        pnlSur.add(pnlSurCen, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlSur, java.awt.BorderLayout.PAGE_END);

        tblCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarritoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCarrito);

        pnlCentro.add(jScrollPane1);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMetodoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMetodoPagoActionPerformed

    private void tblCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarritoMouseClicked
        int column = tblCarrito.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblCarrito.getRowHeight();
        
        //verifica que la posicion x y y no se pasen del numero de columnas y filas existentes
        if(row < tblCarrito.getRowCount() && row >= 0 && column < tblCarrito.getColumnCount() && column >= 0){
            Object value = tblCarrito.getValueAt(row, column);
            //verifica que si se hizo click en un boton, reciba el value del boton
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                if(boton.getName().equals("delete")){
                    shoppingCartService.eliminarProducto((Long)tblCarrito.getValueAt(row, 0));
                }
            }
        }
    }//GEN-LAST:event_tblCarritoMouseClicked

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        
        
        double total = Double.parseDouble(lblTotal.getText());
        if(total == 0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun producto.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            return;
        }
        String codigoCuenta = txtCodigoCuenta.getText();
        Object selectedObject = cbxMetodoPago.getSelectedItem();
        String metodoPago = selectedObject.toString();
        
        

        boolean pago =  true;
        if(pago){
            productService.actualizarStockCompra(shoppingCartService.getCart());
            List<Item> items = new ArrayList<Item>();
            for(Product p : shoppingCartService.getCart().getCarro()){
                items.add(new Item(p,p.getStock()));
            }
            Order order = new Order(new Date(),items);
            orderService.saveOrder(order);
            JOptionPane.showMessageDialog(null, "EL pago fue exitoso :3.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            vaciarCarrito();
        }else{
            JOptionPane.showMessageDialog(null, "EL pago rechazado :,v.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            vaciarCarrito();
        }
        
    }//GEN-LAST:event_btnComprarActionPerformed

    private void txtCodigoCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCuentaKeyTyped
        limitarNumeros(evt);
    }//GEN-LAST:event_txtCodigoCuentaKeyTyped
    
    public void limitarNumeros(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume(); // Ignorar el carácter no válido
        }
    }
    public void vaciarCarrito(){
        cbxMetodoPago.setSelectedIndex(0);
        txtCodigoCuenta.setText("Codigo de cuenta");
        shoppingCartService.vaciarCarrito();
        this.setVisible(false);
    }
    
    @Override // total de la compra
    public void update(Object o) {
        this.setVisible(true);
        ShoppingCartService aux =(ShoppingCartService)o;
        fillTable(aux.getCart().getCarro());
        totalPrecio(aux.getCart().getCarro());
    }
    /*
    private String getBaseFilePath() {
        try {
            String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "UTF-8"); //This should solve the problem with spaces and special characters.
            File pathFile = new File(path);
            if (pathFile.isFile()) {
                path = pathFile.getParent();
                
                if (!path.endsWith(File.separator)) {
                    path += File.separator;
                }
            }

            return path;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PagoCore.class.getName()).log(Level.SEVERE, "Error al eliminar espacios en la ruta del archivo", ex);
            return null;
        }
    }*/
    
    public class Render extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if(value instanceof JButton){
            JButton btn = (JButton)value;
            return btn;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, 
                hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JComboBox<String> cbxMetodoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JPanel pnlSurCen;
    private javax.swing.JPanel pnlSurDer;
    private javax.swing.JTable tblCarrito;
    private javax.swing.JTextField txtCodigoCuenta;
    // End of variables declaration//GEN-END:variables
}
