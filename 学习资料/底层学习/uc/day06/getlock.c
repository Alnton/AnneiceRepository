#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(){
  int fd = open("a.txt",O_RDWR);
  if(fd == -1) perror("open"),exit(-1);
  struct flock rlock;
  rlock.l_type = F_RDLCK;
  rlock.l_whence = SEEK_SET;
  rlock.l_start = 10;
  rlock.l_len = 10;
  rlock.l_pid = -1;
  int res = fcntl(fd,F_GETLK,&rlock);
  if(res == -1) perror("rlock"),exit(-1);
 printf("%d,%d,%d\n",F_RDLCK,F_WRLCK,F_UNLCK);
  printf("type=%d,whence=%d,start=%d,"
     "len=%d,pid=%d\n",rlock.l_type,
     rlock.l_whence,rlock.l_start,
     rlock.l_len,rlock.l_pid);
  if(rlock.l_pid == -1){
    printf("能加\n");
  }else printf("不能加\n");
  //练习：接着写 测试写锁能不能加的代码
  struct flock wlock;
  wlock.l_type = F_WRLCK;
  wlock.l_whence = SEEK_SET;
  wlock.l_start = 10;
  wlock.l_len = 10;
  wlock.l_pid = -1;
  res = fcntl(fd,F_GETLK,&wlock);
  if(res == -1) perror("wlock"),exit(-1);
  printf("type=%d,whence=%d,start=%d,"
     "len=%d,pid=%d\n",wlock.l_type,
     wlock.l_whence,wlock.l_start,
     wlock.l_len,wlock.l_pid);
  if(wlock.l_pid == -1){
    printf("能加\n");
  }else printf("不能加\n");
}


