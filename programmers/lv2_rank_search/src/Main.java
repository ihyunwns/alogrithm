import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"}
        )));
    }
    /*
         언어	 직군	     경력   소울 푸드	점수
        java	backend	    junior	pizza	150
        python	frontend	senior	chicken	210
        python	frontend	senior	chicken	150
        cpp	    backend	    senior	pizza	260
        java	backend	    junior	chicken	80
        python	backend	    senior	chicken	50
    */
}

class Solution {

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        HashMap<String, List<Integer>> map = new HashMap<>();
        // 경우의 수 분기
        for (String i : info) {
            DFS(i, -1, "", map);
        }

        // score 오름 차순 정렬
        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
        }

        //query 변환
        int index = 0;
        for (String q : query) {
            String key = q.replaceAll(" and ", "").split(" ")[0];
            int score = Integer.parseInt(q.replaceAll(" and ", "").split(" ")[1]);

            //이진 탐색
            if (map.containsKey(key)) {
                answer[index++] = binarySort(map.get(key), score);
            } else {
                answer[index++] = 0;
            }
        }

        return answer;
    }

    public int binarySort(List<Integer> values, int score) {
        int start = 0;
        int end = values.size() -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (values.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }



        return values.size() - start;

    }

    public void DFS(String i, int depth, String key, HashMap<String, List<Integer>> map) {
        if (depth >= 3) {
            int score = Integer.parseInt(i.split(" ")[4]);
            map.putIfAbsent(key, new ArrayList<>()); // 기존 데이터에 key가 없을 때 실행
            map.get(key).add(score); // 데이터가 있는 경우 해당 key에 score 추가

            return;
        }

        depth++;

        String key_1 = key + "-";
        String key_2 = key + i.split(" ")[depth];

        // "-" 분기
        DFS(i , depth, key_1, map);
        // 언어, 직군, 경력, 소울푸드 분기
        DFS(i , depth, key_2, map);

    }

}

