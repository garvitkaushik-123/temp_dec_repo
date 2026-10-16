package com.applovin.impl.sdk.network;

import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.applovin.impl.b6;
import com.applovin.impl.g5;
import com.applovin.impl.k7;
import com.applovin.impl.p6;
import com.applovin.impl.q2;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a, reason: collision with root package name */
    private final k f719a;
    private final o b;
    private final int c;
    private final c d;
    private final Object e = new Object();
    private final List f;
    private final Set g;
    private final List h;

    class a implements AppLovinPostbackListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f720a;
        final /* synthetic */ AppLovinPostbackListener b;

        a(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
            this.f720a = dVar;
            this.b = appLovinPostbackListener;
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackFailure(String str, int i) {
            o unused = b.this.b;
            if (o.a()) {
                b.this.b.d("PersistentPostbackManager", "Failed to submit postback: " + this.f720a + " with error code: " + i + "; will retry later...");
            }
            b.this.d(this.f720a);
            q2.a(this.b, str, i);
            if (this.f720a.c() == 1) {
                b.this.f719a.E().a("dispatchPostback", str, i, (String) null);
            }
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackSuccess(String str) {
            b.this.a(this.f720a);
            o unused = b.this.b;
            if (o.a()) {
                b.this.b.a("PersistentPostbackManager", "Successfully submit postback: " + this.f720a);
            }
            b.this.c();
            q2.a(this.b, str);
        }
    }

    public b(k kVar) {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        this.g = new HashSet();
        this.h = new ArrayList();
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f719a = kVar;
        this.b = kVar.O();
        int intValue = ((Integer) kVar.a(v4.H2)).intValue();
        this.c = intValue;
        if (!((Boolean) kVar.a(v4.K2)).booleanValue()) {
            this.d = null;
            return;
        }
        c cVar = new c(this, kVar);
        this.d = cVar;
        arrayList.addAll(cVar.a(intValue));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
    }

    protected List d() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.e) {
            if (((Boolean) this.f719a.a(v4.J2)).booleanValue()) {
                arrayList.ensureCapacity(this.h.size());
                arrayList.addAll(this.h);
            } else {
                arrayList.ensureCapacity(this.f.size());
                arrayList.addAll(this.f);
            }
        }
        return arrayList;
    }

    public void e(d dVar) {
        a(dVar, true);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        this.f719a.r0().a((g5) this.d, b6.b.OTHER);
    }

    private void c(d dVar) {
        synchronized (this.e) {
            while (this.f.size() > this.c) {
                this.f.remove(0);
            }
            this.f.add(dVar);
        }
        if (o.a()) {
            this.b.a("PersistentPostbackManager", "Enqueued postback: " + dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        synchronized (this.e) {
            Iterator it = new ArrayList(this.f).iterator();
            while (it.hasNext()) {
                b((d) it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
        synchronized (this.e) {
            c(dVar);
            a(dVar, appLovinPostbackListener);
        }
    }

    public void a(d dVar, boolean z) {
        a(dVar, z, (AppLovinPostbackListener) null);
    }

    public void a(final d dVar, boolean z, final AppLovinPostbackListener appLovinPostbackListener) {
        if (TextUtils.isEmpty(dVar.k())) {
            if (o.a()) {
                this.b.b("PersistentPostbackManager", "Requested a postback dispatch for empty URL; nothing to do...");
            }
        } else {
            if (z) {
                dVar.a();
            }
            a(new Runnable() { // from class: com.applovin.impl.sdk.network.b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b(dVar, appLovinPostbackListener);
                }
            }, k7.h(), dVar.m());
        }
    }

    public void b() {
        a(new Runnable() { // from class: com.applovin.impl.sdk.network.b$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                b.this.e();
            }
        }, true, false);
    }

    private void b(d dVar) {
        a(dVar, (AppLovinPostbackListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.e) {
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                b((d) it.next());
            }
            this.h.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(d dVar) {
        synchronized (this.e) {
            this.g.remove(dVar);
            this.h.add(dVar);
        }
    }

    public void a() {
        synchronized (this.e) {
            this.f.clear();
            this.h.clear();
        }
        this.f719a.r0().a((g5) this.d, b6.b.OTHER);
    }

    private void a(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
        if (o.a()) {
            this.b.a("PersistentPostbackManager", "Preparing to submit postback: " + dVar);
        }
        if (this.f719a.F0() && !dVar.m()) {
            if (o.a()) {
                this.b.a("PersistentPostbackManager", "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(dVar.k())) {
            if (o.a()) {
                this.b.b("PersistentPostbackManager", "Skipping empty postback dispatch...");
                return;
            }
            return;
        }
        synchronized (this.e) {
            if (this.g.contains(dVar)) {
                if (o.a()) {
                    this.b.a("PersistentPostbackManager", "Skipping in progress postback: " + dVar.k());
                }
                return;
            }
            dVar.l();
            Integer num = (Integer) this.f719a.a(v4.G2);
            if (dVar.c() > num.intValue()) {
                if (o.a()) {
                    this.b.k("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + num + ". Dequeuing postback: " + dVar);
                }
                a(dVar);
            } else {
                synchronized (this.e) {
                    this.g.add(dVar);
                }
                e a2 = e.b(this.f719a).b(dVar.k()).a(dVar.d()).b(dVar.i()).c(dVar.h()).a(dVar.g()).a(dVar.j() != null ? new JSONObject(dVar.j()) : null).b(dVar.o()).a(dVar.n()).a(dVar.f()).h(dVar.p()).e(dVar.e()).a();
                if (o.a()) {
                    this.b.a("PersistentPostbackManager", "Submitting postback: " + dVar);
                }
                this.f719a.g0().dispatchPostbackRequest(a2, new a(dVar, appLovinPostbackListener));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        synchronized (this.e) {
            this.g.remove(dVar);
            this.f.remove(dVar);
        }
        if (o.a()) {
            this.b.a("PersistentPostbackManager", "Dequeued postback: " + dVar);
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2) {
        if (z) {
            this.f719a.r0().a((g5) new p6(this.f719a, z2, "runPostbackTask", runnable), b6.b.OTHER);
        } else {
            runnable.run();
        }
    }
}
