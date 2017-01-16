/*
   操作符演示
   */
#include <stdio.h>
int main() {
	int num = 0, num1 = 0;
	printf("15 / 6是%d\n", 15 / 6);
	printf("15 %% 6是%d\n", 15 % 6);
	num = num1 = 10;
	printf("num是%d,num1是%d\n", num, num1);
	num += 5;
	printf("num是%d\n", num);
	num *= 2 + 3;
	printf("num是%d\n", num);
	return 0;
}




