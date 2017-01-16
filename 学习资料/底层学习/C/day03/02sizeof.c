/*
   sizeof关键字演示
   */
#include <stdio.h>
int main() {
	int num = 0;
	printf("sizeof(int)是%d\n", sizeof(int));
	printf("sizeof(num)是%d\n", sizeof(num));
	printf("sizeof(3 + 5)是%d\n", sizeof(3 + 5));
	sizeof(num = 10);
	printf("num是%d\n", num);
	return 0;
}



