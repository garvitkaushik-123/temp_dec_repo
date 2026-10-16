package com.instagram.common.viewpoint.core;

import java.lang.reflect.Proxy;

/* renamed from: com.facebook.ads.redexgen.X.Ra, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1287Ra {
    public static <T> T A00(T impl, Class<T> clazz) {
        ClassLoader classLoader = impl.getClass().getClassLoader();
        return clazz.cast(Proxy.newProxyInstance(classLoader, new Class[]{clazz}, new RZ(impl, classLoader)));
    }
}
