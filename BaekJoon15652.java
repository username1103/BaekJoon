package BaekJoon;

import java.io.*;
import java.util.*;

public class BaekJoon15652 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		dfs(0, n, m,1, "");
		bw.flush();
	}

	static void dfs(int depth, int n, int m,int start, String answer) throws IOException {
		if (depth == m) {
			bw.write(answer.substring(0,answer.length()-1)+ "\n");
			return;
		}

		for (int i = start; i <= n; i++) {
			dfs(depth + 1, n, m,i,answer + i + " ");
		}
	}
}
