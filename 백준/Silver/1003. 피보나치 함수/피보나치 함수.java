// BOJ 1003 피보나치 함수 실버3
// DP를 배우기 전에 피보나치 함수 개념을 알아야 한다.
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] fibo0 = new int[45];
			int[] fibo1 = new int[45];
			fibo0[0] = 1;
			fibo0[1] = 0;
			fibo1[0] = 0;
			fibo1[1] = 1;
			for(int k = 2; k <= n; k++) {
				fibo0[k] = fibo0[k-1] + fibo0[k-2];
				fibo1[k] = fibo1[k-1] + fibo1[k-2];
			}
			System.out.println(fibo0[n] + " "+ fibo1[n]);
			
		}
	}
}
