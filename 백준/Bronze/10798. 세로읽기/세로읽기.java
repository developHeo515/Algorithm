import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        char[][] arr = new char[5][15];

        for(int i = 0; i < 5; i++){
            str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                arr[i][j] = str.charAt(j);
//                bw.write(str.charAt(j) + " ");
            }

            if(str.length() < 15){
                for(int j = str.length(); j < 15; j++){
                    arr[i][j] = '@';
                }
            }

//            bw.write("\n");
        }

        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
//                bw.write(arr[i][j] + " ");
                if(arr[j][i] != '@'){
                    bw.write(arr[j][i]);
                }
            }
//            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
