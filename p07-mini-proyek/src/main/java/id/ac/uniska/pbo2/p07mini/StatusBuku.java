package id.ac.uniska.pbo2.p07mini;

public enum StatusBuku {
  TERSEDIA("Tersedia"),
  DIPINJAM("Dipinjam");
  private final String label;

  StatusBuku(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label;
  }
}
