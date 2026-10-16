package com.pgl.ssdk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    private static Method f6411a;
    private static Method b;
    private static Method c;

    static {
        try {
            f6411a = Class.class.getDeclaredMethod("forName", String.class);
            b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Object a(Object obj, Class cls, String str, Object obj2) {
        Field a2;
        try {
            a2 = a(cls, str);
        } catch (Throwable unused) {
        }
        if (a2 == null) {
            return obj2;
        }
        a2.setAccessible(true);
        return a2.get(obj);
    }

    public static Field a(Class cls, String str) {
        if (!a()) {
            return null;
        }
        try {
            Field field = (Field) c.invoke(cls, str);
            try {
                field.setAccessible(true);
                return field;
            } catch (Throwable unused) {
                return field;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Method a(Class cls, String str, Class[] clsArr) {
        if (!a()) {
            return null;
        }
        try {
            Method method = (Method) b.invoke(cls, str, clsArr);
            try {
                method.setAccessible(true);
                return method;
            } catch (Throwable unused) {
                return method;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Object a(Object obj, Class cls, String str, Class[] clsArr, Object... objArr) {
        try {
            Method a2 = a(cls, str, clsArr);
            if (a2 != null) {
                return a2.invoke(obj, objArr);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a() {
        return (f6411a == null || b == null || c == null) ? false : true;
    }
}
