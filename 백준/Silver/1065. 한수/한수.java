//BOJ1065 한수, 실버4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());

		int cnt = 0;
		if(num < 100) {
			bw.write(num + "\n");
		}
		else {
			cnt = 99;
			for(int i = 100; i <= num; i++)	{
				int a = i / 100;
				int b = (i/10) % 10;
				int c = i % 10;
				
				if((a - b) == (b - c)) {
					cnt++;
				}
			}
			bw.write(cnt + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
