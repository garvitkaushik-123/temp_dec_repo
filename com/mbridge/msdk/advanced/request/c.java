package com.mbridge.msdk.advanced.request;

import android.content.Context;
import android.os.Build;
import com.ironsource.N6;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.out.MBConfiguration;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.bidmachine.iab.vast.tags.VastAttributes;

/* compiled from: NativeAdvancedMBLoadRequest.java */
/* loaded from: classes6.dex */
public class c extends com.mbridge.msdk.foundation.same.net.wrapper.b {
    public c(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.wrapper.a, com.mbridge.msdk.foundation.same.net.wrapper.c
    public void addExtraParams(String str, com.mbridge.msdk.foundation.same.net.wrapper.e eVar) {
        super.addExtraParams(str, eVar);
        eVar.a(N6.H, "1");
        eVar.a("os_version", Build.VERSION.RELEASE);
        eVar.a("package_name", l0.t(this.mContext));
        eVar.a("app_version_name", l0.B(this.mContext));
        eVar.a("app_version_code", l0.A(this.mContext) + "");
        eVar.a("orientation", l0.F(this.mContext) + "");
        eVar.a(N6.B, l0.n());
        eVar.a("brand", l0.s());
        eVar.a("gaid", "");
        eVar.a("gaid2", com.mbridge.msdk.foundation.tools.f.c());
        int s = l0.s(this.mContext);
        eVar.a("network_type", s + "");
        eVar.a("network_str", l0.a(this.mContext, s) + "");
        eVar.a("language", l0.p(this.mContext));
        eVar.a("timezone", l0.w());
        eVar.a("useragent", l0.i());
        eVar.a(BidTokenRepositoryKt.SDK_VERSION, MBConfiguration.SDK_VERSION);
        eVar.a("screen_size", l0.n(this.mContext) + VastAttributes.HORIZONTAL_POSITION + l0.m(this.mContext));
        eVar.a("version_flag", "1");
        if (com.mbridge.msdk.util.b.a()) {
            eVar.a("gp_version", u.d(this.mContext));
        }
        com.mbridge.msdk.foundation.same.net.wrapper.f.a(eVar, this.mContext);
        com.mbridge.msdk.foundation.same.net.wrapper.f.b(eVar);
        com.mbridge.msdk.foundation.same.net.wrapper.f.j(eVar);
    }
}
