#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <string.h>
#include <signal.h>
#include <time.h>

int sockfd;
void fa(int signo){
  close(sockfd);
  printf("服务器已关闭\n");
  exit(0);
}
int main(){
  printf("Ctrl+C退出服务器\n");
  signal(SIGINT,fa);
  sockfd = socket(PF_INET,SOCK_DGRAM,0);
  if(sockfd == -1)perror("socket"),exit(-1);
  struct sockaddr_in addr;
  addr.sin_family = PF_INET;
  addr.sin_port = htons(2222);
  addr.sin_addr.s_addr = INADDR_ANY;//代表本机
  int res = bind(sockfd,
    (struct sockaddr*)&addr,sizeof(addr));
  if(res == -1) perror("bind"),exit(-1);
  printf("bind ok\n");
  while(1){
    char buf[100] = {};
    struct sockaddr_in from;
    socklen_t len = sizeof(from);
    recvfrom(sockfd,buf,100,0,//获得发送方地址
      (struct sockaddr*)&from,&len); 
 //练习：UDP时间服务器，返回时间并加上信号关闭
 //时间服务器 时间格式：xxxx-xx-xx xx:xx:xx
    //不发送欢迎，发送时间
    time_t curtime = time(0);
    struct tm* cur = localtime(&curtime);
    sprintf(buf,
      "%4d-%02d-%02d %02d:%02d:%02d",
       cur->tm_year+1900,cur->tm_mon+1,
       cur->tm_mday,cur->tm_hour,
       cur->tm_min,cur->tm_sec);
    sendto(sockfd,buf,strlen(buf),0,
      (struct sockaddr*)&from,len);
  } 
}

