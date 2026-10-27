package lab2_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab2_1 {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);

        int kolvo = skaner.nextInt();

        List<Integer> chisla = new ArrayList<>();
        for (int i = 0; i < kolvo; i++) {
            chisla.add(skaner.nextInt());
        }

        InsertionSort sortirovka = new InsertionSort();
        sortirovka.sort(chisla);

        StringBuilder otvet = new StringBuilder();
        for (int i = 0; i < chisla.size(); i++) {
            // пробел перед каждым числом кроме первого
            if (i > 0) {
                otvet.append(" ");
            }
            otvet.append(chisla.get(i));
        }
        System.out.println(otvet);
    }
}