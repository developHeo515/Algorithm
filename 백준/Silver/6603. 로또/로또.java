import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            int[] arr = new int[k];
            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, new ArrayList<>(), arr);
            System.out.println();
        }
        br.close();
    }
    static void dfs(int depth, int start, List<Integer> list, int[] arr){
        if(depth == 6){
            for(int n : list){
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < arr.length; i++){
            list.add(arr[i]);
            dfs(depth + 1, i + 1, list, arr);
            list.remove(list.size() - 1);
        }
    }
}
