package something.typevariable.javasimple;

/**
 * Author： fanyafeng
 * Data： 2020/3/30 15:40
 * Email: fanyafeng@live.cn
 */
public class DevManagerJava extends ManagerJava {
    private String language;

    public DevManagerJava(String name) {
        super(name);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
