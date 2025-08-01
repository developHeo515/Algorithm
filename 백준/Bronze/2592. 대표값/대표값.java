import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n;
        int sum = 0;
        int cnt = 0;
        int manyNum = 0;

        for(int i = 0; i < 10; i++){
            n = Integer.parseInt(br.readLine());
            hm.put(n, hm.getOrDefault(n, 0) + 1 );
            sum += n;
        }

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(cnt < entry.getValue()){
                cnt = entry.getValue();
                manyNum = entry.getKey();
            }
        }

        bw.write(sum / 10 + "\n");
        bw.write(manyNum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
