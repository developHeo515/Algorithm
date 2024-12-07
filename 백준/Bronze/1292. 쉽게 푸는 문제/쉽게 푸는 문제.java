import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int result = 0;
		
		for(int i = 1; i <= b; i++) {
			for(int j = 1; j <= i; j++) { 
				cnt++;
				if(a <= cnt && cnt <= b) { 
					result += i; 
				}
			}
		}
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
