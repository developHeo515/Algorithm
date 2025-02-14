//BOJ18258 큐, 실5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			
			if(tmp.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				dq.add(num);
			}else if(tmp.equals("front")) {
				if(dq.isEmpty()) {
					bw.write(-1 + "\n");
				}else {
					bw.write(dq.peekFirst() + "\n");
				}
			}else if(tmp.equals("back")) {
				if(dq.isEmpty()) {
					bw.write(-1 + "\n");
				}else {
					bw.write(dq.peekLast()+ "\n");
				}
			}else if(tmp.equals("size")) {
				bw.write(dq.size() + "\n");
			}else if(tmp.equals("empty")) {
				if(dq.isEmpty()) {
					bw.write(1 + "\n");
				}else {
					bw.write(0 + "\n");
				}
			}else if(tmp.equals("pop")) {
				if(dq.isEmpty()) {
					bw.write(-1 + "\n");
				}else {
					bw.write(dq.poll() + "\n");
				}
			}
			
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
