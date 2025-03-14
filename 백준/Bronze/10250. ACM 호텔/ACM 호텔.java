import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스
 
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
 
			if (N % H == 0) {
				int num = (H * 100) + (N / H);
				bw.write(num + "\n");
 
			} else {
				int num = ((N % H) * 100) + ((N / H) + 1);
				bw.write(num + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
