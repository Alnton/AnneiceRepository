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
  int res = bind(sockfd,
    (struct sockaddr*)&addr,sizeof(addr));
  if(res == -1) perror("bind"),exit(-1);
  printf("bind ok!\n");
  char buf[100] = {};
  res = read(sockfd,buf,sizeof(buf));
  printf("读了%d字节，内容:%s\n",res,buf);
  close(sockfd);//练习：写sockb本地通信客户端
}

