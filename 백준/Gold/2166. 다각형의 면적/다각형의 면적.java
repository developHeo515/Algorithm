//BOJ2166 다각형의 면접, 골드5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr= new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i][0] = x;
			arr[i][1] = y;
		}
		
		double sumX = 0;
		double sumY = 0;
		for(int i = 0; i < N; i++) {
			sumX += (double) arr[i][0] * arr[(i+1) % N][1];
			sumY += (double) arr[(i+1) % N][0] * arr[i][1];				
			
		}
		
		double sum = Math.abs(sumX - sumY);
		sum /= 2;
		
		
		System.out.printf("%.1f", sum);
//		bw.write(sum + "\n");
//		bw.flush();
//		bw.close();
//		br.close();
	}
}
