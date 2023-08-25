package Task_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Splitter {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("poem.txt"))) {
            String line;
            int partNum = 1;
            StringBuilder part = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) { // если строка пустая, то это разделитель абзацев
                    writePartToFile(part.toString(), partNum);
                    part = new StringBuilder();
                    partNum++;
                } else {
                    part.append(line).append("\n");
                }
            }
            // записываем последний абзац
            writePartToFile(part.toString(), partNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writePartToFile(String content, int partNumber) throws IOException {
        try (FileWriter writer = new FileWriter("part" + partNumber + ".txt")) {
            writer.write(content);
        }
    }
}
