package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.mf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3203mf {

    /* renamed from: a, reason: collision with root package name */
    private final String f3592a;
    private final String b;
    private final boolean c;
    private final Boolean d;

    public C3203mf(String str, boolean z, Boolean bool, String str2) {
        this.f3592a = str2;
        this.b = str;
        this.c = z;
        this.d = bool;
    }

    public final String a() {
        return this.f3592a;
    }

    public final boolean b() {
        return Intrinsics.areEqual(this.d, Boolean.TRUE);
    }

    public final boolean a(NetworkSettings networkSettings, IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(networkSettings, "networkSettings");
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        String str = this.b;
        if (str == null || str.length() == 0) {
            return true;
        }
        C3321tf c3321tf = C3321tf.f3849a;
        return Intrinsics.areEqual(c3321tf.a(networkSettings), this.b) && c3321tf.a(networkSettings, adUnit) == this.c;
    }

    public /* synthetic */ C3203mf(String str, boolean z, Boolean bool, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? Boolean.FALSE : bool, (i & 8) != 0 ? null : str2);
    }
}
