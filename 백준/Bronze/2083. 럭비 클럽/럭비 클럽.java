import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String name = "";
		int age = 1;
		int weight = 1;
		while(age != 0 && weight != 0 ) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			age = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
//			System.out.println(name +  " " +age + " " + weight);
			
			boolean flag = true;
			
			if(age == 0 && weight == 0) {
				break;
			}
			
			if(age > 17 ) {
				flag = false;
			}else if(weight >= 80) {
				flag = false;
			}
			
			if(flag) {
				bw.write(name + " " + "Junior\n");
			}else {
				bw.write((name + " " + "Senior\n"));
			}
		}
		bw.flush();
		bw.close();
		
	}
}
