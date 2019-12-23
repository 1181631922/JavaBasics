package something;

import something.override.FatherClass;
import something.override.SonClass;

import java.util.concurrent.ExecutorService;

/**
 * Author： fanyafeng
 * Data： 2019-12-03 14:20
 * Email: fanyafeng@live.cn
 */
public class TestOverride {
    public static void main(String[] args) {
        FatherClass fatherClass = new SonClass();
    }

}


