package ch01.Beakjoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mushrooms[] = new int[11];
        //누적합에서 0번째 인덱스는 0으로 두고 1번째인덱스부터 보는게 수월하다.

        for (int i = 1; i <= 10; i++) {
            //1~10번쨰 인덱스에 값을 입력
            mushrooms[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += mushrooms[i];

            if (sum >= 100) {

                //이전 인덱스까지 저장한 합과 현재 인덱스까지 저장한 합을 비교
                //절대값을 씌워 둘중 값이 더 작은 쪽을 택함.
                if (Math.abs((sum - mushrooms[i]) - 100) < Math.abs(sum - 100)) {
                    System.out.println(sum - mushrooms[i]);
                } else if (Math.abs((sum - mushrooms[i]) - 100) >= Math.abs(sum - 100)) {
                    System.out.println(sum);
                }
                return;
            }
        }
        //인덱스를 다 저장했는데도 100이 안 넘는 경우가 있음 이럴경우 최종 누적합을 출력
        System.out.println(sum);
    }
}
