#include <stdio.h>
#include <stdlib.h>
int i1 = 10;//全局区
int i2 = 20;//全局
int i3;//bss
const int i4 = 40;//只读常量
void fa(int i5){//栈
  int i6 = 60;//栈
  static int i7 = 70;//全局
  const int i8 = 80;//栈
  int* pi = malloc(4);//堆
  char* s1 = "abcd";//只读
  char s2[] = "abcd";//栈
  printf("i5=%p\n",&i5);
  printf("i6=%p\n",&i6);
  printf("i7=%p\n",&i7);
  printf("i8=%p\n",&i8);
  printf("pi=%p\n",pi);
  printf("s1=%p\n",s1);
  printf("s2=%p\n",s2);
}
int main(){
  printf("i1=%p\n",&i1); 
  printf("i2=%p\n",&i2); 
  printf("i3=%p\n",&i3); 
  printf("i4=%p\n",&i4); 
  printf("fa=%p\n",fa);
  fa(100); 
}


