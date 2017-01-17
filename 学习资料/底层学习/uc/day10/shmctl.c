#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

int main(){
  key_t key = ftok(".",100);
  printf("key=%x\n",key);
  int shmid = shmget(key,0,0);
  struct shmid_ds ds;
  shmctl(shmid,IPC_STAT,&ds);//查询
  printf("key=%x\n",ds.shm_perm.__key);
  printf("mode=%o\n",ds.shm_perm.mode);
  printf("size=%d\n",ds.shm_segsz);
  printf("cpid=%d\n",ds.shm_cpid);
  printf("nattch=%d\n",ds.shm_nattch);
  ds.shm_perm.mode = 0600;//能改
  ds.shm_segsz = 400;//不能改
  shmctl(shmid,IPC_SET,&ds);//修改
  //shmctl(shmid,IPC_RMID,0);//删除
}


