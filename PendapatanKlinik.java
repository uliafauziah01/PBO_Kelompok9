public class PendapatanKlinik {
    private double pendapatan;

    public PendapatanKlinik() {
        this.pendapatan = 0;
    }

    public void tambahPendapatan(double jumlah) {
        this.pendapatan += jumlah;
    }

    public double getPendapatan() {
        return pendapatan;
    }

    @Override
    public String toString() {
        return "Pendapatan Klinik: Rp " + pendapatan;
    }
}
