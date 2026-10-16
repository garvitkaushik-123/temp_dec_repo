package com.instagram.common.viewpoint.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: assets/audience_network/classes2.dex */
public class RY implements InvocationHandler {
    public final /* synthetic */ ClassLoader A00;

    public RY(ClassLoader classLoader) {
        this.A00 = classLoader;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object A00;
        A00 = RZ.A00(this.A00, method);
        return A00;
    }
}
