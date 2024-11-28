import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = 0;
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = Math.max(arr[i], num);
			}
			System.out.println("Case #" + i + ": " + arr[i]);
		}

//		for(int i = 1; i <= n; i++) {
//			System.out.print(arr[i] + "\n");
//		}
		
	}
}
