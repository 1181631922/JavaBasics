package asm.methodvisitor;

import asm.annotationvisitor.PermissionAnnotationMethod;
import asm.model.PermissionAnnonModel;
import org.objectweb.asm.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Author： fanyafeng
 * Data： 2020/4/9 19:03
 * Email: fanyafeng@live.cn
 */
public class PermissionMethodVisitor extends MethodVisitor {
    private String methodName;
    private String methodDesc;
    private String className;
    private PermissionAnnotationMethod tempAnnotationVisitor;

    public PermissionMethodVisitor(MethodVisitor av, String className, String methodName, String desc) {
        super(Opcodes.ASM5, av);
        this.methodName = methodName;
        this.methodDesc = desc;
        this.className = className;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        /**
         * 这里读取所有注解方法
         */
//            System.out.println("visitAnnotation desc:" + desc);

        //@PermissionAnnon 前面加Lasm为注解方法
        if ("Lasm/PermissionAnnon;".equals(desc)) {
            tempAnnotationVisitor = new PermissionAnnotationMethod(super.visitAnnotation(desc, visible), className, desc);
            return tempAnnotationVisitor;
        } else {
            return super.visitAnnotation(desc, visible);
        }
    }


    @Override
    public void visitCode() {
        super.visitCode();
        //方法前插入
        if (tempAnnotationVisitor != null) {
            System.out.println("visitCode 获取:" + tempAnnotationVisitor.getTempModel().toString());
            /**
             * 在此进行字节码插装
             */
            PermissionAnnonModel model = tempAnnotationVisitor.getTempModel();


//            addFunBody(mv, model);
            addJudge(mv, model);
        }

    }

    @Override
    public void visitInsn(int opcode) {
        super.visitInsn(opcode);
    }




    private void addJudge(MethodVisitor mv, PermissionAnnonModel model) {
        Label label = new Label();

        boolean value = model.isValue();
        String failMethodName = model.getFailMethodName();
        ArrayList<String> permissionList = model.getPermissionList();

        mv.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList");
        mv.visitInsn(Opcodes.DUP);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/ArrayList", "<init>", "()V", false);
        mv.visitVarInsn(Opcodes.ASTORE, 2);
        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitVarInsn(Opcodes.ALOAD, 2);
        mv.visitLocalVariable("args", "Ljava/util/List;", "Ljava/util/List<Ljava/lang/Object;>;", l1, label, 1);

//        mv.visitLabel(label);
//        mv.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList");
//        mv.visitInsn(Opcodes.DUP);
//        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/ArrayList", "<init>", "()V", false);
//        mv.visitVarInsn(Opcodes.ASTORE, 2);
//
//
//        for (int i = 0; i < permissionList.size(); i++) {
//            mv.visitVarInsn(Opcodes.ALOAD, 2);
//            mv.visitLdcInsn(permissionList.get(i));
//            mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "add", "(Ljava/lang/Object;)Z", true);
//            mv.visitInsn(Opcodes.POP);
//        }
//
//
//        mv.visitFieldInsn(Opcodes.GETSTATIC, "com/ripple/permission/RipplePermission", "INSTANCE", "Lcom/ripple/permission/RipplePermission;");
//        mv.visitVarInsn(Opcodes.ALOAD, 0);
//        mv.visitVarInsn(Opcodes.ALOAD, 2);
//        mv.visitLdcInsn(methodName);
//        mv.visitLdcInsn(methodDesc);
//        mv.visitVarInsn(Opcodes.ALOAD, 1);
//        mv.visitLdcInsn(failMethodName);
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "com/ripple/permission/RipplePermission", "doCheckPermission", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Z", false);
//
//
//        mv.visitLocalVariable("list", "Ljava/util/List;", "Ljava/util/List<Ljava/lang/Object;>;", label, label, 1);
//        mv.visitLocalVariable("permissionList", "Ljava/util/List;", "Ljava/util/List<Ljava/lang/String;>;", label, label, 2);
//
//        Label endLabel = new Label();
//        mv.visitJumpInsn(Opcodes.IFNE, endLabel);
//        mv.visitInsn(Opcodes.RETURN);
//        mv.visitLabel(endLabel);
//        mv.visitFrame(Opcodes.F_APPEND, 0, new Object[]{"java/util/List"}, 0, null);
    }


    private void addFunBody(MethodVisitor mv, PermissionAnnonModel model) {
        boolean value = model.isValue();
        String failMethodName = model.getFailMethodName();
        ArrayList<String> permissionList = model.getPermissionList();

        Label label = new Label();

        //类型
        mv.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList");
        mv.visitInsn(Opcodes.DUP);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/ArrayList", "<init>", "()V", false);
        mv.visitVarInsn(Opcodes.ASTORE, 1);
//        mv.visitLocalVariable("this", "Lasm/Permission;", null, label, label, 0);

        //定义循环
//        for (int i = 0; i < permissionList.size(); i++) {
//            mv.visitVarInsn(Opcodes.ALOAD, 1);
//            mv.visitLdcInsn(permissionList.get(i));
//            mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "add", "(Ljava/lang/Object;)Z", true);
//            mv.visitLocalVariable("stringArrayList", "Ljava/util/List;", "Ljava/util/List<Ljava/lang/String;>;", label, label, 1);
//            mv.visitInsn(Opcodes.POP);
//        }

//        mv.visitVarInsn(Opcodes.ALOAD, 1);
//        mv.visitJumpInsn(Opcodes.IFNULL, label);
//        mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"java/util/List"}, 0, null);
//        mv.visitLocalVariable("this", "Lasm/Permission;", null, label, label, 0);


        //if (stringArrayList == null) {
        //  System.out.println("调用方法:annonMethod");
        //}
//        mv.visitVarInsn(Opcodes.ALOAD, 1);
//        mv.visitJumpInsn(Opcodes.IFNULL, label);
//        mv.visitInsn(Opcodes.RETURN);
//        mv.visitLabel(label);
//        mv.visitFrame(Opcodes.F_APPEND, 0, null, 0, null);
//        mv.visitLabel(label);
//        mv.visitLocalVariable("this", "Lasm/Permission;", null, label, label, 0);
    }
}
