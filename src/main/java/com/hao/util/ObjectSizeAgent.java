package com.hao.util;

import java.lang.instrument.Instrumentation;

/**
 * @author hao
 */
public class ObjectSizeAgent {
    private static Instrumentation instrumentation;

    /**
     * 该方法名称是固定的，通过 META-INF 下的 MANIFEST.MF 中的定义，JVM 会自动调用该方法
     */
    public static void premain(String agentArgs, Instrumentation _inst) {
        instrumentation = _inst;
    }

    /**
     * 计算对象实例的大小，类似 C/C++ 中的 sizeof 运算符
     */
    public static long sizeOf(Object o) {
        return instrumentation.getObjectSize(o);
    }
}
