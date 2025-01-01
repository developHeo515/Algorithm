//BOJ11656 접미사 배열, 실4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp = br.readLine();
		int size = temp.length();
		String[] str = new String[size];
		
		for(int i = 0; i < size; i++) {
			str[i] = temp.substring(i);
		}
		
		Arrays.sort(str);
		for(String res : str) {
			System.out.println(res);
		}
	}
}
