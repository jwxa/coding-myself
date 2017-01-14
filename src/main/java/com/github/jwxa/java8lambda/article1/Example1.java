package com.github.jwxa.java8lambda.article1;


import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * 实例<br>
 * 下面的代码源自 JDK 中的 Class 类型（getEnclosingMethod 方法），这段代码会遍历所有声明的方法，然后根据方法名称、返回类型以及参数的数量和类型进行匹配：
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class Example1 {

    public Method inClass() {
        EnclosingMethodInfo enclosingInfo = getEnclosingMethodInfo();
        Class<?> enclosingCandidate =  enclosingInfo.getEnclosingClass();
        Class<?>   returnType       = null;
        Class<?>[] parameterClasses =  null;
        for(Method m: enclosingCandidate.getDeclaredMethods()) {
            if (m.getName().equals(enclosingInfo.getName()) ) {
                Class<?>[] candidateParamClasses = m.getParameterTypes();
                if (candidateParamClasses.length == parameterClasses.length) {
                    boolean matches = true;
                    for(int i = 0; i < candidateParamClasses.length; i++) {
                        if (!candidateParamClasses[i].equals(parameterClasses[i])) {
                            matches = false;
                            break;
                        }
                    }

                    if (matches) { // finally, check return type
                        if (m.getReturnType().equals(returnType) )
                            return m;
                    }
                }
            }
        }
        return null;
    }

    //通过使用流，我们不但可以消除上面代码里面所有的临时变量，还可以把控制逻辑交给类库处理。
    public Method refact(){
        EnclosingMethodInfo enclosingInfo = getEnclosingMethodInfo();
        Class<?>   returnType       = null;
        Class<?>[] parameterClasses =  null;
        return Arrays.stream(enclosingInfo.getEnclosingClass().getDeclaredMethods())
                .filter(m->Objects.equals(m.getName(),enclosingInfo.getName()))
                .filter(m->Arrays.equals(m.getParameterTypes(),parameterClasses))
                .filter(m->Objects.equals(m.getReturnType(),returnType))
                .findFirst()
                .orElseThrow(()-> new InternalError("Enclosing method not found"));
    }



    private final static class EnclosingMethodInfo {
        private Class<?> enclosingClass;
        private String name;
        private String descriptor;

        private EnclosingMethodInfo(Object[] enclosingInfo) {
            if (enclosingInfo.length != 3)
                throw new InternalError("Malformed enclosing method information");
            try {
                // The array is expected to have three elements:

                // the immediately enclosing class
                enclosingClass = (Class<?>) enclosingInfo[0];
                assert(enclosingClass != null);

                // the immediately enclosing method or constructor's
                // name (can be null).
                name            = (String)   enclosingInfo[1];

                // the immediately enclosing method or constructor's
                // descriptor (null iff name is).
                descriptor      = (String)   enclosingInfo[2];
                assert((name != null && descriptor != null) || name == descriptor);
            } catch (ClassCastException cce) {
                throw new InternalError("Invalid type in enclosing method information", cce);
            }
        }

        boolean isPartial() {
            return enclosingClass == null || name == null || descriptor == null;
        }

        boolean isConstructor() { return !isPartial() && "<init>".equals(name); }

        boolean isMethod() { return !isPartial() && !isConstructor() && !"<clinit>".equals(name); }

        Class<?> getEnclosingClass() { return enclosingClass; }

        String getName() { return name; }

        String getDescriptor() { return descriptor; }

    }

    private EnclosingMethodInfo getEnclosingMethodInfo() {
        Object[] enclosingInfo = getEnclosingMethod0();
        if (enclosingInfo == null)
            return null;
        else {
            return new EnclosingMethodInfo(enclosingInfo);
        }
    }

    private native Object[] getEnclosingMethod0();

}

