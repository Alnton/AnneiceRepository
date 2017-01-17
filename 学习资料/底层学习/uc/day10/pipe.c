#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
  int fd[2] = {}; pipe(fd);
  int i;
  pid_t pid = fork();
  if(pid == 0){
    close(fd[1]);//关闭写端
    for(i=0;i<100;i++){
      int x; read(fd[0],&x,4);
      printf("%d ",x); fflush(0); }
    close(fd[0]); exit(0);  }
  close(fd[0]);//关闭读端
  for(i=0;i<100;i++){
    write(fd[1],&i,4); usleep(100000); }
  close(fd[1]);
}


