import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        while(true){
            if(A <= 0 && B <= 0){
                break;
            }

            if(A > 0){
                A -= C;
            }
            if(B > 0){
                B -= D;
            }
            L--;
        }

        bw.write(L + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
