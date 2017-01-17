/*
   自增，自减操作符演示
   */
#include <stdio.h>
int num2 = 10;
int main() {
	int num = 0, num1 = 0;
	num++;
	printf("num是%d\n", num);
	++num;
	printf("num是%d\n", num);
	num1 = ++num;
	printf("num是%d,num1是%d\n", num, num1);
	num1 = 0;
	num1 = num++;
	printf("num是%d,num1是%d\n", num, num1);
	num = 10;
	num1 = num++ + ++num;
	printf("num是%d,num1是%d\n", num, num1);
	num1 = num2++ + ++num2;
	printf("num2是%d,num1是%d\n", num2, num1);
	return 0;
}





