import java.util.*;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int h1, h2, m1, m2, s1, s2, h, m, s, total1 = 0, total2 = 0;
		
		for(int i = 0; i < 3; i++) {
			h1 = sc.nextInt();
			m1 = sc.nextInt();
			s1 = sc.nextInt();
			h2 = sc.nextInt();
			m2 = sc.nextInt();
			s2 = sc.nextInt();
			total1 = 3600 * h1 + 60 * m1 + s1;
			total2 = 3600 * h2 + 60 * m2 + s2;
			
			total2 = total2 - total1;
			h = total2 / 3600;
			m = total2 / 60 % 60;
			s = total2 % 60;
			System.out.println(h + " " + m + " " + s);
		}
		sc.close();
	}
}