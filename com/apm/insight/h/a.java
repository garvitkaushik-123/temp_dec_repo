package com.apm.insight.h;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: JavaCalls.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f254a;

    /* compiled from: JavaCalls.java */
    /* renamed from: com.apm.insight.h.a$a, reason: collision with other inner class name */
    public static class C0083a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends T> f255a;
        public final T b;
    }

    static {
        HashMap hashMap = new HashMap();
        f254a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        hashMap.put(Integer.class, Integer.TYPE);
        hashMap.put(Float.class, Float.TYPE);
        hashMap.put(Long.class, Long.TYPE);
        hashMap.put(Double.class, Double.TYPE);
        Class cls = Boolean.TYPE;
        hashMap.put(cls, cls);
        Class cls2 = Byte.TYPE;
        hashMap.put(cls2, cls2);
        Class cls3 = Character.TYPE;
        hashMap.put(cls3, cls3);
        Class cls4 = Short.TYPE;
        hashMap.put(cls4, cls4);
        Class cls5 = Integer.TYPE;
        hashMap.put(cls5, cls5);
        Class cls6 = Float.TYPE;
        hashMap.put(cls6, cls6);
        Class cls7 = Long.TYPE;
        hashMap.put(cls7, cls7);
        Class cls8 = Double.TYPE;
        hashMap.put(cls8, cls8);
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        Method method;
        Class<?>[] parameterTypes;
        Class<?> cls;
        try {
            Class<?> cls2 = Class.forName(str);
            Class<?>[] clsArr = new Class[4];
            for (int i = 0; i < 4; i++) {
                Object obj = objArr[i];
                if (obj != null && (obj instanceof C0083a)) {
                    cls = ((C0083a) obj).f255a;
                } else {
                    cls = obj == null ? null : obj.getClass();
                }
                clsArr[i] = cls;
            }
            while (true) {
                Method[] declaredMethods = cls2.getDeclaredMethods();
                int length = declaredMethods.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        method = null;
                        break;
                    }
                    method = declaredMethods[i2];
                    if (method.getName().equals(str2) && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 4) {
                        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                            if (!parameterTypes[i3].isAssignableFrom(clsArr[i3])) {
                                Map<Class<?>, Class<?>> map = f254a;
                                if (map.containsKey(parameterTypes[i3]) && map.get(parameterTypes[i3]).equals(map.get(clsArr[i3]))) {
                                }
                            }
                        }
                        break;
                    }
                    i2++;
                }
                if (method == null) {
                    if (cls2.getSuperclass() != null) {
                        cls2 = cls2.getSuperclass();
                    } else {
                        throw new NoSuchMethodException();
                    }
                } else {
                    method.setAccessible(true);
                    Object[] objArr2 = new Object[4];
                    for (int i4 = 0; i4 < 4; i4++) {
                        Object obj2 = objArr[i4];
                        if (obj2 != null && (obj2 instanceof C0083a)) {
                            objArr2[i4] = ((C0083a) obj2).b;
                        } else {
                            objArr2[i4] = obj2;
                        }
                    }
                    return (T) method.invoke(null, objArr2);
                }
            }
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str, e);
            return null;
        }
    }
}
