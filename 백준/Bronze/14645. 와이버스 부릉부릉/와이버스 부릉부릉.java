import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String name = "비와이";
		int sum = sc.nextInt();
		for (int i = 0; i < N; i++) {
			sum += sc.nextInt();
			sum -= sc.nextInt();
		}

		System.out.println(name);
	}
}