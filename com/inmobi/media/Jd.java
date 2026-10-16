package com.inmobi.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public final class Jd {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f2329a = new ConcurrentHashMap();
    public static Id b;
    public static boolean c;

    public static void a() {
        Intrinsics.checkNotNullExpressionValue("Jd", "TAG");
        b("android.intent.action.ACTION_SHUTDOWN");
        b("android.intent.action.REBOOT");
        L3 l3 = L3.f2348a;
        if (l3.H()) {
            b("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        }
        b("android.intent.action.USER_PRESENT");
        if (l3.x()) {
            b("SYSTEM_CONNECTIVITY_CHANGE");
        } else {
            b("android.net.conn.CONNECTIVITY_CHANGE");
        }
        f2329a.clear();
    }

    public static void b() {
        Intrinsics.checkNotNullExpressionValue("Jd", "TAG");
        a("android.intent.action.ACTION_SHUTDOWN");
        a("android.intent.action.REBOOT");
        L3 l3 = L3.f2348a;
        if (l3.H()) {
            a("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        }
        a("android.intent.action.USER_PRESENT");
        if (l3.x()) {
            a("SYSTEM_CONNECTIVITY_CHANGE");
        } else {
            a("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    public static void b(String str) {
        Context d = Uc.d();
        if (d != null) {
            if (L3.f2348a.x() && Intrinsics.areEqual("SYSTEM_CONNECTIVITY_CHANGE", str) && b != null) {
                Object systemService = d.getSystemService("connectivity");
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                if (connectivityManager != null) {
                    Id id = b;
                    Intrinsics.checkNotNull(id);
                    connectivityManager.unregisterNetworkCallback(id);
                    b = null;
                    return;
                }
                return;
            }
            ConcurrentHashMap concurrentHashMap = f2329a;
            if (concurrentHashMap.get(str) != null) {
                d.unregisterReceiver((BroadcastReceiver) concurrentHashMap.get(str));
                concurrentHashMap.remove(str);
            }
        }
    }

    public static void a(String str) {
        Context d = Uc.d();
        if (d != null) {
            if (L3.f2348a.x() && Intrinsics.areEqual("SYSTEM_CONNECTIVITY_CHANGE", str)) {
                Object systemService = d.getSystemService("connectivity");
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                if (connectivityManager != null) {
                    Id id = new Id();
                    b = id;
                    connectivityManager.registerDefaultNetworkCallback(id);
                    return;
                }
                return;
            }
            ConcurrentHashMap concurrentHashMap = f2329a;
            if (concurrentHashMap.get(str) == null) {
                Hd hd = new Hd();
                concurrentHashMap.put(str, hd);
                B2.a(d, hd, new IntentFilter(str));
            }
        }
    }

    public static final void a(Context context, Intent intent) {
        Intrinsics.checkNotNullExpressionValue("Jd", "TAG");
        if (intent.getAction() == null) {
            return;
        }
        try {
            Intrinsics.checkNotNullExpressionValue("Jd", "TAG");
            intent.getAction();
            boolean z = false;
            if (Intrinsics.areEqual("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
                Object systemService = context.getSystemService("connectivity");
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || activeNetworkInfo.isConnected() != c) {
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            z = true;
                        }
                        c = z;
                        Intrinsics.checkNotNullExpressionValue("Jd", "TAG");
                        Uc.f().b(new C2607d2(10, 4, c ? "available" : "lost"));
                        return;
                    }
                    return;
                }
                return;
            }
            if (StringsKt.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED", intent.getAction(), true)) {
                Object systemService2 = context.getSystemService("power");
                PowerManager powerManager = systemService2 instanceof PowerManager ? (PowerManager) systemService2 : null;
                if (powerManager != null && L3.f2348a.H()) {
                    z = powerManager.isDeviceIdleMode();
                }
                if (z == c || !L3.f2348a.H()) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue("Jd", "TAG");
                Uc.f().b(new C2607d2(11, 4, String.valueOf(z)));
                return;
            }
            if (Intrinsics.areEqual("android.intent.action.USER_PRESENT", intent.getAction())) {
                Intrinsics.checkNotNullExpressionValue("Jd", "TAG");
                Uc.f().b(new C2607d2(100, 6, (String) null));
                return;
            }
            if (Intrinsics.areEqual("android.intent.action.ACTION_SHUTDOWN", intent.getAction())) {
                Intrinsics.checkNotNullExpressionValue("Jd", "TAG");
                Uc.f().b(new C2607d2(1, 6, (String) null));
                Iterator it = f2329a.entrySet().iterator();
                while (it.hasNext()) {
                    b((String) ((Map.Entry) it.next()).getKey());
                }
                f2329a.clear();
                b = null;
                return;
            }
            if (Intrinsics.areEqual("android.intent.action.REBOOT", intent.getAction())) {
                Intrinsics.checkNotNullExpressionValue("Jd", "TAG");
                Uc.f().b(new C2607d2(2, 6, (String) null));
                Iterator it2 = f2329a.entrySet().iterator();
                while (it2.hasNext()) {
                    b((String) ((Map.Entry) it2.next()).getKey());
                }
                f2329a.clear();
                b = null;
                return;
            }
            Intrinsics.checkNotNullExpressionValue("Jd", "TAG");
            Uc.f().b(new C2607d2(99, 4, intent.getAction()));
        } catch (Exception unused) {
        }
    }
}
