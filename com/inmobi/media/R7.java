package com.inmobi.media;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class R7 implements InterfaceC2961yb {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T7 f2416a;

    public R7(T7 t7) {
        this.f2416a = t7;
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public final boolean a() {
        return true;
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public final boolean d() {
        return true;
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public final long getViewTouchTimestamp() {
        return -1L;
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public final void a(String triggerApi) {
        Intrinsics.checkNotNullParameter(triggerApi, "triggerApi");
        HashMap hashMap = new HashMap();
        hashMap.put("creativeId", this.f2416a.getCreativeId());
        hashMap.put("trigger", triggerApi);
        hashMap.put("impressionId", this.f2416a.getImpressionId());
        hashMap.put("adType", "native");
        Pd pd = Pd.f2401a;
        Pd.b("BlockAutoRedirection", hashMap, Td.f2443a);
    }
}
