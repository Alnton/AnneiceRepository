#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <signal.h>
#include <unistd.h>
int sockfd;
void fa(int signo){
  close(sockfd);
  printf("服务器关闭\n");
  exit(0);
}
int main(){
  signal(SIGINT,fa);
  sockfd = socket(PF_INET,SOCK_STREAM,0);
  if(sockfd == -1) perror("socket"),exit(-1);
  struct sockaddr_in addr;
  addr.sin_family = PF_INET;
  addr.sin_port = htons(2222);
  addr.sin_addr.s_addr = 
    inet_addr("192.168.182.14");
  //解决重启时地址被占用问题
  int reuseaddr = 1;
  setsockopt(sockfd,SOL_SOCKET,SO_REUSEADDR,
   &reuseaddr,sizeof(reuseaddr));
  int res = bind(sockfd,
    (struct sockaddr*)&addr,sizeof(addr));
  if(res == -1) perror("bind"),exit(-1);
  printf("bind ok\n");
  listen(sockfd,100);
  while(1){
    struct sockaddr_in from;
    socklen_t len = sizeof(from);
    int fd = accept(sockfd,
      (struct sockaddr*)&from,&len);
    char* fromip = inet_ntoa(from.sin_addr);
    printf("客户端%s连接成功\n",fromip);
    pid_t pid = fork();
    if(pid == 0){
      while(1){
        char buf[100] = {}; 
        read(fd,buf,100);
        printf("buf=%s\n",buf);
        if(strcmp(buf,"bye")==0) break;
        write(fd,buf,strlen(buf));  } 
      close(fd); 
      exit(0);
    }
    close(fd);
  }
}


