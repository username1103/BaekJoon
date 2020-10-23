package BaekJoon;

import java.util.*;

public class BaekJoon7576 {

	static int[][] map;
	static int[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	// static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static int n;
	static int m;
	// static int h;
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		// h = sc.nextInt();

		map = new int[n][m];
		visit = new int[n][m];

		sc.nextLine();

		for (int i = 0; i < map.length; i++) {
			String[] temp = sc.nextLine().split(" ");
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if (map[i][j] == 1) {
					q.add(new Point(i, j, 0));
				}
			}
		}
		
		System.out.println(bfs());
	}

	public static int bfs() {
		int nd = 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				nd = cur.d + 1;
				if (0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length) {
					if (map[nx][ny] == 0) {
						map[nx][ny] = 1;
						q.add(new Point(nx, ny, nd));
					}
				}
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0)
					return -1;
			}
		}
		return nd - 1;
	}

	public static class Point {
		int x, y, d;

		Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

}
