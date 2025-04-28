package 정렬;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 학생출력 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n 입력 받기
        System.out.println("n 입력 : ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String,Integer> map = new HashMap<>();

        // 학생 정보 입력 map으로 받기
        System.out.println("정보 입력 : ");
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            map.put(parts[0], Integer.parseInt(parts[1]));
        }

        // stream으로 오름차순 정렬
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        for (String key : sortedMap.keySet()) {
            System.out.println(key);
        }


    }
}
