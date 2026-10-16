package com.applovin.impl;

import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class e5 implements AppLovinBroadcastManager.Receiver {
    private final String b;
    private final WeakReference c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f445a = true;
    private final Set d = new LinkedHashSet();
    private final Object e = new Object();

    e5(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        this.b = str;
        this.c = new WeakReference(appLovinCommunicatorSubscriber);
    }

    public AppLovinCommunicatorSubscriber a() {
        return (AppLovinCommunicatorSubscriber) this.c.get();
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.f445a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e5)) {
            return false;
        }
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = (AppLovinCommunicatorSubscriber) this.c.get();
        e5 e5Var = (e5) obj;
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber2 = (AppLovinCommunicatorSubscriber) e5Var.c.get();
        return b().equals(e5Var.b()) && (appLovinCommunicatorSubscriber == null ? appLovinCommunicatorSubscriber == appLovinCommunicatorSubscriber2 : appLovinCommunicatorSubscriber.equals(appLovinCommunicatorSubscriber2));
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = (AppLovinCommunicatorSubscriber) this.c.get();
        return (hashCode * 31) + (appLovinCommunicatorSubscriber != null ? appLovinCommunicatorSubscriber.hashCode() : 0);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        boolean z;
        if (a() == null) {
            com.applovin.impl.sdk.o.h("AppLovinCommunicator", "Message received for GC'd subscriber");
            return;
        }
        CommunicatorMessageImpl communicatorMessageImpl = (CommunicatorMessageImpl) intent;
        synchronized (this.e) {
            if (this.d.contains(communicatorMessageImpl.getUniqueId())) {
                z = false;
            } else {
                this.d.add(communicatorMessageImpl.getUniqueId());
                z = true;
            }
        }
        if (z) {
            a().onMessageReceived((AppLovinCommunicatorMessage) communicatorMessageImpl);
        }
    }

    public void a(boolean z) {
        this.f445a = z;
    }
}
