package BaekJoon;

import java.io.*;
import java.util.*;

// prim : 임의의 정점에서 최소간선트리

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
		
		// len이 가장 작도록 queue안의 edge를 정렬
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		edges.add(new Edge(start, start, 0));
		int sum = 0;
		
		// q가 빌 때 까지
		while (!edges.isEmpty()) {
			
			// q에서 꺼내어 해당 edge의 도착점과 len
			Edge temp = edges.poll();
			int cur = temp.v2;
			int len = temp.len;

			// 이미 방문했다면 다음 q의 원소로
			if (visit[cur]) {
				continue;
			} else {
				// 방문하지 않았다면 방문 표시 후, len더하기.
				visit[cur] = true;
				sum += len;
			}
			
			// 해당 정점에서 연결되어 있는 간선 추가
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
