import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            hm.put(players[i], i);
        }

        for(String calling : callings){
            String win = players[hm.get(calling)];
            String lose = players[hm.get(calling)-1];
            players[hm.get(calling)] = lose;
            players[hm.get(calling)-1] = win;

//            System.out.println(win + " " + lose);
//            System.out.println(Arrays.toString(players));
//            System.out.println();

            int winIdx = hm.get(calling);
            int loseIdx = hm.get(calling) - 1;
            hm.put(win, loseIdx);
            hm.put(lose, winIdx);
        }
//        System.out.println(Arrays.toString(players));

        return players;
    }
}