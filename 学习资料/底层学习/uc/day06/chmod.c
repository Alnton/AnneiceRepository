#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>

int main(){
  struct stat s = {};
  stat("a.txt",&s);
  printf("%o\n",s.st_mode&0777);
  printf("size=%d\n",s.st_size);
  chmod("a.txt",0600);//修改权限
  truncate("a.txt",100);//指定文件的大小
  stat("a.txt",&s);
  printf("%o\n",s.st_mode&0777);
  printf("size=%d\n",s.st_size);
}


