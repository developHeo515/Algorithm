import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < M; j++){
                char ch = str.charAt(j);

                if(ch == '-'){
                    ch = '|';
                }
                else if(ch == '|'){
                    ch = '-';
                }
                else if(ch == '/'){
                    ch = '\\';
                }
                else if(ch == '\\'){
                    ch = '/';
                }
                else if(ch == '^'){
                    ch = '<';
                }
                else if(ch == '<'){
                    ch = 'v';
                }
                else if(ch == 'v'){
                    ch = '>';
                }
                else if(ch == '>'){
                    ch = '^';
                }

                arr[i][j] = ch;
            }
        }

        for(int j = M-1; j >= 0; j--){
            for(int i = 0; i < N; i++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
