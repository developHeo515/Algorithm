import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double alice = 0;
        double bob = 0;
        int[] dart = new int[20];
        int twenty = 0;

        for(int i = 0; i < 20; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == 20)
                twenty = i;
            dart[i] = num;
        }

        int left = twenty - 1;
        int right = twenty + 1;

        if(left == -1)
            left = 19;
        if(right == 20)
            right = 0;

        //alice
        alice = dart[left] + dart[twenty] + dart[right];
        alice /= 3;

        //bob
        for(int i = 0; i < 20; i++){
            bob += dart[i];
        }
        bob /= 20;

//        System.out.println(alice + " " +bob);
        if(alice > bob){
            bw.write("Alice" + "\n");
        }
        else if(alice < bob){
            bw.write("Bob" + "\n");
        }
        else{
            bw.write("Tie" + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
