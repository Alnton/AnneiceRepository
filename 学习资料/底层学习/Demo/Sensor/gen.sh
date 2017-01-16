#########################################################################
# File Name: gen.sh
# Author: rank
# mail: rank_ck@sina.com
# Created Time: 2016年02月03日 星期三 10时20分17秒
#########################################################################
#!/bin/bash

ndk-build NDK_PROJECT_PATH=./src    APP_BUILD_SCRIPT=./src/Android.mk
