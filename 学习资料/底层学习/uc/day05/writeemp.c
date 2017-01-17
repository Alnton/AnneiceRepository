#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
struct emp{
  int id;
  char name[20];
  double sal;
};
int main(){
  struct emp em = {1,"zhangfei",12000.0};
  char buf[50] = {};
  sprintf(buf,"%d%s%lf",em.id,em.name,em.sal);
  int fd = open("emp.dat",
    O_WRONLY|O_CREAT|O_TRUNC,0666);
  if(fd == -1) perror("open"),exit(-1);
  write(fd,buf,strlen(buf));
  close(fd);
}

