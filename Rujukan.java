public class Rujukan {
    private Pasien pasien;
    private Dokter dokter;

    public Rujukan(Pasien pasien, Dokter dokter) {
        this.pasien = pasien;
        this.dokter = dokter;
    }

    @Override
    public String toString() {
        return "Rujukan: \n" + pasien + "\nKe Dokter: " + dokter;
    }
}
