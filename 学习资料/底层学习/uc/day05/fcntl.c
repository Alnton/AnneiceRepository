#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(){
  int fd = open("a.txt",
    O_RDONLY|O_CREAT|O_APPEND,0666);
  if(fd == -1) perror("open"),exit(-1);
  int fd2 = fcntl(fd,F_DUPFD,5);//返回>=5
  printf("fd=%d,fd2=%d\n",fd,fd2);
  int flags = fcntl(fd,F_GETFL);
  printf("flags=%d\n",flags);
  if(flags & O_APPEND) printf("追加\n");
  if((flags&3)==O_WRONLY) printf("WRONLY\n");
  if((flags&3)==O_RDWR) printf("RDWR\n");
  if((flags&3)==O_RDONLY) printf("RDONLY\n"); 
  //无法获取创建相关标识
  if(flags & O_CREAT) printf("CREAT");
  //修改不能改权限，不能改O_TRUNC，能去掉O_APPEND
  fcntl(fd,F_SETFL,O_RDWR|O_TRUNC);//修改
  flags = fcntl(fd,F_GETFL);
  printf("change.......\n");
  if(flags & O_APPEND) printf("追加\n");
  if((flags&3)==O_WRONLY) printf("WRONLY\n");
  if((flags&3)==O_RDWR) printf("RDWR\n");
  if((flags&3)==O_RDONLY) printf("RDONLY\n"); 
  if(flags & O_TRUNC) printf("TRUNC\n");
}


