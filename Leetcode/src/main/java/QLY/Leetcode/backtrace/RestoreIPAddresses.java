package QLY.Leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class RestoreIPAddresses {
    public static final int IPSEGMENT = 4;
    public static final int IPSEGMENTLEN = 3;
    public static final int IPSEGMENTMAX = 255;
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        if (s.length() < IPSEGMENT)
            return results;
        backtrace(s, 1, new LinkedList<>(), results);
        return results;
    }
    private void backtrace(String s, int segmentIndex, LinkedList<String> path, List<String> results){
        if (segmentIndex > IPSEGMENT){
            results.add(String.join(".", path));
            return;
        }

        int minLength = s.length() - (IPSEGMENT - segmentIndex) * IPSEGMENTLEN > 0 ? s.length() - (IPSEGMENT - segmentIndex) * IPSEGMENTLEN: 1;
        int maxLength = s.length() - (IPSEGMENT - segmentIndex) <= IPSEGMENTLEN ? s.length() - (IPSEGMENT - segmentIndex): IPSEGMENTLEN;
        for (int length = minLength; length <= maxLength ; length++) {
            String curr = s.substring(0, length);
            int digit = Integer.parseInt(curr);
            if (digit > IPSEGMENTMAX)
                continue;
            if (curr.length() > 1 && curr.charAt(0) == '0')
                continue;
            path.add(curr);
            backtrace(s.substring(length), segmentIndex + 1, path, results);
            path.removeLast();

            if (curr.equals("0"))
                break;
        }
    }



    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        System.out.println(restoreIPAddresses.restoreIpAddresses("000256"));
        /**
         * 输入：
         * "101023"
         * 输出：
         * ["1.0.1.023","1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
         * 预期结果：
         * ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
         */
    }
}
