import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataKlinik implements FileManager {
    private static final String FILE_PATH = "data_pasien.txt";

    @Override
    public void simpanData(String filename, List<String> data) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            for (String line : data) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data: " + e.getMessage());
        }
    }

    public void simpanDataPasien(Pasien pasien) throws IOException {
        simpanData(FILE_PATH, List.of(pasien.toString()));
    }
} 
