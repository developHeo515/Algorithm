import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr;

        String str = br.readLine();
        while(!str.equals("*")){
            arr = new int[26];

            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                int idx = (int)ch - 97;
//                System.out.println((int)ch - 97);
                if(0 <= idx && idx <= 25)
                   arr[idx]++;
            }

            boolean flag = true;
            for(int i = 0; i < 26; i++){
                if(arr[i] == 0){
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                bw.write("Y" + "\n");
            }else {
                bw.write("N" + "\n");
            }

            str = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
