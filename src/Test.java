/**
 * Author： fanyafeng
 * Data： 2020/6/4 10:21
 * Email: fanyafeng@live.cn
 */
public class Test extends ProcessTaskImpl<Model> {

    private Model item;

    public Test(Model item) {
        this.item = item;
    }

    @Override
    public Model getProcessModel() {
        return item;
    }

    @Override
    public void setProcessModel(Model processModel) {
        this.item = processModel;
    }

}
