package com.ripple.permission.annotation

/**
 * Author： fanyafeng
 * Data： 2020/4/14 10:46
 * Email: fanyafeng@live.cn
 */

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation class NeedPermission(val permissionList: Array<String>, val failMethodName: String)