//BOJ1475 방 번호, 실5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int[] arr = new int[9];
        
        for(int i = 0; i < str.length(); i++) {
        	int n = str.charAt(i) - '0';
        	
        	if(n == 9) n = 6;
        	arr[n]++;
        }
        
        arr[6] = arr[6]/2 + arr[6]%2;
        
        int max = 0;
        for(int i = 0; i < 9; i++) {
        	max = Math.max(max, arr[i]);
        }
        
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
	}
}
