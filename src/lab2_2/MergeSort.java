package lab2_2;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {
    private void slice(List<Integer> spisok, int nachalo, int konec) {

        if (nachalo >= konec) { // один элемент или меньше тикаем
            return;
        }
        int seredina = (nachalo + konec) / 2;
        slice(spisok, nachalo, seredina);
        slice(spisok, seredina + 1, konec);
        merge(spisok, nachalo, seredina, konec);
    }

    private void merge(List<Integer> spisok, int nachalo, int seredina, int konec) {
        // во временный, чтобы не затереть числа
        List<Integer> vremenny = new ArrayList<>();
        int i = nachalo;
        int j = seredina + 1;

        while (i <= seredina && j <= konec) {

            if (spisok.get(i) <= spisok.get(j)) { // чтобы одинаковые не менялись местами
                vremenny.add(spisok.get(i));
                i++;
            } else {
                vremenny.add(spisok.get(j));
                j++;
            }
        }

        while (i <= seredina) {
            vremenny.add(spisok.get(i));
            i++;
        }

        while (j <= konec) {
            vremenny.add(spisok.get(j));
            j++;
        }


        for (int k = 0; k < vremenny.size(); k++) { // врем с нуля, а кусок с начала
            spisok.set(nachalo + k, vremenny.get(k));
        }
    }

    @Override
    public void sort(List<Integer> spisok) {
        slice(spisok, 0, spisok.size() - 1);
    }
}