package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Sb {
    public static final a e = new a(null);
    private static volatile Sb f;

    /* renamed from: a, reason: collision with root package name */
    private C3167kd f3050a;
    private final AtomicBoolean b;
    private String c;
    private U3 d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Sb a() {
            Sb sb;
            Sb sb2 = Sb.f;
            if (sb2 != null) {
                return sb2;
            }
            synchronized (this) {
                sb = Sb.f;
                if (sb == null) {
                    sb = new Sb(null);
                    a aVar = Sb.e;
                    Sb.f = sb;
                }
            }
            return sb;
        }

        private a() {
        }

        public final InterfaceC3037d1 a(IronSource.AD_UNIT adFormat) {
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Sb sb = Sb.f;
            U3 b = sb != null ? sb.b() : null;
            Sb sb2 = Sb.f;
            C3167kd e = sb2 != null ? sb2.e() : null;
            if (b != null && e != null) {
                return new C3309t3(b, e, adFormat);
            }
            return new C3159k5();
        }
    }

    public /* synthetic */ Sb(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final Sb d() {
        return e.a();
    }

    public final U3 b() {
        return this.d;
    }

    public final AtomicBoolean c() {
        return this.b;
    }

    public final C3167kd e() {
        return this.f3050a;
    }

    public final String f() {
        return this.c;
    }

    public final void g() {
        this.b.set(true);
    }

    private Sb() {
        this.b = new AtomicBoolean(false);
        this.c = "";
    }

    public final void a(C3167kd c3167kd) {
        this.f3050a = c3167kd;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void a(U3 u3) {
        this.d = u3;
    }
}
