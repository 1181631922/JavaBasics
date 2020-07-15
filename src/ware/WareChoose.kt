package ware

import com.alibaba.fastjson.JSONArray
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

/**
 * Author： fanyafeng
 * Data： 2020/6/29 15:45
 * Email: fanyafeng@live.cn
 */

class WareChoose {

    @Test
    fun unionList() {
//        val shopList = listOf("a1-b1-c1", "a1-b1-c3", "a1-b2-c1", "a2-b2-c3", "a1-b2-c3", "a1-b3-c3", "a1-b3-c2")
        val shopList = listOf("a1-b1-c1", "a2-b1-c1", "a3-b2-c2", "a1-b2-c1")
        val skuList = mutableListOf<List<String>>()
        shopList.forEach { spu ->
            val spuList = spu.split("-")
            skuList.add(spuList)
        }
        println("可选商品集合：$skuList")
        println()

        val selectCount = 3

        /**
         * 用户选择的参数
         */
        val userCheckList: MutableList<String> = mutableListOf()

        val userCanCheckList = mutableMapOf<Int, TreeSet<String>>()

        /**
         * 保存被选后会有那些选项序列
         */
        val containCanSelectList: MutableList<List<List<String>>> = mutableListOf()

        (0 until selectCount).forEach { index ->
            userCheckList.add("")
            containCanSelectList.add(mutableListOf())
            userCanCheckList[index] = TreeSet()
        }

        userCheckList[0] = "a2"
        userCheckList[1] = "b2"
        userCheckList[2] = "c1"

        /**
         * 用户选择和反选后开始进行筛选可选项
         */
        userCheckList.forEachIndexed { index, userCheckListItem ->
            if (!userCheckListItem.isNullOrBlank()) {
                val canSelectList = mutableListOf<List<String>>()
                skuList.forEach { skuListItem ->
                    if (skuListItem.contains(userCheckListItem)) {
                        canSelectList.add(skuListItem)
                    }
                }
                containCanSelectList[index] = canSelectList
            }
        }

        val containCanSelectSet = mutableSetOf<List<String>>()
        containCanSelectList.forEach {
            containCanSelectSet.addAll(it.toMutableSet())
        }

        containCanSelectSet.forEachIndexed { index, containCanSelectSetItem ->
            containCanSelectSetItem.forEachIndexed { innerIndex, it ->
                userCanCheckList[innerIndex]?.add(it)
            }
        }

        userCheckList.forEachIndexed { index, it ->

            println("第 $index 类已选规格：$it ")
        }

        userCanCheckList.forEach { (t, u) ->
            println()
            print("第 $t 类用户可选规格为：")
            u.forEach {
                print("$it ")
            }
        }


//        val aSelect = "a3"
//        val bSelect = "b2"
//        val cSelect = "c2"
//
//        /**
//         * 当a被选择
//         */
//        val aSelectList = mutableListOf<List<String>>()
//        if (!aSelect.isNullOrBlank()) {
//            skuList.forEach { spuList ->
//                if (spuList.contains(aSelect)) {
//                    aSelectList.add(spuList)
//                }
//            }
//            println(aSelectList.toString())
//        }
//
//        /**
//         * 当b被选择
//         */
//        val bSelectList = mutableListOf<List<String>>()
//        if (!bSelect.isNullOrBlank()) {
//            skuList.forEach { spuList ->
//                if (spuList.contains(bSelect)) {
//                    bSelectList.add(spuList)
//                }
//            }
//            println(bSelectList)
//        }
//
//        /**
//         * 当c被选择
//         */
//        val cSelectList = mutableListOf<List<String>>()
//        if (!bSelect.isNullOrBlank()) {
//            skuList.forEach { spuList ->
//                if (spuList.contains(cSelect)) {
//                    cSelectList.add(spuList)
//                }
//            }
//            println(bSelectList)
//        }
//
//        val unionSelect = aSelectList.union(bSelectList)
//        println("当$aSelect $bSelect $cSelect 被选择时，以下为所有可选框")
//        val canSelectSet = TreeSet<String>()
//        unionSelect.forEach {
//            it.forEach { innerIt ->
//                canSelectSet.add(innerIt)
//            }
//        }
//        canSelectSet.forEach {
//            print(" 可选框：" + it)
//        }

    }

