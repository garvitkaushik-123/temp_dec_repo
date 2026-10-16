package com.inmobi.media;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.x2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2933x2 implements N2 {
    public static ThreadPoolExecutor b;
    public static HandlerC2805p2 c;
    public static HandlerThread d;
    public static AdConfig.ImaiConfig g;
    public static final C2917w2 m;

    /* renamed from: a, reason: collision with root package name */
    public static final C2933x2 f2748a = new C2933x2();
    public static List e = new ArrayList();
    public static final AtomicBoolean f = new AtomicBoolean(false);
    public static final AtomicBoolean h = new AtomicBoolean(true);
    public static final Object i = new Object();
    public static final LinkedHashMap j = new LinkedHashMap();
    public static final C2885u2 k = C2885u2.f2717a;
    public static final Lazy l = LazyKt.lazy(C2901v2.f2728a);

    public static final HashMap a(C2933x2 c2933x2, C2740l2 c2740l2) {
        c2933x2.getClass();
        HashMap hashMap = new HashMap();
        try {
            AdConfig.ImaiConfig imaiConfig = g;
            int maxRetries = ((imaiConfig != null ? imaiConfig.getMaxRetries() : 0) - c2740l2.f) + 1;
            if (maxRetries > 0) {
                hashMap.put("X-im-retry-count", String.valueOf(maxRetries));
                return hashMap;
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("x2", "TAG");
        }
        return hashMap;
    }

    public static final /* synthetic */ String f() {
        return "x2";
    }

    public static void i() {
        try {
            AtomicBoolean atomicBoolean = f;
            atomicBoolean.set(false);
            synchronized (i) {
                if (!atomicBoolean.get()) {
                    HandlerThread handlerThread = d;
                    if (handlerThread != null) {
                        handlerThread.getLooper().quit();
                        handlerThread.interrupt();
                    }
                    d = null;
                    c = null;
                }
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("x2", "TAG");
        }
    }

    public final boolean g() {
        return ((Boolean) l.getValue()).booleanValue();
    }

    public final void h() {
        HandlerThread handlerThread;
        try {
            boolean z = T9.f2439a;
            if (T9.a(false) != null) {
                return;
            }
            synchronized (i) {
                AtomicBoolean atomicBoolean = f;
                if (atomicBoolean.compareAndSet(false, true)) {
                    Intrinsics.checkNotNullExpressionValue("x2", "TAG");
                    if (d == null) {
                        HandlerThread handlerThread2 = new HandlerThread("pingHandlerThread");
                        d = handlerThread2;
                        D4.a(handlerThread2, "pingHandlerThread");
                    }
                    if (c == null && (handlerThread = d) != null) {
                        Looper looper = handlerThread.getLooper();
                        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
                        c = new HandlerC2805p2(looper);
                    }
                    C2756m2 b2 = Nc.b();
                    if (b2 != null && T1.a(b2, null, null, 63) != 0) {
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        HandlerC2805p2 handlerC2805p2 = c;
                        if (handlerC2805p2 != null) {
                            handlerC2805p2.sendMessage(obtain);
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue("x2", "TAG");
                    atomicBoolean.set(false);
                    i();
                }
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("x2", "TAG");
        }
    }

    public static final void b(C2933x2 c2933x2, C2740l2 c2740l2) {
        c2933x2.getClass();
        LinkedHashMap linkedHashMap = j;
        Z1 z1 = (Z1) linkedHashMap.get(Integer.valueOf(c2740l2.f2628a));
        if (z1 != null) {
            z1.a(c2740l2);
        }
        linkedHashMap.remove(Integer.valueOf(c2740l2.f2628a));
    }

    public static final void c(C2933x2 c2933x2, C2740l2 click) {
        c2933x2.getClass();
        int i2 = click.f;
        if (i2 > 0) {
            click.f = i2 - 1;
            click.g = System.currentTimeMillis();
            C2756m2 b2 = Nc.b();
            b2.getClass();
            Intrinsics.checkNotNullParameter(click, "click");
            b2.b(click, "id = ?", new String[]{String.valueOf(click.f2628a)});
        }
    }

    public static /* synthetic */ void b(C2933x2 c2933x2, String str, boolean z, Z1 z1, InterfaceC2971z5 interfaceC2971z5, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z1 = null;
        }
        c2933x2.b(str, z, z1, interfaceC2971z5);
    }

    public final void b(final String url, final boolean z, final Z1 z1, final InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(url, "url");
        Ua ua = AbstractC2949y2.f2758a;
        AbstractC2949y2.a(new Runnable() { // from class: com.inmobi.media.x2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C2933x2.b(url, z, interfaceC2971z5, z1);
            }
        }, Ta.b);
    }

    public static final /* synthetic */ void a(C2933x2 c2933x2) {
        c2933x2.getClass();
        i();
    }

    static {
        Intrinsics.checkNotNullExpressionValue("x2", "TAG");
        Uc.a(new Runnable() { // from class: com.inmobi.media.x2$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C2933x2.a();
            }
        });
        m = new C2917w2();
    }

    public static final void a() {
        C2933x2 c2933x2 = f2748a;
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            Intrinsics.checkNotNullExpressionValue("x2", "TAG");
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5L, timeUnit, linkedBlockingQueue, new K5("x2"));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            b = threadPoolExecutor;
            HandlerThread handlerThread = new HandlerThread("pingHandlerThread");
            d = handlerThread;
            D4.a(handlerThread, "pingHandlerThread");
            HandlerThread handlerThread2 = d;
            Intrinsics.checkNotNull(handlerThread2);
            Looper looper = handlerThread2.getLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
            c = new HandlerC2805p2(looper);
            LinkedHashMap linkedHashMap = O2.f2380a;
            Config a2 = M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, Uc.b(), c2933x2);
            Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
            g = ((AdConfig) a2).getImai();
            Uc.f().a(new int[]{10, 11, 2, 1}, k);
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("x2", "TAG");
        }
    }

    public static final void c(String url, boolean z, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(url, "$url");
        try {
            if (f2748a.g()) {
                AdConfig.ImaiConfig imaiConfig = g;
                C2740l2 c2740l2 = new C2740l2(url, null, z, true, (imaiConfig != null ? imaiConfig.getMaxRetries() : 0) + 1, 197);
                if (interfaceC2971z5 != null) {
                    Intrinsics.checkNotNullExpressionValue("x2", "TAG");
                    ((A5) interfaceC2971z5).c("x2", "Received click (" + url + ") for pinging in WebView");
                }
                a(c2740l2, (Z1) null, interfaceC2971z5);
            }
        } catch (Exception e2) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("x2", rf.a(e2, H6.a("x2", "TAG", "SDK encountered unexpected error in pinging click over WebView; ")));
            }
        }
    }

    public static final void b(String url, boolean z, InterfaceC2971z5 interfaceC2971z5, Z1 z1) {
        Intrinsics.checkNotNullParameter(url, "$url");
        try {
            if (f2748a.g()) {
                AdConfig.ImaiConfig imaiConfig = g;
                C2740l2 c2740l2 = new C2740l2(url, null, z, false, (imaiConfig != null ? imaiConfig.getMaxRetries() : 0) + 1, 197);
                if (interfaceC2971z5 != null) {
                    Intrinsics.checkNotNullExpressionValue("x2", "TAG");
                    ((A5) interfaceC2971z5).a("x2", "Received click (" + url + ") for pinging over HTTP");
                }
                a(c2740l2, z1, interfaceC2971z5);
            }
        } catch (Exception e2) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("x2", rf.a(e2, H6.a("x2", "TAG", "SDK encountered unexpected error in pinging click; ")));
            }
        }
    }

    @Override // com.inmobi.media.N2
    public void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        AdConfig adConfig = config instanceof AdConfig ? (AdConfig) config : null;
        g = adConfig != null ? adConfig.getImai() : null;
    }

    public final void a(String url, boolean z, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(url, "url");
        a(url, z, (Z1) null, interfaceC2971z5);
    }

    public static /* synthetic */ void a(C2933x2 c2933x2, String str, boolean z, Z1 z1, InterfaceC2971z5 interfaceC2971z5, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z1 = null;
        }
        c2933x2.a(str, z, z1, interfaceC2971z5);
    }

    public final void a(final String url, final boolean z, final Z1 z1, final InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(url, "url");
        Ua ua = AbstractC2949y2.f2758a;
        AbstractC2949y2.a(new Runnable() { // from class: com.inmobi.media.x2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2933x2.a(url, z, interfaceC2971z5, z1);
            }
        }, Ta.c);
    }

    public static final void a(String url, boolean z, InterfaceC2971z5 interfaceC2971z5, Z1 z1) {
        Intrinsics.checkNotNullParameter(url, "$url");
        try {
            if (f2748a.g()) {
                AdConfig.ImaiConfig imaiConfig = g;
                C2740l2 c2740l2 = new C2740l2(url, null, z, false, (imaiConfig != null ? imaiConfig.getMaxRetries() : 0) + 1, 197);
                if (interfaceC2971z5 != null) {
                    Intrinsics.checkNotNullExpressionValue("x2", "TAG");
                    ((A5) interfaceC2971z5).a("x2", "Received click (" + url + ") for pinging over HTTP");
                }
                a(c2740l2, z1, interfaceC2971z5);
            }
        } catch (Exception e2) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("x2", rf.a(e2, H6.a("x2", "TAG", "SDK encountered unexpected error in pinging click; ")));
            }
        }
    }

    public final void b(final String url, final boolean z, final InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(url, "url");
        Ua ua = AbstractC2949y2.f2758a;
        AbstractC2949y2.a(new Runnable() { // from class: com.inmobi.media.x2$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C2933x2.c(url, z, interfaceC2971z5);
            }
        }, Ta.c);
    }

    public static /* synthetic */ void a(C2933x2 c2933x2, String str, Map map, boolean z, Z1 z1, Ta ta, InterfaceC2971z5 interfaceC2971z5, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z1 = null;
        }
        c2933x2.a(str, map, z, z1, ta, interfaceC2971z5);
    }

    public final void a(final String url, final Map<String, String> map, final boolean z, final Z1 z1, Ta priority, final InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Ua ua = AbstractC2949y2.f2758a;
        AbstractC2949y2.a(new Runnable() { // from class: com.inmobi.media.x2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C2933x2.a(url, map, z, interfaceC2971z5, z1);
            }
        }, priority);
    }

    public static final void a(String url, Map map, boolean z, InterfaceC2971z5 interfaceC2971z5, Z1 z1) {
        Intrinsics.checkNotNullParameter(url, "$url");
        try {
            if (f2748a.g()) {
                AdConfig.ImaiConfig imaiConfig = g;
                C2740l2 c2740l2 = new C2740l2(url, map, z, false, (imaiConfig != null ? imaiConfig.getMaxRetries() : 0) + 1, 193);
                if (interfaceC2971z5 != null) {
                    Intrinsics.checkNotNullExpressionValue("x2", "TAG");
                    ((A5) interfaceC2971z5).a("x2", "Received click (" + url + ") for pinging over HTTP");
                }
                a(c2740l2, z1, interfaceC2971z5);
            }
        } catch (Exception e2) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("x2", rf.a(e2, H6.a("x2", "TAG", "SDK encountered unexpected error in pinging click; ")));
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e2, "event"));
        }
    }

    public static void a(final C2740l2 click, Z1 z1, final InterfaceC2971z5 interfaceC2971z5) {
        HandlerC2805p2 handlerC2805p2 = c;
        if (handlerC2805p2 != null) {
            handlerC2805p2.f2667a = interfaceC2971z5;
        }
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("x2", "TAG");
            ((A5) interfaceC2971z5).c("x2", "record Click");
        }
        AdConfig.ImaiConfig imaiConfig = g;
        if (imaiConfig != null) {
            C2756m2 b2 = Nc.b();
            int maxDbEvents = imaiConfig.getMaxDbEvents();
            synchronized (b2) {
                Intrinsics.checkNotNullParameter(click, "click");
                if (T1.a(b2, null, null, 63) >= maxDbEvents) {
                    Intrinsics.checkNotNullExpressionValue("m2", "TAG");
                    C2740l2 click2 = (C2740l2) b2.b("ts= (SELECT MIN(ts) FROM click LIMIT 1)", null);
                    if (click2 != null) {
                        Intrinsics.checkNotNullExpressionValue("m2", "TAG");
                        f2748a.a(click, "DB_OVERLOAD");
                        Intrinsics.checkNotNullParameter(click2, "click");
                        b2.a("id = ?", new String[]{String.valueOf(click2.f2628a)});
                    }
                }
                b2.a(click);
            }
            if (z1 != null) {
                j.put(Integer.valueOf(click.f2628a), z1);
            }
        }
        boolean z = T9.f2439a;
        if (T9.a(false) != null) {
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("x2", "TAG");
                ((A5) interfaceC2971z5).b("x2", "No network available. Saving click for later processing ...");
            }
            f.set(false);
            i();
            return;
        }
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("x2", H6.a("x2", "TAG", "submit click - ").append(click.f2628a).toString());
        }
        ThreadPoolExecutor threadPoolExecutor = b;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.submit(new Runnable() { // from class: com.inmobi.media.x2$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    C2933x2.a(C2740l2.this, interfaceC2971z5);
                }
            });
        }
    }

    public static final void a(C2740l2 click, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(click, "$click");
        SystemClock.elapsedRealtime();
        if (click.e) {
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("x2", "TAG");
                ((A5) interfaceC2971z5).c("x2", "ping in web view");
            }
            new C2836r2(m, interfaceC2971z5).a(click);
            return;
        }
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("x2", "TAG");
            ((A5) interfaceC2971z5).c("x2", "ping in http executor");
        }
        new C2852s2(m, interfaceC2971z5).a(click);
    }

    public final void a(C2740l2 click, String error) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(error, "error");
        LinkedHashMap linkedHashMap = j;
        Z1 z1 = (Z1) linkedHashMap.get(Integer.valueOf(click.f2628a));
        if (z1 != null) {
            z1.a(click, error);
        }
        linkedHashMap.remove(Integer.valueOf(click.f2628a));
    }
}
