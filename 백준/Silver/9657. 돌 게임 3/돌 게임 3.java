//BOJ9657 돌 게임3, 실3
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		bw.write((N % 7 == 0 || N % 7 == 2) ? "CY" : "SK");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
