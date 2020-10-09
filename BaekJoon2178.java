package BaekJoon;

import java.util.*;

public class BaekJoon2178 {

	static int n, m;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int ans;
	static int[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		ans = n * m;

		visit = new int[n][m];
		map = new int[n][m];
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			char[] temp = sc.nextLine().toCharArray();
			for (int j = 0; j < m; j++)
				map[i][j] = temp[j] - '0';
		}

		dfs(1, 0, 0);

		System.out.println(ans);
	}

	public static void dfs(int depth, int startX, int startY) {
		if (startX == (n - 1) && startY == (m - 1)) {
			ans = (ans > depth) ? depth : ans;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextX = startX + dx[i];
			int nextY = startY + dy[i];
			if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
				if (map[nextX][nextY] == 1 && visit[nextX][nextY] == 0) {
					visit[nextX][nextY] = 1;
					dfs(depth + 1, nextX, nextY);
					visit[nextX][nextY] = 0;
				}
			}
		}
	}
}
