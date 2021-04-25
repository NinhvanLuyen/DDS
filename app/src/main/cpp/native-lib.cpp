#include <jni.h>

//
// Created by Ninh Luyen on 4/25/21.
//
#define DOOR_ID "60c6fbeb4b93ac653c492ba806fc346d"

extern "C"
JNIEXPORT jstring JNICALL
Java_ninh_luyen_dds_datas_world_Door_openMainDoor(JNIEnv *env, jobject thiz) {
    const char *msg = DOOR_ID;
    return env->NewStringUTF(msg);
}