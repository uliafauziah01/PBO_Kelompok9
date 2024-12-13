public class Doctor {
    private String kode;  // Kode Dokter
    private String nama;  // Nama Dokter
    private String spesialisasi; // Spesialisasi Dokter
    private String jadwalPraktek; // Jadwal Praktek Dokter

    // Konstruktor
    public Doctor(String kode, String nama, String spesialisasi, String jadwalPraktek) {
        this.kode = kode;
        this.nama = nama;
        this.spesialisasi = spesialisasi;
        this.jadwalPraktek = jadwalPraktek;
    }

    // Menampilkan info dokter
    public void tampilkanInfoDokter() {
        System.out.println("Kode Dokter: " + kode);
        System.out.println("Nama Dokter: " + nama);
        System.out.println("Spesialisasi: " + spesialisasi);
        System.out.println("Jadwal Praktek: " + jadwalPraktek);
    }

    // Getter dan Setter
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public String getJadwalPraktek() {
        return jadwalPraktek;
    }

    public void setJadwalPraktek(String jadwalPraktek) {
        this.jadwalPraktek = jadwalPraktek;
    }
}
