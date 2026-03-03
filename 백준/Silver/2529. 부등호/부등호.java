import java.io.*;
import java.util.*;

public class Main {
    static long max;
    static long min;
    static String maxStr = "";
    static String minStr = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        String[] ineq = new String[k];

        for(int i = 0; i < k; i++){
            ineq[i] = st.nextToken();
        }

        max = 0;
        min = Long.MAX_VALUE;
        purm(ineq, 0, k, new ArrayList<>(), new boolean[10]);

        bw.write(maxStr + "\n");
        bw.write(minStr + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void purm(String[] ineq, int depth, int k, List<Integer> select, boolean[] visit){
        //숫자 다 만족하게 골랐을때
        if(depth == k + 1){
            String str = "";
            long num = 0;
            for(int n : select){
                str += n;
                num = num * 10 + n;
            }

            if(num > max){
                max = num;
                maxStr = str;
            }
            if(num < min){
                min = num;
                minStr = str;
            }

//            for(int n = 0; n < k + 1; n++){
//                System.out.print(select.get(n) + " ");
//                if(n < k){
//                    System.out.print(ineq[n] + " ");
//                }
//            }
//            System.out.println();
            return;
        }

        for(int i = 0; i < 10; i++){
            // 첫번째 숫자일땐 비교할 수 없으니 일단 넣는다.
            if(select.size() == 0) {
                select.add(i);
                visit[i] = true;
                purm(ineq, depth + 1, k, select, visit);
                visit[i] = false;
                select.remove(select.size() - 1);
            }
            else {
                if(!visit[i]){
                    //부등호 비교
                    if(ineq[depth-1].equals(">")){
                        if(select.get(depth-1) > i){
                            select.add(i);
                            visit[i] = true;
                            purm(ineq, depth + 1, k, select, visit);
                            visit[i] = false;
                            select.remove(select.size() - 1);
                        }
                    }
                    else if(ineq[depth-1].equals("<")){
                        if(select.get(depth-1) < i){
                            select.add(i);
                            visit[i] = true;
                            purm(ineq, depth + 1, k, select, visit);
                            visit[i] = false;
                            select.remove(select.size() - 1);
                        }
                    }
                }
            }
        }
    }
}