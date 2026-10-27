package lab2_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // сколько будет чисел

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt()); // читаем числа по одному
        }

        InsertionSort sorter = new InsertionSort(); // создаём объект сортировки
        sorter.sort(nums);

        // выводим результат через пробел
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0) {
                result.append(" "); // пробел только между числами
            }
            result.append(nums.get(i));
        }
        System.out.println(result);
    }
}