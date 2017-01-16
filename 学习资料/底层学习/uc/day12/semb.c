#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <unistd.h>

int main(){
  key_t key = ftok(".",100);
  int semid = semget(key,0,0);
  int i;
  for(i=0;i<10;i++){
    pid_t pid = fork();
    if(pid == 0){
      struct sembuf op; op.sem_num = 0;//下标
      op.sem_op = -1; op.sem_flg = 0;
      semop(semid,&op,1);//数组的地址等于第一个元素的首地址
      printf("申请共享资源成功\n");
      sleep(20);//操作共享资源
      printf("共享资源使用完毕\n");
      op.sem_op = 1;
      semop(semid,&op,1);//计数加1
      exit(0);
    }
  }
}


