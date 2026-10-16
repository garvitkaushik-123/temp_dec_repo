package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public class U {
    public static final a q = new a(null);
    public static final int r = -1;

    /* renamed from: a, reason: collision with root package name */
    private final IronSource.AD_UNIT f3064a;
    private final String b;
    private final List<NetworkSettings> c;
    private final C3241p2 d;
    private int e;
    private final int f;
    private boolean g;
    private final int h;
    private final int i;
    private final N0 j;
    private final H0 k;
    private final long l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private boolean p;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public U(IronSource.AD_UNIT adUnit, String str, List<? extends NetworkSettings> list, C3241p2 auctionSettings, int i, int i2, boolean z, int i3, int i4, N0 loadingData, H0 interactionData, long j, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(auctionSettings, "auctionSettings");
        Intrinsics.checkNotNullParameter(loadingData, "loadingData");
        Intrinsics.checkNotNullParameter(interactionData, "interactionData");
        this.f3064a = adUnit;
        this.b = str;
        this.c = list;
        this.d = auctionSettings;
        this.e = i;
        this.f = i2;
        this.g = z;
        this.h = i3;
        this.i = i4;
        this.j = loadingData;
        this.k = interactionData;
        this.l = j;
        this.m = z2;
        this.n = z3;
        this.o = z4;
        this.p = z5;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final IronSource.AD_UNIT b() {
        return this.f3064a;
    }

    public final boolean c() {
        return this.g;
    }

    public final C3241p2 d() {
        return this.d;
    }

    public final long e() {
        return this.l;
    }

    public final int f() {
        return this.h;
    }

    public final H0 g() {
        return this.k;
    }

    public final N0 h() {
        return this.j;
    }

    public final int i() {
        return this.e;
    }

    public List<NetworkSettings> j() {
        return this.c;
    }

    public final boolean k() {
        return this.m;
    }

    public final boolean l() {
        return this.o;
    }

    public final boolean m() {
        return this.p;
    }

    public final int n() {
        return this.f;
    }

    public String o() {
        return this.b;
    }

    public final boolean p() {
        return this.n;
    }

    public final boolean q() {
        return this.d.g() > 0;
    }

    public final String r() {
        String format = String.format(Locale.getDefault(), "%s: %d, %s: %b, %s: %b", com.ironsource.mediationsdk.d.x, Integer.valueOf(this.e), com.ironsource.mediationsdk.d.y, Boolean.valueOf(this.g), com.ironsource.mediationsdk.d.z, Boolean.valueOf(this.p));
        Intrinsics.checkNotNullExpressionValue(format, "format(\n          Locale…     showPriorityEnabled)");
        return format;
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final void b(boolean z) {
        this.p = z;
    }

    public final int a() {
        return this.i;
    }

    public final NetworkSettings a(String instanceName) {
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        List<NetworkSettings> j = j();
        Object obj = null;
        if (j == null) {
            return null;
        }
        Iterator<T> it = j.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((NetworkSettings) next).getProviderInstanceName().equals(instanceName)) {
                obj = next;
                break;
            }
        }
        return (NetworkSettings) obj;
    }

    public /* synthetic */ U(IronSource.AD_UNIT ad_unit, String str, List list, C3241p2 c3241p2, int i, int i2, boolean z, int i3, int i4, N0 n0, H0 h0, long j, boolean z2, boolean z3, boolean z4, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(ad_unit, str, list, c3241p2, i, i2, z, i3, i4, n0, h0, j, z2, z3, z4, (i5 & 32768) != 0 ? false : z5);
    }
}
