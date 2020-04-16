package something.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Author： fanyafeng
 * Data： 2020-01-09 10:30
 * Email: fanyafeng@live.cn
 */
public class TestReflectMethod {
    public static void main(String[] args) {

        Map<String, PageNameData> map = new HashMap<String, PageNameData>();
        map.put("test", new PageNameData("fanyafeng", PageName.class, true));

        for (Map.Entry<String, PageNameData> item : map.entrySet()) {
            PageNameData myItem = item.getValue();
            Method method = null;
            try {
                method = myItem.getClass().getDeclaredMethod("getFullName");
                method.getReturnType().toGenericString();
                System.out.println("方法返回值类型：" + method.getGenericReturnType().getTypeName());

//                Field[] fields = myItem.getClass().getDeclaredFields();
//                for (Field field : fields) {
//                    System.out.println(field.getGenericType().toString());
//                    System.out.println("类型为：" + field.getType().getName());
//                    System.out.println("类型为："+getReflectType(field.getType().getName()));
//                }

                System.out.println(method.getDeclaringClass().toString());
                String name = (String) method.invoke(myItem);
                System.out.println(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        PageNameData item = map.get("test");
//
//        Method method = null;
//        try {
//            method = item.getClass().getDeclaredMethod("getFullName");
//            String name = (String) method.invoke(item);
//            System.out.println(name);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    /**
     * 只能获取基础类型
     *
     * @param fromData
     * @return toData
     */
    private static String getReflectType(String fromDataType) {
        String toDataType = null;
        final String[] types = {
                "java.lang.Integer",
                "java.lang.Double",
                "java.lang.Float",
                "java.lang.Long",
                "java.lang.Short",
                "java.lang.Byte",
                "java.lang.Boolean",
                "java.lang.Character",
                "java.lang.String",
                "java.lang.Class",
                "int", "double", "long", "short", "byte", "boolean", "char", "float"};
        switch (fromDataType) {
            case "java.lang.Integer":
            case "int":
                toDataType = "Integer";
                break;
            case "java.lang.Double":
            case "double":
                toDataType = "Double";
                break;
            case "java.lang.Float":
            case "float":
                toDataType = "Float";
                break;
            case "java.lang.Long":
            case "long":
                toDataType = "Long";
                break;
            case "java.lang.Short":
            case "short":
                toDataType = "Short";
                break;
            case "java.lang.Byte":
            case "byte":
                toDataType = "Byte";
                break;
            case "java.lang.Boolean":
            case "boolean":
                toDataType = "Boolean";
                break;
            case "java.lang.Character":
            case "char":
                toDataType = "Character";
                break;
            case "java.lang.String":
                toDataType = "String";
                break;
            case "java.lang.Class":
                toDataType = "Class";
                break;
        }
        return toDataType;
    }
}
