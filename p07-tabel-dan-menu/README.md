# P07 - Tabel dan Menu

Muhammad Randy Firmansyah - 2410010268  
Kelas 5B

## Jawaban eksperimen Praktikum 5

1. **`fireTableRowsInserted` dijadikan komentar.** Kontak baru tetap masuk ke List, tetapi tabel tidak menerima pemberitahuan bahwa ada baris baru. Karena itu tampilan tidak langsung diperbarui dengan benar. Pemanggilan `fireTableRowsInserted(baris, baris)` diperlukan agar tabel dan sorter ikut memperbarui data.

2. **Menggunakan `getSelectedRow()` tanpa konversi.** Setelah mencari "ah", Ahmad Fauzi berada di baris tampilan nomor 1, sedangkan di model berada di nomor 2. Kalau langsung memakai nomor tampilan, dialog justru menyebut **Budi Santoso**, yaitu data di model nomor 1. Karena itu baris perlu diubah dengan `convertRowIndexToModel()`.

3. **Dialog diubah menjadi nonmodal (`false`).** Jendela utama bisa diklik walaupun dialog masih terbuka. `tampilkan()` langsung mengembalikan `hasil` yang masih `null`, sehingga kode tambah di jendela utama sudah selesai sebelum tombol Simpan ditekan. Akibatnya kontak yang kemudian diisi tidak ditambahkan ke tabel melalui alur tersebut.

4. **Ctrl+N, Ctrl+E, dan Ctrl+D.** Ctrl+N membuka dialog tambah. Ctrl+E untuk mengubah dan Ctrl+D untuk menghapus kontak yang dipilih. Saat belum memilih baris, menu Ubah dan Hapus dinonaktifkan oleh `perbaruiTombol()`, jadi kedua pintasan itu tidak menjalankan aksi.

5. **Pintasan Hapus diganti menjadi Delete tanpa Ctrl.** Baris pengaturan accelerator menjadi:

   ```java
   hapusItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
           java.awt.event.KeyEvent.VK_DELETE, 0));
   ```

   Modifier `CTRL_DOWN_MASK` diganti `0`, dan tombolnya diganti menjadi `VK_DELETE`. Penulisan literal `"DELETE"` melalui `KeyStroke.getKeyStroke("DELETE")` juga memberikan pintasan yang sama.

6. **Model baru dibuat setelah `initComponents()`.** Saat `kontakTable.setModel(model)` dijalankan, nilai `model` masih `null`. JTable menolaknya dan menghasilkan **`IllegalArgumentException: Cannot set a null TableModel`**. Jadi object model harus dibuat sebelum `initComponents()` dipanggil.

Jawaban menjelaskan perilaku kode sesuai skenario modul. Perubahan percobaan yang sengaja merusak fungsi tidak dipertahankan pada project akhir. Pemetaan baris pada nomor 2 dan error JTable pada nomor 6 sudah diperiksa lewat pengujian kode; eksperimen interaktif di NetBeans perlu dicocokkan saat aplikasi dijalankan.
