package io.bidmachine.utils;

import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public class ReflectionUtils {
    public static Object findValueByPath(Object object, String[] path) {
        if (path.length == 0) {
            return null;
        }
        for (String str : path) {
            object = findValue(object, str);
            if (object == null) {
                return null;
            }
        }
        return object;
    }

    public static Object findValue(Object object, String fieldName) {
        return findValue(object.getClass(), fieldName, object);
    }

    public static Object findValue(Class<?> clazz, String fieldName, Object object) {
        try {
            return getValue(clazz, fieldName, object);
        } catch (Throwable unused) {
            Class<? super Object> superclass = clazz.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return findValue(superclass, fieldName, object);
        }
    }

    public static Object getValue(Class<?> clazz, String fieldName, Object object) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException, SecurityException {
        Field declaredField = clazz.getDeclaredField(fieldName);
        declaredField.setAccessible(true);
        return declaredField.get(object);
    }
}
