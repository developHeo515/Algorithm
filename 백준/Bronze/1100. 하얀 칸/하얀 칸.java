import java.io.*;
import java.util.*; 

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[][] arr = new char[8+1][8+1];
		
		for(int i = 1; i <= 8; i++) {
			String temp = br.readLine();
			for(int j = 1; j <= 8; j++) {
				char ch = temp.charAt(j-1);
				arr[i][j] = ch;
			}
		}
		
		int cnt = 0;
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++) {
				if(arr[i][j] == 'F' && (i+j) % 2 == 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}
