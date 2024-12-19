public class Karyawan {
    String id;
    String nama;
    String jabatan;

    public Karyawan(String id, String nama, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    @Override
    public String toString() {
        return "ID Karyawan: " + id + ", Nama: " + nama + ", Jabatan: " + jabatan;
    }
}
