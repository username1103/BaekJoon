package BaekJoon;

import java.util.Scanner;

public class BaekJoon1717 {

	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		Union_1 union = new Union_1(n);

		sc.nextLine();
		
		for (int i = 0; i < m; i++) {
			String[] temp = sc.nextLine().split(" ");
			if (temp[0].equals("0")) {
				union.merge(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
			} else {
				int head_1 = union.find(Integer.parseInt(temp[1]));
				int head_2 = union.find(Integer.parseInt(temp[2]));
				if (head_1 == head_2) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}

			}
		}
	}
}

class Union_1 {

	public static int arr[];

	public Union_1(int n) {
		arr = new int[n + 1];

		for (int i = 0; i < arr.length; i++)
			arr[i] = i;
	}

	public void merge(int a, int b) {
		int aHead = find(a);
		int bHead = find(b);

		if (arr[aHead] != arr[bHead])
			arr[bHead] = aHead;
	}

	public int find(int n) {
		if (arr[n] == n)
			return n;

		return arr[n] = find(arr[n]);
	}
}
