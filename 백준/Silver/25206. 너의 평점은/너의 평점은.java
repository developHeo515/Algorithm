import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		double result = 0;
		double credit_sum  = 0;
		
		for(int i = 0; i < 20; i++) {
			double grade = 0;
			
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			double credit  = Double.parseDouble(st.nextToken());
			String alpha = st.nextToken();

			switch(alpha.charAt(0)) {
			case 'A' :
				if(alpha.charAt(1) == '+')
					grade += 4.5;
				else
					grade += 4.0;
				break;
			case 'B' :
				if(alpha.charAt(1) == '+')
					grade += 3.5;
				else 
					grade += 3.0;
				break;
			case 'C' :
				if(alpha.charAt(1) == '+')
					grade += 2.5;
				else 
					grade += 2.0;
				break;
			case 'D' :
				if(alpha.charAt(1) == '+')
					grade += 1.5;
				else 
					grade += 1.0;
				break;
			case 'F':
				grade += 0;
				break;
			case 'P':
				grade += 0;
				credit = 0;
				break;
			}
			credit_sum  += credit;
			result += credit*grade;
//			System.out.println(total + " "  + result);
		}
//		System.out.println(result  + " " + credit_sum );
		System.out.println(result / credit_sum );
		bw.flush();
		bw.close();
		br.close();
	}
}
