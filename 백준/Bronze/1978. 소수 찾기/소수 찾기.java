import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
        int N = Integer.parseInt(br.readLine());
        int num;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        
        for (int i =0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            for(int j = 2; j <= num; j++) {
                if(j == num) {
                    cnt++;
                }
                if(num % j == 0) {
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}