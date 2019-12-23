package something.override;

/**
 * Author： fanyafeng
 * Data： 2019-12-03 14:22
 * Email: fanyafeng@live.cn
 */
public class SonClass extends FatherClass{

    @Override
    public void testNormalMethod() {
        super.testNormalMethod();
        FatherClass.testStatic();

    }
}
