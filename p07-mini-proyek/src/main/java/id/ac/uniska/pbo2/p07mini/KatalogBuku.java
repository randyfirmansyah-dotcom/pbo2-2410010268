package id.ac.uniska.pbo2.p07mini;

import com.formdev.flatlaf.FlatLightLaf;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class KatalogBuku extends javax.swing.JFrame {
  private final BukuTableModel model = new BukuTableModel();
  private final TableRowSorter<BukuTableModel> sorter = new TableRowSorter<>(model);

  public KatalogBuku() {
    initComponents();
    setTitle("Katalog Buku Perpustakaan");
    atasPanel.setBorder(BorderFactory.createEmptyBorder(12, 4, 8, 12));
    tabelPanel.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 12));
    statusLabel.setBorder(BorderFactory.createEmptyBorder(6, 12, 8, 12));
    cariField.putClientProperty("JTextField.placeholderText", "Cari kode, judul, penulis");
    bukuTable.setRowSorter(sorter);
    sorter.setSortsOnUpdates(true);
    bukuTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    bukuTable.setRowHeight(28);
    bukuTable.getSelectionModel().addListSelectionListener(e -> perbaruiTombol());
    sorter.addRowSorterListener(
        e -> {
          perbaruiStatus();
          perbaruiTombol();
        });
    model.addTableModelListener(
        e ->
            SwingUtilities.invokeLater(
                () -> {
                  perbaruiStatus();
                  perbaruiTombol();
                }));
    isiContoh();
    perbaruiTombol();
    perbaruiStatus();
    setSize(860, 480);
    setMinimumSize(new java.awt.Dimension(760, 360));
    setLocationRelativeTo(null);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    atasPanel = new javax.swing.JPanel();
    tombolPanel = new javax.swing.JPanel();
    tambahButton = new javax.swing.JButton();
    ubahButton = new javax.swing.JButton();
    hapusButton = new javax.swing.JButton();
    cariField = new javax.swing.JTextField();
    tabelPanel = new javax.swing.JPanel();
    tabelScroll = new javax.swing.JScrollPane();
    bukuTable = new javax.swing.JTable();
    statusLabel = new javax.swing.JLabel();
    menuBar = new javax.swing.JMenuBar();
    fileMenu = new javax.swing.JMenu();
    keluarItem = new javax.swing.JMenuItem();
    bukuMenu = new javax.swing.JMenu();
    tambahItem = new javax.swing.JMenuItem();
    ubahItem = new javax.swing.JMenuItem();
    pemisah = new javax.swing.JPopupMenu.Separator();
    hapusItem = new javax.swing.JMenuItem();
    bantuanMenu = new javax.swing.JMenu();
    tentangItem = new javax.swing.JMenuItem();
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    getContentPane().setLayout(new java.awt.BorderLayout(8, 8));
    atasPanel.setLayout(new java.awt.BorderLayout(8, 8));
    tombolPanel.setLayout(new java.awt.FlowLayout(0, 8, 0));
    tambahButton.setText("Tambah");
    tambahButton.addActionListener(this::tambahButtonActionPerformed);
    tombolPanel.add(tambahButton);
    ubahButton.setText("Ubah");
    ubahButton.addActionListener(this::ubahButtonActionPerformed);
    tombolPanel.add(ubahButton);
    hapusButton.setText("Hapus");
    hapusButton.addActionListener(this::hapusButtonActionPerformed);
    tombolPanel.add(hapusButton);
    atasPanel.add(tombolPanel, java.awt.BorderLayout.WEST);
    cariField.setColumns(22);
    cariField.setToolTipText("Cari kode, judul, atau penulis");
    cariField.addKeyListener(
        new java.awt.event.KeyAdapter() {
          public void keyReleased(java.awt.event.KeyEvent evt) {
            cariFieldKeyReleased(evt);
          }
        });
    atasPanel.add(cariField, java.awt.BorderLayout.EAST);
    getContentPane().add(atasPanel, java.awt.BorderLayout.NORTH);
    tabelPanel.setLayout(new java.awt.BorderLayout(8, 8));
    bukuTable.setModel(model);
    bukuTable.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
            bukuTableMouseClicked(evt);
          }
        });
    tabelScroll.setViewportView(bukuTable);
    tabelPanel.add(tabelScroll, java.awt.BorderLayout.CENTER);
    getContentPane().add(tabelPanel, java.awt.BorderLayout.CENTER);
    statusLabel.setText(" ");
    getContentPane().add(statusLabel, java.awt.BorderLayout.SOUTH);
    fileMenu.setText("File");
    fileMenu.setMnemonic(70);
    keluarItem.setText("Keluar");
    keluarItem.addActionListener(this::keluarItemActionPerformed);
    fileMenu.add(keluarItem);
    menuBar.add(fileMenu);
    bukuMenu.setText("Buku");
    bukuMenu.setMnemonic(66);
    tambahItem.setText("Tambah");
    tambahItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke("ctrl N"));
    tambahItem.addActionListener(this::tambahItemActionPerformed);
    bukuMenu.add(tambahItem);
    ubahItem.setText("Ubah");
    ubahItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke("ctrl E"));
    ubahItem.addActionListener(this::ubahItemActionPerformed);
    bukuMenu.add(ubahItem);
    bukuMenu.add(pemisah);
    hapusItem.setText("Hapus");
    hapusItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke("ctrl D"));
    hapusItem.addActionListener(this::hapusItemActionPerformed);
    bukuMenu.add(hapusItem);
    menuBar.add(bukuMenu);
    bantuanMenu.setText("Bantuan");
    bantuanMenu.setMnemonic(65);
    tentangItem.setText("Tentang");
    tentangItem.addActionListener(this::tentangItemActionPerformed);
    bantuanMenu.add(tentangItem);
    menuBar.add(bantuanMenu);
    setJMenuBar(menuBar);
    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void tambahButtonActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
    tambah();
  }//GEN-LAST:event_tambahButtonActionPerformed

  private void ubahButtonActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahButtonActionPerformed
    ubah();
  }//GEN-LAST:event_ubahButtonActionPerformed

  private void hapusButtonActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
    hapus();
  }//GEN-LAST:event_hapusButtonActionPerformed

  private void cariFieldKeyReleased(
      java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariFieldKeyReleased
    saring();
  }//GEN-LAST:event_cariFieldKeyReleased

  private void bukuTableMouseClicked(
      java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bukuTableMouseClicked
    if (evt.getClickCount() == 2 && bukuTable.getSelectedRow() >= 0) ubah();
  }//GEN-LAST:event_bukuTableMouseClicked

  private void keluarItemActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarItemActionPerformed
    dispose();
  }//GEN-LAST:event_keluarItemActionPerformed

  private void tambahItemActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahItemActionPerformed
    tambah();
  }//GEN-LAST:event_tambahItemActionPerformed

  private void ubahItemActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahItemActionPerformed
    ubah();
  }//GEN-LAST:event_ubahItemActionPerformed

  private void hapusItemActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusItemActionPerformed
    hapus();
  }//GEN-LAST:event_hapusItemActionPerformed

  private void tentangItemActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tentangItemActionPerformed
    JOptionPane.showMessageDialog(
        this,
        "KatalogBuku\nRandy - 2410010268 - 5B",
        "Tentang",
        JOptionPane.INFORMATION_MESSAGE);
  }//GEN-LAST:event_tentangItemActionPerformed

  private void isiContoh() {
    model.tambah(new Buku("B001", "Laskar Pelangi", "Andrea Hirata", 2005, StatusBuku.TERSEDIA));
    model.tambah(new Buku("B002", "Clean Code", "Robert C. Martin", 2008, StatusBuku.DIPINJAM));
    model.tambah(
        new Buku("B003", "Bumi Manusia", "Pramoedya Ananta Toer", 1980, StatusBuku.TERSEDIA));
    model.tambah(new Buku("B004", "Negeri 5 Menara", "Ahmad Fuadi", 2009, StatusBuku.TERSEDIA));
    model.tambah(
        new Buku(
            "B005",
            "The Pragmatic Programmer",
            "Andrew Hunt dan David Thomas",
            1999,
            StatusBuku.DIPINJAM));
  }

  private void saring() {
    String kata = cariField.getText().trim();
    sorter.setRowFilter(
        kata.isEmpty() ? null : RowFilter.regexFilter("(?i)" + Pattern.quote(kata), 0, 1, 2));
    perbaruiStatus();
    perbaruiTombol();
  }

  private int barisTerpilih() {
    int baris = bukuTable.getSelectedRow();
    return baris < 0 ? -1 : bukuTable.convertRowIndexToModel(baris);
  }

  private void tambah() {
    Buku data = new DialogBuku(this, "Tambah Buku", null).tampilkan();
    if (data != null) {
      if (model.kodeDipakai(data.kode(), -1)) {
        JOptionPane.showMessageDialog(
            this, "Kode buku sudah digunakan", "Data belum disimpan", JOptionPane.WARNING_MESSAGE);
        return;
      }
      model.tambah(data);
      perbaruiStatus();
    }
  }

  private void ubah() {
    int baris = barisTerpilih();
    if (baris < 0) return;
    Buku data = new DialogBuku(this, "Ubah Buku", model.get(baris)).tampilkan();
    if (data != null) {
      if (model.kodeDipakai(data.kode(), baris)) {
        JOptionPane.showMessageDialog(
            this, "Kode buku sudah digunakan", "Data belum disimpan", JOptionPane.WARNING_MESSAGE);
        return;
      }
      model.ubah(baris, data);
      perbaruiStatus();
    }
  }

  private void hapus() {
    int baris = barisTerpilih();
    if (baris < 0) return;
    String nama = model.get(baris).judul();
    int jawab =
        JOptionPane.showConfirmDialog(
            this,
            "Hapus Buku " + nama + "?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
    if (jawab == JOptionPane.YES_OPTION) {
      model.hapus(baris);
      perbaruiStatus();
    }
  }

  private void perbaruiTombol() {
    boolean ada = bukuTable.getSelectedRow() >= 0;
    ubahButton.setEnabled(ada);
    hapusButton.setEnabled(ada);
    ubahItem.setEnabled(ada);
    hapusItem.setEnabled(ada);
  }

  private void perbaruiStatus() {
    statusLabel.setText(
        "Menampilkan "
            + bukuTable.getRowCount()
            + " dari "
            + model.getRowCount()
            + " buku"
            + " | Tersedia: "
            + model.jumlahTersedia()
            + " buku (seluruh katalog)");
  }

  public static void main(String[] args) {
    FlatLightLaf.setup();
    SwingUtilities.invokeLater(() -> new KatalogBuku().setVisible(true));
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel atasPanel;
  private javax.swing.JPanel tombolPanel;
  private javax.swing.JButton tambahButton;
  private javax.swing.JButton ubahButton;
  private javax.swing.JButton hapusButton;
  private javax.swing.JTextField cariField;
  private javax.swing.JPanel tabelPanel;
  private javax.swing.JScrollPane tabelScroll;
  private javax.swing.JTable bukuTable;
  private javax.swing.JLabel statusLabel;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenu fileMenu;
  private javax.swing.JMenuItem keluarItem;
  private javax.swing.JMenu bukuMenu;
  private javax.swing.JMenuItem tambahItem;
  private javax.swing.JMenuItem ubahItem;
  private javax.swing.JPopupMenu.Separator pemisah;
  private javax.swing.JMenuItem hapusItem;
  private javax.swing.JMenu bantuanMenu;
  private javax.swing.JMenuItem tentangItem;
  // End of variables declaration//GEN-END:variables
}
