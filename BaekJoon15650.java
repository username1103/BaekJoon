package BaekJoon;

import java.util.Scanner;

public class BaekJoon15650 {
	static int[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		visit = new int[n+1];

		dfs(0, n, m, 0, "");
	}

	static void dfs(int depth, int n, int m, int start, String answer) {
		if (depth == m) {
			System.out.println(answer.substring(0,answer.length()-1));
			return;
		}

		for (int i = start+1; i <= n; i++) {
			if (visit[i] == 0) {
				visit[i] = 1;
				dfs(depth + 1, n, m, i, answer + i + " ");
				visit[i] = 0;
			}
		}
	}
}
