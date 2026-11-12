package lab3_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);      // Scanner читает то, что мы вводим с клавиатуры
        int n = scanner.nextInt();                     // читаем первое число: сколько всего элементов (N)

        List<Integer> nums = new ArrayList<>();        // создаём пустой список для чисел
        for (int i = 0; i < n; i++) {                  // повторяем N раз
            nums.add(scanner.nextInt());               // читаем очередное число и добавляем его в список
        }

        CountingSort sorter = new CountingSort();      // создаём объект нашей сортировки
        sorter.sort(nums);                             // сортируем список (результат окажется в nums)

        for (int i = 0; i < n; i++) {                  // проходим по отсортированному списку
            System.out.print(nums.get(i));             // выводим число
            if (i < n - 1) {                           // если это не последнее число
                System.out.print(" ");                 // ставим после него пробел
            }
        }
        System.out.println();                          // переход на новую строку в конце
    }
}
