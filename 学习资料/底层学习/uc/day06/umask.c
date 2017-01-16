#include <stdio.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
int main(){
  mode_t old = umask(0022);
  int fd = open("abc",O_RDWR|O_CREAT,0666);
  umask(old);//恢复系统的权限屏蔽字
  //写察看abc文件的权限的代码
}

