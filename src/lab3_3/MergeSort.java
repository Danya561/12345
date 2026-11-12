package lab3_3;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<? super T>> implements Sorting<T> {

    private void slice(List<T> nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = start + (end - start) / 2;
        slice(nums, start, middle);
        slice(nums, middle + 1, end);

        merge(nums, start, middle, end);
    }

    private void merge(List<T> nums, int start, int middle, int end) {
        List<T> left = new ArrayList<>(nums.subList(start, middle + 1));
        List<T> right = new ArrayList<>(nums.subList(middle + 1, end + 1));

        int j = 0;
        int i = 0;
        int k = start;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                nums.set(k, left.get(i));
                i++;
            } else {
                nums.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            nums.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            nums.set(k, right.get(j));
            j++;
            k++;
        }
    }

    @Override
    public void sort(List<T> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}