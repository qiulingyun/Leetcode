package QLY.Leetcode.string;

public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null){
            if (name == null && typed == null)
                return true;
            return false;
        }else if (name.length() == 0 || typed.length() == 0){
            if (name.length() == 0 && typed.length() == 0)
                return true;
            return false;
        }
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();

    }

    public static void main(String[] args) {
        IsLongPressedName IsLongPressedName = new IsLongPressedName();
        System.out.println(IsLongPressedName.isLongPressedName("pyplrz", "ppyypllrz"));
    }
}
