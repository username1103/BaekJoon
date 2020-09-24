package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class BaekJoon1260 {
	static int[][] arr;
	static int point_cnt;
	static int edge_cnt;
	static int a_start_point;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] temp = (br.readLine()).split(" ");
		
		point_cnt = Integer.parseInt(temp[0]);
		edge_cnt = Integer.parseInt(temp[1]);
		a_start_point = Integer.parseInt(temp[2]);
		
		arr = new int[point_cnt+1][point_cnt+1];
		visited = new int[point_cnt+1];
		
		for(int i = 0; i <edge_cnt; i++) {
			String[] edge = (br.readLine()).split(" ");
			arr[Integer.parseInt(edge[0])][Integer.parseInt(edge[1])] += 1;
			arr[Integer.parseInt(edge[1])][Integer.parseInt(edge[0])] += 1;
		}
		
		sb.append(a_start_point);
		visited[a_start_point] = 1;
		DFS(a_start_point,sb);
		System.out.println(sb);
		
		visited = new int[point_cnt + 1];
		
		BFS(a_start_point);
	}
	
	public static void DFS(int start_point,StringBuilder sb) {
		for(int i = 1; i <= point_cnt; i++) {
			if(arr[start_point][i]==1 && visited[i]==0) {
				visited[i] = 1;
				sb.append(" " + i);
				DFS(i,sb);
			}
		}
	}
	
	public static void BFS(int start_point) {
		Queue<Integer> q = new LinkedList<>(); 
		q.add(start_point);
		visited[start_point] = 1;
		System.out.print(start_point);
		while(!q.isEmpty()) {
			start_point = q.poll();
			for(int i = 1; i <= point_cnt; i++) {
				if(arr[start_point][i] == 1 && visited[i] ==0) {
					visited[i]=1;
					q.add(i);
					System.out.print(" " + i);
				}
			}
		}
		
	}
}
