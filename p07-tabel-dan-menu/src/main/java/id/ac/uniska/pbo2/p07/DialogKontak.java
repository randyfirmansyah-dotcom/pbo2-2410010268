package id.ac.uniska.pbo2.p07;

import com.formdev.flatlaf.FlatLaf;
import java.awt.Color;
import javax.swing.*;

public class DialogKontak extends javax.swing.JDialog {
  private Kontak hasil;

  public DialogKontak(java.awt.Frame pemilik, String judul, Kontak awal) {
    super(pemilik, judul, true);
    initComponents();
    formPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 8, 16));
    bawahPanel.setBorder(BorderFactory.createEmptyBorder(0, 16, 16, 16));
    pesanLabel.setForeground(FlatLaf.isLafDark() ? new Color(0xFF8A80) : new Color(0xC62828));
    pesanLabel.setPreferredSize(new java.awt.Dimension(450, 24));
    if (awal != null) {
      namaField.setText(awal.nama());
      teleponField.setText(awal.telepon());
      emailField.setText(awal.email());
      kategoriCombo.setSelectedItem(awal.kategori());
    }
    getRootPane().setDefaultButton(simpanButton);
    pack();
    setLocationRelativeTo(pemilik);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    formPanel = new javax.swing.JPanel();
    labelPanel = new javax.swing.JPanel();
    namaLabel = new javax.swing.JLabel();
    teleponLabel = new javax.swing.JLabel();
    emailLabel = new javax.swing.JLabel();
    kategoriLabel = new javax.swing.JLabel();
    isianPanel = new javax.swing.JPanel();
    namaField = new javax.swing.JTextField();
    teleponField = new javax.swing.JTextField();
    emailField = new javax.swing.JTextField();
    kategoriCombo = new javax.swing.JComboBox<>();
    bawahPanel = new javax.swing.JPanel();
    pesanLabel = new javax.swing.JLabel();
    tombolPanel = new javax.swing.JPanel();
    batalButton = new javax.swing.JButton();
    simpanButton = new javax.swing.JButton();
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setResizable(false);
    getContentPane().setLayout(new java.awt.BorderLayout(8, 8));
    formPanel.setLayout(new java.awt.BorderLayout(8, 8));
    labelPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 8));
    namaLabel.setText("Nama");
    namaLabel.setLabelFor(namaField);
    labelPanel.add(namaLabel);
    teleponLabel.setText("Telepon");
    teleponLabel.setLabelFor(teleponField);
    labelPanel.add(teleponLabel);
    emailLabel.setText("Email");
    emailLabel.setLabelFor(emailField);
    labelPanel.add(emailLabel);
    kategoriLabel.setText("Kategori");
    kategoriLabel.setLabelFor(kategoriCombo);
    labelPanel.add(kategoriLabel);
    formPanel.add(labelPanel, java.awt.BorderLayout.WEST);
    isianPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 8));
    namaField.setColumns(28);
    isianPanel.add(namaField);
    teleponField.setColumns(28);
    isianPanel.add(teleponField);
    emailField.setColumns(28);
    isianPanel.add(emailField);
    kategoriCombo.setModel(new javax.swing.DefaultComboBoxModel<>(Kategori.values()));
    isianPanel.add(kategoriCombo);
    formPanel.add(isianPanel, java.awt.BorderLayout.CENTER);
    getContentPane().add(formPanel, java.awt.BorderLayout.CENTER);
    bawahPanel.setLayout(new java.awt.BorderLayout(8, 8));
    pesanLabel.setText(" ");
    bawahPanel.add(pesanLabel, java.awt.BorderLayout.NORTH);
    tombolPanel.setLayout(new java.awt.FlowLayout(2, 8, 0));
    batalButton.setText("Batal");
    batalButton.addActionListener(this::batalButtonActionPerformed);
    tombolPanel.add(batalButton);
    simpanButton.setText("Simpan");
    simpanButton.addActionListener(this::simpanButtonActionPerformed);
    tombolPanel.add(simpanButton);
    bawahPanel.add(tombolPanel, java.awt.BorderLayout.SOUTH);
    getContentPane().add(bawahPanel, java.awt.BorderLayout.SOUTH);
    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void batalButtonActionPerformed(
      java.awt.event.ActionEvent evt) { //GEN-FIRST:event_batalButtonActionPerformed
    dispose();
  } //GEN-LAST:event_batalButtonActionPerformed

  private void simpanButtonActionPerformed(
      java.awt.event.ActionEvent evt) { //GEN-FIRST:event_simpanButtonActionPerformed
    simpan();
  } //GEN-LAST:event_simpanButtonActionPerformed

  private void tolak(String pesan, JTextField isian) {
    pesanLabel.setText(pesan);
    isian.requestFocusInWindow();
  }

  private void simpan() {
    String nama = namaField.getText().trim(), telepon = teleponField.getText().trim();
    if (nama.isEmpty()) {
      tolak("Nama wajib diisi", namaField);
      return;
    }
    if (!telepon.matches("\\d{10,13}")) {
      tolak("Telepon berisi 10 sampai 13 digit angka", teleponField);
      return;
    }
    hasil =
        new Kontak(
            nama, telepon, emailField.getText().trim(), (Kategori) kategoriCombo.getSelectedItem());
    dispose();
  }

  public Kontak tampilkan() {
    setVisible(true);
    return hasil;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel formPanel;
  private javax.swing.JPanel labelPanel;
  private javax.swing.JLabel namaLabel;
  private javax.swing.JLabel teleponLabel;
  private javax.swing.JLabel emailLabel;
  private javax.swing.JLabel kategoriLabel;
  private javax.swing.JPanel isianPanel;
  private javax.swing.JTextField namaField;
  private javax.swing.JTextField teleponField;
  private javax.swing.JTextField emailField;
  private javax.swing.JComboBox<Kategori> kategoriCombo;
  private javax.swing.JPanel bawahPanel;
  private javax.swing.JLabel pesanLabel;
  private javax.swing.JPanel tombolPanel;
  private javax.swing.JButton batalButton;
  private javax.swing.JButton simpanButton;
  // End of variables declaration//GEN-END:variables
}
