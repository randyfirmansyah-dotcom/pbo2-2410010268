package id.ac.uniska.pbo2.p07mini;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BukuTableModel extends AbstractTableModel {
  private static final String[] KOLOM =
      new String[] {"Kode", "Judul", "Penulis", "Tahun Terbit", "Status"};
  private final List<Buku> daftar = new ArrayList<>();

  @Override
  public int getRowCount() {
    return daftar.size();
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
    Buku k = daftar.get(baris);
    return switch (kolom) {
      case 0 -> k.kode();
      case 1 -> k.judul();
      case 2 -> k.penulis();
      case 3 -> k.tahunTerbit();
      case 4 -> k.status();
      default -> throw new IndexOutOfBoundsException("Kolom: " + kolom);
    };
  }

  public Buku get(int baris) {
    return daftar.get(baris);
  }

  public void tambah(Buku data) {
    daftar.add(data);
    int b = daftar.size() - 1;
    fireTableRowsInserted(b, b);
  }

  public void ubah(int baris, Buku data) {
    daftar.set(baris, data);
    fireTableRowsUpdated(baris, baris);
  }

  public void hapus(int baris) {
    daftar.remove(baris);
    fireTableRowsDeleted(baris, baris);
  }

  @Override
  public Class<?> getColumnClass(int kolom) {
    return kolom == 3 ? Integer.class : String.class;
  }

  public long jumlahTersedia() {
    return daftar.stream().filter(b -> b.status() == StatusBuku.TERSEDIA).count();
  }

  public boolean kodeDipakai(String kode, int kecuali) {
    for (int i = 0; i < daftar.size(); i++)
      if (i != kecuali && daftar.get(i).kode().equalsIgnoreCase(kode.trim())) return true;
    return false;
  }
}
