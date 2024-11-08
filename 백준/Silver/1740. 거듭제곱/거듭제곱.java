//BOJ1740 거듭제곱, 실버3
 import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		long n = Long.parseLong(br.readLine());
		long threeN = 1;
		long ans = 0;
		
		while(n > 0) {
			if((n&1) == 1) {
				ans += threeN;
			}
			
			threeN *= 3;
			n = n >> 1;
		}
		System.out.println(ans);
	}
}
