#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
  int fd = open("a.pipe",O_WRONLY/*O_RDWR*/);
  //open不能建管道文件
  int i; 
  for(i=0;i<100;i++){
    write(fd,&i,4);
    usleep(100000);
  }
  close(fd);
}


