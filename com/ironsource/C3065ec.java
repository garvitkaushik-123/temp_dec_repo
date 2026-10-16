package com.ironsource;

import com.ironsource.sdk.IronSourceNetwork;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ec, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3065ec implements InterfaceC3048dc {
    @Override // com.ironsource.InterfaceC3048dc
    public void a(B9 adInstance, C3082fc loadParams) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(loadParams, "loadParams");
        IronSourceNetwork.loadAd(adInstance, loadParams.a());
    }

    @Override // com.ironsource.InterfaceC3048dc
    public String a() {
        String version = IronSourceNetwork.getVersion();
        Intrinsics.checkNotNullExpressionValue(version, "getVersion()");
        return version;
    }
}
