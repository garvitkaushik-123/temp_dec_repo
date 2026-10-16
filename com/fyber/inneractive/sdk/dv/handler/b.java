package com.fyber.inneractive.sdk.dv.handler;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.network.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

/* loaded from: classes4.dex */
public final class b extends QueryInfoGenerationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f1138a;

    public b(c cVar) {
        this.f1138a = cVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        c cVar = this.f1138a;
        e eVar = cVar.b;
        if (eVar.b) {
            return;
        }
        AdFormat adFormat = cVar.f1139a;
        eVar.getClass();
        IAlog.a("Firing Event 1000 - Fetch error DV - msg  " + str, new Object[0]);
        w wVar = new w(t.FETCH_TOKEN_DV_ERROR, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null);
        wVar.f.put(new x().a(str, PglCryptUtils.KEY_MESSAGE).a(e.b(), "version").a(adFormat.name(), "adFormat").a(Integer.valueOf(eVar.d), "success_count").f1342a);
        wVar.a((String) null);
        this.f1138a.b.b = true;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        IAlog.a("DVHanlder - %s - put query: %s", this.f1138a.f1139a.toString(), queryInfo.getQuery());
        synchronized (this.f1138a.b.c) {
            c cVar = this.f1138a;
            e eVar = cVar.b;
            eVar.d++;
            eVar.f1141a.put(cVar.f1139a, queryInfo);
        }
    }
}
