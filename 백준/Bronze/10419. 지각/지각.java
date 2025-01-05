//BOJ10419 지각, 브4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++){
			int d = Integer.parseInt(br.readLine());
			
			int time = 0;
			while(true) {
				if(time + time*time <= d) {
					time++;
				}
				else
					break;
			}
			bw.write(time-1 + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
