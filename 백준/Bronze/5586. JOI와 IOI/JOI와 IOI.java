import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int joi = 0;
        int ioi = 0;
        String str = br.readLine();
        int repeat = str.length() - 3 + 1;

        for(int i = 0; i < repeat; i++){
            if("JOI".equals(str.substring(i, i + 3))){
                joi++;
            }
        }
        for(int i = 0; i < repeat; i++){
            if("IOI".equals(str.substring(i, i + 3))){
                ioi++;
            }
        }

        bw.write(joi + "\n");
        bw.write(ioi + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
