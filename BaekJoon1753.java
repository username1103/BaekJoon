package BaekJoon;

import java.io.*;
import java.util.*;

public class BaekJoon1753 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int s = Integer.parseInt(br.readLine());

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
		}
		
		Djikstra(s,map,n);
	}

	public static void Djikstra(int start, List<Edge>[] map, int n) {
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(start, start, 0));
		int[] length = new int[n + 1];
		Arrays.fill(length, Integer.MAX_VALUE);
		
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
		
		for(int i =1 ; i <= n ; i ++) {
			if(length[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(length[i]);
			}
			
		}
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
