package id.ac.uniska.pbo2.p02;

public interface BisaDipinjam {

    /**
     * Lama peminjaman maksimal dalam hari.
     */
    int batasHariPinjam();

    /**
     * Denda keterlambatan dalam rupiah.
     */
    long hitungDenda(int hariTerlambat);

}