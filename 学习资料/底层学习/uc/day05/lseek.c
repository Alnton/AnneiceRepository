#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(){
  int fd = open("a.txt",O_RDWR);
  if(fd == -1) perror("open"),exit(-1);
  char ch;
  read(fd,&ch,1); printf("%c\n",ch);//a
  read(fd,&ch,1); printf("%c\n",ch);//b
  lseek(fd,3,SEEK_CUR);
  read(fd,&ch,1); printf("%c\n",ch);//f
  lseek(fd,0,SEEK_SET);//回到第一个位置
  write(fd,"1",1);//a
  lseek(fd,3,SEEK_SET); write(fd,"2",1);//d
  lseek(fd,2,SEEK_CUR); write(fd,"3",1);//g
  lseek(fd,-2,SEEK_CUR); write(fd,"4",1);//f
  lseek(fd,-2,SEEK_END); write(fd,"5",1);//t
  close(fd);
}

