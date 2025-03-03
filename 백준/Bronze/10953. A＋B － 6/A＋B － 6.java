//BOJ10953 A+B - 6, 브3
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(a + b + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
