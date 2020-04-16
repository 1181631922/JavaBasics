package something.typevariable

import something.typevariable.kotlinsimple.DevManagerKotlin
import something.typevariable.kotlinsimple.EmployeeKotlin
import something.typevariable.kotlinsimple.ManagerKotlin
import something.typevariable.kotlinsimple.TestInAndOut
import kotlin.reflect.KClass

/**
 * Author： fanyafeng
 * Data： 2020/3/30 15:36
 * Email: fanyafeng@live.cn
 */
object TypeVariableKotlin {
    @JvmStatic
    fun main(args: Array<String>) {
        val managerJavaWorkStationJava = WorkStationJava(ManagerKotlin())
        val employeeJava: WorkStationJava<out EmployeeKotlin> = managerJavaWorkStationJava

        val workStationJava: WorkStationJava<in ManagerKotlin> = WorkStationJava(ManagerKotlin())
        workStationJava.employee = DevManagerKotlin()
        workStationJava.employee = ManagerKotlin()
//        workStationJava.employee = EmployeeKotlin()

        val list: MutableList<in Number> = mutableListOf()
        list.add(32)
        printFirst(list)

        val a = mutableMapOf<KClass<*>, List<*>>()
    }

    fun test(i: String, inter: TestInAndOut<String, Int>): Int {
        return inter.fun1(i)
    }

    fun <T : Any> get1(clazz: KClass<T>, list: List<T>) {

    }

    fun printFirst(list: List<*>) {
    }
}