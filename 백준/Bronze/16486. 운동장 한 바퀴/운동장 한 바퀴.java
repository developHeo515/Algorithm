//BOJ16486 운동장 한 바퀴
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int d1 = Integer.parseInt(br.readLine());
		int d2 = Integer.parseInt(br.readLine());
		
		double res = d1 * 2 + 2 * 3.141592 * d2;
		
		
		bw.write(res + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
