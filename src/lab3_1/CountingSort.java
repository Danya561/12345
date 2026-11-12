package lab3_1;

import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        int[] count = new int[128];

        for (int x : nums) {
            count[x]++;
        }

        int i = 0;
        for (int v = 0; v < 128; v++) {
            for (int k = 0; k < count[v]; k++) {
                nums.set(i, v);
                i++;
            }
        }
    }
}





