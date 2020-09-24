package BaekJoon;

import java.io.*;

public class BaeKJoon1992 {
	static int[][] input;
	
	static String ans="";
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		input = new int[size][size];
		for(int i = 0; i<size;i++) {
			String[] temp = (br.readLine()).split("");
			for(int j =0; j<size;j++) {
				input[i][j]=Integer.parseInt(temp[j]);
			}
		}
		
		if(!check(0,0,size)) Quad_tree(0,0,size);
		
		System.out.println(ans);
	}
	
	public static void Quad_tree(int x, int y, int size) {
		
		int n = size/2;
		
		ans+="(";
		if(!check(x,y,n)) Quad_tree(x,y,n);
		if(!check(x,y+n,n)) Quad_tree(x,y+n,n);
		if(!check(x+n,y,n)) Quad_tree(x+n,y,n);
		if(!check(x+n,y+n,n)) Quad_tree(x+n,y+n,n);
		ans+=")";
	}
	
	public static boolean check(int x, int y, int size) {
		
		int cnt = 0;
		
		for(int i=x; i<x+size;i++)
			for(int j=y;j<y+size;j++)
				cnt+=input[i][j];
		
		if(cnt == 0)
			ans+= '0';
		else if(cnt ==size*size)
			ans+= '1';
		else
			return false;
		
		return true;
	}
}
