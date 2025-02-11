//BOJ4999 아!, 브5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		if(str1.length() >= str2.length()) {
			bw.write("go" + "\n");
		}else {
			bw.write("no" + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
