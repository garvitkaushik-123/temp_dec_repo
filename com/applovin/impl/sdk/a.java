package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.s1;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class a implements AppLovinBroadcastManager.Receiver {
    private static final long e = TimeUnit.SECONDS.toMillis(2);

    /* renamed from: a, reason: collision with root package name */
    private final k f674a;
    private final o b;
    private final HashSet c = new HashSet();
    private final Object d = new Object();

    /* renamed from: com.applovin.impl.sdk.a$a, reason: collision with other inner class name */
    public interface InterfaceC0101a {
        void onAdExpired(s1 s1Var);
    }

    public a(k kVar) {
        this.f674a = kVar;
        this.b = kVar.O();
    }

    private b b(s1 s1Var) {
        synchronized (this.d) {
            if (s1Var == null) {
                return null;
            }
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (s1Var == bVar.b()) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public boolean a(s1 s1Var, InterfaceC0101a interfaceC0101a) {
        synchronized (this.d) {
            if (b(s1Var) != null) {
                if (o.a()) {
                    this.b.a("AdExpirationManager", "Ad expiration already scheduled for ad: " + s1Var);
                }
                return true;
            }
            if (s1Var.getTimeToLiveMillis() <= e) {
                if (o.a()) {
                    this.b.a("AdExpirationManager", "Ad has already expired: " + s1Var);
                }
                s1Var.setExpired();
                return false;
            }
            if (o.a()) {
                this.b.a("AdExpirationManager", "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(s1Var.getTimeToLiveMillis()) + " seconds from now for " + s1Var + "...");
            }
            if (this.c.isEmpty()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
            }
            this.c.add(b.a(s1Var, interfaceC0101a, this.f674a));
            return true;
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            a();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            b();
        }
    }

    private void b() {
        HashSet hashSet = new HashSet();
        synchronized (this.d) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                s1 b = bVar.b();
                if (b == null) {
                    hashSet.add(bVar);
                } else {
                    long timeToLiveMillis = b.getTimeToLiveMillis();
                    if (timeToLiveMillis <= 0) {
                        if (o.a()) {
                            this.b.a("AdExpirationManager", "Ad expired while app was paused. Preparing to notify listener for ad: " + b);
                        }
                        hashSet.add(bVar);
                    } else {
                        if (o.a()) {
                            this.b.a("AdExpirationManager", "Rescheduling expiration with remaining " + TimeUnit.MILLISECONDS.toSeconds(timeToLiveMillis) + " seconds for ad: " + b);
                        }
                        bVar.a(timeToLiveMillis);
                    }
                }
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            b bVar2 = (b) it2.next();
            a(bVar2);
            bVar2.d();
        }
    }

    public void a(s1 s1Var) {
        synchronized (this.d) {
            b b = b(s1Var);
            if (b != null) {
                if (o.a()) {
                    this.b.a("AdExpirationManager", "Cancelling expiration timer for ad: " + s1Var);
                }
                b.a();
                a(b);
            }
        }
    }

    public void a(b bVar) {
        synchronized (this.d) {
            this.c.remove(bVar);
            if (this.c.isEmpty()) {
                AppLovinBroadcastManager.unregisterReceiver(this);
            }
        }
    }

    private void a() {
        synchronized (this.d) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a();
            }
        }
    }
}
