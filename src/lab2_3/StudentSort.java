package lab2_3;

import java.util.ArrayList;
import java.util.List;

public class StudentSort implements Sorting<Student> {

    @Override
    public void sort(List<Student> students) {
        // сначала по возрасту, потом по имени
        // вторая сортировка стабильная, (у одинаковых имён порядок по возрасту не бом бом)
        List<Student> rezultat = sortirovkaSlianiem(students, true);
        rezultat = sortirovkaSlianiem(rezultat, false);

        for (int i = 0; i < rezultat.size(); i++) {
            students.set(i, rezultat.get(i));
        }
    }


    private List<Student> sortirovkaSlianiem(List<Student> spisok, boolean poVozrastu) {
        if (spisok.size() <= 1) {
            return spisok;
        }

        int seredina = spisok.size() / 2;


        List<Student> levaya = new ArrayList<>(spisok.subList(0, seredina)); // subList это только "окно" в исходный список (делаем копии(
        List<Student> pravaya = new ArrayList<>(spisok.subList(seredina, spisok.size()));

        levaya = sortirovkaSlianiem(levaya, poVozrastu);
        pravaya = sortirovkaSlianiem(pravaya, poVozrastu);

        return slit(levaya, pravaya, poVozrastu);
    }

    private List<Student> slit(List<Student> levaya, List<Student> pravaya, boolean poVozrastu) {
        List<Student> rezultat = new ArrayList<>();
        int indexLevoi = 0;
        int indexPravoi = 0;

        while (indexLevoi < levaya.size() && indexPravoi < pravaya.size()) {
            // <= а не <, чтобы при равных брался левый (так сортировка остаётся стабильной)
            if (sravni(levaya.get(indexLevoi), pravaya.get(indexPravoi), poVozrastu) <= 0) {
                rezultat.add(levaya.get(indexLevoi));
                indexLevoi++;
            } else {
                rezultat.add(pravaya.get(indexPravoi));
                indexPravoi++;
            }
        }


        while (indexLevoi < levaya.size()) { // одна из половин кончилась, дописываем остаток другой
            rezultat.add(levaya.get(indexLevoi));
            indexLevoi++;
        }
        while (indexPravoi < pravaya.size()) {
            rezultat.add(pravaya.get(indexPravoi));
            indexPravoi++;
        }

        return rezultat;
    }

    private int sravni(Student pervyi, Student vtoroi, boolean poVozrastu) {
        if (poVozrastu) {
            return pervyi.getAge() - vtoroi.getAge();
        } else {
            return pervyi.getName().compareTo(vtoroi.getName());
        }
    }
}