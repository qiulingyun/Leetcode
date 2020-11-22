package QLY.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        if (n <= 0)
            return null;

        List<String> result = new ArrayList<>();
        backtrace(result, "", n, n, 0);
        return result;
    }

    private void backtrace(List<String> result, String path, int left, int right, int unpairedLeft){
        if (left == 0 && right == 0){
            result.add(path);
            return;
        }

        if (left != 0){
            backtrace(result, path + "(", left - 1, right, unpairedLeft + 1);
        }

        if (unpairedLeft > 0 && right > 0){
            backtrace(result, path + ")", left, right - 1, unpairedLeft - 1);
        }

//        for (int i = 0; i < 2; i++){
//            if (i == 0){
//                if (left == 0)
//                    continue;
//                backtrace(result, path + "(", left - 1, right, unpairedLeft + 1);
//            }else {
//                if (unpairedLeft == 0 || right == 0)
//                    continue;
//                backtrace(result, path + ")", left, right - 1, unpairedLeft - 1);
//            }
//        }
    }

    public static void main(String[] args) {
        GenerateParenthesis GenerateParenthesis = new GenerateParenthesis();
        System.out.println(GenerateParenthesis.generateParenthesis(4));
    }
}
