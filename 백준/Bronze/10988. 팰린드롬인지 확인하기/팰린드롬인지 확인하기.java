//BOJ10988 팰린드롬인지 확인하기, 브3
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		boolean flag = true;

		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				flag = false;
			}
		}
		
		if(flag) {
			bw.write(1 + "\n");
		}else {
			bw.write(0 + "\n");
		}
			
		bw.flush();
		bw.close();
		br.close();
	}
}
