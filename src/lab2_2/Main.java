package lab2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        int kolvo = skaner.nextInt();

        List<Integer> spisok = new ArrayList<>();
        for (int i = 0; i < kolvo; i++) {
            spisok.add(skaner.nextInt());
        }

        Sorting<Integer> sortirovka = new MergeSort();
        sortirovka.sort(spisok);

        StringBuilder otvet = new StringBuilder();
        for (int i = 0; i < spisok.size(); i++) {
            otvet.append(spisok.get(i));
            if (i < spisok.size() - 1) {
                otvet.append(" ");
            }
        }
        System.out.println(otvet);
    }
}