package BaekJoon;

import java.util.*;

public class BaekJoon2178_2 {

	static int n, m;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int ans = 0;
	static int[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		visit = new int[n][m];
		map = new int[n][m];
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			char[] temp = sc.nextLine().toCharArray();
			for (int j = 0; j < m; j++)
				map[i][j] = temp[j] - '0';
		}

		System.out.println(bfs());
	}

	public static class Point {
		int x;
		int y;
		int depth;

		public Point(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;

		}
	}

	public static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1));
		visit[0][0] = 1;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nd = cur.depth + 1;
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (visit[nx][ny] == 0 && map[nx][ny] == 1) {
						visit[nx][ny] = 1;
						q.add(new Point(nx, ny, nd));
					}

					if (nx == n - 1 && ny == m - 1) {
						return nd;
					}
				}
			}
		}
		return -1;
	}

}
