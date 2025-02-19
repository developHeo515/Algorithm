//BOJ11966 2의 제곱인가?, 브3
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int ans = 3;
		
		while(true) {
			if(N % 2 != 0) {
				break;
			}else {
				N /= 2;
			}
		}
		
		if(N == 1) {
			ans = 1;
		}else {
			ans = 0;
		}
		
		System.out.println(ans);

	}
}
