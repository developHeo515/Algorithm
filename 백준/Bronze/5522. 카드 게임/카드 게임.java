//BOJ5522 카드 게임 브5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum  =  0;
		for(int i = 0; i < 5; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
		}
		System.out.println(sum);
	}
}