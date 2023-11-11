package ch01.Beakjoon;
import java.util.Scanner;

public class Beakjoon10828 {

    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        //명령수
        int n = in.nextInt();
        stack = new int[n];

        for(int i = 0; i < n; i++){
            String str = in.next();

            switch(str){
                case "push":
                    push(in.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int item) {//정수 X를 스택에 넣는 연산이다.
        stack[size] = item;
        size++;
    }
    public static int pop(){  //스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다.
                            //만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if(size == 0)
            return -1;
        else{
            int res = stack[size - 1];
            //res 가장 위의 정수
            stack[size - 1] = 0;
            size--;
            return res;
        }
    }
    public static int size() {  //데이터의 갯수. 스택에 들어있는 정수의 개수를 출력한다.
        return size;
    }

    public static int empty() {    //스택이 비어있으면 1, 아니면 0을 출력한다.
        if(size == 0)
            return 1;
        else
            return 0;
    }
    public static int top() {  //스택의 가장 위에 있는 정수를 출력한다.
        // 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if(size == 0)
            return -1;
        else
            return stack[size - 1];
    }
}
