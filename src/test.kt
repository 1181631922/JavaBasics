import ProcessTask as ProcessTask

/**
 * Author： fanyafeng
 * Data： 2020/6/2 14:46
 * Email: fanyafeng@live.cn
 */

fun main(args: Array<String>) {

    Task(Model("YYYY")).run()

    Test(Model("DDDD")).run()

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