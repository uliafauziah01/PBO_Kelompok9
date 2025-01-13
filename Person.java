public abstract class Person {
    private String id;
    private String nama;

    public Person(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public abstract void displayInfo();

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama;
    }
}
