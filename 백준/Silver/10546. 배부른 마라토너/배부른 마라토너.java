import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();

        String str = "";
        for(int i = 0; i < n; i++){
            str = br.readLine();
            if(hm.containsKey(str)){
                hm.put(str, hm.get(str) + 1);
            }
            else {
                hm.put(str, 1);
            }
        }

        for(int i = 0; i < n-1; i++){
            str = br.readLine();
            hm.put(str, hm.get(str) + 1);
        }

        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            if(entry.getValue() % 2 == 1){
                bw.write(entry.getKey() + "\n");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}