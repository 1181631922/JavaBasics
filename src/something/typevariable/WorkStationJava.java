package something.typevariable;

/**
 * Author： fanyafeng
 * Data： 2020/3/30 15:49
 * Email: fanyafeng@live.cn
 */
public class WorkStationJava<T> {
    private T employee;

    public WorkStationJava(T employee) {
        this.employee = employee;
    }

    public T getEmployee() {
        return employee;
    }

    public void setEmployee(T employee) {
        this.employee = employee;
    }
}
