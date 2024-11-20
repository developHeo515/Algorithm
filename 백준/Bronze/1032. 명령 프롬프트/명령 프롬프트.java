import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] temp = new String[N];
		
		for(int i = 0; i < N; i++) {
			temp[i] = br.readLine();
		}
		
		int len = temp[0].length();
		for(int i = 0; i < temp[0].length(); i++) {
			char init = temp[0].charAt(i);
			boolean flag = true;
			
			for(int j = 1; j < N; j++) {
				if(init != temp[j].charAt(i)) 
					flag = false;
			}
			if(flag) {
				System.out.print(init);
			}else {
				System.out.print("?");
			}
		}
		
	}
}
