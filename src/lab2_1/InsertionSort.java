package lab2_1;

import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        // идём слева направо, начиная со второго элемента
        for (int i = 1; i < nums.size(); i++) {
            int key = nums.get(i); // запоминаем текущий элемент
            int j = i - 1;         // индекс элемента слева

            // пока слева есть элемент и он больше key, сдвигаем его вправо
            while (j >= 0 && nums.get(j) > key) {
                nums.set(j + 1, nums.get(j));
                j--;
            }

            // ставим key на своё место
            nums.set(j + 1, key);
        }
    }
}