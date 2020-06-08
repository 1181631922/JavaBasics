package something

import kotlin.reflect.KType
import kotlin.reflect.jvm.reflect

/**
 * Author： fanyafeng
 * Data： 2019-12-25 11:26
 * Email: fanyafeng@live.cn
 */
object TestReflect {
    @JvmStatic
    fun main(args: Array<String>) {

//        val testClazz = TestClazz()
//
//        testClazz.onSuccess<String> {
//
//        }
//
//        testClazz.getType()

    }


    class TestClazz {
        var mSuccessLambda: SuccessLambda<Any> = null

        fun <T> onSuccess(successLambda: SuccessLambda<T>) {
            mSuccessLambda = successLambda as SuccessLambda<Any>
        }


        fun getType() {
            val lambda = mSuccessLambda
            var kType: KType? = null

            if (lambda != null) {
                val reflect = lambda.reflect()
                var result: KType? = null
                if (reflect != null) {
                    result = reflect.parameters[0].type
                }
                kType = result

                //获取反射类型
                println(kType.toString())
            }
        }
    }


}

typealias SuccessLambda<T> = ((result: T) -> Unit)?


fun main(args: Array<String>) {

}