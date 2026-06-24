package codingtestbook.first.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 12시 10분 시작
class Solution22_4 {
    public int[] solution(String[] genres, int[] plays) {
        // 많이 재생된 장르 순으로 저장
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, List<int[]>> genreMusics = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreTotalPlays.put(genres[i], genreTotalPlays.getOrDefault(genres[i], 0) + plays[i]);

            genreMusics.putIfAbsent(genres[i], new ArrayList<>());
            genreMusics.get(genres[i]).add(new int[]{i, plays[i]});
        }
        List<String> list = new ArrayList<>(genreTotalPlays.keySet());
        list.sort((a, b) -> Integer.compare(genreTotalPlays.get(b), genreTotalPlays.get(a)));

        // musics (genres, [index, plays])에서 plays 기준으로 내림차순 정렬
        for (List<int[]> musicList : genreMusics.values()) {
            musicList.sort((a, b) -> {
                if (a[1] == b[1]) return Integer.compare(a[0], b[0]);

                return Integer.compare(b[1], a[1]);
            });
        }

        List<Integer> answer = new ArrayList<>();
        // FixMe: 의도가 명확하게 수정
        for (String genre : list) {
            List<int[]> musicList = genreMusics.get(genre);
            int count = 0;
            for (int[] music : musicList) {
                if (++count > 2) break;

                answer.add(music[0]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}