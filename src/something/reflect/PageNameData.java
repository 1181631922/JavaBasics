package something.reflect;

/**
 * Author： fanyafeng
 * Data： 2020-01-09 10:30
 * Email: fanyafeng@live.cn
 */
public class PageNameData {
    private String fullName;

    private Class clazz;

    private boolean needLogin;

    public PageNameData(String fullName, Class clazz, boolean needLogin) {
        this.fullName = fullName;
        this.clazz = clazz;
        this.needLogin = needLogin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public boolean isNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(boolean needLogin) {
        this.needLogin = needLogin;
    }

    @Override
    public String toString() {
        return "PageNameData{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
