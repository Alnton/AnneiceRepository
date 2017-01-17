#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(){
  int fd = open("a.txt",O_RDWR);
  if(fd == -1) perror("open"),exit(-1);
  struct flock lock;
  lock.l_type = F_WRLCK;//
  lock.l_whence = SEEK_SET;
  lock.l_start = 10;
  lock.l_len = 20;
  lock.l_pid = -1;//SETLK时，不使用pid，-1即可
  int res = fcntl(fd,F_SETLK,&lock);
  if(res == -1) printf("锁定失败\n");
  else printf("锁定成功\n");
}


