/***************************************************
 *
 * JNI 调用 步骤  
 * JNI_Load() 首先启动jni调用
 * 再JNI_Load 中 调用static int registerNativeMethods()注册静态函数
 * 和会调函数
 * 在类 CLASS_FULL_NAME
 */
#include<stdio.h>
#include<jni.h> //声明了jni函数
#include<stddef.h>
#include<fcntl.h>
#include<inttypes.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>

#include<android/log.h>  //调试包
#define LOG_TAG "RAW_DATA" //调试tag

#define CLASS_FULL_NAME "com/howso/senser/SernserNative"  //调用so库的类全名
#define DATA_CALLBACK "native_data"     //回调函数名

#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)   //调试宏

#define DEL_JOBJ(env,c) do{ if(env&&c){(*env)->DeleteGlobalRef(env,c);c=0;}}while(0)
#define ARR_SIZE(a) sizeof((a))/sizeof((a[0]))

static JavaVM* jvm = NULL;
jmethodID data_callback_id = 0;  //回调函数的id

jclass logger_class = 0;
jobject logger_inst = 0;

//注册回调函数
static void init_notifier(JNIEnv *env, jclass clazz)
{
    if (env && clazz)
    {
        logger_class = (jclass)(*env)->NewGlobalRef(env, clazz);

        jmethodID data_callback = (*env)->GetMethodID(env, clazz, "<init>", "()V");
        if (data_callback)
        {
            jobject local_inst = (*env)->NewObject(env, clazz, data_callback);
            if (local_inst)
            {
                  LOGD("now init notifier...");
                DEL_JOBJ(env, logger_inst);
                logger_inst = (*env)->NewGlobalRef(env, local_inst);
                data_callback_id = (*env)->GetStaticMethodID(env, clazz, DATA_CALLBACK, "()V");  //设置会调函数的参数与返回值
            }
        }
    }
}

/**
 * jni静态函数1
 * 前俩个变量为jni调用的环境结果与类
 *
 * 参数为一个int 型的变量
 * 返回值为 string 类型
 */
JNIEXPORT jstring JNICALL jnihello(JNIEnv* env,jclass jclazzi, jint type) 
{
	LOGD("sock");
	//sock网络编程实例
	int fd = socket(AF_INET,SOCK_DGRAM,0);
	struct sockaddr_in cli_addr;
	cli_addr.sin_family = AF_INET;
	cli_addr.sin_port = htons(8080);
	cli_addr.sin_addr.s_addr = inet_addr("192.168.0.144");

	int res = connect(fd,(struct sockaddr*)(&cli_addr),sizeof(cli_addr));
	LOGD("res=%d",res);
	if(res == -1)
	{
		LOGD("connect failed");
		exit(-1);
	}

	res = write(fd,"hello,I am phone\n",17);
	LOGD("res=%d",res);
	if(res < 0)
	{
		LOGD("write failed\n");
	}

	close(fd);

	return (*env)->NewStringUTF(env,"jni_helloworld");
}
/***
 *jni静态函数2
 *无参数
 *返回值为 string 类型
 */
JNIEXPORT jstring JNICALL jnisock(JNIEnv* env,jclass jclazz)
{
	return (*env)->NewStringUTF(env,"sock_helloworld");
}



/**
 *注册jni静态函数的结构数组
 *第一个参数为android调用时需要的函数名
 *第二个参数为参数和返回值
 *第三个参数为C层对应的函数值
 */
static JNINativeMethod native_methods[] = {
	{"jni_hello","()Ljava/lang/String;",(void*)jnihello},
	{"jni_sock","()Ljava/lang/String;",(void*)jnisock},
};


/**
 *注册静态函数
 *与回调函数
 */
static int registerNativeMethods(JNIEnv* env, const char* className,
        JNINativeMethod* gMethods, int numMethods)
{
    jclass clazz = (*env)->FindClass(env, className);
    if (clazz == NULL)
    {
        return JNI_FALSE;
    }
	//注册静态函数
    if ((*env)->RegisterNatives(env, clazz, gMethods, numMethods) < 0)
    {
        return JNI_FALSE;
    }
    //init_notifier(env, clazz);    //注册会调函数
    return JNI_TRUE;
}
/**
 *启动jni调用
 */
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved)
{
    jvm = vm;
    JNIEnv* env = NULL;
    jint result = JNI_ERR;

    if ((*vm)->GetEnv(vm, (void**)&env, JNI_VERSION_1_6) == JNI_OK)
    {
        if (NULL != env && registerNativeMethods(
                    env, CLASS_FULL_NAME, native_methods, ARR_SIZE(native_methods)) == JNI_TRUE)
        {
            result = JNI_VERSION_1_6;
        }
    }
    return result;
}

