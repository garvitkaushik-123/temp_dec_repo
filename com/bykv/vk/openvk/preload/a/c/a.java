package com.bykv.vk.openvk.preload.a.c;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeToken.java */
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private Class<? super T> f907a;
    private Type b;
    private int c;

    protected a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        Type a2 = com.bykv.vk.openvk.preload.a.b.a.a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        this.b = a2;
        this.f907a = (Class<? super T>) com.bykv.vk.openvk.preload.a.b.a.b(a2);
        this.c = this.b.hashCode();
    }

    private a(Type type) {
        Type a2 = com.bykv.vk.openvk.preload.a.b.a.a((Type) com.bykv.vk.openvk.preload.falconx.a.a.a(type));
        this.b = a2;
        this.f907a = (Class<? super T>) com.bykv.vk.openvk.preload.a.b.a.b(a2);
        this.c = this.b.hashCode();
    }

    public final Class<? super T> a() {
        return this.f907a;
    }

    public final Type b() {
        return this.b;
    }

    public final int hashCode() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && com.bykv.vk.openvk.preload.a.b.a.a(this.b, ((a) obj).b);
    }

    public final String toString() {
        return com.bykv.vk.openvk.preload.a.b.a.c(this.b);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }
}
