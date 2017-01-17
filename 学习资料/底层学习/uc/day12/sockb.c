#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <sys/un.h>

int main(){//本地通信
  int sockfd = socket(PF_UNIX,SOCK_DGRAM,0);
  if(sockfd == -1) perror("socket"),exit(-1);
  struct sockaddr_un addr;
  addr.sun_family = PF_UNIX;//与socket保持一致
  strcpy(addr.sun_path,"a.sock");
  int res = connect(sockfd,
    (struct sockaddr*)&addr,sizeof(addr));
  if(res == -1) perror("connect"),exit(-1);
  printf("connect ok!\n");
  write(sockfd,"hello",5);
  close(sockfd);
}

