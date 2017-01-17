#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
  pid_t pid = vfork();
  if(pid == 0){
    printf("child begin\n");//ls -l /
    //第一个参数是命令所在路径，后面的参数就是命令，空格分成多个字符串，以NULL结束
    execl("/bin/ls","ls","-l","/",NULL);
    printf("child end\n");//不会再执行，因为代码段已经换成exec调用的新代码段
  }
  printf("father begin\n");
  printf("father end\n");
}

