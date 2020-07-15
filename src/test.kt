/**
 * Author： fanyafeng
 * Data： 2020/6/2 14:46
 * Email: fanyafeng@live.cn
 */

fun main(args: Array<String>) {
//
//    Task(Model("YYYY")).run()
//
//    Test(Model("DDDD")).run()

    (0 until 11).forEach {
        if (it == 4) {
            return@forEach
        }
        if (it==8){
            return
        }
        println("输出：" + it)


    }

    println(5 shr 1)

    println(4 shl 1)

}

class Task(override var processModel: Model) : ProcessTaskImpl<Model>() {

}

abstract class ProcessTaskImpl<T : ProcessModel> : ProcessTask<T> {

}

interface ProcessTask<T : ProcessModel> : Runnable {
    var processModel: T

    override fun run() {
        println("开始")
        println(processModel.parse(processModel.getSourcePath()))
        println("结束")
    }


}

interface ProcessModel {
    fun getSourcePath(): String

    fun parse(source: String): String
}

class Model(private val path: String) : ProcessModel {
    override fun getSourcePath(): String {
        return path
    }


    override fun parse(source: String): String {
        return source.toLowerCase()
    }

}