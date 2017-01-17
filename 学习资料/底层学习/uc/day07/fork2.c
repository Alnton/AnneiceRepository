#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
  printf("begin\n");
  pid_t pid = fork();
  if(pid == 0){//子进程
    printf("我是子进程%d,父进程是%d\n",
      getpid(),getppid());
    //exit(0);
  }else{//父进程
    //sleep(1);
    printf("我是父进程%d,子进程是%d\n",
       getpid(),pid);
  }
  printf("end%d\n",getpid());
}

