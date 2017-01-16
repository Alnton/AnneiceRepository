#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>

int main(){
  struct stat s = {};
  int res = stat("a.txt",&s);
  if(res==-1) perror("stat"),exit(-1);
  printf("inode=%d\n",s.st_ino);//i节点
  printf("mode=%o\n",s.st_mode);//权限+类型
  printf("size=%d\n",s.st_size);//大小
  printf("nlink=%d\n",s.st_nlink);//硬链接数
  printf("最后修改时间:%s\n",
    ctime(&s.st_mtime));
  printf("权限:%o\n",s.st_mode & 07777); 
  if(S_ISREG(s.st_mode)) printf("是文件\n");
  if((s.st_mode&S_IFREG) == S_IFREG)
    printf("是文件\n");
  if(S_ISDIR(s.st_mode)) printf("是目录\n");
}


