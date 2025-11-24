import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int t = 0; t < n; t++){
            Deque<Character> lStack = new ArrayDeque<>();
            Deque<Character> rStack = new ArrayDeque<>();
            String str = br.readLine();

            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);

                switch(ch) {
                    case '<':
                        if(!lStack.isEmpty()){
                            char move = lStack.pop();
                            rStack.push(move);
                        }
                        break;
                    case '>':
                        if(!rStack.isEmpty()){
                            char move = rStack.pop();
                            lStack.push(move);
                        }
                        break;
                    case '-':
                        if(!lStack.isEmpty()){
                            lStack.pop();
                        }
                        break;
                    default :
                        lStack.push(ch);
                        break;
                }
            }
            //출력 전 옮기기
            while(!lStack.isEmpty()){
                char move = lStack.pop();
                rStack.push(move);
            }

            //출력
            while(!rStack.isEmpty()){
                char print = rStack.pop();
                bw.write(print);
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}