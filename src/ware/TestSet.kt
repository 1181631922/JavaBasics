package ware

import java.io.Serializable
import java.util.*

/**
 * Author： fanyafeng
 * Data： 2020/7/7 09:45
 * Email: fanyafeng@live.cn
 */

fun main(args: Array<String>) {

    val model1 = ChooseModel(id = "a2", name = "黄色")
    val model2 = ChooseModel(id = "a1", name = "绿色")
    val model3 = ChooseModel(id = "a3", name = "蓝色")
    val model4 = ChooseModel(id = "a3", name = "黄色")

    val modelSet = TreeSet<ChooseModel>()
    modelSet.apply {
        add(model1)
        add(model2)
        add(model3)
        add(model4)
    }

    modelSet.forEachIndexed { index, chooseModel ->
//        println(chooseModel.toString())
    }

    val userCanCheckList = mutableMapOf<Int, TreeSet<ChooseModel>>()
    userCanCheckList[0] = TreeSet()
    userCanCheckList[0]?.apply {
        add(model1)
        add(model2)
        add(model3)
        add(model4)
    }
    println(userCanCheckList[0].toString())
}

data class ChooseModel @JvmOverloads constructor(
        var name: String,//商品规格name
        var checkable: Boolean = true,
        var checked: Boolean = false,
        var id: String? = null//商品规格id
) :
        IChooseModel, Comparable<ChooseModel> {
    override fun getChooseItemTitle(): String {
        return name
    }

    override fun getChooseItemCheckable(): Boolean {
        return checkable
    }

    override fun getChooseItemChecked(): Boolean {
        return checked
    }

    override fun setChooseItemChecked(isChecked: Boolean) {
        checked = isChecked
    }

    override fun setChooseItemCheckable(checkable: Boolean) {
        this.checkable = checkable
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChooseModel

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun compareTo(other: ChooseModel): Int {
        return if (id == other.id) {
            0
        } else {
            1
        }
    }

}

interface IChooseModel : Serializable {

    /**
     * 单个view标题
     */
    fun getChooseItemTitle(): String

    /**
     * 是否可以被点击
     */
    fun getChooseItemCheckable(): Boolean

    /**
     * 是否被选中
     */
    fun getChooseItemChecked(): Boolean

    /**
     * 当有最大选取数量时控件会根据FIFO更新data model
     */
    fun setChooseItemChecked(isChecked: Boolean)

    /**
     * 更新是否可点击
     */
    fun setChooseItemCheckable(checkable: Boolean)
}