#include <stdio.h>
#include "add.h"

int main(){
  int r1 = add(2,3);
  double r2 = add2(3.0,2.0);
  printf("r1=%d,r2=%lf\n",r1,r2);
  return 0;
}

