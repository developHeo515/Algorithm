//BOJ4673 셀프넘버
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] arr = new boolean[10001];
		
		for(int i = 1; i <= 10000; i++) {
			int N = i;
			int sum = 0;
			sum += N;
			
			while(N >= 10) {
				sum += N%10;
				N = N / 10;
			}
			sum += N;
			if(sum <= 10000) {
				arr[sum] = true;
			}
		}
		
		for(int i = 1; i <= 10000; i++) {
			if(!arr[i]) {
				System.out.println(i);
			}
		}
   
		bw.flush();
		bw.close();
		br.close();
	}
}
