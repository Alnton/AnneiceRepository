#include <stdio.h>
#include <signal.h>

int main(){
  printf("size=%d\n",sizeof(sigset_t));
  sigset_t set; printf("set=%d\n",set);//乱码
  sigemptyset(&set);
  printf("set=%d\n",set);//0
  sigaddset(&set,2);
  printf("set=%d\n",set);//2,倒数第二位 置1
  sigaddset(&set,3);
  printf("set=%d\n",set);//6
  sigaddset(&set,7);
  printf("set=%d\n",set);//70
  sigdelset(&set,3);
  printf("set=%d\n",set);//66
  if(sigismember(&set,7))printf("信号7在\n");
}

