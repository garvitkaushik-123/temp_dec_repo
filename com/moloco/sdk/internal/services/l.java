package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.pm.PackageInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class l implements InterfaceC3447k {
    public static final int c = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5715a;
    public C3446j b;

    public l(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5715a = context;
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC3447k
    public C3446j invoke() {
        Object m10241constructorimpl;
        C3446j c3446j = this.b;
        if (c3446j != null) {
            return c3446j;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context = this.f5715a;
            String obj = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
            PackageInfo a2 = m.a(this.f5715a);
            String packageName = a2.packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            String versionName = a2.versionName;
            Intrinsics.checkNotNullExpressionValue(versionName, "versionName");
            C3446j c3446j2 = new C3446j(obj, packageName, versionName);
            this.b = c3446j2;
            m10241constructorimpl = Result.m10241constructorimpl(c3446j2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        C3446j c3446j3 = (C3446j) m10241constructorimpl;
        return c3446j3 == null ? new C3446j("", "", "") : c3446j3;
    }
}
