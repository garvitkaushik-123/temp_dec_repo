package com.moloco.sdk.internal;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g implements f {

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i f5399a;

    public g(com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest) {
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        this.f5399a = persistentHttpRequest;
    }

    @Override // com.moloco.sdk.internal.f
    public void a(String burl) {
        Intrinsics.checkNotNullParameter(burl, "burl");
        try {
            Uri parse = Uri.parse(burl);
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar = this.f5399a;
            String uri = parse.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
            iVar.a(uri);
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "BUrlTrackerImpl", e.toString(), null, false, 12, null);
        }
    }
}
