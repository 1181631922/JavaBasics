package ktmethod

/**
 * Author： fanyafeng
 * Data： 2020/6/22 10:59
 * Email: fanyafeng@live.cn
 */

fun main(args: Array<String>) {
    testMethod("樊亚风", 30, ::myFun)
    testMethod("樊亚风", 30, ::myFun1)
}

fun testMethod(name: String, age: Int, method: ((name: String, age: Int) -> Unit)) {
    method(name, age)
}

fun myFun(name: String, age: Int) {
    println("姓名：$name,年龄：$age")
}

fun myFun1(name: String, age: Int) {
    println("就是这么个性的一个人：姓名：$name,年龄：$age")
}