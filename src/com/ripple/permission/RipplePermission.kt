package com.ripple.permission

/**
 * Author： fanyafeng
 * Data： 2020/4/14 13:59
 * Email: fanyafeng@live.cn
 */
object RipplePermission {
    fun doCheckPermission(host: Any, permissions: List<String>,
                          methodName: String, methodDesc: String, args: List<Any>,
                          failMethodName: String?): Boolean {

        return true
    }
}