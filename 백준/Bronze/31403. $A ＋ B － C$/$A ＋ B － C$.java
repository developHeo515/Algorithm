//BOJ31403 A + B - C, 브4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();
		
		int a = Integer.parseInt(A);
		int b = Integer.parseInt(B);
		int c = Integer.parseInt(C);
		
		System.out.println(a + b - c);
		String AB = A + B;
		int res = Integer.parseInt(AB);
		System.out.println(res - c);
		
		
	}
}
