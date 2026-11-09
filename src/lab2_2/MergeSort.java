package lab2_2;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {
    private void slice(List<Integer> nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        slice(nums, start, middle);
        slice(nums, middle + 1, end);
        merge(nums, start, middle, end);
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> left = new ArrayList<>();
        for (int x = start; x <= middle; x++) {
            left.add(nums.get(x));
        }

        List<Integer> right = new ArrayList<>();
        for (int x = middle + 1; x <= end; x++) {
            right.add(nums.get(x));
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
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
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}