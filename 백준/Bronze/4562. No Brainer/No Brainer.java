//BOJ4562 No Brainer, 브4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a >= b) {
				bw.write("MMM BRAINS" + "\n");
			}else {
				bw.write("NO BRAINS" + "\n");
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
