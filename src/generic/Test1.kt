package generic

/**
 * Author： fanyafeng
 * Data： 2020/6/16 11:03
 * Email: fanyafeng@live.cn
 */

data class ProcessModelImpl @JvmOverloads constructor(var sourcePath: String, var targetPath: String = "我是默认的target") : ProcessModel<String, String> {
    override fun getSource(): String {
        return sourcePath
    }

    override fun getTarget(): String? {
        return targetPath
    }

    override fun setTarget(target: String) {
        this.targetPath = target
    }

    override fun parse(source: String, target: String): String {
        return "这是原路径：" + source.toUpperCase()
    }

}

interface ProcessModel<S, T> {

    fun getSource(): S

    fun getTarget(): T?

    fun setTarget(target: T)

    fun parse(source: S, target: T): T
}

interface ProcessTask<S, T> {
    fun getItem(): ProcessModel<S, T>
}

class ProcessTaskImpl<S, T> : ProcessTask<S, T> {

    private var result: List<ProcessModel<S, T>> = arrayListOf()

    override fun getItem(): ProcessModel<S, T> {
        if (result.isNotEmpty()) {
            return result[0]
        }
        return result[0]
    }

    fun handleList(list: List<ProcessModel<S, T>>) {
        result = list
    }
}


fun main(args: Array<String>) {
    val handleList = mutableListOf<ProcessModelImpl>()
    handleList.apply {
        add(ProcessModelImpl("我是第一个aaa"))
        add(ProcessModelImpl("我是第二个bbb"))
    }

    val impl = ProcessTaskImpl<String, String>()
    impl.handleList(handleList)
    println(impl.getItem().getSource())
}
