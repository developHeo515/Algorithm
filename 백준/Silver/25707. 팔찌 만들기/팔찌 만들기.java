import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
//            System.out.println(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        int sum = 0;
        for(int i = 0; i < N-1; i++){
            sum += Math.abs(arr[i] - arr[i+1]);
//            System.out.print(arr[i] + " ");
        }
        sum += Math.abs(arr[N-1] - arr[0]);

        System.out.println(sum);

        bw.flush();
        br.close();
        bw.close();
    }
}