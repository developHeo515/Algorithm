import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] a = new String[n];
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.next();
			max = Math.max(max, a[i].length());
		}
		
		for(int i = 0; i < n; i++) {
			if(a[i].length() < max) {
				for(int j = a[i].length(); j < max; j++) {
					a[i] += '0';
				}
			}
		}
		
		for(int i = 0; i < max; i++) {
			int total = 0;
			int count = 0;
			for(int j = 0; j < n; j++) {
				if(a[j].charAt(i) == '0') {
					total += 0;
					count++;
				}else {
					total += a[j].charAt(i);
				}
			}
			total = total / (n - count);
			System.out.print((char)total);
		}
		sc.close();
	}
}