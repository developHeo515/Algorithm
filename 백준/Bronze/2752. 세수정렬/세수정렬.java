//BOJ2752 세수정렬, 브4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[3];
		
		for(int i = 0; i < 3; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		Arrays.sort(arr);

		for(int i = 0; i < 3; i++) {
			bw.write(arr[i] + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
