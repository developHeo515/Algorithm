import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i = n-1; i > 0; i--){
            for(int j = 0; j <= i-1 && cnt < k; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    cnt++;
                }
            }
        }

        if(cnt < k){
            bw.write(-1 + "\n");
        }
        else{
            for(int i = 0; i < n; i++){
                bw.write(arr[i] + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}