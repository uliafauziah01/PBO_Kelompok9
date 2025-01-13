public class Pasien {
    private static int counter = 1; // Counter untuk ID
    private String id;
    private String nama;
    private String alamat;
    private String penyakit;
    private int usia;

    public Pasien(String nama, String alamat, String penyakit, int usia) {
        this.id = generateId();
        this.nama = nama;
        this.alamat = alamat;
        this.penyakit = penyakit;
        this.usia = usia;
    }

    private String generateId() {
        return String.format("P%02d", counter++);
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getPenyakit() {
        return penyakit;
    }

    @Override
    public String toString() {
        return "Pasien{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", penyakit='" + penyakit + '\'' +
                ", usia=" + usia +
                '}';
    }
}
