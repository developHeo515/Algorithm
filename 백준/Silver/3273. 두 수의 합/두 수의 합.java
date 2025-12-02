import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean finish = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int x = 0;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        x = Integer.parseInt(br.readLine());
//        System.out.println(Arrays.toString(arr));

        //투포인터
        int l = 0;
        int r = arr.length - 1;
        while(l != r){
            if(arr[l] + arr[r] == x){
                result++;
                l++;
            }
            else if(arr[l] + arr[r] < x){
                l++;
            }
            else if(arr[l] + arr[r] > x){
                r--;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}