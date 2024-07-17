package ch01;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class cote {
    public String[] solution(String[] records, int k, String date) {

        Map<String, Set<String>> purchaseMap = new HashMap<>(); // 구매
        Map<String, Set<String>> repurchaseMap = new HashMap<>(); // 재구매
        Map<String, Integer> purchaseCountMap = new HashMap<>(); // 구매 횟수

        LocalDate endDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate startDate = endDate.minusDays(k - 1);

        // 주어진 구매 기록 돌면서 처리함
        for (String record : records) {
            // 문자열 쪼개기 후 배열에 저장
            String[] s = record.split(" ");

            String uid = s[1];
            String pid = s[2];

            LocalDate recordDate = LocalDate.parse(s[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // 기간 사이의 구매 기록인지 확인
            if (!recordDate.isBefore(startDate) && !recordDate.isAfter(endDate)) {

                purchaseMap.putIfAbsent(pid, new HashSet<>());
                purchaseMap.get(pid).add(uid);
                purchaseCountMap.put(pid, purchaseCountMap.getOrDefault(pid, 0) + 1);

                // 재구매하는 사용자인 경우 재구매 Map에 추가함
                if (purchaseMap.get(pid).contains(uid)) {
                    repurchaseMap.putIfAbsent(pid, new HashSet<>());
                    repurchaseMap.get(pid).add(uid);
                }
            }
        }

        List<String> productList = new ArrayList<>(purchaseMap.keySet());

        // 재구매율, 구매 횟수에 따라 정렬시킴
        productList.sort((pid1, pid2) -> {
            double repurchaseRate1 = (double) repurchaseMap.getOrDefault(pid1, Collections.emptySet()).size() / purchaseMap.get(pid1).size() * 100;
            double repurchaseRate2 = (double) repurchaseMap.getOrDefault(pid2, Collections.emptySet()).size() / purchaseMap.get(pid2).size() * 100;

            if (Double.isNaN(repurchaseRate1)) repurchaseRate1 = 0.0; // 분모가 0일 경우 처리
            if (Double.isNaN(repurchaseRate2)) repurchaseRate2 = 0.0; // 분모가 0일 경우 처리

            if (repurchaseRate1 != repurchaseRate2) {
                return Double.compare(repurchaseRate2, repurchaseRate1); // 내림차순 정렬
            } else { // 재구매율이 같을 때
                // 구매 횟수 비교
                if (!purchaseCountMap.get(pid1).equals(purchaseCountMap.get(pid2))) {
                    // 구매 횟수가 다른 경우 구매 횟수가 많은 상품이 앞으로 오도록 함
                    return purchaseCountMap.get(pid2) - purchaseCountMap.get(pid1);
                } else {
                    // 상품 아이디의 숫자 부분 비교(오름차순 정렬)
                    int pidNum1 = Integer.parseInt(pid1.substring(3));
                    int pidNum2 = Integer.parseInt(pid2.substring(3));

                    return Integer.compare(pidNum1, pidNum2);
                }
            }
        });

        if (productList.isEmpty()) {
            return new String[]{"no result"};
        } else {
            return productList.toArray(new String[0]);
        }
    }
}

