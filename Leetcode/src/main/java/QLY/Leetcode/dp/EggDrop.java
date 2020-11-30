package QLY.Leetcode.dp;

public class EggDrop {

	// f[k][n] = f[k][n-1] + f[k-1][n-1] + 1
	public int superEggDrop(int K, int N) {
		if (K == 0) {
			return 0;
		}else if (K == 1) {
			return N;
		}
		int[][] f = new int[K+1][N+1];	// K个鸡蛋，N层楼，最坏情况至少投掷？次，
        for (int i = 0; i < N+1; i++) {
			f[0][i] = 0;
			f[1][i] = i;
			
		}
        for(int i = 0; i < K+1; i++){
        	f[i][0] = 0;
        }
        for (int i = 2; i < f.length; i++) {
			for (int j = 1; j < f[i].length; j++) {
				f[i][j] = f[i][j-1] + f[i-1][j-1] + 1;
				if(i == K && f[i][j] >= N){
					return j;
				}
			}
		}
        return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EggDrop obj = new EggDrop();
		System.out.println(obj.superEggDrop(1, 2));
	}

}
