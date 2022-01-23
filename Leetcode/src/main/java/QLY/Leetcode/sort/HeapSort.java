package QLY.Leetcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class HeapSort {

    private void maintainMaxHeap(int[] source, int index, int length){
        int maxSubIndex = 2*index;
        if (maxSubIndex > length){  // leaf node
            return;
        }

        if (2*index+1 <= length){   //right son node exist
            if (source[2*index] >= source[2*index+1]){
                maxSubIndex = 2*index;
            }else {
                maxSubIndex = 2*index+1;
            }
        }


        if (source[index] < source[maxSubIndex]){   //swap the value of bigest and root node
            int tmp = source[index];
            source[index] = source[maxSubIndex];
            source[maxSubIndex] = tmp;

            maintainMaxHeap(source, maxSubIndex, length);
        }
    }

    public void constructMaxHeap(int[] source, int length){
        for (int i = length/2; i >= 1; i--){
            maintainMaxHeap(source, i, length);
        }
    }

    public int[] heapSort(int[] source){
        int[] maxHeap = new int[source.length+1];
        System.arraycopy(source, 0, maxHeap, 1, source.length);
//        System.out.println("maxHeap: " + Arrays.toString(maxHeap));
        constructMaxHeap(maxHeap, source.length);

        int heapLength = source.length;
        do {
            int bigest = maxHeap[1];
            maxHeap[1] = maxHeap[heapLength];
            maxHeap[heapLength] = bigest;

            maintainMaxHeap(maxHeap, 1, --heapLength);
        }while (heapLength > 1);

        int[] result = new int[source.length];
        System.arraycopy(maxHeap, 1, result, 0, source.length);
        return result;

    }

    public int[] heapSort2(int[] source){
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2)->o2-o1);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(Arrays.stream(source).boxed().collect(Collectors.toList()));
        System.out.println("Initial: " + priorityQueue);

        int[] result = new int[source.length];
        for (int i = 0; i < source.length; i++){
            result[i] = priorityQueue.poll();
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
//        System.out.println("result: " + Arrays.toString(heapSort.heapSort(new int[]{0, -1, 9, 10, -3, 8, 22, 9})));
        heapSort.heapSort2(new int[]{0, -1, 9, 10, -3, 8, 22, 9});
    }
}
