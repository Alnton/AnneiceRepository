#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(){
  int fd = open("a.txt",O_RDWR);
  if(fd == -1) perror("open"),exit(-1);
  struct flock lock;
  lock.l_type = F_RDLCK;//F_WRLCK
  lock.l_whence = SEEK_SET;
  lock.l_start = 0;
  lock.l_len = 20;
  lock.l_pid = -1;//SETLK时，不使用pid，-1即可
  int res = fcntl(fd,F_SETLK,&lock);
  if(res == -1) printf("锁定失败\n");
  else printf("锁定成功，开始读文件\n");
  sleep(20);//模拟读文件需要20秒
  printf("文件读完，开始释放锁\n");
  lock.l_type = F_UNLCK;
  fcntl(fd,F_SETLK,&lock);//释放锁
  sleep(20);
  printf("main over\n");
}


