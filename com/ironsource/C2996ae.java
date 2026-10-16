package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ae, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C2996ae {

    /* renamed from: a, reason: collision with root package name */
    private final String f3184a;
    private final String b;
    private final List<IronSource.AD_UNIT> c;

    public C2996ae(String appKey, String str, List<IronSource.AD_UNIT> legacyAdFormats) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(legacyAdFormats, "legacyAdFormats");
        this.f3184a = appKey;
        this.b = str;
        this.c = legacyAdFormats;
    }

    public final String a() {
        return this.f3184a;
    }

    public final String b() {
        return this.b;
    }

    public final List<IronSource.AD_UNIT> c() {
        return this.c;
    }

    public final String d() {
        return this.f3184a;
    }

    public final List<IronSource.AD_UNIT> e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2996ae)) {
            return false;
        }
        C2996ae c2996ae = (C2996ae) obj;
        return Intrinsics.areEqual(this.f3184a, c2996ae.f3184a) && Intrinsics.areEqual(this.b, c2996ae.b) && Intrinsics.areEqual(this.c, c2996ae.c);
    }

    public final String f() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = this.f3184a.hashCode() * 31;
        String str = this.b;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "SdkInitRequest(appKey=" + this.f3184a + ", userId=" + this.b + ", legacyAdFormats=" + this.c + ")";
    }

    public final C2996ae a(String appKey, String str, List<IronSource.AD_UNIT> legacyAdFormats) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(legacyAdFormats, "legacyAdFormats");
        return new C2996ae(appKey, str, legacyAdFormats);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C2996ae a(C2996ae c2996ae, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c2996ae.f3184a;
        }
        if ((i & 2) != 0) {
            str2 = c2996ae.b;
        }
        if ((i & 4) != 0) {
            list = c2996ae.c;
        }
        return c2996ae.a(str, str2, list);
    }

    public final void a(List<? extends IronSource.AD_UNIT> adFormats) {
        Intrinsics.checkNotNullParameter(adFormats, "adFormats");
        this.c.clear();
        this.c.addAll(adFormats);
    }

    public /* synthetic */ C2996ae(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, list);
    }
}
