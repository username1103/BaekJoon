package BaekJoon;

import java.util.Scanner;

public class BeakJoon1717_2 {

	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		Union union = new Union(n);

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

class Union {
	class Node {
		int head;
		int depth;

		public Node(int head, int depth) {
			this.head = head;
			this.depth = depth;
		}
	}

	Node arr[];

	public Union(int n) {
		arr = new Node[n + 1];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Node(i, 1);
		}
	}

	void merge(int a, int b) {
		int aHead = find(a);
		int bHead = find(b);

		if (arr[aHead].depth == arr[bHead].depth) {
			arr[aHead].depth += 1;
			arr[bHead].head = aHead;
		} else if (arr[aHead].depth > arr[bHead].depth) {
			arr[bHead].head = aHead;
		} else {
			arr[aHead].head = bHead;
		}

	}

	int find(int n) {
		if (arr[n].head == n)
			return n;

		return arr[n].head = find(arr[n].head);
	}
}
