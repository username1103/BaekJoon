package BaekJoon;

import java.io.*;
import java.util.*;

// prim : ������ �������� �ּҰ���Ʈ��

/*
3 3
1 2 1
2 3 2
1 3 3
*/

public class Prim_1197_2 {

	static int map[][];
	static boolean visit[];
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n];
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st_1 = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st_1.nextToken());
			int to = Integer.parseInt(st_1.nextToken());
			int len = Integer.parseInt(st_1.nextToken());

			map[start - 1][to - 1] = len;
			map[to - 1][start - 1] = len;
		}

		System.out.println(prim(0));
	}

	public static int prim(int start) {
		
		// len�� ���� �۵��� queue���� edge�� ����
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		edges.add(new Edge(start, start, 0));
		int sum = 0;
		
		// q�� �� �� ����
		while (!edges.isEmpty()) {
			
			// q���� ������ �ش� edge�� �������� len
			Edge temp = edges.poll();
			int cur = temp.v2;
			int len = temp.len;

			// �̹� �湮�ߴٸ� ���� q�� ���ҷ�
			if (visit[cur]) {
				continue;
			} else {
				// �湮���� �ʾҴٸ� �湮 ǥ�� ��, len���ϱ�.
				visit[cur] = true;
				sum += len;
			}
			
			// �ش� �������� ����Ǿ� �ִ� ���� �߰�
			for (int i = 0; i < n; i++) {
				if (map[cur][i] != Integer.MAX_VALUE) {
					edges.add(new Edge(cur, i, map[cur][i]));
				}
			}

		}
		
		return sum;
	}

	static class Edge implements Comparable<Edge> {
		int v1, v2, len;

		public Edge(int v1, int v2, int len) {
			this.v1 = v1;
			this.v2 = v2;
			this.len = len;
		}

		@Override
		public int compareTo(Edge o) {
			return len - o.len;
		}

	}
}
