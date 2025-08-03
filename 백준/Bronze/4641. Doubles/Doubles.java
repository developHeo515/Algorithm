import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Integer> list;
        int n;

        while(true){
            st = new StringTokenizer(br.readLine());
            int ans = 0;
            n = Integer.parseInt(st.nextToken());
            if(n == -1)
                break;

            list = new ArrayList<>();
            while(true){
                if(n == 0)
                    break;
                list.add(n);
                n = Integer.parseInt(st.nextToken());
            }

            Collections.sort(list);
            for(int i = 0; i < list.size(); i++){
                for(int j = i + 1; j < list.size(); j++){
                    if(list.get(i) * 2 == list.get(j)){
                        ans++;
                        break;
                    }
                }
            }
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
