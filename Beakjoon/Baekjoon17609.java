package ch01.Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();

            if(palindrome(str))
                System.out.println(0);
            else if(pseudoPalindrome(str))
                System.out.println(1);
            else
                System.out.println(2);
        }
    }

    private static boolean palindrome(String str) {//회문
        int start = 0; //str문자열의 첫 번째 문자를 가르키는 포인터
        int end = str.length()-1; //str문자열의 마지막 번째 문자를 가르키는 포인터

        while(start <= end) {
            if(str.charAt(start++)!=str.charAt(end--))
                //start 포인터는 늘어나고 end 포인터는 줄어들고 있다 이 두 포인터가 일치하지 않게 되면 false
                return false;
        }
        return true;    //문자열의 모든 문자가 양 끝에서부터 중앙까지 같으면 true
    }

    private static boolean pseudoPalindrome(String str) {//유사회문
        int start = 0;
        int end = str.length()-1;

        while(start <= end) {
            if(str.charAt(start)!=str.charAt(end)) {    //start포인터가 가르키는 문자와 end 포인터가 가르키는 문자가 다르면
                return palindrome(str.substring(start,end)) || palindrome(str.substring(start+1, end+1));
                //start에서 end - 1까지의 부분 문자열이 회문인지 확인, start + 1에서 end까지의 부분 문자열이 회문인지 확인
                //둘중하나라도 회문이면 true
            }
            //문자가 같다면 start를 증가, end를 감소시켜 다음문자로 이동
            start++;
            end--;
        }
        return true;
    }
}
