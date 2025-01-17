//BOJ2163 초콜릿 자르기, 브1
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//2*3  -> 5번
		int res = N-1 + (M-1) * N;
				
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
