public class ResepObat {
    private Dokter dokter;
    private String resep;

    public ResepObat(Dokter dokter, String resep) {
        this.dokter = dokter;
        this.resep = resep;
    }

    public String getResep() {
        return resep;
    }

    @Override
    public String toString() {
        return "Resep Obat: " + resep;
    }
}
