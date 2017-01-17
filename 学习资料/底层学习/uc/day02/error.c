#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>

int rand10(){//函数三要素：名字/返回值/参数
  srand(time(0));
  int res = rand()%10 + 1;//细致全面
  if(res == 5) return -1;
  else return res;
}
int max(int a,int b,int *max){
  if(a == b) return -1;
  else *max = (a>b)?a:b;
  return 0; }
char* iserror(char* str){
  if(strcmp(str,"error")==0) return NULL;
  else return "ok";
}
void print(char* str){
  printf("%s\n",str);
}
int main(){
  int x = rand10();
  if(x==-1) printf("rand error\n");
  else printf("x=%d\n",x);
  int res;
  x = max(2,2,&res);
  if(x == -1) printf("max error\n");
  else printf("res=%d\n",res);
}

