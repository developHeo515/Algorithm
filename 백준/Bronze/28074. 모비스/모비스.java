import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String mobis = "MOBIS";
        String str = br.readLine();
        HashMap<Character, Boolean> hm = new HashMap<>();

        for(int i = 0; i < mobis.length(); i++){
            hm.put(mobis.charAt(i), false);
        }

        for(int i = 0; i < str.length(); i++){
            if(hm.containsKey(str.charAt(i))){
                hm.put(str.charAt(i), true);
            }
        }

        for(Map.Entry<Character, Boolean> entry : hm.entrySet()){
            if(entry.getValue() == false){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

        bw.flush();
        bw.close();
        br.close();
    }
}
