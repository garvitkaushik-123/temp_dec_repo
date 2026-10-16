package com.moloco.sdk.internal.error.api;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.I;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements a {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final I f5392a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.a b;
    public final String c;

    public b(I timeProviderService, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.a httpClient) {
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.f5392a = timeProviderService;
        this.b = httpClient;
        this.c = "ErrorReportingApi";
    }

    @Override // com.moloco.sdk.internal.error.api.a
    public void a(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "SDK Crashed", error, false, 8, null);
    }

    @Override // com.moloco.sdk.internal.error.api.a
    public void a(String error, String url, com.moloco.sdk.internal.error.a errorMetadata) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(errorMetadata, "errorMetadata");
        String b = com.moloco.sdk.internal.utils.b.b(com.moloco.sdk.internal.utils.b.a(url, error, this.f5392a.invoke()), errorMetadata.b());
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.c, "Reporting error: " + error + " to url: " + b, null, false, 12, null);
        this.b.a(b);
    }
}
