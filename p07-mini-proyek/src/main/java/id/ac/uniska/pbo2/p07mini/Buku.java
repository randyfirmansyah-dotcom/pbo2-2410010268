package id.ac.uniska.pbo2.p07mini;

/** Data katalog disesuaikan dari konsep Buku dan StatusKoleksi pada P02. */
public record Buku(String kode, String judul, String penulis, int tahunTerbit, StatusBuku status) {}