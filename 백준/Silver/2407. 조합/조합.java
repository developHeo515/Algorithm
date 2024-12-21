//BOJ2407 조합, 실3
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger bigN = BigInteger.ONE;
		BigInteger bigM = BigInteger.ONE;
		for(int i = 0; i < m; i++) {
			bigN = bigN.multiply(new BigInteger(String.valueOf(n-i)));
			bigM = bigM.multiply(new BigInteger(String.valueOf(i+1)));
		}
//		bw.write(bigN + " " + bigM + "\n");
		bw.write(bigN.divide(bigM) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
