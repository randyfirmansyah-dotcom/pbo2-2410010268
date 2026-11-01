# Mini Proyek - Katalog Buku Perpustakaan

[Muhammad Randy Firmasnyah] - [2410010268]
Kelas 5B

## Video demo

**Tautan video:** [https://drive.google.com/file/d/1xom74HFXBR8ooPg6XpfPWpHQlfmcBNnw/view?usp=sharing]

## Peta event

| Komponen | Event | Aksi |
|---|---|---|
| tambahButton, tambahItem (Ctrl+N) | actionPerformed | Membuka DialogBuku modal untuk menambah buku |
| ubahButton, ubahItem (Ctrl+E) | actionPerformed | Mengubah buku terpilih setelah nomor baris tampilan diubah ke nomor baris model |
| hapusButton, hapusItem (Ctrl+D) | actionPerformed | Meminta konfirmasi sebelum menghapus buku terpilih |
| cariField | keyReleased | Menyaring berdasarkan kode, judul, atau penulis tanpa membedakan huruf besar/kecil |
| [nama tabel] | mouseClicked | Klik dua kali membuka dialog ubah buku |
| Pemilihan baris tabel | ListSelectionListener | Mengaktifkan tombol dan menu Ubah/Hapus hanya saat ada baris dipilih |
| Header kolom tabel | TableRowSorter | Mengurutkan tabel; kolom tahun terurut sebagai angka |
| Perubahan model/filter | TableModelListener / RowSorterListener | Memperbarui label status dan keadaan tombol |
| simpanButton (DialogBuku) | actionPerformed | Memvalidasi kode, judul, dan tahun, lalu mengembalikan data buku |
| batalButton (DialogBuku) | actionPerformed | Menutup dialog tanpa menyimpan |
| keluarItem | actionPerformed | Menutup jendela |
| tentangItem | actionPerformed | Menampilkan informasi aplikasi |

## Fitur

- Tabel kode, judul, penulis, tahun terbit, dan status memakai BukuTableModel (AbstractTableModel) yang menyimpan List object Buku.
- Lima buku contoh dimuat saat aplikasi dibuka.
- Tambah dan ubah lewat DialogBuku (JDialog Form modal). Kode dan judul wajib diisi; tahun harus angka dari 1900 sampai tahun berjalan. [Hapus kalimat ini jika belum ada validasi kode ganda: Kode ganda ditolak.]
- Hapus meminta konfirmasi. Ubah dan hapus memakai convertRowIndexToModel sehingga tetap benar saat tabel diurutkan atau disaring.
- Menu File, Buku, dan Bantuan dengan mnemonic [cek: Alt+F, Alt+B, Alt+...] dan accelerator Ctrl+N, Ctrl+E, Ctrl+D.
- Label status menampilkan jumlah buku yang tampil dan jumlah buku yang tersedia.
- JFrame Form dan JDialog Form masing-masing memiliki file .form. Tampilan memakai FlatLaf.

Data disimpan selama aplikasi berjalan. Setiap aplikasi dibuka, lima data contoh dimuat kembali.

## Deklarasi penggunaan AI

Saya menggunakan Claude untuk membantu memahami modul, memeriksa kode (TableModel, validasi dialog, penggunaan convertRowIndexToModel), dan menyelesaikan error GUI Builder di NetBeans. [Tambahkan alat AI lain jika ada, beserta keperluannya.] Pengujian aplikasi, penyusunan tampilan di tab Design, dan perekaman video demo saya lakukan sendiri.