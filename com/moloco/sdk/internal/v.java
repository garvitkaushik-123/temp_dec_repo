package com.moloco.sdk.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public abstract class v<R, E> {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5745a = 0;

    public static final class a<R, E> extends v<R, E> {
        public static final int c = 0;
        public final E b;

        public a(E e) {
            super(null);
            this.b = e;
        }

        public final E a() {
            return this.b;
        }
    }

    public static final class b<R, E> extends v<R, E> {
        public static final int c = 0;
        public final R b;

        public b(R r) {
            super(null);
            this.b = r;
        }

        public final R a() {
            return this.b;
        }
    }

    public /* synthetic */ v(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public v() {
    }
}
