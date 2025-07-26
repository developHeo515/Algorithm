import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int gcd = 0;
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 1; i < N; i++){
            gcd = gcd(arr[i] - arr[i-1], gcd);
        }
        
        System.out.println((arr[N-1] - arr[0]) / gcd +1 - arr.length);

        bw.flush();
        bw.close();
        br.close();
    }
    
    static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
