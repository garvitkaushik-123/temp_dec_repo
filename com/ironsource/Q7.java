package com.ironsource;

import com.ironsource.sdk.utils.SDKUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Q7 {
    public final String a() {
        String OMID_LIB_VERSION = C3251pc.f;
        Intrinsics.checkNotNullExpressionValue(OMID_LIB_VERSION, "OMID_LIB_VERSION");
        return OMID_LIB_VERSION;
    }

    public final String b() {
        return C3251pc.e;
    }

    public final String c() {
        String sDKVersion = SDKUtils.getSDKVersion();
        Intrinsics.checkNotNullExpressionValue(sDKVersion, "getSDKVersion()");
        return sDKVersion;
    }
}
