package QLY.Leetcode.dp;

import java.util.Arrays;

/**
 * 887. 鸡蛋掉落
 * 难度 困难
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 *
 * 示例 1：
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 * 输入：K = 3, N = 14
 * 输出：4
 *
 * 提示：
 * 1 <= K <= 100
 * 1 <= N <= 10000
 */
public class EggDrop {

	// f[k][n] = f[k][n-1] + f[k-1][n-1] + 1
	public int superEggDrop2(int K, int N) {
		if (K == 0) {
			return 0;
		}else if (K == 1) {
			return N;
		}
		int[][] dp = new int[K+1][N+1];	// K个鸡蛋，N层楼，最坏情况至少投掷？次，
        for (int i = 0; i < N+1; i++) {
			dp[0][i] = 0;
			dp[1][i] = i;
			
		}
        for(int i = 0; i < K+1; i++){
        	dp[i][0] = 0;
        }
        for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j-1] + 1;
				if(i == K && dp[i][j] >= N){
					return j;
				}
			}
		}
        return -1;
    }

	public int superEggDrop(int K, int N) {
		// k个鸡蛋，n层楼，最少扔几次
		int[][] dp = new int[K+1][N+1];
		for (int i = 2; i <= K; i++){
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		//1个鸡蛋
		for (int i = 1; i <= N; i++){
			dp[1][i] = i;
		}
		// 0层楼
		for (int i = 1; i <= K; i++){
			dp[i][0] = 0;
		}
		// 1层楼
		for (int i = 1; i <= K; i++){
			dp[i][1] = 1;
		}

		for (int i = 2; i <= K; i++){
			for (int j = 2; j <= N; j++){
				for (int k = 1; k <= j; k++){
					dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k-1], dp[i][j-k]) + 1);
				}

			}
		}

		return dp[K][N];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EggDrop obj = new EggDrop();
		System.out.println(obj.superEggDrop(3, 14));
	}

}
