package com.fyber.inneractive.sdk.dv.handler;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.o;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;

/* loaded from: classes4.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdFormat f1139a;
    public final /* synthetic */ e b;

    public c(e eVar, AdFormat adFormat) {
        this.b = eVar;
        this.f1139a = adFormat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            QueryInfo.generate(o.f1770a, this.f1139a, e.a(this.b), new b(this));
        } catch (Throwable th) {
            IAlog.a("Error in resolveDVTokens", th, new Object[0]);
        }
    }
}
