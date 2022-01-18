package QLY.Leetcode.array;

public class BinaryIndexTree {
    int[] bit;

    public BinaryIndexTree(int[] source) {
        bit = new int[source.length + 1];
        for (int i = 1; i < bit.length; i++) {
            int sum = source[i - 1];
            int size = (int)(Math.log(lowbit(i)) / Math.log(2));
            for (int j = i - 1, count = 0; j > 0 && count < size; j-=lowbit(j), count++) {
                sum += bit[j];
            }
            bit[i] = sum;
        }
    }

    public int sum(int end){
        int sum = 0;
        for (int i = end + 1; i > 0; i-=lowbit(i)) {
            sum += bit[i];
        }
        return sum;
    }

    public void update(int index, int delta){
        for (int i = index; i < bit.length; i+=lowbit(i)) {
            bit[i] += delta;
        }
    }

    private int lowbit(int x){
        return x & (-x);
    }


    public static void main(String[] args) {
        int[] inputs = new int[]{0, 1, 2, 3, 4, 5};
        BinaryIndexTree bit = new BinaryIndexTree(inputs);
        System.out.println(bit.sum(3));
        System.out.println(bit.sum(0));
        bit.update(3, 1);   //0, 1, 2, 4, 4, 5
        System.out.println(bit.sum(4));
    }
}
