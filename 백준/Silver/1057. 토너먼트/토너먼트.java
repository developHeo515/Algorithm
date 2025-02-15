//BOJ1057 토너먼트, 실4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		int cnt = 0;

		while(a != b) {
			a = a/2 + a%2;
			b = b/2 + b%2;
			cnt++;
		}
		
		
		System.out.println(cnt);
		br.close();
	}
}
