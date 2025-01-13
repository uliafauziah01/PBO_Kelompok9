public class StokObat {
    private String namaObat;
    private int hargaObat;
    private int jumlahObat;

    public StokObat(String namaObat, int hargaObat, int jumlahObat) {
        this.namaObat = namaObat;
        this.hargaObat = hargaObat;
        this.jumlahObat = jumlahObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public int getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(int hargaObat) {
        this.hargaObat = hargaObat;
    }

    public int getJumlahObat() {
        return jumlahObat;
    }

    public void setJumlahObat(int jumlahObat) {
        this.jumlahObat = jumlahObat;
    }

    @Override
    public String toString() {
        return "StokObat{" +
                "namaObat='" + namaObat + '\'' +
                ", hargaObat=" + hargaObat +
                ", jumlahObat=" + jumlahObat +
                '}';
    }
}