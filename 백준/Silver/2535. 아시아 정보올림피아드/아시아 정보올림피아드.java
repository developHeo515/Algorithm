import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o2[2] - o1[2];
           }
        });

        int medal = 2;
        if(arr[0][0] == arr[1][0]){
            for(int i = 2; i < n; i++){
                if(arr[0][0] != arr[i][0]){
                    medal = i;
                    break;
                }
            }
        }
        System.out.println(arr[0][0] + " " + arr[0][1]);
        System.out.println(arr[1][0] + " " + arr[1][1]);
        System.out.println(arr[medal][0] + " " + arr[medal][1]);
    }
}
