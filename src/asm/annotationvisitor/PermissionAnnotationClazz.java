package asm.annotationvisitor;

import asm.AnnotationTest;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Author： fanyafeng
 * Data： 2020/4/9 18:58
 * Email: fanyafeng@live.cn
 */
public class PermissionAnnotationClazz extends AnnotationVisitor {
    public PermissionAnnotationClazz(AnnotationVisitor av) {
        super(Opcodes.ASM5, av);
    }

    /**
     * 读取注解的值
     */
    @Override
    public void visit(String name, Object value) {
        super.visit(name, value);
//            System.out.println("类注解值: " + name + " = " + value);
    }

    /*
     * 注解枚举的类型的值
     */
    @Override
    public void visitEnum(String name, String desc, String value) {
        super.visitEnum(name, desc, value);
//            System.out.println("name =" + name + ", desc=" + desc + " , value=" + value);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name, String desc) {
        return super.visitAnnotation(name, desc);
    }

    /**
     * 注解数组类型的值
     */
    @Override
    public AnnotationVisitor visitArray(String name) {
//        System.out.println("Array:" + name);
        return new PermissionAnnotationArray(super.visitArray(name));
    }
}
