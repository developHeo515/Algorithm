import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;

        while(true){
            str = br.readLine();
            if(str.equals("0"))
                break;

            while(true){
                bw.write(str + " ");
                if(str.length() == 1){
                    break;
                }

                int mul = 1;
                for(int i = 0; i < str.length(); i++){
//                System.out.println((int)str.charAt(i) - 48);
                    mul *= (int)str.charAt(i) - 48;
                }
                str = mul + "";
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
