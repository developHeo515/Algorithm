import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // TreeMap은 기본적으로 키(Key) 기준 오름차순 정렬됩니다.
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String str : operations) {
            StringTokenizer st = new StringTokenizer(str);
            String operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (operation.equals("I")) {
                // 값이 있으면 개수 + 1, 없으면 1 저장 (중복 허용)
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if (operation.equals("D")) {
                if (map.isEmpty()) continue;

                // num이 1이면 최댓값(lastKey), -1이면 최솟값(firstKey)
                int targetKey = (num == 1) ? map.lastKey() : map.firstKey();
                
                // 개수가 1개면 아예 삭제, 여러 개면 개수만 줄임
                if (map.get(targetKey) == 1) {
                    map.remove(targetKey);
                } else {
                    map.put(targetKey, map.get(targetKey) - 1);
                }
            }
        }

        // 비어있으면 [0, 0], 아니면 [최대, 최소] 반환
        if (map.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{map.lastKey(), map.firstKey()};
        }
    }
}