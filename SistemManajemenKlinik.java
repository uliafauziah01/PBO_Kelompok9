import java.util.ArrayList;
import java.util.Scanner;

public class SistemManajemenKlinik {
    private static ArrayList<Dokter> daftarDokter = new ArrayList<>();
    private static ArrayList<Pasien> daftarPasien = new ArrayList<>();
    private static ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();
    private static ArrayList<JanjiTemu> daftarJanjiTemu = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarDokter.add(new Dokter("D1", "Dr. Andi", "Umum", "Senin, Rabu"));
        daftarDokter.add(new Dokter("D2", "Dr. Budi", "Spesialis Bedah", "Selasa, Kamis"));
        
        daftarKaryawan.add(new Karyawan("K1", "Siti", "Administrasi"));
        daftarKaryawan.add(new Karyawan("K2", "Ali", "Petugas Registrasi"));

        int pilihan;
        do {
            System.out.println("=== Sistem Manajemen Klinik ===");
            System.out.println("1. Pilih Dokter");
            System.out.println("2. Input Data Pasien");
            System.out.println("3. Lihat Semua Dokter");
            System.out.println("4. Lihat Semua Pasien");
            System.out.println("5. Buat Janji Temu");
            System.out.println("6. Lihat Semua Karyawan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    pilihDokter();
                    break;
                case 2:
                    inputDataPasien();
                    break;
                case 3:
                    lihatSemuaDokter();
                    break;
                case 4:
                    lihatSemuaPasien();
                    break;
                case 5:
                    buatJanjiTemu();
                    break;
                case 6:
                    lihatSemuaKaryawan();
                    break;
                case 0:
                    System.out.println("Program selesai, terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    private static void pilihDokter() {
        System.out.println("\n=== Pilih Dokter ===");
        System.out.println("1. Dokter Umum");
        System.out.println("2. Dokter Spesialis");
        System.out.print("Pilih jenis dokter: ");
        int jenisDokter = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        if (jenisDokter == 1) {
            System.out.println("\n=== Dokter Umum ===");
        } else if (jenisDokter == 2) {
            System.out.println("\n=== Dokter Spesialis ===");
        }

        for (Dokter dokter : daftarDokter) {
            System.out.println(dokter);
        }

        System.out.print("\nMasukkan kode dokter yang ingin dipilih: ");
        String kodeDokter = scanner.nextLine();

        for (Dokter dokter : daftarDokter) {
            if (dokter.id.equals(kodeDokter)) {
                System.out.println("\nDokter yang dipilih: \n" + dokter);
                return;
            }
        }
        System.out.println("Dokter tidak ditemukan.");
    }

    private static void inputDataPasien() {
        System.out.println("\n=== Input Data Pasien ===");
        System.out.print("Nama Pasien: ");
        String namaPasien = scanner.nextLine();
        System.out.print("Alamat Pasien: ");
        String alamatPasien = scanner.nextLine();
        System.out.print("Penyakit: ");
        String penyakit = scanner.nextLine();

        Pasien pasien = new Pasien("P" + (daftarPasien.size() + 1), namaPasien, penyakit, alamatPasien);
        daftarPasien.add(pasien);

        System.out.println("Data pasien berhasil ditambahkan.");
        System.out.println("Pengobatan\n" + "D1, Dr. Ardi, Spesialisasi umum\nResep Obat: paracetamol");
        System.out.println("\nPembayaran\nData pasien:\n" + pasien);
        System.out.println("\nDoktor:\nD1, Dr. Ardi, Spesialisasi umum\nResep obat: paracetamol\nHarga: 10000");
        System.out.println("\nPetugas: ID K1, Siti\nJabatan: Administrasi");
    }

    private static void lihatSemuaDokter() {
        System.out.println("\n=== Semua Dokter ===");
        for (Dokter dokter : daftarDokter) {
            System.out.println(dokter);
        }
    }

    private static void lihatSemuaPasien() {
        System.out.println("\n=== Semua Pasien ===");
        for (Pasien pasien : daftarPasien) {
            System.out.println(pasien);
        }
    }

    private static void buatJanjiTemu() {
        System.out.println("\n=== Semua Pasien ===");
        for (Pasien pasien : daftarPasien) {
            System.out.println(pasien);
        }

        System.out.print("\nPilih ID Pasien: ");
        String idPasien = scanner.nextLine();

        Pasien pasienDipilih = null;
        for (Pasien pasien : daftarPasien) {
            if (pasien.id.equals(idPasien)) {
                pasienDipilih = pasien;
                break;
            }
        }

        if (pasienDipilih == null) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        System.out.println("\n=== Semua Dokter ===");
        for (Dokter dokter : daftarDokter) {
            System.out.println(dokter);
        }

        System.out.print("\nPilih Kode Dokter: ");
        String kodeDokter = scanner.nextLine();

        Dokter dokterDipilih = null;
        for (Dokter dokter : daftarDokter) {
            if (dokter.id.equals(kodeDokter)) {
                dokterDipilih = dokter;
                break;
            }
        }

        if (dokterDipilih == null) {
            System.out.println("Dokter tidak ditemukan.");
            return;
        }

        System.out.print("\nMasukkan penyakit: ");
        String penyakit = scanner.nextLine();

        Karyawan petugas = daftarKaryawan.get(1); 

        JanjiTemu janjiTemu = new JanjiTemu(pasienDipilih, dokterDipilih, penyakit, petugas);
        daftarJanjiTemu.add(janjiTemu);

        System.out.println("Janji temu berhasil dibuat.\n" + janjiTemu);
    }

    private static void lihatSemuaKaryawan() {
        System.out.println("\n=== Semua Karyawan ===");
        for (Karyawan karyawan : daftarKaryawan) {
            System.out.println(karyawan);
        }
    }
}
