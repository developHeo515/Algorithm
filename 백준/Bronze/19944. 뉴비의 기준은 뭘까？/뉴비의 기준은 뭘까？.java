//BOJ19944 뉴비의 기준은 뭘까?, 브4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(M == 1 || M == 2) {
			System.out.println("NEWBIE!");
		}
		else if(N >= M) {
			System.out.println("OLDBIE!");
		}
		else {
			System.out.println("TLE!");
		}
	}
}
