//BOJ 11399 ATM 실버4
import java.io.*;
import java.util.*;

public class Main {
	static int N, total, num;
	static int[] arr, totalArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		totalArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		
		for(int i = 0; i < N; i++) {
			num += arr[i];
			total += num;
		}
		System.out.println(total);
		
	}
}
