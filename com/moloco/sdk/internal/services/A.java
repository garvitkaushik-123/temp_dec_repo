package com.moloco.sdk.internal.services;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class A {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5602a = 0;

    public static final class a extends A {
        public static final int c = 0;
        public final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String carrier) {
            super(null);
            Intrinsics.checkNotNullParameter(carrier, "carrier");
            this.b = carrier;
        }

        public final String a() {
            return this.b;
        }
    }

    public static final class b extends A {
        public static final b b = new b();
        public static final int c = 0;

        public b() {
            super(null);
        }
    }

    public static final class c extends A {
        public static final c b = new c();
        public static final int c = 0;

        public c() {
            super(null);
        }
    }

    public /* synthetic */ A(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public A() {
    }
}
