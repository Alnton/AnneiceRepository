#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
  int fd = open("a.pipe",O_RDONLY);
  int i; 
  for(i=0;i<100;i++){
    int x;
    read(fd,&x,4);
    printf("x=%d\n",x);
  }
  close(fd);
}


