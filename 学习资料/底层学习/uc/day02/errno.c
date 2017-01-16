#include <stdio.h>
#include <errno.h>
#include <string.h>

int main(){
  FILE *file = fopen("/etc/passwd1","r");
  if(file == NULL){
    printf("errno=%d\n",errno);
    printf("%s\n",strerror(errno));   
    perror("fopen");//不需要换行，也不需要传
    printf("%m\n");//不需要额外传变量
  }
  file = fopen("/etc/passwd","r"/*"w"*/);
  if(file == NULL){
    printf("errno=%d\n",errno);
    perror("fopen2");
  }
  printf("%s\n",strerror(3));//errno错误改值
  printf("errno=%d\n",errno);//errno正确不改值
}


