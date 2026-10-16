package com.moloco.sdk.internal.services.events;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public e f5681a;

    public c() {
        e eVar;
        eVar = d.f5682a;
        this.f5681a = eVar;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c
    public void a(boolean z, boolean z2, String appForegroundUrl, String appBackgroundUrl) {
        Intrinsics.checkNotNullParameter(appForegroundUrl, "appForegroundUrl");
        Intrinsics.checkNotNullParameter(appBackgroundUrl, "appBackgroundUrl");
        this.f5681a = new e(z, z2, appForegroundUrl, appBackgroundUrl);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c
    public boolean b() {
        return this.f5681a.h();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c
    public boolean c() {
        return this.f5681a.g();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c
    public String d() {
        return this.f5681a.f();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c
    public String a() {
        return this.f5681a.e();
    }
}
