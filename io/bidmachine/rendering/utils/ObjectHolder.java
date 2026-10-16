package io.bidmachine.rendering.utils;

/* loaded from: classes8.dex */
public class ObjectHolder<T> {

    /* renamed from: a, reason: collision with root package name */
    private T f7195a;

    public ObjectHolder() {
        this(null);
    }

    public T get() {
        return this.f7195a;
    }

    public void set(T object) {
        this.f7195a = object;
    }

    public ObjectHolder(T object) {
        this.f7195a = object;
    }
}
