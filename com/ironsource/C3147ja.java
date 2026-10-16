package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.ironsource.ja, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3147ja {
    private static final String i = "WaterfallLifeCycleHolder";
    private com.ironsource.mediationsdk.r d;
    private final List<String> e;
    private final int f;

    /* renamed from: a, reason: collision with root package name */
    ConcurrentHashMap<String, CopyOnWriteArrayList<com.ironsource.mediationsdk.r>> f3377a = new ConcurrentHashMap<>();
    private String b = "";
    private String c = "";
    private final Timer g = new Timer();
    ConcurrentHashMap<String, AdInfo> h = new ConcurrentHashMap<>();

    /* renamed from: com.ironsource.ja$a */
    class a extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3378a;

        a(String str) {
            this.f3378a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("removing waterfall with id " + this.f3378a + " from memory");
                C3147ja.this.f3377a.remove(this.f3378a);
                ironLog.verbose("waterfall size is currently " + C3147ja.this.f3377a.size());
                ironLog.verbose("removing adInfo with id " + this.f3378a + " from memory");
                C3147ja.this.h.remove(this.f3378a);
                ironLog.verbose("adInfo size is currently " + C3147ja.this.h.size());
            } finally {
                cancel();
            }
        }
    }

    public C3147ja(List<String> list, int i2) {
        this.e = list;
        this.f = i2;
    }

    public synchronized void a(com.ironsource.mediationsdk.r rVar) {
        IronLog.INTERNAL.verbose();
        com.ironsource.mediationsdk.r rVar2 = this.d;
        if (rVar2 != null && !rVar2.equals(rVar)) {
            this.d.q();
        }
        this.d = rVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        if (r5.e.contains(r6.j()) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        if (r5.d.j().equals(r6.j()) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean b(com.ironsource.mediationsdk.r rVar) {
        boolean z;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (rVar != null && !rVar.o()) {
            z = false;
            if (this.d != null) {
                if (rVar.w() == LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK) {
                    if (this.d.c().equals(rVar.c())) {
                    }
                }
                if (rVar.w() != LoadWhileShowSupportState.NONE) {
                }
            }
            if (z && rVar != null) {
                ironLog.verbose(rVar.c() + " will not be added to the auction request");
            }
        }
        z = true;
        if (z) {
            ironLog.verbose(rVar.c() + " will not be added to the auction request");
        }
        return !z;
    }

    public CopyOnWriteArrayList<com.ironsource.mediationsdk.r> c() {
        CopyOnWriteArrayList<com.ironsource.mediationsdk.r> copyOnWriteArrayList = this.f3377a.get(this.b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList<>() : copyOnWriteArrayList;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.f3377a.size();
    }

    public com.ironsource.mediationsdk.r f() {
        return this.d;
    }

    public synchronized boolean g() {
        boolean z;
        com.ironsource.mediationsdk.r rVar = this.d;
        if (rVar != null) {
            z = rVar.u().equals(this.c);
        }
        return z;
    }

    public void a(CopyOnWriteArrayList<com.ironsource.mediationsdk.r> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        b();
        this.f3377a.put(str, copyOnWriteArrayList);
        if (!TextUtils.isEmpty(this.c)) {
            if (g()) {
                ironLog.verbose("ad from previous waterfall " + this.c + " is still showing - the current waterfall " + this.b + " will be deleted instead");
                String str2 = this.b;
                this.b = this.c;
                this.c = str2;
            }
            this.g.schedule(new a(this.c), this.f);
        }
        this.c = this.b;
        this.b = str;
    }

    private void b() {
        Iterator<com.ironsource.mediationsdk.r> it = c().iterator();
        while (it.hasNext()) {
            com.ironsource.mediationsdk.r next = it.next();
            if (!next.equals(this.d)) {
                next.q();
            }
        }
    }

    public boolean a() {
        return this.f3377a.size() > 5;
    }

    public void a(String str, ImpressionData impressionData, C3132ib c3132ib) {
        if (TextUtils.isEmpty(str) || impressionData == null) {
            return;
        }
        this.h.put(str, new AdInfo(impressionData, c3132ib));
    }

    public AdInfo a(String str) {
        if (this.h.containsKey(str)) {
            return this.h.get(str);
        }
        return null;
    }
}
