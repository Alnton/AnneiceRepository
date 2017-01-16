/*
   scanf练习
   */
#include <stdio.h>
int main() {
	int radius = 0;
	double area = 0.0;
	printf("请输入圆的半径：");
	scanf("%d", &radius);
	area = 3.1415 * radius * radius;
	printf("圆的面积是%lg\n", area);
	return 0;
}



