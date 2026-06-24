package codingtestbook.first.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 12시 10분 시작
class Solution22_7 {
    public int[] solution(String[] genres, int[] plays) {
        // 많이 재생된 장르 순으로 저장
        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<int[]>> genreMusics = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);

            genreMusics.putIfAbsent(genres[i], new ArrayList<>());
            genreMusics.get(genres[i]).add(new int[]{i, plays[i]});
        }
        List<String> list = new ArrayList<>(totalPlays.keySet());
        list.sort((a, b) -> Integer.compare(totalPlays.get(b), totalPlays.get(a)));

        // musics (genres, [index, plays])에서 plays 기준으로 내림차순 정렬
        // ArrayList는 삽입 순서를 유지하므로 장르 내에서 재생 횟수가 같을 때 고유 번호가 낮은 순으로 정렬을 따로 할 필요는 없음...!
        for (List<int[]> musicList : genreMusics.values()) {
            musicList.sort((a, b) -> Integer.compare(b[1], a[1]));
        }

        List<Integer> answer = new ArrayList<>();
        for (String genre : list) {
            List<int[]> musicList = genreMusics.get(genre);
            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                answer.add(musicList.get(i)[0]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}