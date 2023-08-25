package Task_2;

public class Main {
    public static void main(String[] args) {
        Author author = new Author("Никлаус Вирт", "niklauswirth@gmail.com", 'М');
        Book book = new Book("Алгоритмы и структуры данных", author, 259.99, 1000);

        System.out.println(book.toString());
        System.out.println("Цена: " + book.getPrice() + " рублей" + " Количество: " + book.getQty());

        book.setPrice(299.99);
        book.setQty(500);

        System.out.println("Цена: " + book.getPrice() + " рублей" + " Количество: " + book.getQty());
    }
}
