package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f6192a = 0;

    public static final class a extends b {
        public static final a b = new a();
        public static final int c = 0;

        public a() {
            super(null);
        }
    }

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b$b, reason: collision with other inner class name */
    public static final class C0540b extends b {
        public static final C0540b b = new C0540b();
        public static final int c = 0;

        public C0540b() {
            super(null);
        }
    }

    public static final class c extends b {
        public static final c b = new c();
        public static final int c = 0;

        public c() {
            super(null);
        }
    }

    public static final class d extends b {
        public static final int c = 8;
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.b = error;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c a() {
            return this.b;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.areEqual(this.b, ((d) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.b + ')';
        }

        public final d a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new d(error);
        }

        public static /* synthetic */ d a(d dVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar, int i, Object obj) {
            if ((i & 1) != 0) {
                cVar = dVar.b;
            }
            return dVar.a(cVar);
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public b() {
    }
}
