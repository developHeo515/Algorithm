//BOJ9655 돌 게임, 실5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N % 2 == 1) {
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
