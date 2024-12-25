import java.io.IOException;
import java.util.List;

public class FileWriter {
    public static void writeToFile(String fileName, List<String[]> data) throws IOException {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            for (String[] record : data) {
                writer.write(String.join("|", record));
                writer.write("\n");
            }
        }
    }
}
