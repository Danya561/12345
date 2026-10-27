package lab2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);

        int kolichestvo = skaner.nextInt();

        List<Student> studenty = new ArrayList<>();
        for (int i = 0; i < kolichestvo; i++) {
            String imya = skaner.next();
            int vozrast = skaner.nextInt();
            studenty.add(new Student(imya, vozrast));
        }

        StudentSort sortirovshik = new StudentSort();
        sortirovshik.sort(studenty);

        // StringBuilder nuzhen, chtoby vyvod 100000 strok byl bystrym
        StringBuilder stroka = new StringBuilder();
        for (Student student : studenty) {
            stroka.append(student.getName()).append(" ").append(student.getAge()).append("\n");
        }
        System.out.print(stroka);
    }
}