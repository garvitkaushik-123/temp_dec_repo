package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f6290a = 0;

    public static final class a extends d {
        public static final a b = new a();
        public static final int c = 0;

        public a() {
            super(null);
        }
    }

    public static final class b extends d {
        public static final b b = new b();
        public static final int c = 0;

        public b() {
            super(null);
        }
    }

    public static final class c extends d {
        public static final c b = new c();
        public static final int c = 0;

        public c() {
            super(null);
        }
    }

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d$d, reason: collision with other inner class name */
    public static final class C0558d extends d {
        public static final int c = 0;
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0558d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.b = error;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l a() {
            return this.b;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0558d) && this.b == ((C0558d) obj).b;
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.b + ')';
        }

        public final C0558d a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new C0558d(error);
        }

        public static /* synthetic */ C0558d a(C0558d c0558d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l lVar, int i, Object obj) {
            if ((i & 1) != 0) {
                lVar = c0558d.b;
            }
            return c0558d.a(lVar);
        }
    }

    public static final class e extends d {
        public static final e b = new e();
        public static final int c = 0;

        public e() {
            super(null);
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public d() {
    }
}
