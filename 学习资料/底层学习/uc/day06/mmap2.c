#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

struct emp{
  int id;
  char name[20];
  double sal;
};
int main(){
  int fd = open("emp.dat",O_RDWR/*O_RDONLY*/);
  if(fd==-1) perror("open"),exit(-1);
  void* p = mmap(0,sizeof(struct emp)*3,
    PROT_READ|PROT_WRITE,//与fd的权限要匹配
    MAP_SHARED,fd,0);
  if(p == MAP_FAILED) perror("mmap"),exit(-1);
  struct emp* pe = p;
  int i;
  for(i=0;i<3;i++){
    printf("%d,%s,%lf\n",pe[i].id,pe[i].name,
      pe[i].sal); }
  munmap(p,sizeof(struct emp)*3);
  close(fd);
}

