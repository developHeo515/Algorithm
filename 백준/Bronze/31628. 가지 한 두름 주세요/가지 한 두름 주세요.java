import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String[][] arr = new String[10][10];
        int res = 0;

        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                arr[i][j] = st.nextToken();
            }
        }

        for(int i = 0; i < 10; i++){
            String str = arr[i][0];
            int cnt = 1;
            for(int j = 1; j < 10; j++){
                if(str.equals(arr[i][j])){
                    cnt++;
                }
                else {
                    break;
                }
            }
            if(cnt == 10) res = 1;
        }

        if(res == 0){
            for(int j = 0; j < 10; j++){
                String str = arr[0][j];
                int cnt = 1;
                for(int i = 1; i < 10; i++){
                    if(str.equals(arr[i][j])){
                        cnt++;
                    }
                    else {
                        break;
                    }
                }
                if(cnt == 10) res = 1;
            }
        }

        bw.write(res + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}