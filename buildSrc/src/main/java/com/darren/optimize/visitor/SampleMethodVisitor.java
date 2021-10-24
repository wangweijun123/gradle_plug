package com.darren.optimize.visitor;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

public class SampleMethodVisitor extends AdviceAdapter {
    private String mMethodName;
    public SampleMethodVisitor(MethodVisitor methodVisitor, int access, String methodName, String descriptor) {
        super(Opcodes.ASM5, methodVisitor, access, methodName , descriptor);
        this.mMethodName = methodName;
    }
    /**
     * step by step in method
     */
    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        if(mMethodName.equals("onCreate")){
            System.out.println("owner -> "+owner+", name -> "+name+", descriptor -> "+descriptor);
        }
        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
    }


    @Override
    public void visitVarInsn(int opcode, int var) {
        super.visitVarInsn(opcode, var);
//        System.out.println("visitVarInsn opcode:"+opcode +", var:"+var);
    }


    /**
     * Visits the end of the method
     */
    @Override
    public void visitEnd() {
        super.visitEnd();
        if(mMethodName.equals("onCreate")){
            System.out.println("visitEnd methodName -> "+mMethodName);
            mv.visitLdcInsn("wangweijun");
            mv.visitLdcInsn("enterMethod");
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "android/util/Log", "e",
                    "(Ljava/lang/String;Ljava/lang/String;)I", false);
        }
    }
}
