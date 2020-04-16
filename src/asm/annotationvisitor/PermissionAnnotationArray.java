package asm.annotationvisitor;

import asm.model.PermissionAnnonModel;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Author： fanyafeng
 * Data： 2020/4/9 18:59
 * Email: fanyafeng@live.cn
 */
public class PermissionAnnotationArray extends AnnotationVisitor {

    private PermissionAnnonModel tempModel;

    public PermissionAnnotationArray(AnnotationVisitor av, PermissionAnnonModel tempModel) {
        super(Opcodes.ASM5, av);
        this.tempModel = tempModel;
    }

    public PermissionAnnotationArray(AnnotationVisitor av) {
        super(Opcodes.ASM5, av);
    }

    /**
     * 读取数组的内容
     */
    @Override
    public void visit(String name, Object value) {
        super.visit(name, value);
//        System.out.println(name + " = " + value);
        if (tempModel != null) {
            tempModel.getPermissionList().add((String) value);
        }
    }
}
