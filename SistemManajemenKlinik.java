import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SistemManajemenKlinik {
    private List<Pasien> daftarPasien;
    private List<Dokter> daftarDokter;
    private List<Karyawan> daftarKaryawan;
    private List<JanjiTemu> daftarJanjiTemu;
    private List<StokObat> daftarStokObat;
    private List<ResepObat> daftarResepObat;
    private Scanner scanner;

    public SistemManajemenKlinik() {
        daftarPasien = new ArrayList<>();
        daftarDokter = new ArrayList<>();
        daftarKaryawan = new ArrayList<>();
        daftarJanjiTemu = new ArrayList<>();
        daftarStokObat = new ArrayList<>();
        daftarResepObat = new ArrayList<>();
        scanner = new Scanner(System.in);
        tambahDataAwal();
    }

    private void tambahDataAwal() {
        daftarKaryawan.add(new Karyawan("K1", "Siti", "Administrasi"));
        daftarKaryawan.add(new Karyawan("K2", "Ali", "Petugas Registrasi"));

        Map<String, String> jadwalDokter1 = new HashMap<>();
        jadwalDokter1.put("Senin", "08:00 - 12:00");
        jadwalDokter1.put("Selasa", "13:00 - 17:00");
        daftarDokter.add(new Dokter("D1", "Dr. Ardi", "Umum", jadwalDokter1));

        Map<String, String> jadwalDokter2 = new HashMap<>();
        jadwalDokter2.put("Senin", "08:00 - 12:00");
        daftarDokter.add(new Dokter("D2", "Dr. Budi", "Spesialis Anak", jadwalDokter2));

        daftarStokObat.add(new StokObat("Paracetamol", 7500, 100));
    }

    public void start() {
        while (true) {
            System.out.println("=== Sistem Manajemen Klinik ===");
            System.out.println("1. Input Data Pasien");
            System.out.println("2. Lihat Semua Dokter");
            System.out.println("3. Lihat Semua Pasien");
            System.out.println("4. Buat Janji Temu");
            System.out.println("5. Lihat Semua Karyawan");
            System.out.println("6. Lihat Semua Stok Obat");
            System.out.println("7. Tambah Stok Obat");
            System.out.println("8. Buat Resep Obat");
            System.out.println("9. Pembayaran");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    inputDataPasien();
                    break;
                case 2:
                    lihatSemuaDokter();
                    break;
                case 3:
                    lihatSemuaPasien();
                    break;
                case 4:
                    buatJanjiTemu();
                    break;
                case 5:
                    lihatSemuaKaryawan();
                    break;
                case 6:
                    lihatSemuaStokObat();
                    break;
                case 7:
                    tambahStokObat();
                    break;
                case 8:
                    buatResepObat();
                    break;
                case 9:
                    pembayaran();
                    break;
                case 0:
                    System.out.println("Program selesai, terima kasih.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
            }
        }
    }

    private void inputDataPasien() {
        System.out.println("\n=== Input Data Pasien ===");
        System.out.print("Nama Pasien: ");
        String namaPasien = scanner.nextLine();
        System.out.print("Alamat Pasien: ");
        String alamatPasien = scanner.nextLine();
        System.out.print("Penyakit: ");
        String penyakitPasien = scanner.nextLine();
        System.out.print("Usia: ");
        int usiaPasien = scanner.nextInt();
        scanner.nextLine();
    
        Pasien pasien = new Pasien(namaPasien, alamatPasien, penyakitPasien, usiaPasien);
        daftarPasien.add(pasien);
        System.out.println("Data pasien berhasil ditambahkan. ID Pasien: " + pasien.getId());
    }

    private void lihatSemuaDokter() {
        System.out.println("\n=== Daftar Dokter ===");
        for (Dokter dokter : daftarDokter) {
            System.out.println(dokter);
        }
    }

    private void lihatSemuaPasien() {
        System.out.println("\n=== Data Pasien ===");
        for (Pasien pasien : daftarPasien) {
            System.out.println(pasien);
        }
    }

    private void buatJanjiTemu() {
        System.out.println("\n=== Formulir Janji Temu ===");
        System.out.print("Petugas: ");
        String petugasName = scanner.nextLine();
        Karyawan petugas = null;
        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.getNama().equalsIgnoreCase(petugasName)) {
                petugas = karyawan;
                break;
            }
        }
        if (petugas == null) {
            System.out.println("Petugas tidak ditemukan.");
            return;
        }

        System.out.println("\n=== Semua Pasien ===");
        for (Pasien pasien : daftarPasien) {
            System.out.println(pasien);
        }

        System.out.print("\nPilih ID Pasien: ");
        String idPasien = scanner.nextLine();
        Pasien pasienDipilih = null;
        for (Pasien pasien : daftarPasien) {
            if (pasien.getId().equals(idPasien)) {
                pasienDipilih = pasien;
                break;
            }
        }

        if (pasienDipilih == null) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        System.out.println("\n=== Daftar Dokter ===");
        for (Dokter dokter : daftarDokter) {
            System.out.println(dokter);
        }

        System.out.print("\nPilih Kode Dokter: ");
        String kodeDokter = scanner.nextLine();
        Dokter dokterDipilih = null;
        for (Dokter dokter : daftarDokter) {
            if (dokter.getId().equals(kodeDokter)) {
                dokterDipilih = dokter;
                break;
            }
        }

        if (dokterDipilih == null) {
            System.out.println("Dokter tidak ditemukan.");
            return;
        }

        System.out.print("Pilih Hari: ");
        String hariPraktek = scanner.nextLine();

        JanjiTemu janjiTemu = new JanjiTemu(pasienDipilih, dokterDipilih, pasienDipilih.getPenyakit(), petugas, hariPraktek);
        daftarJanjiTemu.add(janjiTemu);
        System.out.println("Janji temu berhasil dibuat.");
    }

    private void lihatSemuaKaryawan() {
        System.out.println("\n=== Semua Karyawan ===");
        for (Karyawan karyawan : daftarKaryawan) {
            System.out.println(karyawan);
        }
    }

    private void lihatSemuaStokObat() {
        System.out.println("\n=== Semua Stok Obat ===");
        for (StokObat stokObat : daftarStokObat) {
            System.out.println(stokObat);
        }
    }

    private void tambahStokObat() {
        System.out.println("\n=== Tambah Stok Obat ===");
        System.out.print("Nama Obat: ");
        String namaObat = scanner.nextLine();
        System.out.print("Harga Obat: ");
        int hargaObat = scanner.nextInt();
        System.out.print("Jumlah Stok: ");
        int jumlahStok = scanner.nextInt();
        scanner.nextLine();

        StokObat stokObat = new StokObat(namaObat, hargaObat, jumlahStok);
        daftarStokObat.add(stokObat);
        System.out.println("Stok obat berhasil ditambahkan.");
    }

    private void buatResepObat() {
        System.out.println("\n=== Buat Resep Obat ===");
        System.out.println("\n=== Semua Pasien ===");
        for (Pasien pasien : daftarPasien) {
            System.out.println(pasien);
        }

        System.out.print("\nPilih ID Pasien: ");
        String idPasien = scanner.nextLine();
        Pasien pasienDipilih = null;
        for (Pasien pasien : daftarPasien) {
            if (pasien.getId().equals(idPasien)) {
                pasienDipilih = pasien;
                break;
            }
        }

        if (pasienDipilih == null) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        System.out.println("\n=== Semua Stok Obat ===");
        for (StokObat stokObat : daftarStokObat) {
            System.out.println(stokObat);
        }

        System.out.print("\nPilih Obat: ");
        String namaObat = scanner.nextLine();
        StokObat obatDipilih = null;
        for (StokObat stok : daftarStokObat) {
            if (stok.getNamaObat().equalsIgnoreCase(namaObat)) {
                obatDipilih = stok;
                break;
            }
        }

        if (obatDipilih == null) {
            System.out.println("Obat tidak ditemukan.");
            return;
        }

        System.out.print("Jumlah Obat: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();

        Dokter dokter = null;
        for (JanjiTemu janji : daftarJanjiTemu) {
            if (janji.getPasien().equals(pasienDipilih)) {
                dokter = janji.getDokter();
                break;
            }
        }

        if (dokter == null) {
            System.out.println("Dokter untuk pasien ini tidak ditemukan.");
            return;
        }

        ResepObat resepObat = new ResepObat(dokter, obatDipilih.getNamaObat(), String.valueOf(jumlah), "Ambil setelah makan");
        daftarResepObat.add(resepObat);
        System.out.println("Resep obat berhasil dibuat.");
    }

    private void pembayaran() {
        System.out.println("\n=== Formulir Pembayaran ===");
        System.out.print("Petugas: ");
        String petugasName = scanner.nextLine();
        Karyawan petugas = null;
        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.getNama().equalsIgnoreCase(petugasName)) {
                petugas = karyawan;
                break;
            }
        }
        if (petugas == null) {
            System.out.println("Petugas tidak ditemukan.");
            return;
        }

        System.out.println("\n=== Semua Pasien ===");
        for (Pasien pasien : daftarPasien) {
            System.out.println(pasien);
        }

        System.out.print("\nPilih ID Pasien: ");
        String idPasien = scanner.nextLine();
        Pasien pasienDipilih = null;
        for (Pasien pasien : daftarPasien) {
            if (pasien.getId().equals(idPasien)) {
                pasienDipilih = pasien;
                break;
            }
        }

        if (pasienDipilih == null) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        System.out.println("\n=== Semua Stok Obat ===");
        for (StokObat stok : daftarStokObat) {
            System.out.println(stok);
        }

        System.out.print("\nPilih Obat: ");
        String obatDipilih = scanner.nextLine();
        StokObat stokObatDipilih = null;
        for (StokObat stok : daftarStokObat) {
            if (stok.getNamaObat().equalsIgnoreCase(obatDipilih)) {
                stokObatDipilih = stok;
                break;
            }
        }

        if (stokObatDipilih == null) {
            System.out.println("Obat tidak ditemukan.");
            return;
        }

        System.out.println("\n=== Pembayaran ===");
        System.out.println("1. Cash");
        System.out.println("2. Transfer");
        System.out.println("3. Qris");
        System.out.print("Masukkan jenis pembayaran: ");
        int pembayaran = scanner.nextInt();
        scanner.nextLine();

        String metodePembayaran = "";
        switch (pembayaran) {
            case 1:
                metodePembayaran = "Cash";
                break;
            case 2:
                metodePembayaran = "Transfer";
                break;
            case 3:
                metodePembayaran = "Qris";
                break;
            default:
                System.out.println("Pilihan pembayaran tidak valid.");
                return;
        }

        System.out.println("=== Data Pasien ===");
        System.out.println("Pasien: " + pasienDipilih.getNama());
        System.out.println("Obat: " + stokObatDipilih.getNamaObat());
        System.out.println("Harga: " + stokObatDipilih.getHargaObat());
        System.out.println("Pembayaran: " + metodePembayaran);
        System.out.println("Petugas: " + petugas.getNama());
    }
}