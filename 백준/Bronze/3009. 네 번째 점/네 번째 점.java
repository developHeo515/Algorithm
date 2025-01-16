//BOJ3009 네 번째 점
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[][] square = new int[4][2];
		
		for(int k = 0; k < 3; k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			square[k][0] = a;
			square[k][1] = b;
		}
		
		if(square[0][0] == square[1][0]) {
			square[3][0] = square[2][0];
		}else if(square[0][0] == square[2][0]) {
			square[3][0] = square[1][0];
		}else {
			square[3][0] = square[0][0];
		}
		
		if(square[0][1] == square[1][1]) {
			square[3][1] = square[2][1];
		}else if(square[0][1] == square[2][1]) {
			square[3][1] = square[1][1];
		}else {
			square[3][1] = square[0][1];
		}
		
		bw.write(square[3][0] + " " + square[3][1] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
