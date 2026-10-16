package com.instagram.common.viewpoint.core;

import java.util.Collection;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.kJ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2135kJ implements InterfaceC1184Mw {
    public final /* synthetic */ C1929gi A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ JSONObject A02;

    public C2135kJ(JSONObject jSONObject, C1929gi c1929gi, String str) {
        this.A02 = jSONObject;
        this.A00 = c1929gi;
        this.A01 = str;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1184Mw
    public final String A7O() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1184Mw
    public final Collection<String> A7p() {
        return AbstractC1185Mx.A03(this.A00, this.A02);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1184Mw
    public final EnumC1183Mv A8K() {
        return AbstractC1185Mx.A00(this.A02);
    }
}
