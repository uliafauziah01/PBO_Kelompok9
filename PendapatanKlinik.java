public class PendapatanKlinik { 
    private double pendapatan;

    public PendapatanKlinik() {
        this.pendapatan = 0;
    }

    public void addPendapatan(double jumlah) {
        this.pendapatan += jumlah;
    }

    public double getTotalPendapatan() {
        return this.pendapatan;
    }

    public void prosesPembayaran(double harga, String jenisPembayaran) {
        addPendapatan(harga);
        System.out.println("Pembayaran berhasil dengan jenis pembayaran: " + jenisPembayaran);
        System.out.println("Total Pendapatan Klinik: Rp " + pendapatan);
    }

    @Override
    public String toString() {
        return "Pendapatan Klinik: Rp " + pendapatan;
    }
}
