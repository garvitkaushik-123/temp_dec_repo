package com.ironsource;

import android.text.TextUtils;
import com.ironsource.AbstractC3292s3;
import com.ironsource.N0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class lg<Smash extends AbstractC3292s3<?>> {
    AbstractC3292s3<?> d;
    private final List<String> e;
    private final int f;
    mg h;

    /* renamed from: a, reason: collision with root package name */
    ConcurrentHashMap<String, CopyOnWriteArrayList<Smash>> f3467a = new ConcurrentHashMap<>();
    private String b = "";
    private String c = "";
    private final Timer g = new Timer();
    private final int i = 5;

    class a extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3468a;

        a(String str) {
            this.f3468a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("removing waterfall with id " + this.f3468a + " from memory");
                lg.this.f3467a.remove(this.f3468a);
                ironLog.verbose("waterfall size is currently " + lg.this.f3467a.size());
            } finally {
                cancel();
            }
        }
    }

    public lg(List<String> list, int i, mg mgVar) {
        this.e = list;
        this.f = i;
        this.h = mgVar;
    }

    private synchronized boolean e() {
        boolean z;
        AbstractC3292s3<?> abstractC3292s3 = this.d;
        if (abstractC3292s3 != null && abstractC3292s3.C()) {
            z = this.d.h().equals(this.c);
        }
        return z;
    }

    public synchronized void a(AbstractC3292s3<?> abstractC3292s3) {
        IronLog.INTERNAL.verbose();
        AbstractC3292s3<?> abstractC3292s32 = this.d;
        if (abstractC3292s32 != null && !abstractC3292s32.equals(abstractC3292s3)) {
            this.d.M();
        }
    }

    public synchronized void b(AbstractC3292s3<?> abstractC3292s3) {
        IronLog.INTERNAL.verbose();
        this.d = abstractC3292s3;
    }

    public String c() {
        return this.b;
    }

    public AbstractC3292s3<?> d() {
        return this.d;
    }

    public List<Smash> b() {
        CopyOnWriteArrayList<Smash> copyOnWriteArrayList = this.f3467a.get(this.b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList() : copyOnWriteArrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0038, code lost:
    
        if (r0.e.contains(r3) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0044, code lost:
    
        if (r0.d.n().equals(r3) == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0049 A[Catch: all -> 0x0063, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0049, B:13:0x0008, B:15:0x000d, B:18:0x0012, B:20:0x0016, B:23:0x001d, B:25:0x0021, B:28:0x002e, B:30:0x0032, B:32:0x003a), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean a(N0.a aVar, String str, String str2, LoadWhileShowSupportState loadWhileShowSupportState, AdapterBaseInterface adapterBaseInterface, IronSource.AD_UNIT ad_unit) {
        boolean z;
        if (!a(adapterBaseInterface, ad_unit, str)) {
            z = true;
            if (aVar != N0.a.AUTOMATIC_LOAD_WHILE_SHOW) {
                if (aVar != N0.a.MANUAL_WITH_LOAD_ON_SHOW) {
                    if (!z) {
                        IronLog.INTERNAL.verbose(str + " will not be added to the auction request");
                    }
                }
            }
            AbstractC3292s3<?> abstractC3292s3 = this.d;
            if (abstractC3292s3 != null) {
                if (abstractC3292s3.C()) {
                    if (loadWhileShowSupportState == LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK) {
                        if (this.d.c().equals(str)) {
                        }
                    }
                    if (loadWhileShowSupportState != LoadWhileShowSupportState.NONE) {
                    }
                }
            }
            if (!z) {
            }
        }
        z = false;
        if (!z) {
        }
        return z;
    }

    public boolean a(AdapterBaseInterface adapterBaseInterface, IronSource.AD_UNIT ad_unit, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !(adapterBaseInterface instanceof AdapterSettingsInterface) || !((AdapterSettingsInterface) adapterBaseInterface).isUsingActivityBeforeImpression(ad_unit)) {
            return false;
        }
        ironLog.verbose(str + " - is using activity before impression and activity is null");
        return true;
    }

    public void a(N0.a aVar, CopyOnWriteArrayList<Smash> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        a();
        if (aVar != N0.a.AUTOMATIC_LOAD_WHILE_SHOW && aVar != N0.a.MANUAL_WITH_LOAD_ON_SHOW) {
            this.f3467a.clear();
            this.f3467a.put(str, copyOnWriteArrayList);
        } else {
            this.f3467a.put(str, copyOnWriteArrayList);
            if (!TextUtils.isEmpty(this.c)) {
                if (e()) {
                    ironLog.verbose("ad from previous waterfall " + this.c + " is still showing - the current waterfall " + this.b + " will be deleted instead");
                    String str2 = this.b;
                    this.b = this.c;
                    this.c = str2;
                }
                this.g.schedule(new a(this.c), this.f);
            }
        }
        this.c = this.b;
        this.b = str;
        if (this.f3467a.size() > 5) {
            this.h.a(this.f3467a.size());
        }
    }

    private void a() {
        for (Smash smash : b()) {
            if (!smash.equals(this.d)) {
                smash.M();
            }
        }
    }
}
