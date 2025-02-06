//BOJ20492 세금, 브5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int num = Integer.parseInt(br.readLine());
		
		int a = (int)(num * 0.78);
		int b = (int)(num - (num*0.2) * 0.22);
		
		bw.write(a + " " + b +"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
