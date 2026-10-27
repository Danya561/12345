package lab1_2;

public class lab1_2 {

    public static void main(String[] args) {
        lab1_2 lab = new lab1_2();
        int[] arr = {0, 2, 6, 6, 1, 0, 4, 6};
        int val = 6;
        System.out.println(lab.removeElementInplace(arr, val));
    }

    public int removeElementInplace(int[] arr, int val) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[count] = arr[i];
                count++;
            }
        }

        return count;
    }
}