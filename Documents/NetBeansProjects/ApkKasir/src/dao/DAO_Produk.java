
package dao;

import apkkasir.databasekoneksi;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.model_Produk;
import service.service_Produk;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class DAO_Produk implements service_Produk{
    
    private Connection conn;
    
    public DAO_Produk(){
        conn = databasekoneksi.getConnection();
    }

    @Override
    public void tambahData(model_Produk mobar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO produk (ID, nama_produk, harga_beli, harga_jual, stok, satuan) VALUES (?,?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setInt(1, mobar.getId_produk());
            st.setString(2, mobar.getNama_produk());
            st.setLong  (3, mobar.getHarga_beli());
            st.setLong  (4, mobar.getHarga_jual());
            st.setInt   (5, mobar.getStok());
            st.setString(6, mobar.getSatuan());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!= null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void perbaruiData(model_Produk mobar) {
        PreparedStatement st = null;
        String sql = "UPDATE produk SET nama_produk=?, harga_beli=?, harga_jual=?, stok=?, satuan=? WHERE ID='"+mobar.getId_produk()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString (1, mobar.getNama_produk());
            st.setLong   (2, mobar.getHarga_beli());
            st.setLong   (3, mobar.getHarga_jual());
            st.setInt    (4, mobar.getStok());
            st.setString (5, mobar.getSatuan());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!= null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void hapusData(model_Produk mobar) {
        PreparedStatement st =null;
        String sql = "DELETE FROM produk WHERE ID = ?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setInt(1, mobar.getId_produk());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public model_Produk getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_Produk> getDataByID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_Produk> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT ID, nama_produk, harga_beli, harga_jual, stok, satuan FROM produk";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_Produk mobar = new model_Produk();
                
                mobar.setId_produk(rs.getInt ("ID"));
                mobar.setNama_produk(rs.getString ("nama_produk"));
                mobar.setHarga_beli(rs.getLong ("harga_beli"));
                mobar.setHarga_jual(rs.getLong ("harga_jual"));
                mobar.setStok(rs.getInt ("stok"));
                mobar.setSatuan(rs.getString ("satuan"));
                
                list.add(mobar);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<model_Produk> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT ID, nama_produk, harga_beli, harga_jual, stok, satuan FROM produk WHERE ID LIKE '%"+id+"%' OR nama_produk LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_Produk mobar = new model_Produk();
                
                mobar.setId_produk(rs.getInt ("ID"));
                mobar.setNama_produk(rs.getString ("nama_produk"));
                mobar.setHarga_beli(rs.getLong ("harga_beli"));
                mobar.setHarga_jual(rs.getLong ("harga_jual"));
                mobar.setStok(rs.getInt ("stok"));
                mobar.setSatuan(rs.getString ("satuan"));
                
                list.add(mobar);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!= null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<model_Produk> pencarian2(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        
        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
        String tgl = tanggal.format(now);
        String no = noformat.format(now);
        
        String sql = "SELECT RIGHT(ID, 3) AS Nomor " +
                     "FROM produk " +
                     "WHERE ID LIKE '" + no + "%' " +
                     "ORDER BY ID DESC " +
                     "LIMIT 1";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = no + String.format("%03d", nomor);
            }else {
                urutan = no + "001";
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return urutan;
    }

    @Override
    public String nomor2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
