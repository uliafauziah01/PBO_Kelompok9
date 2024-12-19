public class Person {
    protected String id;
    protected String nama;

    public Person(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.nama;
    }
}
