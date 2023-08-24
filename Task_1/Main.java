package Task_1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Animal[] animals = new Animal[15];
        int index = 0;

        for (int i = 0; i < random.nextInt(3) + 1; i++) {
            animals[index] = new Dog("Собака #" + (i + 1));
            index++;
        }

        for (int i = 0; i < random.nextInt(3) + 1; i++) {
            animals[index] = new House_cat("Кот #" + (i + 1));
            index++;
        }

        for (int i = 0; i < random.nextInt(3) + 1; i++) {
            animals[index] = new Tiger("Тигр #" + (i + 1));
            index++;
        }

        for (int i = 0; i < random.nextInt(3) + 1; i++) {
            animals[index] = new Capybara("Капибара #" + (i + 1));
            index++;
        }

        for (int i = 0; i < random.nextInt(3) + 1; i++) {
            animals[index] = new Duck("Утка #" + (i + 1));
            index++;
        }

        for (Animal animal : animals) {
            if (animal != null) {
                int distance = random.nextInt(1000) + 1;
                animal.run(distance);
                animal.swim(distance);
            }
        }

        System.out.println("Создано " + Dog.getCount() + " собака(и)");
        System.out.println("Создано " + House_cat.getCount() + " домашний(их) кот(а)");
        System.out.println("Создано " + Tiger.getCount() + " тигр(а)");
        System.out.println("Создано " + Capybara.getCount() + " капибара(ы)");
        System.out.println("Создано " + Duck.getCount() + " утка(и)");
        System.out.println("Всего создано " + (Dog.getCount() + House_cat.getCount() + Tiger.getCount() + Capybara.getCount() + Duck.getCount()) + " животных");
    }
}