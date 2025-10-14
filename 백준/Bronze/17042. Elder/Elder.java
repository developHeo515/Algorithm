import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char currentOwner = br.readLine().charAt(0);
        int N = Integer.parseInt(br.readLine());
        Set<Character> owners = new HashSet<>();
        owners.add(currentOwner);
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char winner = st.nextToken().charAt(0);
            char loser = st.nextToken().charAt(0);
            
            if (loser == currentOwner) {
                currentOwner = winner;
                owners.add(currentOwner);
            }
        }
        
        System.out.println(currentOwner);
        System.out.println(owners.size());
        
        br.close();
    }
}