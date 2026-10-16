package com.fyber.inneractive.sdk.config;

import android.content.Context;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* loaded from: classes4.dex */
public abstract class n0 {
    /* JADX WARN: Removed duplicated region for block: B:11:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, w wVar) {
        boolean z;
        AdvertisingIdClient.Info advertisingIdInfo;
        String str = null;
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            z = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        try {
            IAlog.e("limit ad tracking: %s", Boolean.valueOf(z));
            if (z) {
                IAlog.e("user has opt out of Ads Personalization. not accessing Advertising ID.", new Object[0]);
            } else {
                str = advertisingIdInfo.getId();
                IAlog.e("advertising id: %s", str);
            }
        } catch (Throwable th2) {
            th = th2;
            IAlog.e("Handled Exception:", new Object[0]);
            IAlog.e(com.fyber.inneractive.sdk.util.t.b(th), new Object[0]);
            IAlog.c("Advertising ID is not available. Please add Google Play Services library to improve your ad targeting.", new Object[0]);
            synchronized (wVar) {
            }
        }
        synchronized (wVar) {
            v vVar = wVar.b;
            vVar.f1129a = str;
            vVar.b = z;
            vVar.c = false;
        }
    }
}
