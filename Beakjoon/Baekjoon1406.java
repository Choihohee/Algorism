package ch01.Beakjoon;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon1406 {
    public static void main(String[] args) throws IOException {
        // 입력 스트림 및 출력 스트림을 생성합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자를 저장할 스택을 두 개 생성합니다.
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        // 초기 문자열을 입력 받습니다.
        String initStr = br.readLine();
        // 명령어의 개수를 입력 받습니다.
        int count = Integer.parseInt(br.readLine());

        // 초기 문자열을 leftStack에 넣습니다.
        for (int i = 0; i < initStr.length(); i++) {
            leftStack.push(initStr.charAt(i));
        }

        for (int i = 0; i < count; i++) {
            // 명령어를 입력 받습니다.
            String commandLine = br.readLine();
            // 명령어의 첫 번째 문자를 가져옵니다.
            char command = commandLine.charAt(0);

            switch (command) {
                case 'L':
                    //커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                    if (!leftStack.isEmpty())
                        rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    //커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                    if (!rightStack.isEmpty())
                        leftStack.push(rightStack.pop());
                    break;
                case 'B':
                    //커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                    //삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
                    if(!leftStack.isEmpty())
                        leftStack.pop();
                    break;
                case 'P':
                    //문자를 커서 왼쪽에 추가함
                    leftStack.push(commandLine.charAt(2));
                    break;
                default:
                    break;
            }
        }
        // leftStack에 남아 있는 문자를 rightStack으로 옮깁니다.
        while (!leftStack.empty()){
            rightStack.push(leftStack.pop());
        }
        // rightStack에 있는 문자를 출력합니다.
        while (!rightStack.empty()){
            bw.write(rightStack.pop());
        }
        br.close();
        bw.close();

    }
}
