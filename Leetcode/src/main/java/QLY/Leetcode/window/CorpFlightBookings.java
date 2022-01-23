package QLY.Leetcode.window;

import java.util.Arrays;

/**
 * 1109. 航班预订统计
 */
public class CorpFlightBookings {
    private class Difference{
        private int[] diff;
        public Difference(int size) {
            diff = new int[size];
        }
        public void input(int[][] bookings){
            for (int[] booking: bookings){
                diff[booking[0]-1] += booking[2];
                if (booking[1] < diff.length)
                    diff[booking[1]] -= booking[2];
            }
        }
        public int[] origin(){
            int[] result = new int[diff.length];
            result[0] = diff[0];
            for (int i = 1; i < diff.length; i++){
                result[i] = diff[i] + result[i-1];
            }
            return result;
        }
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        Difference difference = new Difference(n);
        difference.input(bookings);
        return difference.origin();
    }

    public static void main(String[] args) {
        CorpFlightBookings corpFlightBookings = new CorpFlightBookings();
        System.out.println(Arrays.toString(corpFlightBookings.corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}}, 5)));
    }
}
