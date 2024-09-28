//BOJ2417 정수 제곱근, 실버4
//처음에는 이 문제와 이분탐색이 어떤 접점이 있는지 이해하기 어려웠음
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long num = Long.parseLong(br.readLine());
		long sqrt = (long) Math.sqrt(num);
		
		if(sqrt * sqrt < num) {
			sqrt++;
		}
		System.out.println(sqrt);


	
	}
}
