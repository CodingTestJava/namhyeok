package codingtestbook.first.hash;

import java.util.*;

class Solution22 {
    public int[] solution(String[] genres, int[] plays) {
        // 재생 횟수의 총합이 가장 많은 장르부터 출력해야 하므로 TreeMap 사용
        // Q: 그냥 HashMap에 저장하고 정렬하는 게 낫나? 아니면 TreeMap에 저장하는 게 낫나?
        // TreeMap은 저장할 때마다 정렬을 하는 것으로 기억하는데... 이러면 HashMap이 나아 보이긴 함 -> 일단 풀고 확인
        // FixMe: TreeMap은 순서가 보장되긴 하지만, Key를 기준으로 정렬을 하므로 지금 구조는 잘못됐음!
        // 많이 재생된 장르 순으로 저장
        Map<String, Integer> map = new TreeMap<>();
        Map<String, List<int[]>> musics = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

            musics.putIfAbsent(genres[i], new ArrayList<>());
            musics.get(genres[i]).add(new int[]{i, plays[i]});
        }


        // 각 장르에서 상위 2개는 어떻게 찾고 고르지?
        // musics (genres, [index, plays])에서 plays 기준으로 내림차순 정렬
        for (List<int[]> musicList : musics.values()) {
            musicList.sort((a, b) -> b[1] - a[1]);
        }

        List<Integer> answer = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String genre = entry.getKey();
            List<int[]> musicList = musics.get(genre);
            int count = 0;
            for (int[] music : musicList) {
                if (++count > 2) break;

                answer.add(music[0]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}