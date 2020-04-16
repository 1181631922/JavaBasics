package something.typevariable.javasimple;


/**
 * Author： fanyafeng
 * Data： 2020/3/30 15:39
 * Email: fanyafeng@live.cn
 */
public class ManagerJava extends EmployeeJava {
    private Integer level;

    public ManagerJava(String name) {
        super(name);
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
