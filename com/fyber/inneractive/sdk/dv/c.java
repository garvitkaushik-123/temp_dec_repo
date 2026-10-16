package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.k;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;

/* loaded from: classes4.dex */
public final class c extends k {
    public final boolean m;

    public c() {
        boolean z;
        try {
            Class.forName("com.google.android.gms.ads.InterstitialAd");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        this.m = !z;
    }

    @Override // com.fyber.inneractive.sdk.flow.k, com.fyber.inneractive.sdk.interfaces.b
    public final void a() {
        x xVar = this.c;
        if (xVar != null) {
            a aVar = (a) xVar;
            aVar.g = null;
            aVar.i = null;
        }
        super.a();
    }

    @Override // com.fyber.inneractive.sdk.flow.k, com.fyber.inneractive.sdk.interfaces.c
    public final void cancel() {
        x xVar = this.c;
        if (xVar != null) {
            a aVar = (a) xVar;
            aVar.g = null;
            aVar.i = null;
        }
        this.k.a();
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(this));
        r.b.removeCallbacks(this.l);
        this.f1207a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public final String d() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public final void g() {
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        if (eVar == null || ((i) eVar).u == null) {
            i();
            return;
        }
        InneractiveAdRequest inneractiveAdRequest = this.f1207a;
        if (inneractiveAdRequest != null) {
            boolean muteVideo = inneractiveAdRequest.getMuteVideo();
            try {
                MobileAds.setAppMuted(muteVideo);
                MobileAds.setAppVolume(muteVideo ? 0.0f : 1.0f);
            } catch (Throwable unused) {
            }
        }
        i iVar = (i) this.b;
        UnitDisplayType unitDisplayType = iVar.p;
        QueryInfo queryInfo = iVar.u.f1146a;
        int i = b.f1135a[unitDisplayType.ordinal()];
        x bVar = i != 1 ? (i == 2 || i == 3) ? new com.fyber.inneractive.sdk.dv.banner.b(e(), this.g, (i) this.b) : i != 4 ? null : this.m ? new com.fyber.inneractive.sdk.dv.rewarded.d(e(), this.g, (i) this.b) : new com.fyber.inneractive.sdk.dv.rewarded.g(e(), this.g, (i) this.b) : this.m ? new com.fyber.inneractive.sdk.dv.interstitial.d(e(), this.g, (i) this.b) : new com.fyber.inneractive.sdk.dv.interstitial.g(e(), this.g, (i) this.b);
        this.c = bVar;
        if (queryInfo == null || bVar == null || this.b == null) {
            i();
            return;
        }
        try {
            AdRequest.Builder builder = new AdRequest.Builder();
            try {
                builder.getClass().getMethod("setAdString", String.class).invoke(builder, ((i) this.b).N);
            } catch (Exception unused2) {
                builder.setAdInfo(new AdInfo(queryInfo, ((i) this.b).N));
            }
            ((a) this.c).a(builder.build(), this);
        } catch (Throwable unused3) {
            i();
        }
    }

    public final void i() {
        a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.i.NETWORK_ERROR));
    }
}
