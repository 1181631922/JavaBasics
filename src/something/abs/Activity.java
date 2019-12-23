package something.abs;

/**
 * Author： fanyafeng
 * Data： 2019-12-07 22:58
 * Email: fanyafeng@live.cn
 */
public class Activity extends ContextWrapper{
    public Activity(Context mBase) {
        super(mBase);
    }

    public Activity() {
        super(new ContextImpl());
    }
}
