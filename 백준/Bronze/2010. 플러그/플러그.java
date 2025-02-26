//BOJ2010 플러그, 브3
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int res = 0;
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			res += num;
		}
		res -= (N-1);
		
		System.out.println(res);
	}
}
