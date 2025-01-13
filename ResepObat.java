public class ResepObat {
    private Dokter dokter;
    private String obat;
    private String dosis;
    private String instruksi;

    public ResepObat(Dokter dokter, String obat, String dosis, String instruksi) {
        this.dokter = dokter;
        this.obat = obat;
        this.dosis = dosis;
        this.instruksi = instruksi;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public String getObat() {
        return obat;
    }

    public void setObat(String obat) {
        this.obat = obat;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getInstruksi() {
        return instruksi;
    }

    public void setInstruksi(String instruksi) {
        this.instruksi = instruksi;
    }

    @Override
    public String toString() {
        return "ResepObat{" +
                "dokter=" + dokter +
                ", obat='" + obat + '\'' +
                ", dosis='" + dosis + '\'' +
                ", instruksi='" + instruksi + '\'' +
                '}';
    }
}
