/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_Produk;

/**
 *
 * @author aryam
 */
public interface service_Produk {
    void tambahData (model_Produk mobar);
    void perbaruiData (model_Produk mobar);
    void hapusData (model_Produk mobar);
    
    model_Produk getByid (String id);
    
    List<model_Produk> getDataByID();
    List<model_Produk> getData();
    
    List<model_Produk> pencarian(String id);
    List<model_Produk> pencarian2(String id);
    
    String nomor();
    String nomor2();
}
