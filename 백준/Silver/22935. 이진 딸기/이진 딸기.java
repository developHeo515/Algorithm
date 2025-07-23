import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int N;
        String str = "";
        String result = "";
        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine()) - 1;
            N = N % 28;

            if(N < 15){
                str = Integer.toBinaryString(N + 1);
                while(str.length() < 4){
                    str = "0" + str;
                }
                result = func(str);
                System.out.println(result);
            }
            else{
                str = Integer.toBinaryString(29-N);
                while(str.length() < 4){
                    str = "0" + str;
                }
                result = func(str);
                System.out.println(result);
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }
    static String func(String str){
        String res = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)-48 == 0){
                res = res + "V";
            }
            else if(str.charAt(i) == '1'){
                res = res + "딸기";
            }
        }
        return res;
    }
}
