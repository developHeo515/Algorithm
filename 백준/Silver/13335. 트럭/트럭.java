import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n;
        int w;
        int L;
        int[] truck;
        int[] bridge;
        int weight = 0;
        int time = 0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        truck = new int[n];
        bridge = new int[w];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            truck[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        while(true){
            time++;
            //트럭 옮기기
            for(int i = w-1; i >= 0; i--){
                //다리를 탈출하는 트럭
                if(bridge[i] != 0 && i == w-1){
                    weight -= bridge[i];
                    bridge[i] = 0;
                }
                //한칸 이동하는 트럭
                else if(bridge[i] != 0){
                    bridge[i+1] = bridge[i];
                    bridge[i] = 0;
                }
            }

            //새 트럭 더 올리기
            if(n > idx){
                if(L >= weight + truck[idx]){
                    bridge[0] = truck[idx];
                    weight += truck[idx];
                    idx++;
                }
            }
//            System.out.println("시간 : " + time + "  == 다리 상황 : " + Arrays.toString(bridge) + "  , 무게 상황 : " + weight );
            //종료조건
            if(idx == n && weight == 0) break;
        }
        
        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}