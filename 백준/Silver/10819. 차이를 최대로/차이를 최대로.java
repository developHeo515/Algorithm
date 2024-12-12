//BOJ10819 차이를 최대로, 실버2
//백트래킹 문제, 백트래킹 너무 어렵다..
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] selected;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		back(0, -1, 0);
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static void back(int depth, int prevIdx, int sum) {
		if(depth == N) {
			//max 랑 합비교해서 max 값 정하기
//			System.out.println(sum);
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				
				if(prevIdx == -1) {
					back(depth + 1, i, sum);
				} 
				else {
				    sum += Math.abs(arr[prevIdx] - arr[i]);  //여기서 애먹음;
				    back(depth + 1, i, sum);
				    sum -= Math.abs(arr[prevIdx] - arr[i]);
				}
				//더 적합한 방안
//				else {
//				    int diff = Math.abs(arr[prevIdx] - arr[i]);
//				    back(depth + 1, i, sum + diff);
//				}


				
				selected[i] = false;;
			}
		}
	}
}
