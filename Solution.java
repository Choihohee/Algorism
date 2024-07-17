package ch01;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Solution {
    public String[] solution(String[] records, int k, String date) {

        Map<String, List<String>> purchaseMap = new HashMap<>(); // 구매
        Map<String, List<String>> repurchaseMap = new HashMap<>(); // 재구매
        Map<String, Integer> purchase_countMap = new HashMap<>(); // 구매 횟수

        LocalDate endDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate startDate = endDate.minusDays(k - 1);

        //주어진 구매 기록 돌면서 처리함
        for (String record : records) {
            //문자열 쪼개기 후 배열에 저장
            String[] s = record.split(" ");

            String uid = s[1];
            String pid = s[2];

            LocalDate recordDate = LocalDate.parse(s[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            //기간 사이의 구매 기록인지 확인
            if (!recordDate.isBefore(startDate) && !recordDate.isAfter(endDate)) {

                purchaseMap.putIfAbsent(pid, new ArrayList<>());
                purchaseMap.get(pid).add(uid);
                purchase_countMap.put(pid, purchase_countMap.getOrDefault(pid, 0) + 1);

                //재구매하는 사용자인 경우 재구매 Map에 추가함
                if (purchaseMap.get(pid).contains(uid)) {
                    repurchaseMap.putIfAbsent(pid, new ArrayList<>());
                    repurchaseMap.get(pid).add(uid);
                }
            }
        }

        List<String> productList = new ArrayList<>(purchaseMap.keySet());

        //재구매율, 구매 횟수에 따라 정렬시킴
        productList.sort((pid1, pid2) -> {
            double repurchaseRate1 = 0.0;
            if (purchaseMap.get(pid1).size() > 0)
                repurchaseRate1 = (double) repurchaseMap.getOrDefault(pid1, Collections.emptyList()).size() / purchaseMap.get(pid1).size() * 100;

            double repurchaseRate2 = 0.0;
            if (purchaseMap.get(pid2).size() > 0)
                repurchaseRate2 = (double) repurchaseMap.getOrDefault(pid2, Collections.emptyList()).size() / purchaseMap.get(pid2).size() * 100;

            if (repurchaseRate1 != repurchaseRate2) {
                return Double.compare(repurchaseRate1, repurchaseRate2);   //자바 메소드 Double.compare사용으로 두개의 값 비교 후 결과 반혼 함
            } else {    //재구매율이 같을 때
                //구매 횟수 비교
                if (!purchase_countMap.get(pid1).equals(purchase_countMap.get(pid2))) {
                    //구매 횟수가 다른 경우 구매 횟수가 많은 상품이 앞으로 오도록함
                    return purchase_countMap.get(pid2) - purchase_countMap.get(pid1);
                } else {
                    //상품 아이디의 숫자 부분 비교(오름차순 정렬)
                    int pid_num1 = Integer.parseInt(pid1.substring(3));
                    int pid_num2 = Integer.parseInt(pid2.substring(3));

                    return Integer.compare(pid_num1, pid_num2);
                }
            }
        });

        if (productList.isEmpty()) {
            return new String[]{"no result"};
        }else {
            return productList.toArray(new String[0]);
        }
    }

        //재구매율 계산
        double calculateRepurchase(String pid, Map<String, List<String>> purchaseMap, Map<String, List<String>> repurchaseMap) {
            double repurchaseRate = 0.0;

            List<String> purchases = purchaseMap.getOrDefault(pid, Collections.emptyList());
            List<String> repurchases = repurchaseMap.getOrDefault(pid, Collections.emptyList());

            if (!purchases.isEmpty()) {
                repurchaseRate = (double) repurchases.size() / purchases.size() * 100;
            } else {
                repurchaseRate = 0.0;   //구매 기록이 없는 경우 재구매율은 0으로 설정
            }

            return repurchaseRate;

    }
}
