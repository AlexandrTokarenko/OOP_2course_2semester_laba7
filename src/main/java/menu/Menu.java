package menu;

import java.util.Scanner;

public class Menu {
    public void show() {
        System.out.println("1. Зчитати дані потягів з текстового файлу");
        System.out.println("2. Записати дані потягів в текстовий файл");
        System.out.println("3. Зчитати дані потягів з JSON файлу");
        System.out.println("4. Записати дані потягів в JSON файл");
        System.out.println("5. Додати елемент в список");
        System.out.println("6. Видалити елемент з списку");
        System.out.println("7. Список поїздів, які прямують до заданого пункту призначення в порядку зростання часу " +
                "відправки, якщо час однаковий – за зростанням номеру поїзда;");
        System.out.println("8. Список поїздів, які прямують до заданого пункту призначення та відправляються після " +
                "заданої години;");
        System.out.println("9. Список поїздів, які відправляються до заданого пункту призначення та мають загальні " +
                "місця;");
        System.out.println("10. Список поїздів, які відправляються до заданого пункту призначення в порядку зростання " +
                "кількості всіх місць");
        System.out.println("11. Вивести дані всіх потягів");
        System.out.println("12. Знайти потяг");
        System.out.println("0. Вихід");
    }

    public int getSelection() {
        return new Scanner(System.in).nextInt();
    }
}