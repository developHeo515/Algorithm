import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1 = st.nextToken();
        String str2 = st.nextToken();
        int res = 50;

        for(int i = 0; i <= str2.length() - str1.length(); i++){
            int count = 0;
            for(int j = 0; j < str1.length(); j++){
                if(str1.charAt(j) != str2.charAt(i + j)){
//                    System.out.println(str1.charAt(j) + " - " + str2.charAt(i + j));
                    count++;
                }
            }
            if(res > count)
                res = count;
        }

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
