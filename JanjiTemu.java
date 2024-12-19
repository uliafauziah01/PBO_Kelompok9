public class JanjiTemu {
    private Pasien pasien;
    private Dokter dokter;
    private String penyakit;
    private Karyawan petugas;

    public JanjiTemu(Pasien pasien, Dokter dokter, String penyakit, Karyawan petugas) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.penyakit = penyakit;
        this.petugas = petugas;
    }

    @Override
    public String toString() {
        return "Rincian:\n" +
               "ID Pasien: " + pasien.id + "\nNama: " + pasien.nama + "\nPenyakit: " + penyakit +
               "\nKode Dokter: " + dokter.id + "\nNama Dokter: " + dokter.nama + "\nSpesialisasi: " + dokter.spesialisasi +
               "\nJadwal Praktek: " + dokter.jadwalPraktek + "\nPetugas: ID " + petugas.id + ", " + petugas.nama + ", Jabatan: " + petugas.jabatan;
    }
}
