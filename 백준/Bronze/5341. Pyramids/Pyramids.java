import java.util.*;

public class Main {
	public static void main(String[] args) {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n == 0) {
				System.exit(0);
			}
			result = solution(n);
			System.out.println(result);
		}
		
	}
	
	public static int solution(int n) {
		return n * (n+1) / 2; 
	}
}