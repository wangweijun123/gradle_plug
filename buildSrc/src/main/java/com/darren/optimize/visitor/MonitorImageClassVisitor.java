package com.darren.optimize.visitor;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static java.lang.System.out;

public class MonitorImageClassVisitor extends ClassVisitor {
    public MonitorImageClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM5, classVisitor);
    }

    /**
     * Visits the header of the class. (first access class after access all method)
     */
    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
//        out.println("visit access:"+access+",name:"+name+", signature:"+signature+", superName:"+superName);
        /*if(superName.equals("android/widget/ImageView")
                && !name.equals("com/darren/optimize/day04/MonitorImageView")){
            superName = "com/darren/optimize/day04/MonitorImageView";
        }*/
        super.visit(version, access, name, signature, superName, interfaces);
    }

    /**
     * Visits a method of the class
     *
     * @param access
     * @param name
     * @param descriptor
     * @param signature
     * @param exceptions
     * @return
     */
    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
//        out.println("visitMethod access:"+access+",name:"+name+", descriptor:"+descriptor+", signature:"+signature);
        MethodVisitor superMethodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
        MethodVisitor methodVisitor = new SampleMethodVisitor(superMethodVisitor, access, name, descriptor);
        return methodVisitor;
    }
}
