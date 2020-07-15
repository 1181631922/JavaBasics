package multithreading.cas

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference

/**
 * Author： fanyafeng
 * Data： 2020/7/14 18:23
 * Email: fanyafeng@live.cn
 */
class CasTest1 {

}

fun main(args: Array<String>) {
//    val owner = AtomicReference<Thread>()
////    val current = Thread.currentThread()
//    val current = Thread("main")
//    println("current的名字：" + current.name)
//    //自旋
//    while (true) {
//        if (owner.compareAndSet(Thread("main"), current)) {
//            println(owner.get().name)
//            return
//        }
//    }

    val owner = AtomicInteger(1)
    val current = 1
    while (true) {
        if (owner.compareAndSet(1, current)) {
            println(owner.get().toString())
            return
        }
    }
}