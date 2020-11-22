package BaekJoon;

// krusckal : 간선의 len이 제일 작은거부터 해서 만든 최소 간선트리

import java.io.*;
import java.util.*;

public class BaekJoon1197 {

	static int n, m;
	static int output = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// Scanner sc = new Scanner(System.in);
		// n = sc.nextInt();
		// m = sc.nextInt();

		Union union = new Union(n + 1);
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		// List<Edge> edges = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			StringTokenizer s_temp = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(s_temp.nextToken());
			int to = Integer.parseInt(s_temp.nextToken());
			int len = Integer.parseInt(s_temp.nextToken());

			// int start = sc.nextInt();
			// int to = sc.nextInt();
			// int len = sc.nextInt();

			Edge temp = new Edge(start, to, len);
			pq.add(temp);
			// edges.add(temp);
		}

		// Collections.sort(edges);

		while (!pq.isEmpty()) {
			Edge temp = pq.poll();
			int v1 = temp.start;
			int v2 = temp.to;

			v1 = union.find(v1);
			v2 = union.find(v2);

			if (v1 != v2) {
				union.merge(v1, v2);
				output += temp.len;
			}
		}

		System.out.println(output);

	}

}

class Edge implements Comparable<Edge> {

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
