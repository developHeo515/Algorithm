//BOJ5555 반지, 실5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str1 = br.readLine();
		int cnt = 0;

		int N = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < N; t++) {
			String str2 = br.readLine();
			str2 += str2; //그냥 문자열 합치면 반지처럼 연결된거다.
			
			if(str2.contains(str1)) {
				cnt++;
			}
		}
		
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
