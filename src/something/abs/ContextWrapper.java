package something.abs;

/**
 * Author： fanyafeng
 * Data： 2019-12-07 22:55
 * Email: fanyafeng@live.cn
 */
public class ContextWrapper extends Context {

    Context mBase;

    public ContextWrapper(Context mBase) {
        this.mBase = mBase;
    }

    @Override
    public String getName() {
        return mBase.getName();
    }
}
