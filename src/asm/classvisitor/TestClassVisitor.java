package asm.classvisitor;

import asm.AnnotationTest;
import asm.annotationvisitor.PermissionAnnotationClazz;
import asm.methodvisitor.PermissionMethodVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import org.objectweb.asm.*;

import java.util.Arrays;

/**
 * Author： fanyafeng
 * Data： 2020/4/9 19:02
 * Email: fanyafeng@live.cn
 */
public class TestClassVisitor extends ClassVisitor {
    private String className;


    public TestClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        //类名称
        System.out.println("类名称: " + name);
        this.className = name;

        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        /**
         * 这里读取到的是当前类的注解信息
         */
        return new PermissionAnnotationClazz(super.visitAnnotation(desc, visible));
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return super.visitTypeAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        /**
         * 这里读取的是当前类所有方法的注解
         */
//            System.out.println(" = " +  );
        System.out.println("方法名称: " + name);
        MethodVisitor methodVisitor = cv.visitMethod(access, name, desc, signature, exceptions);
//        System.out.println("难道是这的desc：" + desc);
//        System.out.println("这是啥玩意signature：" + signature);

        return new PermissionMethodVisitor(methodVisitor, className, name, desc);
//            return super.visitMethod(access, name, desc, signature, exceptions);
    }
}
