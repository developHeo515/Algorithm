import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int count;
		
		count = (m - k) / l;
		
		if((m - k) % l != 0) {
			count++;
		}
		System.out.println(count);
		sc.close();
	}
}