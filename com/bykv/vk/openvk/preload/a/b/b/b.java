package com.bykv.vk.openvk.preload.a.b.b;

import com.bykv.vk.openvk.preload.a.b.d;
import java.lang.reflect.AccessibleObject;

/* compiled from: ReflectionAccessor.java */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f892a;

    public abstract void a(AccessibleObject accessibleObject);

    static {
        f892a = d.a() < 9 ? new a() : new c();
    }

    public static b a() {
        return f892a;
    }
}
