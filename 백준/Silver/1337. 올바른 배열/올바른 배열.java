//BOJ1337 올바른 배열, 실4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> arr = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr);
		
		int cnt = 0;
		int minCnt = 0;
		
		for(int i = 0; i < N; i++) {
			int standardNum = arr.get(i) + 4;
			
			for(int j = 0; j < N - i; j++) {
				int compareNum = arr.get(i + j);
				if(compareNum >= arr.get(i) && compareNum <= standardNum) {
					cnt++;
				}
			}
			minCnt = Math.max(cnt, minCnt);
			cnt = 0;
		}
		
		System.out.println(5 - minCnt);
		br.close();
	}
}
