package ch01.Beakjoon;

import java.util.*;
//오븐 시계
class Beakjoon2525 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();	//시
        int b = scanner.nextInt();	//분
        int c = scanner.nextInt();	//초
        
        int min = (a*60)+b;
        min += c;
        
        int hour = (min/60)%24;
        int minute = min%60;
        
        System.out.println(hour + " " + minute);
    }
}
