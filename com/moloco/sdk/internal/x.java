package com.moloco.sdk.internal;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class x implements w {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i f5746a;

    public x(com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest) {
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        this.f5746a = persistentHttpRequest;
    }

    @Override // com.moloco.sdk.internal.w
    public boolean a(String url, long j, s sVar) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c d;
        Intrinsics.checkNotNullParameter(url, "url");
        if (sVar != null) {
            try {
                d = sVar.d();
            } catch (Exception e) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, "SdkEventUrlTrackerImpl", e.toString(), null, false, 12, null);
                return false;
            }
        } else {
            d = null;
        }
        Uri build = Uri.parse(a(url, j, d)).buildUpon().build();
        com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar = this.f5746a;
        String uri = build.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        iVar.a(uri);
        return true;
    }

    public final String a(String str, long j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
        String a2;
        if (cVar != null && (a2 = com.moloco.sdk.internal.utils.b.a(str, cVar.a())) != null) {
            str = a2;
        }
        return com.moloco.sdk.internal.utils.b.a(str, j);
    }
}
