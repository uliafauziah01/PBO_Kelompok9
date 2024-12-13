import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemManajemenKlinik sistem = new SistemManajemenKlinik();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan dokter dan karyawan
        sistem.tambahDokter(new Doctor("D1", "Dr. Andi", "Umum", "Senin, Rabu"));
        sistem.tambahDokter(new Doctor("D2", "Dr. Budi", "Spesialis Bedah", "Selasa, Kamis"));

        // Menambahkan karyawan
        Karyawan karyawan1 = new Karyawan("K1", "Siti", "Admin");
        Karyawan karyawan2 = new Karyawan("K2", "Ali", "Petugas Registrasi");

        // Menambahkan karyawan ke sistem
        sistem.tambahKaryawan(karyawan1);
        sistem.tambahKaryawan(karyawan2);

        while (true) {
            System.out.println("\n=== Sistem Manajemen Klinik ===");
            System.out.println("1. Pilih Dokter Umum");
            System.out.println("2. Pilih Dokter Spesialis");
            System.out.println("3. Input Data Pasien");
            System.out.println("4. Lihat Semua Dokter");
            System.out.println("5. Lihat Semua Pasien");
            System.out.println("6. Buat Janji Temu");
            System.out.println("7. Lihat Semua Karyawan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (pilihan == 0) break;

            switch (pilihan) {
                case 1:
                    sistem.pilihDokterUmum(scanner);
                    break;
                case 2:
                    sistem.pilihDokterSpesialis(scanner);
                    break;
                case 3:
                    sistem.inputDataPasien(scanner);
                    break;
                case 4:
                    sistem.lihatSemuaDokter();
                    break;
                case 5:
                    sistem.lihatSemuaPasien();
                    break;
                case 6:
                    buatJanjiTemu(sistem, scanner);
                    break;
                case 7:
                    sistem.lihatSemuaKaryawan();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }

    private static void buatJanjiTemu(SistemManajemenKlinik sistem, Scanner scanner) {
        sistem.lihatSemuaPasien();
        System.out.print("Pilih ID Pasien: ");
        String idPasien = scanner.nextLine();

        // Mencari pasien berdasarkan ID
        Pasien pasien = null;
        for (Pasien p : sistem.getPasienList()) {
            if (p.getIdPasien().equals(idPasien)) {
                pasien = p;
                break;
            }
        }

        if (pasien == null) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        sistem.lihatSemuaDokter();
        System.out.print("Pilih Kode Dokter: ");
        String kodeDokter = scanner.nextLine();

        // Mencari dokter berdasarkan kode
        Doctor dokter = null;
        for (Doctor d : sistem.getDokterList()) {
            if (d.getKode().equals(kodeDokter)) {
                dokter = d;
                break;
            }
        }

        if (dokter == null) {
            System.out.println("Dokter tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan penyakit: ");
        String penyakit = scanner.nextLine();

        // Mengambil karyawan yang menjadwalkan
        Karyawan karyawan = sistem.getKaryawanList().get(0); // Mengambil karyawan pertama sebagai contoh

        // Membuat janji temu
        JanjiTemu janjiTemu = new JanjiTemu(pasien, dokter, karyawan, penyakit);
        sistem.tambahJanjiTemu(janjiTemu); // Menambahkan janji temu ke SistemManajemenKlinik
        System.out.println("Janji temu berhasil dibuat.");
    }
}