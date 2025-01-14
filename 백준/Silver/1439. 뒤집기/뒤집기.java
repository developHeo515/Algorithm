//BOJ1439 뒤집기, 실5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String temp = br.readLine();
		char first = temp.charAt(0);
		char current = temp.charAt(0);
		int cnt = 0;
		
		for(int i = 1; i < temp.length(); i++) {
			
			if(first != temp.charAt(i)) {
				if(current != temp.charAt(i)) {
					cnt++;
					current = temp.charAt(i);
				}
			}else {
				current = temp.charAt(i);
			}
		}
		
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
