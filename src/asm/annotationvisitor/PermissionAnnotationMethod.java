package asm.annotationvisitor;

import asm.model.PermissionAnnonModel;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2020/4/9 16:19
 * Email: fanyafeng@live.cn
 * Desc: 带有权限注解的方法
 * <p>
 * 处理PermissionAnnon这个注解
 */
public class PermissionAnnotationMethod extends AnnotationVisitor {

    private String className;
    private String methodDesc;

    private PermissionAnnonModel tempModel = new PermissionAnnonModel();

    public PermissionAnnonModel getTempModel() {
        return tempModel;
    }

    public PermissionAnnotationMethod(AnnotationVisitor av, String className, String methodDesc) {
        super(Opcodes.ASM5, av);
        this.className = className;
        this.methodDesc = methodDesc;
        System.out.println("PermissionAnnotationMethod 初始化方法");
    }


    /**
     * 读取注解的值
     */
    @Override
    public void visit(String name, Object value) {
        super.visit(name, value);
        System.out.println("类注解值: " + name + " = " + value.toString());

        //处理第一个注解值
        if ("value".equals(name)) {
            if ((Boolean) value) {
                //第一个注解为true
                System.out.println("第一个注解参数" + value);
            }
            tempModel.setValue((Boolean) value);
        }

        //第二个注解失败方法
        if ("failMethod".equals(name)) {
            System.out.println("第二个注解参数：" + value);
            tempModel.setFailMethodName((String) value);
        }

        //第三个list注解参数
    }

    @Override
    public AnnotationVisitor visitArray(String name) {
//        System.out.println("在这呢:" + name);
        if (name.equals("permissionList")) {
            return new PermissionAnnotationArray(super.visitArray(name), tempModel);
        } else {
            return super.visitArray(name);
        }
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        System.out.println("visitEnd 结束方法" + tempModel.toString());
        boolean value = tempModel.isValue();
        String failMethodName = tempModel.getFailMethodName();
//        if (value) {
//            try {
//                Class clazz = Class.forName(className.replace("/", "."));
//                Method failMethod = clazz.getDeclaredMethod(failMethodName);
//                failMethod.invoke(clazz.newInstance());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }
}
