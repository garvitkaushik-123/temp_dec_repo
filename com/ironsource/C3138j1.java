package com.ironsource;

import com.ironsource.C3172l1;
import com.ironsource.mediationsdk.IronSource;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.j1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3138j1 implements InterfaceC3155k1 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3366a;
    private final String b;
    private final IronSource.AD_UNIT c;
    private final boolean d;
    private final boolean e;
    private final boolean f;

    /* renamed from: com.ironsource.j1$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3367a = new a();
        public static final int b = 1;
        public static final int c = 1;
        public static final int d = 1;

        private a() {
        }
    }

    public C3138j1(String version, String instanceId, IronSource.AD_UNIT adFormat, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        this.f3366a = version;
        this.b = instanceId;
        this.c = adFormat;
        this.d = z;
        this.e = z2;
        this.f = z3;
    }

    @Override // com.ironsource.InterfaceC3155k1
    public ArrayList<InterfaceC3189m1> a() {
        ArrayList<InterfaceC3189m1> arrayList = new ArrayList<>();
        arrayList.add(new C3172l1.v(this.f3366a));
        arrayList.add(new C3172l1.x(this.b));
        arrayList.add(new C3172l1.a(this.c));
        if (this.d) {
            arrayList.add(new C3172l1.p(1));
        }
        if (this.e) {
            arrayList.add(new C3172l1.e(1));
        }
        if (this.f) {
            arrayList.add(new C3172l1.o(1));
        }
        return arrayList;
    }

    public /* synthetic */ C3138j1(String str, String str2, IronSource.AD_UNIT ad_unit, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, ad_unit, (i & 8) != 0 ? false : z, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? true : z3);
    }
}
