public class Karyawan extends Person {
    private String jabatan;

    public Karyawan(String id, String nama, String jabatan) {
        super(id, nama); 
        this.jabatan = jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    @Override
    public String toString() {
        return super.toString() + ", Jabatan: " + jabatan;
    }
}
