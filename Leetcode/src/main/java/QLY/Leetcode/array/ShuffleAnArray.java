package QLY.Leetcode.array;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    private int[] origin = null;
    private Random random = null;

    public ShuffleAnArray(int[] nums) {
        this.origin = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return this.origin;
    }

    public int[] shuffle() {
        int[] result = Arrays.copyOf(origin, origin.length);

        for (int i = this.origin.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = result[i];
            result[i] = result[index];
            result[index] = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));

    }
}
