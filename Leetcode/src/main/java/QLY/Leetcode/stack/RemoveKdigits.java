package QLY.Leetcode.stack;

import java.util.Stack;

public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        Stack<Integer> increase = new Stack<>();
        for (char c : num.toCharArray()){
            int i = c - '0';
            while (!increase.isEmpty() && increase.peek() > i && k > 0 ){
                increase.pop();
                k--;
            }
            increase.push(i);
        }
        if (k > 0){
            for (int i = 0; i < k; i++)
                increase.pop();
        }
        StringBuffer result = new StringBuffer();
        if (increase.isEmpty()){
            return "0";
        }else {
            increase.stream().forEach(i->{
                if (result.length() == 1 && result.charAt(0) == '0'){
                    result.deleteCharAt(0);
                }
                result.append(i);
            });
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits removeKdigits = new RemoveKdigits();
        System.out.println(removeKdigits.removeKdigits("1234567890", 9));
    }
}
