#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <string.h>

void print(char* path){
  DIR* dir = opendir(path);
  if(dir == NULL) return;//return和void对应
  //chdir(path);
  struct dirent* ent;
  while(ent=readdir(dir)){//1读2赋值3判断ent
    if(ent->d_type == 4){//目录
      printf("[%s]\n",ent->d_name);
      if((strcmp(".",ent->d_name)==0)||
       (strcmp("..",ent->d_name)==0))continue;
      //print(ent->d_name);
      char buf[100] = {};
      sprintf(buf,"%s/%s",path,ent->d_name);
      printf("%s\n",buf);
      print(buf);
    }else{//文件
      printf("%s\n",ent->d_name);
    }
  }
  //chdir("..");
}
int main(){
  print("../day01");
}

