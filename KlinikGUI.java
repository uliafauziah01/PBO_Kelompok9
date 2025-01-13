import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class KlinikGUI {
    private JFrame frame;
    private JTextArea outputArea;
    private List<Pasien> daftarPasien;
    private List<Dokter> daftarDokter;
    private List<Karyawan> daftarKaryawan;
    private List<JanjiTemu> daftarJanjiTemu;
    private List<StokObat> daftarStokObat;
    private List<ResepObat> daftarResepObat;

    public KlinikGUI() {
        daftarPasien = new ArrayList<>();
        daftarDokter = new ArrayList<>();
        daftarKaryawan = new ArrayList<>();
        daftarJanjiTemu = new ArrayList<>();
        daftarStokObat = new ArrayList<>();
        daftarResepObat = new ArrayList<>();

        tambahDataAwal();
        
        frame = new JFrame("Sistem Manajemen Klinik");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1));

        String[] options = {
            "Input Data Pasien",
            "Lihat Semua Dokter",
            "Lihat Semua Pasien",
            "Buat Janji Temu",
            "Lihat Semua Karyawan",
            "Lihat Semua Stok Obat",
            "Tambah Stok Obat",
            "Buat Resep Obat",
            "Pembayaran",
            "Keluar"
        };

        for (String option : options) {
            JButton button = new JButton(option);
            button.addActionListener(new MenuActionListener(option));
            panel.add(button);
        }

        frame.add(panel, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class MenuActionListener implements ActionListener {
        private String option;

        public MenuActionListener(String option) {
            this.option = option;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (option) {
                case "Input Data Pasien":
                    inputDataPasien();
                    break;
                case "Lihat Semua Dokter":
                    lihatSemuaDokter();
                    break;
                case "Lihat Semua Pasien":
                    lihatSemuaPasien();
                    break;
                case "Buat Janji Temu":
                    buatJanjiTemu();
                    break;
                case "Lihat Semua Karyawan":
                    lihatSemuaKaryawan();
                    break;
                case "Lihat Semua Stok Obat":
                    lihatSemuaStokObat();
                    break;
                case "Tambah Stok Obat":
                    tambahStokObat();
                    break;
                case "Buat Resep Obat":
                    buatResepObat();
                    break;
                case "Pembayaran":
                    pembayaran();
                    break;
                case "Keluar":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
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
    
        Map<String, String> jadwalDokter3 = new HashMap<>();
        jadwalDokter3.put("Rabu", "08:00 - 12:00");
        jadwalDokter3.put("Jumat", "13:00 - 17:00");
        daftarDokter.add(new Dokter("D3", "Dr. Citra", "Spesialis Anak", jadwalDokter3));
    
        Map<String, String> jadwalDokter4 = new HashMap<>();
        jadwalDokter4.put("Rabu", "08:00 - 12:00");
        jadwalDokter4.put("Kamis", "13:00 - 17:00");
        daftarDokter.add(new Dokter("D4", "Dr. Dinda", "THT", jadwalDokter4));
    
        Map<String, String> jadwalDokter5 = new HashMap<>();
        jadwalDokter5.put("Kamis", "08:00 - 12:00");
        jadwalDokter5.put("Jumat", "13:00 - 17:00");
        daftarDokter.add(new Dokter("D5", "Dr. Rini", "Spesialis Kulit", jadwalDokter5));
    
        Map<String, String> jadwalDokter6 = new HashMap<>();
        jadwalDokter6.put("Senin", "08:00 - 12:00");
        jadwalDokter6.put("Kamis", "13:00 - 17:00");
        daftarDokter.add(new Dokter("D6", "Dr. Endah", "Spesialis Gigi", jadwalDokter6));

        daftarStokObat.add(new StokObat("Paracetamol", 7500, 100));
        daftarStokObat.add(new StokObat("Ibuprofen", 12000, 150));
        daftarStokObat.add(new StokObat("Amoxicillin", 25000, 200));
        daftarStokObat.add(new StokObat("Captopril", 10000, 50));
        daftarStokObat.add(new StokObat("Metformin", 15000, 120));
        daftarStokObat.add(new StokObat("Aspirin", 8000, 180));
    }

    private void inputDataPasien() {
        String namaPasien = JOptionPane.showInputDialog("Nama Pasien:");
        String alamatPasien = JOptionPane.showInputDialog("Alamat Pasien:");
        String penyakitPasien = JOptionPane.showInputDialog("Penyakit:");
        String usiaString = JOptionPane.showInputDialog("Usia:");
        int usiaPasien = Integer.parseInt(usiaString);

        Pasien pasien = new Pasien(namaPasien, alamatPasien, penyakitPasien, usiaPasien);
        daftarPasien.add(pasien);
        outputArea.append("Data pasien berhasil ditambahkan. ID Pasien: " + pasien.getId() + "\n");
    }

    private void lihatSemuaDokter() {
        outputArea.append("\n=== Daftar Dokter ===\n");
        for (Dokter dokter : daftarDokter) {
            outputArea.append(dokter.toString() + "\n");
        }
    }

    private void lihatSemuaPasien() {
        outputArea.append("\n=== Data Pasien ===\n");
        for (Pasien pasien : daftarPasien) {
            outputArea.append(pasien.toString() + "\n");
        }
    }

    private void buatJanjiTemu() {
        String petugasName = JOptionPane.showInputDialog("Petugas:");
        Karyawan petugas = null;
        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.getNama().equalsIgnoreCase(petugasName)) {
                petugas = karyawan;
                break;
            }
        }
        if (petugas == null) {
            outputArea.append("Petugas tidak ditemukan.\n");
            return;
        }

        StringBuilder pasienList = new StringBuilder("=== Semua Pasien ===\n");
        for (Pasien pasien : daftarPasien) {
            pasienList.append(pasien).append("\n");
        }
        String idPasien = JOptionPane.showInputDialog(pasienList + "Pilih ID Pasien:");

        Pasien pasienDipilih = null;
        for (Pasien pasien : daftarPasien) {
            if (pasien.getId().equals(idPasien)) {
                pasienDipilih = pasien;
                break;
            }
        }

        if (pasienDipilih == null) {
            outputArea.append("Pasien tidak ditemukan.\n");
            return;
        }

        StringBuilder dokterList = new StringBuilder("=== Daftar Dokter ===\n");
        for (Dokter dokter : daftarDokter) {
            dokterList.append(dokter).append("\n");
        }
        String kodeDokter = JOptionPane.showInputDialog(dokterList + "Pilih Kode Dokter:");

        Dokter dokterDipilih = null;
        for (Dokter dokter : daftarDokter) {
            if (dokter.getId().equals(kodeDokter)) {
                dokterDipilih = dokter;
                break;
            }
        }

        if (dokterDipilih == null) {
            outputArea.append("Dokter tidak ditemukan.\n");
            return;
        }

        String hariPraktek = JOptionPane.showInputDialog("Pilih Hari:");
        JanjiTemu janjiTemu = new JanjiTemu(pasienDipilih, dokterDipilih, pasienDipilih.getPenyakit(), petugas, hariPraktek);
        daftarJanjiTemu.add(janjiTemu);
        outputArea.append("Janji temu berhasil dibuat.\n");
    }

    private void lihatSemuaKaryawan() {
        outputArea.append("\n=== Semua Karyawan ===\n");
        for (Karyawan karyawan : daftarKaryawan) {
            outputArea.append(karyawan.toString() + "\n");
        }
    }

    private void lihatSemuaStokObat() {
        outputArea.append("\n=== Semua Stok Obat ===\n");
        for (StokObat stokObat : daftarStokObat) {
            outputArea.append(stokObat.toString() + "\n");
        }
    }

    private void tambahStokObat() {
        String namaObat = JOptionPane.showInputDialog("Nama Obat:");
        String hargaString = JOptionPane.showInputDialog("Harga Obat:");
        int hargaObat = Integer.parseInt(hargaString);
        String jumlahString = JOptionPane.showInputDialog("Jumlah Stok:");
        int jumlahStok = Integer.parseInt(jumlahString);

        StokObat stokObat = new StokObat(namaObat, hargaObat, jumlahStok);
        daftarStokObat.add(stokObat);
        outputArea.append("Stok obat berhasil ditambahkan.\n");
    }

    private void buatResepObat() {
        StringBuilder pasienList = new StringBuilder("\n=== Semua Pasien ===\n");
        for (Pasien pasien : daftarPasien) {
            pasienList.append(pasien).append("\n");
        }
        String idPasien = JOptionPane.showInputDialog(pasienList + "Pilih ID Pasien:");

        Pasien pasienDipilih = null;
        for (Pasien pasien : daftarPasien) {
            if (pasien.getId().equals(idPasien)) {
                pasienDipilih = pasien;
                break;
            }
        }

        if (pasienDipilih == null) {
            outputArea.append("Pasien tidak ditemukan.\n");
            return;
        }

        StringBuilder stokList = new StringBuilder("\n=== Semua Stok Obat ===\n");
        for (StokObat stokObat : daftarStokObat) {
            stokList.append(stokObat).append("\n");
        }
        String namaObat = JOptionPane.showInputDialog(stokList + "Pilih Obat:");

        StokObat obatDipilih = null;
        for (StokObat stok : daftarStokObat) {
            if (stok.getNamaObat().equalsIgnoreCase(namaObat)) {
                obatDipilih = stok;
                break;
            }
        }

        if (obatDipilih == null) {
            outputArea.append("Obat tidak ditemukan.\n");
            return;
        }

        String jumlahString = JOptionPane.showInputDialog("Jumlah Obat:");
        int jumlah = Integer.parseInt(jumlahString);
        
        // Logika untuk mendapatkan dokter dari janji temu
        Dokter dokter = null;
        for (JanjiTemu janji : daftarJanjiTemu) {
            if (janji.getPasien().equals(pasienDipilih)) {
                dokter = janji.getDokter();
                break;
            }
        }

        if (dokter == null) {
            outputArea.append("Dokter untuk pasien ini tidak ditemukan.\n");
            return;
        }

        ResepObat resepObat = new ResepObat(dokter, obatDipilih.getNamaObat(), String.valueOf(jumlah), "Ambil setelah makan");
        daftarResepObat.add(resepObat);
        outputArea.append("Resep obat berhasil dibuat.\n");
    }

    private void pembayaran() {
        String petugasName = JOptionPane.showInputDialog("Petugas:");
        Karyawan petugas = null;
        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.getNama().equalsIgnoreCase(petugasName)) {
                petugas = karyawan;
                break;
            }
        }
        if (petugas == null) {
            outputArea.append("Petugas tidak ditemukan.\n");
            return;
        }

        StringBuilder pasienList = new StringBuilder("\n=== Semua Pasien ===\n");
        for (Pasien pasien : daftarPasien) {
            pasienList.append(pasien).append("\n");
        }
        String idPasien = JOptionPane.showInputDialog(pasienList + "Pilih ID Pasien:");

        Pasien pasienDipilih = null;
        for (Pasien pasien : daftarPasien) {
            if (pasien.getId().equals(idPasien)) {
                pasienDipilih = pasien;
                break;
            }
        }

        if (pasienDipilih == null) {
            outputArea.append("Pasien tidak ditemukan.\n");
            return;
        }

        StringBuilder stokList = new StringBuilder("\n=== Semua Stok Obat ===\n");
        for (StokObat stok : daftarStokObat) {
            stokList.append(stok).append("\n");
        }
        String obatDipilih = JOptionPane.showInputDialog(stokList + "Pilih Obat:");

        StokObat stokObatDipilih = null;
        for (StokObat stok : daftarStokObat) {
            if (stok.getNamaObat().equalsIgnoreCase(obatDipilih)) {
                stokObatDipilih = stok;
                break;
            }
        }

        if (stokObatDipilih == null) {
            outputArea.append("Obat tidak ditemukan.\n");
            return;
        }

        String metodePembayaran = JOptionPane.showInputDialog("Pilih metode pembayaran (Cash, Transfer, Qris):");
        outputArea.append("=== Data Pembayaran ===\n");
        outputArea.append("Pasien: " + pasienDipilih.getNama() + "\n");
        outputArea.append("Obat: " + stokObatDipilih.getNamaObat() + "\n");
        outputArea.append("Harga: " + stokObatDipilih.getHargaObat() + "\n");
        outputArea.append("Pembayaran: " + metodePembayaran + "\n");
        outputArea.append("Petugas: " + petugas.getNama() + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KlinikGUI::new);
    }
}