//BOJ1058 친구, 실버2
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int arr[][];
	static int max = 987654321;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			String temp = br.readLine();
			for(int j = 1; j <= N; j++) {
				char ch = temp.charAt(j-1);
				
				if(ch == 'Y') {
					arr[i][j] = 1;
				}else if(i != j)
					arr[i][j] = max;
			}
		}
		
		//플로이드 워샬
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i == j) continue;
					if(arr[i][j] > arr[i][k] + arr[k][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			int tmp = 0;
			
			for(int j = 1; j <= N; j++) {
				if(i == j)
					continue;
				else if(arr[i][j] <= 2) {
					tmp = tmp + 1;
				}
			}
			
			ans = Math.max(ans, tmp);
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
