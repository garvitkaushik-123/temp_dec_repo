package com.fyber.inneractive.sdk.dv.handler;

import android.os.Bundle;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.dv.j;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.network.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class e extends a {
    public static final List e = Arrays.asList(UnitDisplayType.INTERSTITIAL, UnitDisplayType.REWARDED, UnitDisplayType.BANNER);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1141a = new HashMap();
    public boolean b = false;
    public final Object c = new Object();
    public int d = 0;

    public static AdRequest a(e eVar) {
        eVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_3");
        AdRequest.Builder builder = new AdRequest.Builder();
        try {
            Class<?> cls = Class.forName("com.google.android.gms.ads.AbstractAdRequestBuilder");
            Object invoke = cls.getMethod("setRequestAgent", String.class).invoke(builder, "FyberMarketplace-v8.3.8");
            if (invoke != null) {
                builder = (AdRequest.Builder) invoke;
            }
            Object invoke2 = cls.getMethod("addNetworkExtrasBundle", Class.class, Bundle.class).invoke(builder, AdMobAdapter.class, bundle);
            if (invoke2 != null) {
                builder = (AdRequest.Builder) invoke2;
            }
        } catch (ClassNotFoundException unused) {
            builder.setRequestAgent("FyberMarketplace-v8.3.8").addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        }
        return builder.build();
    }

    public static String b() {
        try {
            try {
                Object invoke = Class.forName("com.google.android.gms.ads.MobileAds").getMethod("getVersion", null).invoke(null, null);
                if (invoke != null) {
                    return invoke.toString();
                }
            } catch (NoSuchMethodException unused) {
                return MobileAds.getVersionString();
            }
        } catch (Throwable unused2) {
        }
        return "na";
    }

    @Override // com.fyber.inneractive.sdk.dv.handler.a
    public final void a() {
        AdFormat adFormat;
        Iterator it = e.iterator();
        while (it.hasNext()) {
            int i = d.f1140a[((UnitDisplayType) it.next()).ordinal()];
            if (i == 1 || i == 2) {
                adFormat = AdFormat.BANNER;
            } else if (i != 3) {
                adFormat = AdFormat.INTERSTITIAL;
            } else {
                adFormat = AdFormat.REWARDED;
            }
            r.f1777a.execute(new c(this, adFormat));
        }
    }

    @Override // com.fyber.inneractive.sdk.dv.handler.a
    public final j a(UnitDisplayType unitDisplayType) {
        AdFormat adFormat;
        j jVar;
        int i = d.f1140a[unitDisplayType.ordinal()];
        if (i == 1 || i == 2) {
            adFormat = AdFormat.BANNER;
        } else if (i != 3) {
            adFormat = AdFormat.INTERSTITIAL;
        } else {
            adFormat = AdFormat.REWARDED;
        }
        QueryInfo queryInfo = (QueryInfo) this.f1141a.get(adFormat);
        if (queryInfo != null) {
            synchronized (this.c) {
                this.f1141a.remove(adFormat);
            }
            jVar = new j(queryInfo);
        } else {
            jVar = null;
        }
        IAlog.a("DVHanlder - get query: %s", jVar);
        r.f1777a.execute(new c(this, adFormat));
        return jVar;
    }

    public static void a(String str, com.fyber.inneractive.sdk.dv.enums.a aVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, String str2) {
        IAlog.a("Firing Event 1001 -Phase - " + aVar.name() + "  Fetch error DV - msg  " + str2, new Object[0]);
        w wVar = new w(t.DV_ERROR_PHASE, inneractiveAdRequest, eVar);
        wVar.f.put(new x().a(str, "spot_id").a(aVar.name().toLowerCase(Locale.US), "phase").a(b(), "version").a(str2, PglCryptUtils.KEY_MESSAGE).f1342a);
        wVar.a((String) null);
    }
}
