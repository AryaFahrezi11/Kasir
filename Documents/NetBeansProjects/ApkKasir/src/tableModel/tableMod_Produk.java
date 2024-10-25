/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_Produk;


/**
 *
 * @author aryam
 */
public class tableMod_Produk extends AbstractTableModel{
    
    private List<model_Produk> list = new ArrayList<>();
    
    public void tambahData(model_Produk mod_bar){
        list.add(mod_bar);
        fireTableRowsInserted(list.size() -1,list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void perbaruiData(int row, model_Produk mod_bar){
        list.add(row, mod_bar);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
    }
    
    public void hapusData(int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    
    public void setData(List<model_Produk> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, model_Produk mod_bar){
        list.set(index, mod_bar);
        fireTableRowsUpdated(index, index);
    }
    
    public model_Produk getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    private final String[] columnNames = {"No", "ID Produk", "Nama Produk", "Harga Beli", "Harga Jual", "Stok", "Satuan"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return "    " + (rowIndex + 1);
            }else{
                switch (columnIndex - 1){
                case 0: return list.get(rowIndex).getId_produk();
                case 1: return list.get(rowIndex).getNama_produk();
                case 2: return list.get(rowIndex).getHarga_beli();
                case 3: return list.get(rowIndex).getHarga_jual();
                case 4: return list.get(rowIndex).getStok();
                case 5: return list.get(rowIndex).getSatuan();

                default: return null;
            }
        
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0) {
            return "   " + columnNames[column];
        }else{
            return columnNames[column];
        }
    }
    
}
