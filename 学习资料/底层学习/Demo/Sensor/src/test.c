/*************************************************************************
    > File Name: src/test.c
    > Author: rank
    > Mail: rank_ck@sina.com 
    > Created Time: 2016年02月03日 星期三 11时56分44秒
 ************************************************************************/

#include<stdio.h>
#include <jni.h> 

jstring Java_com_howso_senser_SernserNative_hello(JNIEnv* env,jobject obj){

	return  (*env)->NewStringUTF(env,"helloworldfromc");

}
