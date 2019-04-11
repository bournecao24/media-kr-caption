package com.kr.caption.normal;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.kr.caption.controller.TestClass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HessianSer {

    /**
     * Hessian实现序列化
     *
     * @param TestClass
     * @return
     * @throws IOException
     */
    private static byte[] serialize(TestClass TestClass) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        HessianOutput hessianOutput = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            // Hessian的序列化
            hessianOutput = new HessianOutput(byteArrayOutputStream);
            hessianOutput.writeObject(TestClass);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                hessianOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Hessian实现反序列化
     *
     * @param TestClassArray
     * @return
     */
    private static TestClass deserialize(byte[] TestClassArray) {
        ByteArrayInputStream byteArrayInputStream = null;
        HessianInput hessianInput = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(TestClassArray);
            // Hessian的反序列化读取对象
            hessianInput = new HessianInput(byteArrayInputStream);
            return (TestClass) hessianInput.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                hessianInput.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {

        TestClass TestClass = new TestClass();
//            TestClass.setTestClassId(1);
//            TestClass.setTestClassName("赵新国");
//            TestClass.setDepartment("软件工程师");
        // 序列化
        byte[] serialize = serialize(TestClass);
        System.out.println(serialize);
        // 反序列化
        TestClass deserialize = deserialize(serialize);
        System.out.println(deserialize.toString());

    }

}

