package something.typevariable;

import something.typevariable.javasimple.DevManagerJava;
import something.typevariable.javasimple.EmployeeJava;
import something.typevariable.javasimple.ManagerJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author： fanyafeng
 * Data： 2020/3/30 15:51
 * Email: fanyafeng@live.cn
 * <p>
 * https://segmentfault.com/a/1190000018531061?utm_source=tag-newest
 */
public class TypeVariableJava {
    public static void main(String[] args) {
        WorkStationJava<ManagerJava> managerJavaWorkStationJava = new WorkStationJava<>(new ManagerJava("姓名"));
        WorkStationJava<? extends EmployeeJava> employeeJava = managerJavaWorkStationJava;

        WorkStationJava<? super ManagerJava> workStationJava = new WorkStationJava<>(new ManagerJava("姓名"));
        workStationJava.setEmployee(new DevManagerJava("那么"));
        workStationJava.setEmployee(new ManagerJava("姓名"));
//        workStationJava.setEmployee(new EmployeeJava("那么"));

//        val list: MutableList<in Number> = mutableListOf()
//        list.add(32)
        List<? super Number> list = new ArrayList<>();
        list.add(2);
        printFirst(list);
        Map<Class<?>, List<?>> a = new HashMap<>();
    }

    private <T> void get1(Class<T> clazz, List<T> list) {

    }

    private static void printFirst(List<?> list) {
    }
}
