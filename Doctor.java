public class Dokter {
    String id;
    String nama;
    String spesialisasi;
    String jadwalPraktek;

    public Dokter(String id, String nama, String spesialisasi, String jadwalPraktek) {
        this.id = id;
        this.nama = nama;
        this.spesialisasi = spesialisasi;
        this.jadwalPraktek = jadwalPraktek;
    }

    @Override
    public String toString() {
        return "Kode Dokter: " + id + "\nNama Dokter: " + nama + "\nSpesialisasi: " + spesialisasi + "\nJadwal Praktek: " + jadwalPraktek;
    }
}
