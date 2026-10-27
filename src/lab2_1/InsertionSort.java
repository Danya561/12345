package lab2_1;

import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> chisla) {
        for (int i = 1; i < chisla.size(); i++) {
            int tekushee = chisla.get(i);
            int j = i - 1;


            while (j >= 0 && chisla.get(j) > tekushee) { // сдвигаем большие элементы вправо
                chisla.set(j + 1, chisla.get(j));
                j--;
            }


            chisla.set(j + 1, tekushee);// вст в освободивш место
        }
    }
}