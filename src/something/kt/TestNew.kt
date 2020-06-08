package something.kt

import kotlin.reflect.KClass

/**
 * Author： fanyafeng
 * Data： 2020-02-24 17:24
 * Email: fanyafeng@live.cn
 */
object TestNew {
    @JvmStatic
    fun main(args: Array<String>) {
//        val personList = listOf<Person>(Person(1), Person(2))
//        personList.maxBy(Person::age)
//        personList.maxBy { it.age }

//        val clazz = Point::class
//        clazz.annotations.forEachIndexed { index, annotation ->
//            println(annotation.toString())
//            println(annotation.javaClass.toString())
//            println(annotation.annotationClass.toString())
//            println(GAImageLoadFrame::class.toString())
//
////            Class.forName("").newInstance()
//        }

        println(7%3)

    }

    data class Person(var age: Int) {

        val getAge = { person: Person -> person.age }

        fun getMyAge(int: Int) = age

        fun getYouAge(method: (i: Int) -> Int) {
            method(6)
        }

        fun test() {
            getYouAge(this::getMyAge)
        }

    }

    data class A(var a: Int)

}