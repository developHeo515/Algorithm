import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		char[] arr = new char[n];
		
		String temp = br.readLine();
		for(int i = 0 ; i < n; i++) {
			arr[i] = temp.charAt(i);
		}
		
		for(int i = 0 ; i < n; i++) {
			if(i == n-1) {
				if(arr[i] == 'G') {
					continue;
				}else {
					System.out.print(arr[i] + "" + 'G');
				}
				
			}else {
				System.out.print(arr[i]);
			}
		}
	}
}
