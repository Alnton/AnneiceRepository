#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(){
  int fd = open("a.txt",O_RDWR);
  if(fd == -1) perror("open"),exit(-1);
  int fd2 = dup(fd);//复制文件描述符
  printf("fd=%d,fd2=%d\n",fd,fd2);
  write(fd,"A",1);//没有复制文件表
  write(fd2,"B",1);
  int fd3 = open("b.txt",O_RDWR|O_CREAT,0666);
  printf("fd3=%d\n",fd3);//5
  int fd4 = dup2(fd,fd3);//关闭fd3，然后复制
  printf("fd4=%d\n",fd4);
  write(fd3/*fd4*/,"HEHE",4);
  close(fd); close(fd2); 
}


