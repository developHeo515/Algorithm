//BOJ1312 소수, 실5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int res = 0;
		
		for(int i = 0; i < n; i++) {
			a = (a % b) * 10;
			res = a / b;
		}
		
		bw.write(res + "\n");
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
