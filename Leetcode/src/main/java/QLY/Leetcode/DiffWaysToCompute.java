package QLY.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.isEmpty())
            return null;

        return _diffWaysToCompute(input);

    }

    public List<Integer> _diffWaysToCompute(String input){

        List<Integer> results = new ArrayList<>();
        List<Integer> operatorIndex = getOperatorIndex(input);
        if (operatorIndex.isEmpty()){
            results.add(Integer.valueOf(input));
            return results;
        }

        for (int index: operatorIndex){
            List<Integer> lefts = _diffWaysToCompute(input.substring(0, index));
            List<Integer> rights = _diffWaysToCompute(input.substring(index+1));

            char operator = input.charAt(index);
            for (int left: lefts){
                for (int right: rights){
                    switch (operator){
                        case '+': results.add(Integer.valueOf(left) + Integer.valueOf(right)); break;
                        case '-': results.add(Integer.valueOf(left) - Integer.valueOf(right)); break;
                        case '*': results.add(Integer.valueOf(left) * Integer.valueOf(right)); break;
                    }
                }
            }
        }

        return results;

    }

    private List<Integer> getOperatorIndex(String input){
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*')
                indexs.add(i);
        }
        return indexs;
    }

    public static void main(String[] args) {
        DiffWaysToCompute diffWaysToCompute = new DiffWaysToCompute();
        System.out.println(diffWaysToCompute.diffWaysToCompute("2*3-4*5"));
    }
}
