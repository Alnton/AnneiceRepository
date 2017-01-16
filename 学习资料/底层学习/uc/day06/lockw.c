#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(){
  int fd = open("a.txt",O_RDWR|O_CREAT,0666);
  if(fd == -1) perror("open"),exit(-1);
  struct flock lock;
  lock.l_type = F_WRLCK;
  lock.l_whence = SEEK_SET;
  lock.l_start = 0;
  lock.l_len = 10;
  lock.l_pid = -1;
  int res = fcntl(fd,F_SETLKW,&lock);//阻塞
  if(res == -1) perror("fcntl"),exit(-1);
  else printf("lock ok\n");
}


