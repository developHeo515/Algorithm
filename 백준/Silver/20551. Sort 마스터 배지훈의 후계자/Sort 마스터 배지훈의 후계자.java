//BOJ20551 Sort 마스터 배지훈의 후계자, 실4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N, M;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		
		Arrays.sort(arr);
		
//		System.out.println(Arrays.toString(arr));
		
		for(int i = 0; i < M; i++) {
			int search = Integer.parseInt(br.readLine());
			
			int res = -1;
			int low = 0;
			int high = N - 1;

			
			while(low <= high) {
//				System.out.println(low + " " + high);
				int mid = (low + high) / 2;
				
				if(arr[mid] == search) {
					res = mid;
					high = mid - 1; //같은 값 중에 가장 왼쪽값 찾아야함
				}else if(arr[mid] < search) {
					low = mid + 1;
				}else if(search < arr[mid]) {
					high = mid - 1;
				}
			}
			bw.write(res + "\n");	
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
