package com.applovin.impl.mediation;

import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.b6;
import com.applovin.impl.g5;
import com.applovin.impl.i;
import com.applovin.impl.k7;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.n5;
import com.applovin.impl.o3;
import com.applovin.impl.p3;
import com.applovin.impl.q2;
import com.applovin.impl.q3;
import com.applovin.impl.r3;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t5;
import com.applovin.impl.v2;
import com.applovin.impl.v4;
import com.applovin.impl.x2;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final k f576a;
    private final Map b = new HashMap(4);
    private final Object c = new Object();
    private final Map d = new HashMap(4);
    private final Object e = new Object();
    private final Map f = new HashMap();
    private final Object g = new Object();

    class a implements n5.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f577a;
        final /* synthetic */ Map b;
        final /* synthetic */ String c;
        final /* synthetic */ x2 d;
        final /* synthetic */ Context e;
        final /* synthetic */ a.InterfaceC0097a f;

        a(long j, Map map, String str, x2 x2Var, Context context, a.InterfaceC0097a interfaceC0097a) {
            this.f577a = j;
            this.b = map;
            this.c = str;
            this.d = x2Var;
            this.e = context;
            this.f = interfaceC0097a;
        }

        @Override // com.applovin.impl.n5.b
        public void a(JSONArray jSONArray) {
            this.b.put("sct_ms", Long.valueOf(SystemClock.elapsedRealtime() - this.f577a));
            this.b.put("calfc", Integer.valueOf(d.this.b(this.c)));
            t5 t5Var = new t5(this.d, jSONArray, this.e, d.this.f576a, this.f);
            if (((Boolean) d.this.f576a.a(o3.e8)).booleanValue()) {
                d.this.f576a.r0().a((g5) t5Var, b6.b.MEDIATION);
            } else {
                d.this.f576a.r0().a(t5Var);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements a.InterfaceC0097a {

        /* renamed from: a, reason: collision with root package name */
        private final k f578a;
        private final WeakReference b;
        private final d c;
        private final c d;
        private final MaxAdFormat e;
        private final Map f;
        private final Map g;
        private final Map h;
        private final int i;
        private long j;
        private long k;

        /* synthetic */ b(Map map, Map map2, Map map3, c cVar, MaxAdFormat maxAdFormat, long j, long j2, d dVar, k kVar, Context context, a aVar) {
            this(map, map2, map3, cVar, maxAdFormat, j, j2, dVar, kVar, context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, String str) {
            this.g.put("retry_delay_sec", Integer.valueOf(i));
            this.g.put("retry_attempt", Integer.valueOf(this.d.c));
            Context context = (Context) this.b.get();
            if (context == null) {
                context = k.o();
            }
            this.h.put("art", i.EXPONENTIAL_RETRY.b());
            this.h.put("era", Integer.valueOf(this.d.c));
            this.k = System.currentTimeMillis();
            this.c.a(str, this.e, this.f, this.g, this.h, context, this);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            throw new IllegalStateException("Wrong callback invoked for ad: " + maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, MaxError maxError) {
            MaxError maxError2;
            this.c.c(str);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.j;
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) maxError.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                maxError2 = maxError;
                this.f578a.X().processWaterfallInfoPostback(maxAdWaterfallInfoImpl, maxError2, this.k, elapsedRealtime);
            } else {
                maxError2 = maxError;
            }
            boolean z = maxError2.getCode() == -5603 && k7.c(this.f578a) && ((Boolean) this.f578a.a(v4.o6)).booleanValue();
            if (this.f578a.a(o3.Y7, this.e) && this.d.c < this.i && !z) {
                c.e(this.d);
                final int pow = (int) Math.pow(2.0d, this.d.c);
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.d$b$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.b.this.a(pow, str);
                    }
                }, TimeUnit.SECONDS.toMillis(pow));
                return;
            }
            this.d.c = 0;
            this.d.b.set(false);
            if (this.d.d != null) {
                MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxError2;
                maxErrorImpl.setLoadTag(this.d.f579a);
                maxErrorImpl.setRequestLatencyMillis(elapsedRealtime);
                q2.a(this.d.d, str, maxError2);
                this.d.d = null;
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            v2 v2Var = (v2) maxAd;
            v2Var.i(this.d.f579a);
            v2Var.a(SystemClock.elapsedRealtime() - this.j);
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) v2Var.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                this.f578a.X().processWaterfallInfoPostback(maxAdWaterfallInfoImpl, null, this.k, v2Var.getRequestLatencyMillis());
            }
            this.c.a(maxAd.getAdUnitId());
            this.d.c = 0;
            if (this.d.d == null) {
                this.c.a(v2Var);
                this.d.b.set(false);
                return;
            }
            v2Var.A().c().a(this.d.d);
            this.d.d.onAdLoaded(v2Var);
            if (v2Var.N().endsWith("load")) {
                this.d.d.onAdRevenuePaid(v2Var);
            }
            this.d.d = null;
            if ((!this.f578a.c(o3.U7).contains(maxAd.getAdUnitId()) && !this.f578a.a(o3.T7, maxAd.getFormat())) || this.f578a.t0().c() || this.f578a.t0().d()) {
                this.d.b.set(false);
                return;
            }
            Context context = (Context) this.b.get();
            if (context == null) {
                context = k.o();
            }
            this.j = SystemClock.elapsedRealtime();
            this.k = System.currentTimeMillis();
            this.h.put("art", i.SEQUENTIAL_OR_PRECACHE.b());
            this.c.a(maxAd.getAdUnitId(), maxAd.getFormat(), this.f, this.g, this.h, context, this);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        private b(Map map, Map map2, Map map3, c cVar, MaxAdFormat maxAdFormat, long j, long j2, d dVar, k kVar, Context context) {
            this.f578a = kVar;
            this.b = new WeakReference(context);
            this.c = dVar;
            this.d = cVar;
            this.e = maxAdFormat;
            this.g = map2;
            this.f = map;
            this.h = map3;
            this.j = j;
            this.k = j2;
            if (CollectionUtils.getBoolean(map2, "disable_auto_retries")) {
                this.i = -1;
            } else if (maxAdFormat.isAdViewAd() && CollectionUtils.getBoolean(map2, "auto_refresh_stopped")) {
                this.i = Math.min(2, ((Integer) kVar.a(o3.X7)).intValue());
            } else {
                this.i = ((Integer) kVar.a(o3.X7)).intValue();
            }
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f579a;
        private final AtomicBoolean b;
        private int c;
        private volatile a.InterfaceC0097a d;

        /* synthetic */ c(String str, a aVar) {
            this(str);
        }

        static /* synthetic */ int e(c cVar) {
            int i = cVar.c;
            cVar.c = i + 1;
            return i;
        }

        private c(String str) {
            this.b = new AtomicBoolean();
            this.f579a = str;
        }
    }

    public d(k kVar) {
        this.f576a = kVar;
    }

    private v2 e(String str) {
        v2 v2Var;
        synchronized (this.e) {
            v2Var = (v2) this.d.get(str);
            this.d.remove(str);
        }
        return v2Var;
    }

    public void c(String str, String str2) {
        synchronized (this.c) {
            this.b.remove(b(str, str2));
        }
    }

    public boolean d(String str) {
        boolean z;
        synchronized (this.e) {
            z = this.d.get(str) != null;
        }
        return z;
    }

    private String b(String str, String str2) {
        return str + (str2 != null ? "-" + str2 : "");
    }

    public int b(String str) {
        int intValue;
        synchronized (this.g) {
            Integer num = (Integer) this.f.get(str);
            intValue = num != null ? num.intValue() : 0;
        }
        return intValue;
    }

    public void a(String str, String str2, MaxAdFormat maxAdFormat, i iVar, Map map, Map map2, Context context, a.InterfaceC0097a interfaceC0097a) {
        v2 e = (this.f576a.t0().d() || k7.h(k.o())) ? null : e(str);
        if (e != null) {
            e.i(str2);
            e.A().c().a(interfaceC0097a);
            interfaceC0097a.onAdLoaded(e);
            if (e.N().endsWith("load")) {
                interfaceC0097a.onAdRevenuePaid(e);
            }
        }
        c a2 = a(str, str2);
        if (!a2.b.compareAndSet(false, true)) {
            if (a2.d != null && a2.d != interfaceC0097a) {
                o.j("MediationAdLoadManager", "Attempting to load ad for same ad unit id (" + str + ") while another ad load is already in progress!");
            }
            a2.d = interfaceC0097a;
            return;
        }
        if (e == null) {
            a2.d = interfaceC0097a;
        }
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        synchronizedMap.put("art", iVar.b());
        if (StringUtils.isValidString(str2)) {
            synchronizedMap.put("alt", str2);
        }
        a(str, maxAdFormat, map, map2, synchronizedMap, context, new b(map, map2, synchronizedMap, a2, maxAdFormat, SystemClock.elapsedRealtime(), System.currentTimeMillis(), this, this.f576a, context, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        synchronized (this.g) {
            this.f576a.O();
            if (o.a()) {
                this.f576a.O().a("MediationAdLoadManager", "Incrementing ad load failures count for ad unit ID: " + str);
            }
            Integer num = (Integer) this.f.get(str);
            if (num == null) {
                num = 0;
            }
            this.f.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MaxAdFormat maxAdFormat, Map map, Map map2, Map map3, Context context, a.InterfaceC0097a interfaceC0097a) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        x2 x2Var = new x2(str, maxAdFormat, map, map2, map3, a(str, maxAdFormat));
        this.f576a.r0().a((g5) new n5(x2Var, context, this.f576a, new a(elapsedRealtime, map3, str, x2Var, context, interfaceC0097a)), b6.b.MEDIATION);
    }

    private com.applovin.impl.h a(String str, MaxAdFormat maxAdFormat) {
        if (((Boolean) this.f576a.a(v4.C4)).booleanValue()) {
            r3 Y = this.f576a.Y();
            p3 p3Var = p3.e;
            Map a2 = Y.a(p3Var, q3.a(str));
            p3.a aVar = p3.a.SESSION;
            int a3 = a(a2, aVar);
            p3.a aVar2 = p3.a.INSTALL;
            int a4 = a(a2, aVar2);
            Map a5 = this.f576a.Y().a(p3Var, q3.a(maxAdFormat));
            return new com.applovin.impl.h(a3, a4, a(a5, aVar), a(a5, aVar2));
        }
        return new com.applovin.impl.h(-1, -1, -1, -1);
    }

    private int a(Map map, p3.a aVar) {
        Long l;
        if (map == null || (l = (Long) map.get(aVar.b())) == null) {
            return -1;
        }
        return l.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v2 v2Var) {
        synchronized (this.e) {
            if (this.d.containsKey(v2Var.getAdUnitId())) {
                o.h("AppLovinSdk", "Ad in cache already: " + v2Var.getAdUnitId());
            }
            this.d.put(v2Var.getAdUnitId(), v2Var);
        }
    }

    private c a(String str, String str2) {
        c cVar;
        synchronized (this.c) {
            String b2 = b(str, str2);
            cVar = (c) this.b.get(b2);
            if (cVar == null) {
                cVar = new c(str2, null);
                this.b.put(b2, cVar);
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        synchronized (this.g) {
            this.f576a.O();
            if (o.a()) {
                this.f576a.O().a("MediationAdLoadManager", "Clearing ad load failures count for ad unit ID: " + str);
            }
            this.f.remove(str);
        }
    }
}
