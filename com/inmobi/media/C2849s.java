package com.inmobi.media;

import android.content.Context;
import android.media.AudioManager;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2849s {
    public static AudioManager b;
    public static C2769n c;
    public static ScheduledFuture f;
    public static C2818q h;

    /* renamed from: a, reason: collision with root package name */
    public static final C2849s f2699a = new C2849s();
    public static final AtomicBoolean d = new AtomicBoolean(false);
    public static final AtomicReference e = new AtomicReference(null);
    public static final Set g = Collections.synchronizedSet(new LinkedHashSet());

    public static void a(final InterfaceC2971z5 interfaceC2971z5, final Ib listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue()).execute(new Runnable() { // from class: com.inmobi.media.s$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2849s.b(InterfaceC2971z5.this, listener);
            }
        });
    }

    public static final void b(InterfaceC2971z5 interfaceC2971z5, Ib listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("AdAudioTracker", "Adding audio volume change listener. Existing listeners - " + g.size());
        }
        Set<WeakReference> listeners = g;
        Intrinsics.checkNotNullExpressionValue(listeners, "listeners");
        for (WeakReference weakReference : listeners) {
            if (weakReference.get() == null) {
                g.remove(weakReference);
            }
        }
        Set set = g;
        boolean isEmpty = set.isEmpty();
        set.add(new WeakReference(listener));
        Float f2 = (Float) e.get();
        listener.f2317a.c("window.mraidview.broadcastEvent('audioVolumeChange', " + (f2 != null ? Float.valueOf(B2.a(f2.floatValue() * 100.0f)) : null) + ");");
        if (!isEmpty) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).c("AdAudioTracker", "Resuming audio volume change listener");
                return;
            }
            return;
        }
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("AdAudioTracker", "Starting audio volume change listener");
        }
        Context d2 = Uc.d();
        if (d2 == null) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("AdAudioTracker", "Context is null. Cannot start audio volume tracking");
            }
            a((Float) null);
            return;
        }
        LinkedHashMap linkedHashMap = O2.f2380a;
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(C2.a(new r(interfaceC2971z5, d2, ((AdConfig) AbstractC2808p5.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null)).getMraid3().getMuteChangeInterval())));
        if (m10244exceptionOrNullimpl != null) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("AdAudioTracker", "Error starting audio volume tracking - " + m10244exceptionOrNullimpl.getMessage());
            }
            a((Float) null);
        }
    }

    public static void c(final InterfaceC2971z5 interfaceC2971z5, final Ib listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue()).execute(new Runnable() { // from class: com.inmobi.media.s$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C2849s.d(InterfaceC2971z5.this, listener);
            }
        });
    }

    public static final void d(InterfaceC2971z5 interfaceC2971z5, Ib listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("AdAudioTracker", "Removing audio volume change listener");
        }
        Set<WeakReference> listeners = g;
        Intrinsics.checkNotNullExpressionValue(listeners, "listeners");
        for (WeakReference weakReference : listeners) {
            if (Intrinsics.areEqual(weakReference.get(), listener)) {
                g.remove(weakReference);
            }
        }
        if (g.isEmpty()) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).c("AdAudioTracker", "Stopping audio volume change listener");
            }
            Context d2 = Uc.d();
            if (d2 == null) {
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).b("AdAudioTracker", "Context is null. Cannot stop audio volume tracking");
                }
                a((Float) null);
            } else {
                if (!d.compareAndSet(true, false)) {
                    if (interfaceC2971z5 != null) {
                        ((A5) interfaceC2971z5).c("AdAudioTracker", "Audio volume tracking is already stopped");
                        return;
                    }
                    return;
                }
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).c("AdAudioTracker", "Stopping audio volume tracking");
                }
                Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(C2.a(new C2802p(d2)));
                if (m10244exceptionOrNullimpl == null || interfaceC2971z5 == null) {
                    return;
                }
                ((A5) interfaceC2971z5).b("AdAudioTracker", "Error cleaning up audio volume tracker - " + m10244exceptionOrNullimpl.getMessage());
            }
        }
    }

    public static final void e() {
        if (d.get() && b()) {
            a(Float.valueOf(0.0f));
        }
    }

    public static void a(long j) {
        f = ((ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue()).scheduleWithFixedDelay(new Runnable() { // from class: com.inmobi.media.s$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C2849s.e();
            }
        }, 0L, j, TimeUnit.MILLISECONDS);
    }

    public static void c() {
        if (!L3.f2348a.H()) {
            a((Float) null);
        } else {
            ((ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue()).execute(new Runnable() { // from class: com.inmobi.media.s$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    C2849s.d();
                }
            });
        }
    }

    public final synchronized float a() {
        float f2;
        boolean b2 = b();
        AudioManager audioManager = b;
        int streamVolume = audioManager != null ? audioManager.getStreamVolume(3) : 0;
        AudioManager audioManager2 = b;
        int streamMaxVolume = audioManager2 != null ? audioManager2.getStreamMaxVolume(3) : 0;
        if (!b2 && streamVolume >= 0) {
            if (streamVolume > streamMaxVolume) {
                f2 = 1.0f;
            } else if (streamMaxVolume != 0) {
                f2 = streamVolume / streamMaxVolume;
            }
        }
        f2 = 0.0f;
        return f2;
    }

    public static void a(Float f2) {
        if (Intrinsics.areEqual((Float) e.getAndSet(f2), f2)) {
            return;
        }
        Iterator it = g.iterator();
        while (it.hasNext()) {
            Ib ib = (Ib) ((WeakReference) it.next()).get();
            if (ib != null) {
                ib.f2317a.c("window.mraidview.broadcastEvent('audioVolumeChange', " + (f2 != null ? Float.valueOf(B2.a(f2.floatValue() * 100.0f)) : null) + ");");
            }
        }
    }

    public static final void d() {
        a(Float.valueOf(f2699a.a()));
    }

    public static boolean b() {
        AudioManager audioManager;
        AudioManager audioManager2;
        if (!L3.f2348a.H() ? (audioManager = b) == null || audioManager.getStreamVolume(3) != 0 : (audioManager2 = b) == null || !audioManager2.isStreamMute(3)) {
            if (!Uc.o()) {
                return false;
            }
        }
        return true;
    }
}
