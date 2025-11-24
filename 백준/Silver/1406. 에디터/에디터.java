import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Deque<Character> leftStack = new ArrayDeque<>();
        Deque<Character> rightStack = new ArrayDeque<>();

        for(int i = 0; i < str.length(); i++){
            leftStack.push(str.charAt(i));
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);

            switch(ch) {
                case 'P' :
                    char c = st.nextToken().charAt(0);
                    leftStack.push(c);
                    break;

                case 'L' :
                    if(!leftStack.isEmpty()){
                        char move = leftStack.pop();
                        rightStack.push(move);
                    }
                    break;

                case 'D' :
                    if(!rightStack.isEmpty()){
                        char move = rightStack.pop();
                        leftStack.push(move);
                    }
                    break;

                case 'B' :
                    if(!leftStack.isEmpty()){
                        leftStack.pop();
                    }
                    break;

                default :
                    break;
            }
        }

        //출력을 위한 이동
        while(!leftStack.isEmpty()){
            char move = leftStack.pop();
            rightStack.push(move);
        }
        //출력
        while(!rightStack.isEmpty()){
            char print = rightStack.pop();
            bw.write(print);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}