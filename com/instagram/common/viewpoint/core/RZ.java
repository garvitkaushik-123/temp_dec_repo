package com.instagram.common.viewpoint.core;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class RZ<T> implements InvocationHandler {
    public static byte[] A02;
    public ClassLoader A00;
    public T A01;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 102);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{49, 32, 57};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.RZ != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    public RZ(T impl, ClassLoader classLoader) {
        this.A01 = impl;
        this.A00 = classLoader;
    }

    public static Object A00(ClassLoader classLoader, Method method) {
        Class<?> returnType = method.getReturnType();
        Object result = Void.TYPE;
        if (returnType.equals(result)) {
            return null;
        }
        if (returnType.isPrimitive()) {
            Object result2 = Array.newInstance(method.getReturnType(), 1);
            return Array.get(result2, 0);
        }
        if (returnType.equals(String.class)) {
            return A02(0, 0, 70);
        }
        if (!returnType.isInterface()) {
            return null;
        }
        return Proxy.newProxyInstance(classLoader, new Class[]{returnType}, new RY(classLoader));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.RZ != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    public final T A04() {
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.RZ != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            return method.invoke(this.A01, objArr);
        } catch (Throwable t) {
            if (t instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) t).getTargetException();
                if (targetException instanceof OF) {
                    throw new IllegalStateException(targetException.getMessage());
                }
            }
            Object A00 = A00(this.A00, method);
            C1925ge A002 = T7.A00();
            if (A002 != null) {
                A002.A08().ABC(A02(0, 3, 54), AbstractC1341Td.A0O, new C1342Te(t));
                return A00;
            }
            return A00;
        }
    }
}
