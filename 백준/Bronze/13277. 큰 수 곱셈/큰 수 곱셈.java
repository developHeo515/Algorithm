//BOJ13277 큰 수 곱셈, 브5
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        BigInteger numA = new BigInteger(st.nextToken());
        BigInteger numB = new BigInteger(st.nextToken());
		
        System.out.println(numA.multiply(numB));
	}
}
