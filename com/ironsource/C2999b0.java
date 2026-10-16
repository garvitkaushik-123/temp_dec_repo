package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.b0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C2999b0 implements InterfaceC2982a0 {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3149jc f3188a;

    public C2999b0(InterfaceC3149jc networkShowApi) {
        Intrinsics.checkNotNullParameter(networkShowApi, "networkShowApi");
        this.f3188a = networkShowApi;
    }

    @Override // com.ironsource.InterfaceC2982a0
    public void a(Activity activity, B9 adInstance) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        IronLog.ADAPTER_API.verbose("Show: networkInstanceId=" + adInstance.g() + " adInstanceId=" + adInstance.e());
        this.f3188a.a(activity, adInstance, new HashMap());
    }

    @Override // com.ironsource.InterfaceC2982a0
    public boolean a(B9 adInstance) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        return this.f3188a.a(adInstance);
    }
}
