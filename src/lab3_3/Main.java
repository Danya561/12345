package lab3_3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Main {
    private static <T extends Comparable<? super T>> void test(String title, List<T> items) {
        Sorting<T> SORT = new MergeSort<>();
        SORT.sort(items);

        System.out.println(title + ":");
        System.out.println(items.stream()
                .map(x -> String.valueOf(x))
                .collect(Collectors.joining("\n")));
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(List.of(5, -3, 42, 0, 17, 5, 1));
        test("Integer", ints);

        List<String> strings = new ArrayList<>(List.of("pear", "apple", "Banana", "kiwi", "apple"));
        test("String", strings);

        List<LocalDateTime> dates = new ArrayList<>(List.of(
                LocalDateTime.of(2025, 3, 14, 15, 9),
                LocalDateTime.of(2024, 12, 31, 23, 59),
                LocalDateTime.of(2025, 3, 14, 9, 0),
                LocalDateTime.of(2000, 1, 1, 0, 0)
        ));
        test("LocalDateTime", dates);

        List<UUID> uuids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            uuids.add(UUID.randomUUID());
        }
        test("UUID", uuids);

        List<Student> students = new ArrayList<>(List.of(
                new Student("Vasya", 21),
                new Student("Vasya", 19),
                new Student("Anton", 22),
                new Student("Antonio", 23)
        ));
        test("Student", students);
    }
}