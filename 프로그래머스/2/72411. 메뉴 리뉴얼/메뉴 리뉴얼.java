import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> list = new ArrayList<>();

        //각 손님의 주문에서 조합들 생성
        for(int i = 0; i < orders.length; i++){
            comb(0, hm, "", orders[i]);
        }
//        System.out.println(hm);

        for(int num : course){
            // course 수에 맞게 찾는건 순회 돌면서 Key 문자열의 길이를 비교해서 course 수의 최대수 찾기
            int maxSelect = 0;
            for(Map.Entry<String, Integer> entry : hm.entrySet()){
                // 코스 메뉴 수가 같을때, 2 == "AC" 일때
                if(num == entry.getKey().length()){
                    maxSelect = Math.max(maxSelect, entry.getValue());
                }
            }
//            System.out.println(maxSelect);

            //다시 순회 돌면서 코스 수의 최대수와 같은 애들은 다 넣기
            //최소 2명 이상의 손님으로 선택된 조합
            if(maxSelect < 2) continue;
            for(Map.Entry<String, Integer> entry : hm.entrySet()){
                // 메뉴 구성 수(num)가 같고 구성에서 가장 많이 선택된 max일때
                if(num == entry.getKey().length() && maxSelect == entry.getValue()){
//                    System.out.println(maxSelect + " === " + entry.getKey());
                    list.add(entry.getKey());
                }
            }
        }

        //정답 정렬해야함
        Collections.sort(list);
        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    static void comb(int start, HashMap<String, Integer> hm, String str, String order){
        // 최소 2가지 이상의 단품메뉴로 구성
        if(str.length() > 1){
            String menu = "";
            char[] c = new char[str.length()];
            for(int idx = 0; idx < c.length; idx++){
                c[idx] = str.charAt(idx);
            }
            Arrays.sort(c);
            menu = new String(c);
            hm.put(menu, hm.getOrDefault(menu, 0) + 1);
        }

        for(int i = start; i < order.length(); i++){
            comb(i+1, hm, str + order.charAt(i), order);
        }
    }
}