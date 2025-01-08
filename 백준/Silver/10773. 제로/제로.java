//BOJ10773 제로, 실4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num != 0) {
				stack.add(num);
			}
			else {
				stack.pop();
			}
		}
		
		int sum = 0;
		for(int cur : stack) {
			sum += cur;
		}
		
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
