package Task_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.io.IOException;

public class Queue_poem {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("poem.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                queue.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!queue.isEmpty()) {
            String line = queue.poll();
            System.out.println(line);
            try {
                Thread.sleep(new Random().nextInt(3000) + 1000); // рандомная задержка от 1 до 3 секунд
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
