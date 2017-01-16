#include <stdio.h>
#include <string.h>

int main(){
  extern char** environ;//不用赋值就是环境表
  char** p = environ;//不建议改动environ地址
  while(*p /*!=NULL*/){
    printf("%s\n",*p);
    p++;
  }//练习：查找环境变量LANG的值，放入value并打印
  char value[100] = {};//初始清0,中间清0用memset
 //value = "abcd";//数组是常指针，不能用=再次赋值
  //char v[] = "abcd";//不是直接赋值，是复制方式
  p = environ;//把地址回到开始
  while(*p){
    if(strncmp(*p,"LANG=",5)==0){//确保=左边LANG
      strcpy(value,*p+5);//value = "xx";不允许
      break;
    }
    p++;
  }
  printf("value=%s\n",value);
 /* char *p1 = "abcd";
  printf("p1=%p,p1+1=%p\n",p1,p1+1);
  int x;
  int *p2 = &x ;
  printf("p2=%p,p2+1=%p\n",p2,p2+1);*/
  return 0;
}

