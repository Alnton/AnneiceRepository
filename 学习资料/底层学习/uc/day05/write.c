#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(){
  int fd = open("a.txt",O_RDWR);
  struct flock lock;
  lock.l_type = F_WRLCK;
  lock.l_whence = SEEK_SET;
  lock.l_start = 0;
  lock.l_len = 10;
  lock.l_pid = -1;
  int res = fcntl(fd,F_SETLK,&lock);
  if(res == -1) printf("文件被锁定无法写\n");
  else write(fd,"hello",5);
  close(fd);
}

