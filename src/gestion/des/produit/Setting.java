/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit;
import com.github.jinahya.imgscalr.Scalr;
import gestion.des.produit.dao.ConnectDB;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author ziram
 */
public class Setting extends javax.swing.JFrame {

    /**
     * Creates new form Setting
     */
    public Setting() {
        initComponents();
        db = new ConnectDB();
        db.ConnexionIntoDataBase();
        jTextField2.setText(db.NomeLocal());
        jTextField5.setText(db.Tel());
        jTextField6.setText(db.Addr());
        jTextField7.setText(db.TVA()+"");
        ImageIcon icon = new ImageIcon("logo.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        jLabel40.setIcon(icon);
        icon();
    }
    ConnectDB db;
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();

        setTitle("Setting");
        setBackground(new java.awt.Color(51, 102, 255));
        setIconImages(null);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(182, 36, 110));

        jLabel48.setBackground(new java.awt.Color(182, 36, 110));
        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("SETTING");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(240, 226, 244));
        jPanel5.setLayout(null);

        jLabel38.setText("Nome");
        jPanel5.add(jLabel38);
        jLabel38.setBounds(10, 20, 50, 30);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField2);
        jTextField2.setBounds(70, 20, 108, 33);

        jLabel39.setText("Logo");
        jPanel5.add(jLabel39);
        jLabel39.setBounds(10, 144, 40, 20);

        jButton2.setBackground(new java.awt.Color(182, 36, 110));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("choose logo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);
        jButton2.setBounds(70, 140, 108, 23);

        jTextField3.setEditable(false);
        jPanel5.add(jTextField3);
        jTextField3.setBounds(180, 140, 188, 23);

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel40);
        jLabel40.setBounds(10, 164, 359, 187);

        jButton3.setBackground(new java.awt.Color(182, 36, 110));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);
        jButton3.setBounds(312, 27, 57, 23);

        jLabel1.setText("Tel");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(10, 50, 50, 30);
        jPanel5.add(jTextField5);
        jTextField5.setBounds(70, 50, 108, 30);

        jLabel2.setText("Address");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(10, 80, 50, 30);

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField6);
        jTextField6.setBounds(70, 80, 108, 30);

        jLabel3.setText("TAX");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(10, 110, 40, 30);
        jPanel5.add(jTextField7);
        jTextField7.setBounds(70, 110, 48, 30);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/about.png"))); // NOI18N
        jPanel5.add(jLabel49);
        jLabel49.setBounds(0, 0, 380, 370);

        jTabbedPane1.addTab("Ticket", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                  
       
void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().
                getResource("Cartgrill_icon-icons.com_51191.png")));
    }
   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser file =new JFileChooser();
        file.setFileFilter(new FileNameExtensionFilter("png images","png"));
        file.showSaveDialog(this);
        File f = file.getSelectedFile();
        String path = f.getAbsolutePath();
        jTextField3.setText(path);
        Image getAbsolutePath = null ;
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        icon.setImage(image); 
        jLabel40.setIcon(icon);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            String sql="update info set name='"+jTextField2.getText()+"' ,tel='"+jTextField5.getText()+"' , addr ='"+jTextField6.getText()+"' , tva ='"+jTextField7.getText()+"'";
            if(!"".equals(jTextField3.getText())){
              saveImage();}
            if(!"".equals(jTextField2.getText())){
            db.savename(sql);}
        } catch (IOException ex) {
            Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed
    private void saveImage() throws IOException{
    File fl = new File(jTextField3.getText());    
    BufferedImage readed = ImageIO.read(fl);
    
    File f =new File("logo.png");
        

    ImageIO.write(Scalr.resize(readed,100), "png",f );
       
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Setting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

   
}
