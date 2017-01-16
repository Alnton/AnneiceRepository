#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main(){
  int sockfd = socket(PF_INET,SOCK_STREAM,0);
  if(sockfd == -1) perror("socket"),exit(-1);
  struct sockaddr_in addr;
  addr.sin_family = PF_INET;
  addr.sin_port = htons(2222);
  addr.sin_addr.s_addr = 
    inet_addr("192.168.182.14");
  int res = bind(sockfd,
    (struct sockaddr*)&addr,sizeof(addr));
  if(res == -1) perror("bind"),exit(-1);
  printf("bind ok\n");
  listen(sockfd,100);//练习：写客户端代码
  struct sockaddr_in from;//并调通
  socklen_t len = sizeof(from);
  int fd = accept(sockfd,
    (struct sockaddr*)&from,&len);
  char buf[100] = {}; read(fd,buf,100);
  printf("buf=%s\n",buf);
  write(fd,"welcome",7);
  close(fd); close(sockfd);
}


