//BOJ1436 영화감독 숌, 실5
//처음에 문제 이해를 잘못했다.
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int num = 666;
		int cnt = 1;
		
		while(N != cnt) {
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
			
		}
		
		System.out.println(num);
	}
}
