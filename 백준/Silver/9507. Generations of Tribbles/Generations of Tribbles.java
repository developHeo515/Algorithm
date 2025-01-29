//BOJ9507 Generations of Tribbles, 실4
//DP
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			long[] arr = new long[n+1];
			for(int i = 0; i <= n; i++) {
				if(i < 2) {
					arr[i] = 1;
				}
				else if(i == 2) {
					arr[i] = 2;
				}
				else if(i == 3) {
					arr[i] = 4;
				}
				else {
					arr[i] = arr[i-1] + arr[i-2] + arr[i-3] + arr[i-4];
				}
			}
			
			System.out.println(arr[n]);
		}
		
//		bw.flush();
//		bw.close();
//		br.close();
	}
}