    @Test
    fun main() {

        /**
         * 规格1有三个选项
         */
        val a1 = Spec1("a1", "红色")
        val a2 = Spec1("a2", "绿色")
        val a3 = Spec1("a3", "蓝色")

        /**
         * 规格1列表
         */
        val aSpecList = mutableListOf<ISpec>(a1, a2, a3)

        val b1 = Spec2("b1", "帽子")
        val b2 = Spec2("b2", "T恤")
        val b3 = Spec2("b3", "裤子")
        val b4 = Spec2("b4", "群子")

        /**
         * 规格2列表
         */
        val bSpecList = mutableListOf<ISpec>(b1, b2, b3, b4)

        val c1 = Spec3("c1", "男士")
        val c2 = Spec3("c2", "女士")
        val c3 = Spec3("c3", "中性")

        /**
         * 规格3列表
         */
        val cSpecList = mutableListOf<ISpec>(c1, c2, c3)

        val allSpecList = mutableListOf(aSpecList, bSpecList, cSpecList)

        /**
         * 模拟三个规格商品
         */
        val shopList = listOf("a1-b1-c1", "a1-b1-c3", "a1-b2-c1", "a2-b2-c3", "a1-b2-c3", "a1-b3-c3", "a1-b3-c2")


        val jsonArray = JSONArray()
        shopList.forEach {
            jsonArray.add(it)
        }
        println(jsonArray.toString())

        println("所有规格列表：" + allSpecList.toString())


        val tempSpecGroup = mutableListOf<List<String>>()
        shopList.forEachIndexed { index, spec ->
            val specList = spec.split("-")
            val tempSpecList = mutableListOf<String>()
            specList.forEach {
                tempSpecList.add(it)
            }
            tempSpecGroup.add(tempSpecList)
        }

        /**
         * 商品列表
         */
        println("这些为商品列表：、\n$tempSpecGroup")

        /**
         * 当规格1为a1
         */
        val selectResult1 = tempSpecGroup.filter { it[0] == "a1" }
        println("--------当规格1为a1有以下商品------------")
        println("当前选中态为 规格1 的 a1 ")
        println("这些可选：$selectResult1")
        println("具体可选规格有以下几种情况：")

        selectResult1.forEach {
            println()
            it.forEachIndexed { index, item ->
                val select = allSpecList[index].find { spec -> spec.getSpecId() == item }
                select?.setCheckable(true)
                print(select.toString())
            }
        }

        println()


        println()

        println("--------------------------------------")


        println()
        println()
        println()
        /**
         * 当规格2为b2
         */
        val selectResult2 = selectResult1.filter { it[1] == "b2" }
        println("--------当规格2为b2有以下商品------------")
        println("当前选中态为规格1 的a1 和 规格2 的 b2 ")
        println("这些可选：$selectResult2")
        println("具体可选规格有以下几种情况：")
        selectResult2.forEach {
            println()
            it.forEachIndexed { index, item ->
                val select = allSpecList[index].find { spec -> spec.getSpecId() == item }
                select?.setCheckable(true)
                print(select.toString())
            }
        }

        println()

        println()
        println("--------------------------------------")

    }


    /**
     * 规格1
     */
    class Spec1 @JvmOverloads constructor(private val id: String, val name: String, var checkAble: Boolean = true) : ISpec {

        override fun getSpecId(): String {
            return id
        }

        override fun getSpecName(): String {
            return name
        }

        override fun getCheckable(): Boolean {
            return checkAble
        }

        override fun setCheckable(checkable: Boolean) {
            this.checkAble = checkAble
        }

        override fun toString(): String {
            return if (checkAble) {
                "规格1可选(id='$id', name='$name')"
            } else {
                "规格1(id='$id', name='$name')"
            }
        }
    }

    /**
     * 规格2
     */
    class Spec2 @JvmOverloads constructor(private val id: String, val name: String, var checkAble: Boolean = true) : ISpec {

        override fun getSpecId(): String {
            return id
        }

        override fun getSpecName(): String {
            return name
        }

        override fun getCheckable(): Boolean {
            return checkAble
        }

        override fun setCheckable(checkable: Boolean) {
            this.checkAble = checkAble
        }

        override fun toString(): String {
            return if (checkAble) {
                "规格2可选(id='$id', name='$name')"
            } else {
                "规格2(id='$id', name='$name')"
            }

        }
    }

    /**
     * 规格3
     */
    class Spec3 @JvmOverloads constructor(private val id: String, val name: String, var checkAble: Boolean = true) : ISpec {

        override fun getSpecId(): String {
            return id
        }

        override fun getSpecName(): String {
            return name
        }

        override fun getCheckable(): Boolean {
            return checkAble
        }

        override fun setCheckable(checkable: Boolean) {
            this.checkAble = checkAble
        }

        override fun toString(): String {
            return if (checkAble) {
                "规格3可选(id='$id', name='$name')"
            } else {
                "规格3(id='$id', name='$name')"
            }
        }
    }

    interface ISpec {
        /**
         * 规格必须要有的key
         */
        fun getSpecId(): String

        /**
         * 为了方便直接定义name
         */
        fun getSpecName(): String

        /**
         * 是否可选
         */
        fun getCheckable(): Boolean

        /**
         *
         */
        fun setCheckable(checkable: Boolean)
    }
}