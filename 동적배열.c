#include <stdio.h>
#include <stdlib.h>
#define STACK_SIZE 10

int *stack;	//int Ÿ���� ����Ű�� ������ stack ����
int top = -1;               // top �ʱ�ȭ
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

// ������ top�� ���Ҹ� �����ϴ� ����
void push(int item) {
	int *temp;	//int Ÿ���� ����Ű�� ������ temp ����

	if (isFull()) {
		printf(" Full STACK\n");
		
		//int Ÿ�Ի����� * (STACK_SIZE * size) ��ŭ�� �޸𸮸� �Ҵ��ض�! temp�� ������ 
		temp = (int*)malloc((STACK_SIZE * size)* sizeof(int));
		
		for (int i = 0; i < (top + 1); i++) 
			temp[i] = stack[i];
		//int Ÿ�Ի����� * (STACK_SIZE * (size + 1)) ��ŭ�� �޸𸮸� �Ҵ��ض�! stack�� ������ 
		stack = (int*)malloc((STACK_SIZE * (size + 1))* sizeof(int));

		for (int i = 0; i < (top + 1); i++) 
			stack[i] = temp[i];
		stack[++top] = item;  // top�� ������Ų �� ���� top�� ���� ����

		size++;

		free(temp);

	}
	else 
		stack[++top] = item;  // top�� ������Ų �� ���� top�� ���� ����
}

// ������ ���Ҹ� ����ϴ� ����
void printStack() {
	int i;
	printf(" STACK SIZE [%d]\n", (STACK_SIZE * size));
	printf("\n STACK [ ");

	for (i = 0; i <= top; i++) {
		printf("%d ", stack[i]);
	}
	printf("]\n");
}

void main(void) {
	int i;
	//int Ÿ�Ի����� * STACK_SIZE(10) ��ŭ�� �޸𸮸� �Ҵ��ض�! stack�� ������
	stack = (int*)malloc(STACK_SIZE * sizeof(int));
	for (i = 0; i < 44; i++) 
		push(i + 1);
	printStack();
		
	for (i = 0; i < 7; i++) 
		printf(" POP Data [%d]\n", pop());
		
	printStack();
	free(stack);
	getchar();
}
