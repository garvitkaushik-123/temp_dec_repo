package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class m0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1107a;
    public final /* synthetic */ w b;

    public m0(Context context, w wVar) {
        this.f1107a = context;
        this.b = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (InneractiveAdManager.isCurrentUserAChild()) {
            return;
        }
        try {
            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            n0.a(this.f1107a, this.b);
            v vVar = u.f1127a.b;
            if (TextUtils.isEmpty(vVar != null ? vVar.f1129a : null)) {
                n.a(this.f1107a, this.b);
            }
        } catch (Throwable th) {
            IAlog.b("SDK internal error: Make sure that Google Play Services for Mobile Ads is added to the compile dependencies of your project" + th.toString(), new Object[0]);
        }
    }
}
