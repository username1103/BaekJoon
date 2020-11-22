package BaekJoon;

import java.io.*;
import java.util.*;

public class BaekJoon1504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Edge>[] map = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			map[start].add(new Edge(start, to, len));
			map[to].add(new Edge(to, start, len));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int s_v1 = Dijkstra(1, v1, map, n);
		int s_v2 = Dijkstra(1, v2, map, n);
		int v1_v2 = Dijkstra(v1, v2, map, n);
		int v1_e = Dijkstra(v1, n, map, n);
		int v2_e = Dijkstra(v2, n, map, n);
		
		// 문제가 이상한거 같음..... s에서 v1이나 v2에 못가는 경우 를 하지않앗음.. 뒤에부분 없이했는데 맞습니다 나옴.
		if (Dijkstra(1, n, map, n) == Integer.MAX_VALUE || s_v1==Integer.MAX_VALUE || s_v2==Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(Math.min(s_v1 + v1_v2 + v2_e, s_v2 + v1_v2 + v1_e),
					Math.min(s_v1 + 2 * v1_v2 + v1_e, s_v2 + 2 * v1_v2 + v2_e)));
		}

	}

	public static int Dijkstra(int start, int end, List<Edge>[] map, int n) {

		// length 초기화
		int[] length = new int[n + 1];
		Arrays.fill(length, Integer.MAX_VALUE);

		// 큐 생성 후 시작 값
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(start, start, 0));

		while (!q.isEmpty()) {
			Edge e = q.poll();
			int select = e.to;
			int len = e.len;

			if (length[select] < len)
				continue;

			length[select] = len;

			for (Edge edge : map[select]) {
				int next = edge.to;
				int nLen = len + edge.len;

				if (nLen < length[next]) {
					q.add(new Edge(select, next, nLen));
				}
			}
		}

		return length[end];
	}

	static class Edge implements Comparable<Edge> {

		int start, to, len;

		public Edge(int start, int to, int len) {
			this.start = start;
			this.to = to;
			this.len = len;
		}

		@Override
		public int compareTo(Edge o) {
			return len - o.len;
		}

	}
}
