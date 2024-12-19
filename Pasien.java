public class Pasien {
    String id;
    String nama;
    String penyakit;
    String alamat;

    public Pasien(String id, String nama, String penyakit, String alamat) {
        this.id = id;
        this.nama = nama;
        this.penyakit = penyakit;
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "ID Pasien: " + id + ", Nama: " + nama + ", Penyakit: " + penyakit;
    }
}
