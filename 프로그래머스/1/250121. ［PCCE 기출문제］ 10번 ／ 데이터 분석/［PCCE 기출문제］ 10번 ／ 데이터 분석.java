import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("code", 0);
        hm.put("date", 1);
        hm.put("maximum", 2);
        hm.put("remain", 3);
        List<int[]> list = new ArrayList<>();

        int select = hm.get(ext);
        for(int i = 0; i < data.length; i++){
            // val_ext 보다 작은 데이터는 따로 저장
            if(data[i][select] < val_ext){
                list.add(data[i]);
            }
        }

        //answer에 데이터 옮기고 정렬 시작
        final int sortNum = hm.get(sort_by);
        answer = new int[list.size()][list.get(0).length];
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                answer[i][j] = list.get(i)[j];
            }
        }

        Arrays.sort(answer, (a, b) -> Integer.compare(a[sortNum], b[sortNum]));

//        System.out.println(Arrays.deepToString(answer));
        return answer;
    }
}