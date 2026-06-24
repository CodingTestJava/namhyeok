package codingtestbook.first.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

// 12시 10분 시작
class Solution22_6 {
    public int[] solution(String[] genres, int[] plays) {
        // 많이 재생된 장르 순으로 저장
        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<int[]>> genreMusics = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);

            genreMusics.putIfAbsent(genres[i], new ArrayList<>());
            genreMusics.get(genres[i]).add(new int[]{i, plays[i]});
        }
        Stream<Map.Entry<String, Integer>> sortedTotalPlays = totalPlays.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        List<Integer> answer = new ArrayList<>();

        sortedTotalPlays.forEach(entry -> {
            Stream<int[]> sortedMusics = genreMusics.get(entry.getKey()).stream()
                    .sorted((a, b) -> Integer.compare(b[1], a[1]))
                    .limit(2);
            sortedMusics.forEach(music -> answer.add(music[0]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}