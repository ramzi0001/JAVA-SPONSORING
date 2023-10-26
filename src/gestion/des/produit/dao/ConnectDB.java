/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit.dao;

import gestion.des.produit.AES;
import gestion.des.produit.modele.User;
import gestion.des.produit.modele.Bashoard;
import gestion.des.produit.modele.Date_licence;
import gestion.des.produit.modele.Stock_commande;
import gestion.des.produit.modele.Vente_commande;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.sqlite.SQLite;


/**
 *
 * @author ziram
 */
public class ConnectDB {

    private final String url = "jdbc:sqlite:gestion_de_produit.db";      
    private Connection cnx;
    private Statement st, jt;
    private ResultSet rst , ts;

    public void DeleteAllElementTab(JTable T, int column, int row) {
        int i = 0;
        int j = 0;
        while (i < row) {
            while (j <= column) {
                T.setValueAt("", i, j);
                j++;
            }
            j = 0;
            i++;
        }

    }

    public String showDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        return sdf.format(d);

    }

    public String showDateTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        return sdf.format(d);

    }

    public void ConnexionIntoDataBase() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Driver OK");
            try {
                cnx = DriverManager.getConnection(url); 
                st = cnx.createStatement();                
                System.out.println("successful connexion");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, " erreur connexion activer le serveur ou verifier "
                        + "\nle configuration de  serveur");

            } finally {
            }
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int FindUser(User user) {
        int re = 0;
        try {
            
            String sql = "select * from user where user = '" + user.getnom_prenom_user() + "'";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {

                if (rst.getString("user").equals(user.getnom_prenom_user()) && rst.getString("password").equals(user.getpassword())) {
                 
                    re = 1;
                    user.setgrad(rst.getInt("grad"));
                } else {
                 
                    re = 0;
                    
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

        return re;
    }
    public int FindUsername(User user){
    
     int re = 0;
        try {
            
            String sql = "select * from user where user = '" + user.getnom_prenom_user() + "'";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {

                if (rst.getString("user").equals(user.getnom_prenom_user())) {
                 
                    re = 1;
                    
                } else {
                 
                    re = 0;
                    
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

        return re;
    }
    
    
    
        public int FindGrad(User user){
    
     int re = 1;
        try {
            
            String sql = "select * from user where user = '" + user.getnom_prenom_user() + "'";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {

                if (rst.getString("user").equals(user.getnom_prenom_user())) {
                 
                    re = rst.getInt("grad");
                    
                } else {
                 
                    re = 1;
                    
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

        return re;
    }
    
    
    
    
    
    
    public void AddUser(User user){
     try {
            
            String sql1 = "INSERT INTO `user`( `user`, `password`, `grad`) "
                    + "VALUES ('" + user.getnom_prenom_user() + "'," + "'" + user.getpassword() + "','" + user.getgrad() + "') ";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ereur operation");
            
        }
    }

    public void UpdatUser(String s, String ss ,String sss) {

        try {
            String sql = "Update user set user='" + s + "',password='" + ss + "'"
                    + "where user= '" + sss + "'";

            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  

    public void clear(String table) {
        String sql="delete from " + table;
        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    public void savename(String sql) {
         try {
            
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public int TVA(){
    int ttva=0;
    try {
            String sql = "select tva FROM info ";
              
              rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
            ttva=rst.getInt("tva");}
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return ttva ;

}
public String NomeLocal(){
    String nome="MAGAZIN";
    try {
            String sql = "select name FROM info ";
             
              rst = (ResultSet) st.executeQuery(sql);
           while (rst.next()) {
            nome=rst.getString("name");}
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return nome ;}
  public String Tel(){
    String tel="+213xxxxxxxxx";
    try {
            String sql = "select tel FROM info ";
              
              rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
            tel=rst.getString("tel");}
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return tel ;}
    public String Addr(){
    String addr="MAGAZIN";
    try {
            String sql = "select addr FROM info ";
             
              rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
                addr=rst.getString("addr");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return addr ;}
    
    
    
    
    public void Actualise() {
  try {
      
        
        Date_licence dates = null ;

        try {
            String sql ="select * from date_licence where id = '0'";
            
            rst = (ResultSet) st.executeQuery(sql);
            
            while (rst.next()) {
                dates= new Date_licence(rst.getInt("etat"),rst.getString("date_start"),rst.getString("date_point"),rst.getString("date_end"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
            SimpleDateFormat sdft = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
            Date d = new Date();
            AES c = new AES();
            Date date_point;
      try {
            date_point = sdft.parse(c.decrypt(dates.getDate_point()));
      
            if(!date_point.after(d)){
            String s= c.encrypt(sdft.format(d));
            String sql = "Update date_licence set date_point = '" + s + "'  where id = '0' ";
            
            st.executeUpdate(sql);
            }
            } catch (ParseException ex) {
          Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
      }
              
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Date_licence date_licence(){
       
        Date_licence dates = null ;

        try {
            String sql ="select * from date_licence where id = '0'";
            
            rst = (ResultSet) st.executeQuery(sql);
            
            while (rst.next()) {
                dates= new Date_licence(rst.getInt("etat"),rst.getString("date_start"),rst.getString("date_point"),rst.getString("date_end"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
   return dates ;
    }

    public String getSerial() {
     String serial = null ;
       try {
            String sql ="select key from Activation ";
            
            rst = (ResultSet) st.executeQuery(sql);
            
            while (rst.next()) {
                serial= rst.getString("key");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return serial ;
    }
  
    

   /* dashboard */

    public void Ajoute_commande(Bashoard b)  {
        
        try {
            
            String sql;
            
            sql = "INSERT INTO commande(  nom_prenom_client, wilaya, jours, prix_devise, budge, date_insert , date_versment, note,"
                    + "profile_facebook, tele, page_facebook, etat_vercement, etat_commande,"
                    + "sex, but , age , gain) "
                    + "VALUES ('" + b.getNom_prenom_client()+ "'," + "'" + b.getWilaya()
                    + "','" + b.getJours() + "','" + b.getPrix_devise()
                    + "','" + b.getBudge() + "','" + b.getDate_insert()
                    + "','" + b.getDate_versment() + "','" + b.getNote()
                    + "','" + b.getProfile_facebook() + "','" + b.getTele()
                    + "','" + b.getPage_facebook() + "','" + b.getEtat_vercement()
                    + "','" + b.getEtat_commande() + "','" + b.getSex()
                    + "','" + b.getBut() + "','" + b.getAge() +  "','"+b.getGain()+"') ";
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
        public void Ajoute_vente_commande(Vente_commande a)  {
        
        try {
            
            String sql;
            
            sql = "INSERT INTO vente_commande(  nom, gain, ca, qnt, date) "
                    + "VALUES ('" + a.getNom()+ "'," + "'" + a.getGain()
                    + "','" + a.getCA() + "','" + a.getQnt()
                    + "','" + a.getDate()  + "') ";
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

    public Stock_commande getInfocommande() {
     
        Stock_commande ST = null  ;    
        try {
            
            String sql = "select * from stock_commande where id = '0'";
            rst = (ResultSet) st.executeQuery(sql);
            
            
        while (rst.next()){    
            ST = new Stock_commande(rst.getFloat("gain"), rst.getFloat("vent"), rst.getFloat("achat"),  rst.getDouble("qnt") );}
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return ST ;
        
    }
     
    public Bashoard getDetailcommande(int i){
         Bashoard b = null ;
        try {
            
            String sql ="select * from commande where N_commande = '"+i+"'" ;
            rst = (ResultSet) st.executeQuery(sql);
            
            while (rst.next()) {
                
                 b = new Bashoard(rst.getString("nom_prenom_client"),rst.getString("wilaya"),
                        rst.getInt("jours"), rst.getDouble("prix_devise"),
                        rst.getDouble("budge") ,""+ rst.getString("date_insert"),""+ rst.getString("date_versment"),
                        rst.getString("note"),rst.getString("tele") ,rst.getString("page_facebook"),rst.getString("profile_facebook"),
                        rst.getString("etat_vercement"),rst.getString("etat_commande"),
                        rst.getString("sex"),rst.getString("but"),rst.getString("age") ,rst.getString("deadline"),rst.getString("date_start")
                        
                );
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b ;
    }

    
    public int getAllcommande(JTable T , JLabel d , JLabel e , String sql) {
    
            double eurro = 0.0;
            double dinar = 0.0 ;
            float gain = 0 ;
            int nb = 0 ;
        try {

            ArrayList<Bashoard> list = new ArrayList<>();
            
            rst = (ResultSet) st.executeQuery(sql);
          
            while (rst.next()) {
                
                Bashoard b = new Bashoard(rst.getInt("N_commande"), rst.getString("nom_prenom_client"),
                        rst.getInt("jours"), rst.getDouble("prix_devise"),
                        rst.getDouble("budge") , ""+rst.getString("date_insert"),
                        rst.getString("etat_commande"),rst.getFloat("gain")
                );
                nb++;
                eurro= rst.getDouble("prix_devise") + eurro ;
                dinar= rst.getDouble("budge") + dinar ;
                gain= rst.getFloat("gain") + gain ;
          
                list.add(b);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0",DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            df.setMaximumFractionDigits(2);
            Object row[] = new Object[8];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_commande();
                row[1] = list.get(k).getNom_prenom_client();
               
                row[2] = list.get(k).getBudge();
                row[3] = df.format(list.get(k).getPrix_devise());
                row[4] = df.format(list.get(k).getGain());
                row[5] = list.get(k).getJours();
                row[6] = list.get(k).getDate_insert();
                row[7] = list.get(k).getEtat_commande();
                
                

                mo.addRow(row);
            }
            list.clear();
            d.setText("total budge est : "+df.format(dinar)+" DA     ==>   Clients : "+nb);
            e.setText("total devise est : "+df.format(eurro)+" €     ==>   Gain : "+df.format(gain)+" DA");

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
        return nb ;
        
}

    
    
    
    
    public void getAll_vent_commande(JTable T , JLabel d , JLabel e , String sql) {
    
            double eurro =  0.0;
            double dinar =  0.0 ;
            float gain =  0 ;
            int nb = 0 ;
        try {

            ArrayList<Vente_commande> list = new ArrayList<>();
            
            rst = (ResultSet) st.executeQuery(sql);
            
            while (rst.next()) {
                Vente_commande b = new Vente_commande(rst.getFloat("gain"), rst.getFloat("ca"),
                        rst.getFloat("qnt"), ""+rst.getString("date"),
                        rst.getString("nom") , rst.getInt("id") 
                );
         
                nb++;
                eurro= rst.getFloat("qnt") + eurro ;
                dinar= rst.getFloat("ca") + dinar ;
                gain= rst.getFloat("gain") + gain ;
                
                list.add(b);
               
                
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0",DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            df.setMaximumFractionDigits(2);
            Object row[] = new Object[6];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getId();
                row[1] = list.get(k).getNom();
                row[2] = list.get(k).getCA();
                row[3] = list.get(k).getQnt();
                row[4] = list.get(k).getGain();
                row[5] = list.get(k).getDate();
               

                mo.addRow(row);
            }
   
            list.clear();
            
            
            d.setText("total est : "+df.format(dinar)+" DA     ==>   Clients : "+nb);
            e.setText("total devise est : "+df.format(eurro)+" €     ==>   Gain : "+df.format(gain)+" DA");
               

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
        
    
    }
    
    
    public void Gainweek(JLabel caa ,JLabel g){
        try {
          SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd"); 
          Date d = new Date();
            float gain = 0 ;
            float ca = 0 ;
            int nb = 0 ;
            
            String sql = "SELECT * FROM vente_commande WHERE date between'" + sdf.format(d.getTime()-(1000*60*60*24*7)) + "' and '" + sdf.format(d) + "'  ";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
                gain = gain + rst.getFloat("gain");
                ca = ca + rst.getFloat("ca");
                nb++;
               
                
            }
            caa.setText("Total : "+ca+" DA");
            g.setText("Gain : "+gain+" DA       Clients : "+nb);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
        public void Vente_commande(JLabel caa ,JLabel g , JLabel cl , Date d1 , Date d2){
        try {
          SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd"); 
          Date d = new Date();
            float gain = 0 ;
            float ca = 0 ;
            int nb = 0 ;
            
            String sql = "SELECT * FROM vente_commande WHERE date between'" + sdf.format(d1) + "' and '" + sdf.format(d2) + "'  ";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
                gain = gain + rst.getFloat("gain");
                ca = ca + rst.getFloat("ca");
                nb++;
               
                
            }
            caa.setText("Total : "+ca+" DA");
            g.setText("Gain : "+gain+" DA  ");
            cl.setText("Clients : "+nb);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    public String Best(){
       
        String nom ="Zi ram" ;

        try {
            String sql ="select nom , sum(ca) as c from vente_commande group by nom order by c desc limit 1";
            
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
              nom = rst.getString("nom");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return nom ;
    }

    
    public void UpdateCommand(String sql) {

        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DeleteCommande(String sql) {
     
        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}