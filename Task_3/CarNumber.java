package Task_3;

import java.util.Scanner;

/**
 * Форматы ввода: A123AA777, A 123 AA RUS 77, А 123АА77, а123вс  рус46
 * буквы русские и латинские, строчные и заглавные.
 * Если номер не соответствует ни одному из форматов,
 * программа выводит сообщение об ошибке "Некорректный формат номера".
 * Если номер соответствует одному из форматов,
 * программа определяет регион по номеру и выводит его на экран.
 * Если регион не найден, программа выводит сообщение об ошибке "Регион не найден".
 */
public class CarNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("Введите номер автомобиля или 'выход', чтобы закончить: ");
            input = scanner.nextLine().toUpperCase().replaceAll("\\s", ""); // приводим к верхнему регистру и удаляем пробелы
            if (input.equals("ВЫХОД")) { // если пользователь ввел "выход", то выходим из программы
                break;
            }
            if (!isValidFormat(input)) { // проверяем формат номера
                System.out.println("Некорректный формат номера");
                if (input.matches("[^АВЕКМНОРСТУХABEKMHOPCTYX]\\d{3}[^АВЕКМНОРСТУХABEKMHOPCTYX]{2}(RUS)?(РУС)?\\d{2,3}")){
                    System.out.println("Недопустимая буква в номере");
                }
                continue;
            }
            String region = getRegion(input); // получаем регион по номеру
            if (region == null) { // если регион не найден, то выводим сообщение об ошибке
                System.out.println("Регион не найден");
            } else { // иначе выводим регион
                System.out.println(region);
            }
        } while (true);
    }

    //Возвращает true, если формат корректный, иначе false
    private static boolean isValidFormat(String carNumber) {
        return carNumber.matches("[АВЕКМНОРСТУХABEKMHOPCTYX]\\d{3}[АВЕКМНОРСТУХABEKMHOPCTYX]{2}(RUS)?(РУС)?\\d{2,3}");
    }

    // Возвращает регион или null, если регион не найден
    private static String getRegion(String carNumber) {
        String region = null;
        // получаем код региона из номера
        int code;
        String lastDigits = carNumber.substring(carNumber.length() - 3);
        if (lastDigits.matches("\\d\\d\\d")) {
            // последние три символа являются цифрами
            code = Integer.parseInt(lastDigits);
        } else {
            // последние два символа являются цифрами
            code = Integer.parseInt(carNumber.substring(carNumber.length() - 2));
        }
        if (code > 199 && code < 700 || code > 799) {
            return ("Такого региона не существует");
        }
        switch (code) { // проверяем код региона
            case 77:
            case 97:
            case 99:
            case 177:
            case 197:
            case 199:
            case 777:
            case 799:
                region = "Москва";
                break;
            case 50:
            case 90:
            case 150:
            case 190:
            case 750:
                region = "Московская область";
                break;
            case 24:
            case 84:
            case 88:
            case 124:
                region = "Красноярский край";
                break;
            case 16:
            case 116:
            case 716:
                region = "Республика Татарстан";
                break;
            case 23:
            case 93:
            case 123:
                region = "Краснодарский край";
                break;
            case 38:
            case 85:
            case 138:
                region = "Иркутская область";
                break;
            case 59:
            case 81:
            case 159:
                region = "Пермский край";
                break;
            case 78:
            case 98:
            case 178:
                region = "Санкт-Петербург";
                break;
            case 66:
            case 96:
            case 196:
                region = "Свердловская область";
                break;
            case 2:
            case 102:
                region = "Республика Башкортостан";
                break;
            case 13:
            case 113:
                region = "Республика Мордовия";
                break;
            case 21:
            case 121:
                region = "Чувашская Республика";
                break;
            case 25:
            case 125:
                region = "Приморский край";
                break;
            case 26:
            case 126:
                region = "Ставропольский край";
                break;
            case 34:
            case 134:
                region = "Волгоградская область";
                break;
            case 39:
            case 91:
                region = "Калининградская область";
                break;
            case 42:
            case 142:
                region = "Кемеровская область";
                break;
            case 52:
            case 152:
                region = "Нижегородская область";
                break;
            case 54:
            case 154:
                region = "Новосибирская область";
                break;
            case 61:
            case 161:
                region = "Ростовская область";
                break;
            case 63:
            case 163:
                region = "Самарская область";
                break;
            case 64:
            case 164:
                region = "Саратовская область";
                break;
            case 73:
            case 173:
                region = "Ульяновская область";
                break;
            case 74:
            case 174:
                region = "Челябинская область";
                break;
            case 75:
            case 80:
                region = "Забайкальский край";
                break;
            case 86:
            case 186:
                region = "Ханты-Мансийский автономный округ Югра";
                break;
            case 46:
                region = "Курская область";
                break;
            case 82:
            case 182:
                region = "Республика Крым";
                break;
        }
        return region;
    }
}

