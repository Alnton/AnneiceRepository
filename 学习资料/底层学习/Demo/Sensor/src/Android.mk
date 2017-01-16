LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_C_INCLUDES += inc
LOCAL_MODULE += senser

LOCAL_SRC_FILES += senser.c
LOCAL_SRC_FILES += test.c

#LOCAL_SHARED_LIBRARIES += #生成senser所以来的库

LOCAL_LDLIBS += -Llib
LOCAL_LDLIBS += -L$(SYSROOT)/usr/lib
LOCAL_LDLIBS += -lm -llog -ldl

include $(BUILD_SHARED_LIBRARY)
#include $(BUILD_EXECUTABLE
