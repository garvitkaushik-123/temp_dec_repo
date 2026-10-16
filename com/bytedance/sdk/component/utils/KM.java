package com.bytedance.sdk.component.utils;

import android.content.Context;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class KM {
    private static Map<String, Method> DbA = new HashMap();
    private static final HashMap<Class<?>, Class<?>> Os;
    public static final Class<?>[] eli;

    static {
        HashMap<Class<?>, Class<?>> hashMap = new HashMap<>();
        Os = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Float.TYPE, Float.class);
        hashMap.put(Void.TYPE, Void.class);
        eli = new Class[0];
    }

    public static int eli(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int eli(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
