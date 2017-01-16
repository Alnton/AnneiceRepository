#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <string.h>

int main(){
  int sockfd = socket(PF_INET,SOCK_DGRAM,0);
  if(sockfd == -1)perror("socket"),exit(-1);
  struct sockaddr_in addr;
  addr.sin_family = PF_INET;
  addr.sin_port = htons(2222);
  addr.sin_addr.s_addr = INADDR_ANY;//代表本机
  sendto(sockfd,"hello",5,0,
    (struct sockaddr*)&addr,sizeof(addr));
  //write(sockfd,"hello",5);//没有接收方地址
  char buf[100] = {};
  read(sockfd,buf,100);
  printf("time:%s\n",buf);
  close(sockfd);
}

