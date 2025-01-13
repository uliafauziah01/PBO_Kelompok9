import java.util.Map;

public class Dokter extends Person {
    private String spesialisasi;
    private Map<String, String> jadwalPraktek;

    public Dokter(String id, String nama, String spesialisasi, Map<String, String> jadwalPraktek) {
        super(id, nama); 
        this.spesialisasi = spesialisasi;
        this.jadwalPraktek = jadwalPraktek;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public Map<String, String> getJadwalPraktek() {
        return jadwalPraktek;
    }

    @Override
    public String toString() {
        return super.toString() + ", Spesialisasi: " + spesialisasi;
    }
}
