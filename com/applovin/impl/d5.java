package com.applovin.impl;

import android.content.IntentFilter;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class d5 {

    /* renamed from: a, reason: collision with root package name */
    private final Set f436a = new HashSet(32);
    private final Object b = new Object();

    public boolean a(String str) {
        synchronized (this.b) {
            Iterator it = this.f436a.iterator();
            while (it.hasNext()) {
                if (str.equals(((e5) it.next()).b())) {
                    return true;
                }
            }
            return false;
        }
    }

    public void b(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        e5 a2;
        if (StringUtils.isValidString(str)) {
            synchronized (this.b) {
                a2 = a(str, appLovinCommunicatorSubscriber);
            }
            if (a2 != null) {
                a2.a(false);
                AppLovinBroadcastManager.unregisterReceiver(a2);
            }
        }
    }

    public boolean a(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        if (appLovinCommunicatorSubscriber != null && StringUtils.isValidString(str)) {
            synchronized (this.b) {
                e5 a2 = a(str, appLovinCommunicatorSubscriber);
                if (a2 != null) {
                    com.applovin.impl.sdk.o.h("AppLovinCommunicator", "Attempting to re-subscribe subscriber (" + appLovinCommunicatorSubscriber + ") to topic (" + str + ")");
                    if (!a2.c()) {
                        a2.a(true);
                        AppLovinBroadcastManager.registerReceiver(a2, new IntentFilter(str));
                    }
                    return true;
                }
                e5 e5Var = new e5(str, appLovinCommunicatorSubscriber);
                this.f436a.add(e5Var);
                AppLovinBroadcastManager.registerReceiver(e5Var, new IntentFilter(str));
                return true;
            }
        }
        com.applovin.impl.sdk.o.h("AppLovinCommunicator", "Unable to subscribe - invalid subscriber (" + appLovinCommunicatorSubscriber + ") or topic (" + str + ")");
        return false;
    }

    private e5 a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (e5 e5Var : this.f436a) {
            if (str.equals(e5Var.b()) && appLovinCommunicatorSubscriber.equals(e5Var.a())) {
                return e5Var;
            }
        }
        return null;
    }
}
