    package lab2_3;

    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.List;

    public class StudentSort implements Sorting<Student> {

        // Стабильная сортировка слиянием
        @Override
        public void sort(List<Student> spisok) {

            // Сначала сортируем по имени
            mergeSort(spisok, Comparator.comparing(Student::getName));

            // Затем сортируем по возрасту
            mergeSort(spisok, Comparator.comparingInt(Student::getAge));
        }

        private void mergeSort(
                List<Student> list,
                Comparator<Student> comparator) {

            if (list.size() < 2) {
                return;
            }

            int middle = list.size() / 2;

            List<Student> left =
                    new ArrayList<>(list.subList(0, middle));

            List<Student> right =
                    new ArrayList<>(list.subList(middle, list.size()));

            mergeSort(left, comparator);
            mergeSort(right, comparator);

            merge(list, left, right, comparator);
        }

        private void merge(
                List<Student> result,
                List<Student> left,
                List<Student> right,
                Comparator<Student> comparator) {

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < left.size() && j < right.size()) {

                if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                    result.set(k, left.get(i));
                    i++;
                } else {
                    result.set(k, right.get(j));
                    j++;
                }

                k++;
            }

            while (i < left.size()) {
                result.set(k, left.get(i));
                i++;
                k++;
            }

            while (j < right.size()) {
                result.set(k, right.get(j));
                j++;
                k++;
            }
        }

        // Нестабильная сортировка выбором
        public void selectionSort(List<Student> spisok) {

            int n = spisok.size();

            for (int i = 0; i < n - 1; i++) {

                int minIndex = i;

                for (int j = i + 1; j < n; j++) {

                    if (spisok.get(j).getAge()
                            < spisok.get(minIndex).getAge()) {

                        minIndex = j;
                    }
                }

                Student temp = spisok.get(i);

                spisok.set(i, spisok.get(minIndex));
                spisok.set(minIndex, temp);
            }
        }
    }