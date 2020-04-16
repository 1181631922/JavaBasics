package asm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import asm.classvisitor.TestClassVisitor;
import org.junit.Test;
import org.objectweb.asm.*;

/**
 * Author： fanyafeng
 * Data： 2020/4/9 15:05
 * Email: fanyafeng@live.cn
 */
public class AnnotationTest {

    @Test
    public void main() throws IOException {
        ClassReader classReader = new ClassReader("asm.Permission");
        ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
        classReader.accept(new TestClassVisitor(classWriter), ClassReader.EXPAND_FRAMES);
        byte[] code = classWriter.toByteArray();
        String name = "/Users/dmall/IntellijProject/JavaBasics/src/test.class";
        FileOutputStream fos = new FileOutputStream(name);
        fos.write(code);
        fos.close();
    }
}
