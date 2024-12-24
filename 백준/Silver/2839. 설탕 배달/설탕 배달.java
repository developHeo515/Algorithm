//BOJ2839 설탕 배달, 실버4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		//봉지는 3킬로그램 봉지와 5킬로그램 봉지
		//최대한 적은 봉지
		
		if(N == 4 || N == 7) {
			bw.write(-1 + "\n");
		}
		else if(N % 5 == 0) {
			bw.write(N/5 + "\n");
		}
		else if(N % 5 == 1 || N % 5 == 3) {
			bw.write((N/5) + 1 +"\n");
		}
		else if(N % 5 == 2 || N % 5 == 4) {
			bw.write((N/5) + 2 + "\n");
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
