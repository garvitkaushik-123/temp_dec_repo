package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.l, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3462l {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5851a = "DEC_FAILED_TO_LOAD";
    public static final String b = "DEC_LOADED_WITH_NO_APP_ICON";
    public static final String c = "DECLoaderImpl";

    public static final void b(String str) {
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, c, str, false, 4, null);
    }

    public static final InterfaceC3460j a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i mediaCacheRepository, com.moloco.sdk.internal.error.b errorReportingService) {
        Intrinsics.checkNotNullParameter(mediaCacheRepository, "mediaCacheRepository");
        Intrinsics.checkNotNullParameter(errorReportingService, "errorReportingService");
        return new C3461k(mediaCacheRepository, errorReportingService);
    }
}
