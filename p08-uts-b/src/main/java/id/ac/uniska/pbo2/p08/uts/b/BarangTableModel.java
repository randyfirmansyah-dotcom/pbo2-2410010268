/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p08.uts.b;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author MyBook Hype AMD
 */
   public class BarangTableModel extends AbstractTableModel {
    private static final String[] KOLOM
            = {"Nama Barang", "Kategori", "Harga", "Jumlah", "Subtotal"};
    private static final long BATAS_DISKON = 100_000;

    private final List<Barang> data = new ArrayList<>();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom];
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Barang b = data.get(baris);
        switch (kolom) {
            case 0:
                return b.getNama();
            case 1:
                return b.getKategori();
            case 2:
                return b.getHarga();
            case 3:
                return b.getJumlah();
            default:
                return b.getSubtotal();
        }
    }

    public void tambah(Barang b) {
        data.add(b);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public boolean sudahAda(String nama) {
        for (Barang b : data) {
            if (b.getNama().equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    public long getTotal() {
        long total = 0;
        for (Barang b : data) {
            total += b.getSubtotal();
        }
        return total;
    }

    public long getDiskon() {
        long total = getTotal();
        return total >= BATAS_DISKON ? total / 10 : 0; // pembagian bilangan bulat = dibulatkan ke bawah
    }

    public long getBayar() {
        return getTotal() - getDiskon();
    }
}
