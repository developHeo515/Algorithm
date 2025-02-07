//BOJ3046 R2
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R1 = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int res = 0;
		
		S *= 2;
		
		res = S - R1;
				
		bw.write(res+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
