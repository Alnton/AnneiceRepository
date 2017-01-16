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
  int fd = open("emp.dat",
    O_RDWR|O_CREAT|O_TRUNC,0666);
  if(fd==-1) perror("open"),exit(-1);
  ftruncate(fd,sizeof(struct emp)*3);
  void* p = mmap(0,sizeof(struct emp)*3,
    PROT_READ|PROT_WRITE,
    //MAP_PRIVATE,//私有 不会写入文件
    MAP_SHARED,//练习：写mmap2.c 映射emp.dat
    fd,0);//打印出数据
  if(p == MAP_FAILED) perror("mmap"),exit(-1);
  struct emp* pe = p;
  pe[0].id = 100; pe[0].sal = 12000.0;
  strcpy(pe[0].name,"zhangfei"); 
  pe[1].id = 200; pe[1].sal = 20000.0;
  strcpy(pe[1].name,"guanyu"); 
  pe[2].id = 300; pe[2].sal = 24000.0;
  strcpy(pe[2].name,"liubei"); 
  munmap(p,sizeof(struct emp)*3);
}


