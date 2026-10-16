package com.ironsource.mediationsdk;

import com.ironsource.C3024c8;
import com.ironsource.C3184ld;
import com.ironsource.C3325u2;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class n {
    private static final n f = new n();

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f3554a = new HashMap();
    private final Map<String, Boolean> b = new HashMap();
    private int c;
    private int d;
    private int e;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSource.AD_UNIT f3555a;
        final /* synthetic */ IronSourceError b;
        final /* synthetic */ String c;

        a(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError, String str) {
            this.f3555a = ad_unit;
            this.b = ironSourceError;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("onAdLoadFailed - invokeCallback after delaying");
            n.this.a(this.f3555a, this.b);
            n.this.b.put(this.c, Boolean.FALSE);
        }
    }

    private n() {
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            nVar = f;
        }
        return nVar;
    }

    public synchronized void b(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError) {
        if (b(ad_unit)) {
            return;
        }
        String ad_unit2 = ad_unit.toString();
        if (!this.f3554a.containsKey(ad_unit2)) {
            a(ad_unit, ironSourceError);
            return;
        }
        long a2 = a(ad_unit) * 1000;
        long currentTimeMillis = System.currentTimeMillis() - this.f3554a.get(ad_unit2).longValue();
        if (currentTimeMillis > a2) {
            a(ad_unit, ironSourceError);
            return;
        }
        this.b.put(ad_unit2, Boolean.TRUE);
        long j = a2 - currentTimeMillis;
        IronLog.INTERNAL.verbose("delaying callback by " + j);
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(ad_unit, ironSourceError, ad_unit2), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError) {
        this.f3554a.put(ad_unit.toString(), Long.valueOf(System.currentTimeMillis()));
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            C3184ld.a().a(ironSourceError);
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            C3024c8.a().a(ironSourceError);
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            C3325u2.a().a(ironSourceError);
        } else {
            IronLog.INTERNAL.warning("ad unit not supported - " + ad_unit);
        }
    }

    public void a(IronSource.AD_UNIT ad_unit, int i) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.d = i;
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.c = i;
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            this.e = i;
        } else {
            IronLog.INTERNAL.warning("ad unit not supported - " + ad_unit);
        }
    }

    private int a(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return this.d;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return this.c;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return this.e;
        }
        IronLog.INTERNAL.warning("ad unit not supported - " + ad_unit);
        return 0;
    }

    public synchronized boolean b(IronSource.AD_UNIT ad_unit) {
        if (!this.b.containsKey(ad_unit.toString())) {
            return false;
        }
        return this.b.get(ad_unit.toString()).booleanValue();
    }
}
