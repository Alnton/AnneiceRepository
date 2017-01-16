#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(){
  //练习：测试一下fork()对文件描述符和文件表是
  //如何处理的？谁被复制，谁不被复制？
  //id_t pid = fork();
  int fd = open("a.txt",O_RDWR|O_CREAT,0666);
  if(fd==-1) perror("open"),exit(-1);
  pid_t pid = fork();
  if(pid==0){//子进程
    printf("fd=%d\n",fd);
    write(fd,"abc",3); sleep(1);
    close(fd);
    exit(0);
  }
  printf("main:fd=%d\n",fd);
  write(fd,"123",3); sleep(1);
  close(fd);
}


