package com.ironsource;

import android.app.Activity;
import com.ironsource.sdk.IronSourceNetwork;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.kc, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3166kc implements InterfaceC3149jc {
    @Override // com.ironsource.InterfaceC3149jc
    public void a(Activity activity, B9 adInstance, Map<String, String> showParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(showParams, "showParams");
        IronSourceNetwork.showAd(activity, adInstance, showParams);
    }

    @Override // com.ironsource.InterfaceC3149jc
    public boolean a(B9 adInstance) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        return IronSourceNetwork.isAdAvailableForInstance(adInstance);
    }
}
