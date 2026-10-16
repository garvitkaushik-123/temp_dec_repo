package com.ironsource;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.k6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3160k6 implements I {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f3399a;

    public C3160k6(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f3399a = activity;
    }

    @Override // com.ironsource.I
    public void a(C3127i6 fullscreenAdInstance) {
        Intrinsics.checkNotNullParameter(fullscreenAdInstance, "fullscreenAdInstance");
        fullscreenAdInstance.a(this.f3399a);
    }
}
