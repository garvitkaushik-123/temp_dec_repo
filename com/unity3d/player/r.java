package com.unity3d.player;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public final class r implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final RunnableC3549u f6572a;
    public final UnityPlayer b;
    public final long c;
    public final /* synthetic */ long d;

    public r(long j, UnityPlayer unityPlayer) {
        long j2;
        this.d = j;
        j2 = ReflectionHelper.b;
        this.f6572a = new RunnableC3549u(j2, j);
        this.b = unityPlayer;
        this.c = j2;
    }

    public static Object a(Object obj, Method method, Object[] objArr, C3547t c3547t) {
        try {
            if (objArr == null) {
                try {
                    objArr = new Object[0];
                } catch (NoClassDefFoundError unused) {
                    com.unity3d.player.a.t.Log(6, "Java interface default methods are only supported since Android Oreo");
                    ReflectionHelper.nativeProxyLogJNIInvokeException(c3547t.f6576a);
                    c3547t.f6576a = 0L;
                    return null;
                }
            }
            Class<?> declaringClass = method.getDeclaringClass();
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(declaringClass, 2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
        } finally {
            long j = c3547t.f6576a;
            if (j != 0) {
                ReflectionHelper.nativeProxyJNIFreeGCHandle(j);
            }
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object nativeProxyInvoke;
        if (!ReflectionHelper.beginProxyCall(this.c)) {
            com.unity3d.player.a.t.Log(6, "Scripting proxy object was destroyed, because Unity player was unloaded.");
            return null;
        }
        try {
            nativeProxyInvoke = ReflectionHelper.nativeProxyInvoke(this.d, method.getName(), objArr);
            if (!(nativeProxyInvoke instanceof C3547t)) {
                return nativeProxyInvoke;
            }
            C3547t c3547t = (C3547t) nativeProxyInvoke;
            if (c3547t.b && (method.getModifiers() & 1024) == 0) {
                return a(obj, method, objArr, c3547t);
            }
            ReflectionHelper.nativeProxyLogJNIInvokeException(c3547t.f6576a);
            return null;
        } finally {
            ReflectionHelper.endProxyCall();
        }
    }

    public void finalize() {
        this.b.invokeOnMainThread(this.f6572a);
        super.finalize();
    }
}
