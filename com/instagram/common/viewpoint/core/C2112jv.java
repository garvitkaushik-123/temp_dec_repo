package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.jv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2112jv extends AbstractRunnableC1416Wc {
    public final /* synthetic */ C2111ju A00;
    public final /* synthetic */ Map A01;
    public final /* synthetic */ Map A02;

    public C2112jv(C2111ju c2111ju, Map map, Map map2) {
        this.A00 = c2111ju;
        this.A02 = map;
        this.A01 = map2;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        C2099ji c2099ji;
        C1929gi c1929gi;
        C2099ji c2099ji2;
        c2099ji = this.A00.A01;
        if (!TextUtils.isEmpty(c2099ji.A7O())) {
            HashMap hashMap = new HashMap();
            Map<String, String> extraData = this.A02;
            hashMap.putAll(extraData);
            Map<String, String> extraData2 = this.A01;
            hashMap.putAll(extraData2);
            c1929gi = this.A00.A0A;
            VA A0A = c1929gi.A0A();
            c2099ji2 = this.A00.A01;
            A0A.AC3(c2099ji2.A7O(), hashMap);
        }
    }
}
