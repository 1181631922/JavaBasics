package something.override;

/**
 * Author： fanyafeng
 * Data： 2019-12-03 14:21
 * Email: fanyafeng@live.cn
 */
public class FatherClass {
    public static void testStatic() {
        System.out.println("测试子类是否可以重写");
    }

    public void testNormalMethod() {
        System.out.println("测试普通方法是否可以重写");
    }

    public void testNorMethod() {
        testNormalMethod();
    }
}
