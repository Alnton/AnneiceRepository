#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>

int main(){
  DIR* dir = opendir("../day01");
  if(dir == NULL) perror("opendir"),exit(-1);
  struct dirent* ent = readdir(dir);//先读
  while(ent /*!=NULL*/){//为NULL退出
  //printf("%d,%s\n",ent->d_type,ent->d_name);
   // printf("%d,%s\n",ent[0].d_type,
      //ent[0].d_name); // ent[0] == *(ent+0)
    printf("%d,%s\n",
      (*ent).d_type,(*ent).d_name);
    ent = readdir(dir);//继续读
  }//d_type == 4 是目录，不等于4 是文件
}

