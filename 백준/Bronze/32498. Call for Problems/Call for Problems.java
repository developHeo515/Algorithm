import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0 ;
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num % 2 == 1) cnt++;
		}
		System.out.println(cnt);
		
	}
}
