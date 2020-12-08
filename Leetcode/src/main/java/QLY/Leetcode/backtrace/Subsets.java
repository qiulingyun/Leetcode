package QLY.Leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(List<Integer> list){
        if (list == null || list.isEmpty()){
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        getSubSets(list, 0, results, new LinkedList<>());
        return results;
    }

    public void getSubSets(List<Integer> list, int index, List<List<Integer>> results, LinkedList<Integer> currList){

        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(currList);
        results.add(tmp);


        for (int i = index; i < list.size(); i++){
            currList.addLast(list.get(i));
            getSubSets(list, i+1, results, currList);
            currList.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets Subsets = new Subsets();
        System.out.println(Subsets.subsets(Arrays.asList(new Integer[]{1, 2, 3})));

    }
}
