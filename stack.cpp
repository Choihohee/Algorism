#include <stdio.h>
#include <stdlib.h>
#define STACK_SIZE 10

int* stack;	//int 타입을 가리키는 포인터 stack 선언
int top = -1;               // top변수는 최상단의 데이터 위치 가르킴. 
int size = 1;

int isEmpty() {
	if (top == -1)
		return 1;
	else
		return 0;
}

int isFull() {
	if (top % STACK_SIZE == 9)
		return 1;
	else
		return 0;
}

// 스택의 top에 원소를 삽입하는 연산
void push(int item) {
	int* temp;	//int 타입을 가리키는 포인터 temp 선언

	if (isFull()==1) {
		printf(" Full STACK\n");

		//int 타입사이즈 * (STACK_SIZE * size) 만큼의 메모리를 할당해라
		temp = (int*)malloc((STACK_SIZE * size) * sizeof(int));
		for (int i = 0; i < (top + 1); i++)
			temp[i] = stack[i];
	
		stack = (int*)malloc((STACK_SIZE * (size + 1)) * sizeof(int));
		for (int i = 0; i < (top + 1); i++)
			stack[i] = temp[i];

		stack[++top] = item;  // top을 증가시킨 후 현재 top에 원소 삽입

		size++;
		free(temp);
	}

	else {	//isFull()==0
		stack[++top] = item;  // top을 증가시킨 후 현재 top에 원소 삽입
	}
}

int pop() {
	if (isEmpty()==1) {
		printf(" EMPTY STACK\n");
	}
	else {	//isEmpty()==0
		return stack[top--];
	}

}
void insert(int pos, int item) {
	int* temp;

	if (isFull()==1) {
		printf(" Full STACK\n");
		//int 타입사이즈 * (STACK_SIZE * size) 만큼의 메모리를 할당해라
		temp = (int*)malloc((STACK_SIZE * size) * sizeof(int));
		for (int i = 0; i < (top + 1); i++)
			temp[i] = stack[i];
		stack = (int*)malloc((STACK_SIZE * (size + 1)) * sizeof(int));
		for (int i = 0; i < pos; i++)
			stack[i] = temp[i];
		stack[pos] = item;

		for (int i = pos; i < (top + 1); i++)
			stack[i + 1] = temp[i];
		size++;
		top++;

		free(temp);
	}
	else {	//isFull()==0
		temp = (int*)malloc((STACK_SIZE * size) * sizeof(int));
		for (int i = 0; i < (top + 1); i++)
			temp[i] = stack[i];
		for (int i = 0; i < pos; i++)
			stack[i] = temp[i];

		stack[pos] = item;
		for (int i = pos; i < (top + 1); i++)
			stack[i + 1] = temp[i];
		size++;
		top++;

		free(temp);
	}
}

// 스택의 원소를 출력하는 연산
void printStack() {
	int i;
	printf(" STACK SIZE [%d]\n", (STACK_SIZE * size));
	printf("\n STACK [ ");

	for (i = 0; i <= top; i++)
		printf("%d ", stack[i]);
	printf("]\n");
}

void main(void) {
	int i;
	//int 타입사이즈 * STACK_SIZE 만큼의 메모리를 할당해라! stack는 포인터
	stack = (int*)malloc(STACK_SIZE * sizeof(int));

	for (i = 0; i < 44; i++)
		push(i + 1);
	printStack();

	//for (i = 0; i < 7; i++) printf(" POP Data [%d]\n", pop());
	insert(3, 2);
	printStack();
	for (i = 0; i < 7; i++) printf("제거 완료된 원소 : %d\n", pop());

	printStack();
	free(stack);
	getchar();
}