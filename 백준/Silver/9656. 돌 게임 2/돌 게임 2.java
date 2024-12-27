//BOJ9656 돌 게임2, 실5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N % 2 == 0) {
			bw.write("SK" + "\n");
		}
		else {
			bw.write("CY" + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
