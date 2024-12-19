import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Dokter> dokterList = new ArrayList<>();
        List<Pasien> pasienList = new ArrayList<>();
        List<Karyawan> karyawanList = new ArrayList<>();

        dokterList.add(new Dokter("D1", "Dr. Ardi", "Umum", "Senin, Rabu"));
        dokterList.add(new Dokter("D2", "Dr. Budi", "Spesialis Bedah", "Selasa, Kamis"));

        karyawanList.add(new Karyawan("K1", "Siti", "Administrasi"));
        karyawanList.add(new Karyawan("K2", "Ali", "Petugas Registrasi"));

        int menu = -1; 
        while (menu != 0) {
            System.out.println("=== Sistem Manajemen Klinik ===");
            System.out.println("1. Pilih Dokter");
            System.out.println("2. Input Data Pasien");
            System.out.println("3. Lihat Semua Dokter");
            System.out.println("4. Lihat Semua Pasien");
            System.out.println("5. Buat Janji Temu");
            System.out.println("6. Lihat Semua Karyawan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            if (scanner.hasNextInt()) {
                menu = scanner.nextInt();
            } else {
                scanner.nextLine();  
                menu = -1; 
            }

            scanner.nextLine(); 

            switch (menu) {
                case 1:
                    pilihDokter(dokterList, scanner);
                    break;
                case 2:
                    inputPasien(pasienList, scanner);
                    break;
                case 3:
                    lihatSemuaDokter(dokterList);
                    break;
                case 4:
                    lihatSemuaPasien(pasienList);
                    break;
                case 5:
                    buatJanjiTemu(dokterList, pasienList, karyawanList, scanner);
                    break;
                case 6:
                    lihatSemuaKaryawan(karyawanList);
                    break;
                case 0:
                    System.out.println("Program selesai, terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close(); 
    }

    public static void pilihDokter(List<Dokter> dokterList, Scanner scanner) {
        System.out.println("\n=== Pilih Dokter ===");
        System.out.println("1. Dokter Umum");
        System.out.println("2. Dokter Spesialis");
        System.out.print("Pilih jenis dokter: ");
        int jenisDokter = scanner.nextInt();
        scanner.nextLine();  // Clear newline

        System.out.println(jenisDokter == 1 ? "\n=== Dokter Umum ===" : "\n=== Dokter Spesialis ===");
        for (Dokter dokter : dokterList) {
            System.out.println(dokter);
        }

        System.out.print("\nMasukkan kode dokter yang ingin dipilih: ");
        String kodeDokter = scanner.nextLine();

        Dokter dokterDipilih = null;
        for (Dokter dokter : dokterList) {
            if (dokter.id.equals(kodeDokter)) {
                dokterDipilih = dokter;
                break;
            }
        }

        if (dokterDipilih != null) {
            System.out.println("\nDokter yang dipilih: \n" + dokterDipilih);
        } else {
            System.out.println("\nDokter tidak ditemukan.");
        }
    }

    public static void inputPasien(List<Pasien> pasienList, Scanner scanner) {
        System.out.println("\n=== Input Data Pasien ===");
        System.out.print("Nama Pasien: ");
        String namaPasien = scanner.nextLine();
        System.out.print("Alamat Pasien: ");
        String alamatPasien = scanner.nextLine();
        System.out.print("Penyakit: ");
        String penyakitPasien = scanner.nextLine();

        Pasien pasien = new Pasien("P" + (pasienList.size() + 1), namaPasien, penyakitPasien, alamatPasien);
        pasienList.add(pasien);

        System.out.println("Data pasien berhasil ditambahkan.");
        System.out.println("Pengobatan\nD1, Dr. Ardi, Spesialisasi umum\nResep Obat: paracetamol");
        System.out.println("\nPembayaran");
        System.out.println("Data pasien: " + pasien);
        System.out.println("Dokter: D1, Dr. Ardi, Spesialisasi umum\nResep obat: paracetamol\nHarga: 10000");
        System.out.println("Petugas: ID K1, Siti, Jabatan: Administrasi");
    }

    public static void lihatSemuaDokter(List<Dokter> dokterList) {
        System.out.println("\n=== Semua Dokter ===");
        for (Dokter dokter : dokterList) {
            System.out.println(dokter);
        }
    }

    public static void lihatSemuaPasien(List<Pasien> pasienList) {
        System.out.println("\n=== Semua Pasien ===");
        for (Pasien pasien : pasienList) {
            System.out.println(pasien);
        }
    }

    public static void buatJanjiTemu(List<Dokter> dokterList, List<Pasien> pasienList, List<Karyawan> karyawanList, Scanner scanner) {
        System.out.println("\n=== Semua Pasien ===");
        for (Pasien pasien : pasienList) {
            System.out.println(pasien);
        }

        System.out.print("Pilih ID Pasien: ");
        String idPasien = scanner.nextLine();

        Pasien pasienDipilih = null;
        for (Pasien pasien : pasienList) {
            if (pasien.id.equals(idPasien)) {
                pasienDipilih = pasien;
                break;
            }
        }

        if (pasienDipilih != null) {
            System.out.println("\n=== Semua Dokter ===");
            for (Dokter dokter : dokterList) {
                System.out.println(dokter);
            }

            System.out.print("\nPilih Kode Dokter: ");
            String kodeDokter = scanner.nextLine();

            Dokter dokterDipilih = null;
            for (Dokter dokter : dokterList) {
                if (dokter.id.equals(kodeDokter)) {
                    dokterDipilih = dokter;
                    break;
                }
            }

            if (dokterDipilih != null) {
                System.out.print("\nMasukkan penyakit: ");
                String penyakit = scanner.nextLine();

                                Karyawan petugas = karyawanList.get(0); 

                                JanjiTemu janji = new JanjiTemu(pasienDipilih, dokterDipilih, penyakit, petugas);

                                System.out.println("\nJanji temu berhasil dibuat.");
                                System.out.println(janji); 
                            } else {
                                System.out.println("\nDokter tidak ditemukan.");
                            }
                        } else {
                            System.out.println("\nPasien tidak ditemukan.");
                        }
                    }
                
                    public static void lihatSemuaKaryawan(List<Karyawan> karyawanList) {
                        System.out.println("\n=== Semua Karyawan ===");
                        for (Karyawan karyawan : karyawanList) {
                            System.out.println(karyawan);
                        }
                    }
                }
                
