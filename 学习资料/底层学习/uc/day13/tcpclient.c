#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>

int main(){
  int sockfd = socket(PF_INET,SOCK_STREAM,0);
  if(sockfd == -1) perror("socket"),exit(-1);
  struct sockaddr_in addr;
  addr.sin_family = PF_INET;
  addr.sin_port = htons(2222);//本机转网络格式
  addr.sin_addr.s_addr = inet_addr(
   "192.168.182.14");//点分十进制转成整数ip
  int res = connect(sockfd,
    (struct sockaddr*)&addr,sizeof(addr));
  if(res==-1) perror("connect"),exit(-1);
  while(1){
    char word[100] = {};
    printf("请输入要说的话\n");
    scanf("%s",word);
    write(sockfd,word,strlen(word));
    if(strcmp(word,"bye")==0) break;
    char buf[100] = {};
    read(sockfd,buf,100);
    printf("client:%s\n",buf);
  }
  close(sockfd);
}

