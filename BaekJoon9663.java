package BaekJoon;

import java.util.*;

public class BaekJoon9663 {

	static int n;
	static int[] cols;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cols = new int[n + 1];
		cnt = 0;
		dfs(0);
		
		System.out.println(cnt);
	}
	
	public static void dfs(int depth) {

		if (depth == n) {
			cnt++;
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (isProper(depth+1, i)) {
				cols[i] = depth + 1;
				dfs(depth + 1);
				cols[i] = 0;
			}
		}
	}

	public static boolean isProper(int row, int col) {
		if (cols[col] != 0)
			return false;

		for (int i = 1; i <= n; i++) {
			if (cols[i] != 0 && Math.abs(cols[i] - row) == Math.abs(col - i)) {
				return false;
			}
		}
		return true;
	}

}
