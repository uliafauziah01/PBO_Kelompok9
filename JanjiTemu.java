public class JanjiTemu {
    private Pasien pasien;
    private Dokter dokter;
    private String penyakit;
    private Karyawan petugas;
    private String hari;

    public JanjiTemu(Pasien pasien, Dokter dokter, String penyakit, Karyawan petugas, String hari) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.penyakit = penyakit;
        this.petugas = petugas;
        this.hari = hari;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    @Override
    public String toString() {
        return "JanjiTemu{" +
                "pasien=" + pasien.getNama() +
                ", dokter=" + dokter.getNama() +
                ", penyakit='" + penyakit + '\'' +
                ", petugas=" + petugas.getNama() +
                ", hari='" + hari + '\'' +
                '}';
    }
}
