import java.io.*;
import java.util.*;
		
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			if(temp.length() >= 6 && temp.length()  <= 9) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
}
