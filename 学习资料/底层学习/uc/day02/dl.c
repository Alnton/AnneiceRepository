#include <stdio.h>
#include <dlfcn.h>

int main(){
  void* handler = dlopen(
    "./shared/libmyku.so",RTLD_NOW);
  char *error = dlerror();
  if(error/*!=NULL*/){//出错 !=0可以省略
    printf("打开库文件出错\n"); return -1; }
  double (*f) (double,double);//(*f)替换函数名
  f = dlsym(handler,"add2");
  error = dlerror();
  if(error){
    printf("函数出错\n"); return -1; }
  double r = f(2.0,3.0);
  printf("r=%lf\n",r);
  dlclose(handler);
}

