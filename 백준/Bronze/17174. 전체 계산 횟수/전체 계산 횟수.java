import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M; 
		N = sc.nextInt();
		M = sc.nextInt();
		int sum = N;
		System.out.println(recursum(N, M, sum));
	}

	private static int recursum(int N, int M, int sum) {
		if (N / M < M) {
			return sum += N / M;
		} else {
			sum += N / M;
			N = N / M;
			return recursum(N, M, sum);
		}
	}

}