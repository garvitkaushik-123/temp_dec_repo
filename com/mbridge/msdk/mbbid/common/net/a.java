package com.mbridge.msdk.mbbid.common.net;

import android.content.Context;
import android.os.Build;
import com.ironsource.N6;
import com.mbridge.msdk.foundation.same.net.wrapper.e;
import com.mbridge.msdk.foundation.same.net.wrapper.h;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.setting.g;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.bidmachine.iab.vast.tags.VastAttributes;

/* compiled from: BidRequest.java */
/* loaded from: classes6.dex */
public class a extends h {
    public a(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.wrapper.h, com.mbridge.msdk.foundation.same.net.wrapper.c
    public void addExtraParams(String str, e eVar) {
        super.addExtraParams(str, eVar);
        g d = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d == null) {
            d = com.mbridge.msdk.setting.h.b().a();
        }
        eVar.a(N6.H, "1");
        eVar.a("os_version", Build.VERSION.RELEASE);
        eVar.a("package_name", l0.t(this.mContext));
        eVar.a("app_version_name", l0.B(this.mContext));
        eVar.a("app_version_code", l0.A(this.mContext) + "");
        eVar.a(N6.B, l0.n());
        eVar.a("brand", l0.s());
        eVar.a("gaid", "");
        eVar.a("gaid2", f.c());
        int s = l0.s(this.mContext);
        eVar.a("network_type", s + "");
        eVar.a("network_str", l0.a(this.mContext, s) + "");
        eVar.a("language", l0.p(this.mContext));
        eVar.a("timezone", l0.w());
        eVar.a("useragent", l0.i());
        eVar.a(BidTokenRepositoryKt.SDK_VERSION, MBConfiguration.SDK_VERSION);
        eVar.a("screen_size", l0.n(this.mContext) + VastAttributes.HORIZONTAL_POSITION + l0.m(this.mContext));
        b.a(eVar, d, this.mContext);
        com.mbridge.msdk.foundation.same.net.wrapper.f.a(eVar, this.mContext);
        com.mbridge.msdk.foundation.same.net.wrapper.f.b(eVar);
        com.mbridge.msdk.foundation.same.net.wrapper.f.d(eVar);
        com.mbridge.msdk.foundation.same.net.wrapper.f.j(eVar);
    }
}
