import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < n; tc++){
            Deque<Character> stack = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                String str = st.nextToken();

                //스택방식(굳이 안써도될듯)
                for(int i = 0; i < str.length(); i++){
                    stack.push(str.charAt(i));
                }
                while(!stack.isEmpty()){
                    bw.write(stack.pop());
                }
                //기존 방식
//                for(int i = str.length() - 1; i >= 0; i--){
//                    answer += str.charAt(i);
//                }
                bw.write(" ");
            }

            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}