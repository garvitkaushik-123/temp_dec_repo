package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.applovin.impl.b6;
import com.applovin.impl.c2;
import com.applovin.impl.g5;
import com.applovin.impl.k1;
import com.applovin.impl.p6;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.c;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.u;
import com.applovin.impl.v4;
import com.applovin.impl.x4;
import com.applovin.sdk.AppLovinAdType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class d implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a, reason: collision with root package name */
    private final k f683a;
    private final c b;
    private final List c = Collections.synchronizedList(new ArrayList());

    public interface a {
        void a(com.applovin.impl.sdk.ad.b bVar);
    }

    public d(k kVar) {
        this.f683a = kVar;
        this.b = new c(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(c.a aVar) {
        if (aVar == null) {
            this.f683a.O();
            if (o.a()) {
                this.f683a.O().a("AdPersistenceManager", "Ad failed to persist");
                return;
            }
            return;
        }
        this.c.add(aVar);
        if (((Boolean) this.f683a.a(v4.X0)).booleanValue()) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f683a.q0().b(x4.D);
        this.b.a();
    }

    private void e() {
        String str = (String) this.f683a.q0().a(x4.D);
        if (str == null) {
            return;
        }
        JSONArray jsonArray = JsonUtils.toJsonArray(str, new JSONArray());
        for (int length = jsonArray.length() - 1; length >= 0; length--) {
            c.a a2 = c.a.a(JsonUtils.getJSONObject(jsonArray, length, new JSONObject()), this.f683a);
            if (a2 != null) {
                if (a(a2)) {
                    this.f683a.g().d(c2.L, CollectionUtils.map("details", "ttl = " + (a2.c() - SystemClock.elapsedRealtime()) + "ms"));
                } else {
                    this.c.add(0, a2);
                }
            }
        }
    }

    private void f() {
        this.f683a.r0().a((g5) new p6(this.f683a, "loadPersistedAdFilesQueueAndCleanupAsync", new Runnable() { // from class: com.applovin.impl.sdk.d$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                d.this.c();
            }
        }), b6.b.OTHER);
    }

    private void h() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.c) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                arrayList.add(((c.a) it.next()).a());
            }
        }
        this.f683a.q0().b(x4.D, new JSONArray((Collection) arrayList).toString());
    }

    public void a(final u uVar, final a aVar) {
        if (aVar == null) {
            this.f683a.O();
            if (o.a()) {
                this.f683a.O().b("AdPersistenceManager", "Persisted ad could not be retrieved: listener is null");
            }
            k1.a("Persisted ad could not be retrieved: listener is null", new Object[0]);
            return;
        }
        if (uVar == null) {
            a(aVar, null, null, "Persisted ad could not be retrieved: adZone is null");
            return;
        }
        this.f683a.g().a(c2.I, uVar, (AppLovinError) null);
        final c.a a2 = a(uVar.g());
        this.b.a(a2, new c.InterfaceC0103c() { // from class: com.applovin.impl.sdk.d$$ExternalSyntheticLambda0
            @Override // com.applovin.impl.sdk.c.InterfaceC0103c
            public final void a(com.applovin.impl.sdk.ad.b bVar, String str) {
                d.this.a(aVar, a2, uVar, bVar, str);
            }
        });
    }

    public void b() {
        f();
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
    }

    public void g() {
        this.f683a.r0().a((g5) new p6(this.f683a, "resetManagerState", new Runnable() { // from class: com.applovin.impl.sdk.d$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                d.this.d();
            }
        }), b6.b.OTHER);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        h();
    }

    private void d(c.a aVar) {
        if (aVar != null && this.c.remove(aVar)) {
            this.b.b(aVar);
        }
    }

    public void b(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f683a.g().a(c2.F, bVar);
        this.b.b(bVar, new c.b() { // from class: com.applovin.impl.sdk.d$$ExternalSyntheticLambda3
            @Override // com.applovin.impl.sdk.c.b
            public final void a(c.a aVar) {
                d.this.c(aVar);
            }
        });
    }

    private boolean b(c.a aVar) {
        long b = aVar.b();
        return (b == 0 || b == k.n()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        e();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, c.a aVar2, u uVar, com.applovin.impl.sdk.ad.b bVar, String str) {
        if (bVar != null && !StringUtils.isValidString(str)) {
            a(aVar, bVar, aVar2);
        } else {
            a(aVar, aVar2, uVar, str);
        }
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            return;
        }
        d(c.a.a(bVar));
    }

    private c.a a(AppLovinAdType appLovinAdType) {
        c.a aVar;
        synchronized (this.c) {
            Iterator it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = (c.a) it.next();
                if (aVar.f().equals(appLovinAdType) && !a(aVar) && b(aVar)) {
                    break;
                }
            }
            this.c.remove(aVar);
        }
        return aVar;
    }

    private void a(a aVar, c.a aVar2, u uVar, String str) {
        if (aVar == null) {
            return;
        }
        this.f683a.O();
        if (o.a()) {
            this.f683a.O().a("AdPersistenceManager", str);
        }
        aVar.a(null);
        this.b.b(aVar2);
        this.f683a.g().a(c2.K, uVar, new AppLovinError(-1, str));
    }

    private void a(a aVar, com.applovin.impl.sdk.ad.b bVar, c.a aVar2) {
        if (aVar == null) {
            return;
        }
        this.f683a.O();
        if (o.a()) {
            this.f683a.O().a("AdPersistenceManager", "Loading persisted ad");
        }
        aVar.a(bVar);
        this.b.b(aVar2);
        this.f683a.g().a(c2.J, bVar);
    }

    private boolean a(c.a aVar) {
        return SystemClock.elapsedRealtime() + ((Long) this.f683a.a(v4.Z0)).longValue() >= aVar.c();
    }

    private void a() {
        synchronized (this.c) {
            this.b.a(new ArrayList(this.c));
        }
    }
}
