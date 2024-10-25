/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aryam
 */
public class model_Produk {

    public Integer getId_produk() {
        return id_produk;
    }

    public void setId_produk(Integer id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public Long getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(Long harga_beli) {
        this.harga_beli = harga_beli;
    }

    public Long getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(Long harga_jual) {
        this.harga_jual = harga_jual;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
    private Integer id_produk;
    private String nama_produk;
    private Long harga_beli;
    private Long harga_jual;
    private Integer stok;
    private String satuan;
    
}
