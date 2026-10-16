package com.fyber.inneractive.sdk.measurement;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.network.z;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.Omid;
import com.iab.omid.library.fyber.adsession.Partner;

/* loaded from: classes4.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1267a;
    public final /* synthetic */ e b;

    public d(e eVar, Context context) {
        this.b = eVar;
        this.f1267a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Omid.activate(this.f1267a);
            this.b.e = Partner.createPartner("Fyber", InneractiveAdManager.getVersion());
            e.a(this.b, this.f1267a);
            IAlog.a("OMID SDK was activated - version %s", Omid.getVersion());
            IAlog.d("OMID SDK was activated - version %s", Omid.getVersion());
        } catch (Throwable th) {
            IAlog.a("Failed starting omsdk with exception %s", th.getLocalizedMessage());
            this.b.getClass();
            z.a(th.getClass().getSimpleName(), "OpenMeasurementMeasurer - " + th.getMessage(), null, null);
        }
    }
}
