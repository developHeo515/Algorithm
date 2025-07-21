import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if(20 <= x && x <= 23){
            int sleep = 24 - x + y;
            bw.write(sleep + "\n");
        }
        else {
            int sleep = y - x;
            bw.write(sleep + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
