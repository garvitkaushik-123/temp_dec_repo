package com.fyber.inneractive.sdk.measurement;

import android.content.Context;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.e0;
import com.fyber.inneractive.sdk.network.t0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.Omid;
import com.iab.omid.library.fyber.adsession.Partner;

/* loaded from: classes4.dex */
public final class e {
    public String b;
    public String c;
    public String d;
    public Partner e;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1268a = false;
    public final com.fyber.inneractive.sdk.measurement.tracker.f f = new com.fyber.inneractive.sdk.measurement.tracker.f();
    public final a g = new a(this);
    public final b h = new b(this);
    public final c i = new c(this);

    public static void a(e eVar, Context context) {
        eVar.getClass();
        a(context, "https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/" + Omid.getVersion() + ".js", "omid-latest.js", eVar.g);
        a(context, "https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/omid-session-client-" + Omid.getVersion() + ".js", "omid-session-client-latest.js", eVar.h);
        a(context, "https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/dt-omsdk-mraid-video-tracker.js", "dt-omsdk-mraid-video-tracker.js", eVar.i);
    }

    public static void a(Context context, String str, String str2, e0 e0Var) {
        IAlog.d("%s- Loading URL: %s", IAlog.a(e.class), str);
        IAConfigManager.O.s.b(new t0(e0Var, context, new com.fyber.inneractive.sdk.cache.e(str, str2)));
    }
}
