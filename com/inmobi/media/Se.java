package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import com.inmobi.ads.exceptions.VastException;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class Se {

    /* renamed from: a, reason: collision with root package name */
    public static final Se f2431a = new Se();
    public static final Lazy b = LazyKt.lazy(Re.f2419a);
    public static final Lazy c = LazyKt.lazy(Qe.f2410a);

    public static void a(final C2672h ad, final AdConfig adConfig, final Te te, final InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        ((ExecutorService) b.getValue()).execute(new Runnable() { // from class: com.inmobi.media.Se$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Se.b(C2672h.this, adConfig, te, interfaceC2971z5);
            }
        });
    }

    public static final void b(C2672h ad, AdConfig adConfig, Te te, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(ad, "$ad");
        Intrinsics.checkNotNullParameter(adConfig, "$adConfig");
        Se se = f2431a;
        try {
            if (se.a(ad.s(), te)) {
                C2672h a2 = J.a(ad, adConfig, interfaceC2971z5);
                if (a2 == null) {
                    se.a(ad, false, (short) 75);
                } else {
                    se.a(a2, true, (short) 0);
                }
            }
        } catch (VastException e) {
            se.a(ad, false, e.getTelemetryErrorCode());
        } catch (JSONException unused) {
            se.a(ad, false, (short) 58);
        }
    }

    public final synchronized boolean a(String str, Te te) {
        Lazy lazy = c;
        List list = (List) ((HashMap) lazy.getValue()).get(str);
        if (list != null) {
            list.add(new WeakReference(te));
            return false;
        }
        ((HashMap) lazy.getValue()).put(str, CollectionsKt.mutableListOf(new WeakReference(te)));
        return true;
    }

    public final synchronized void a(final C2672h c2672h, final boolean z, final short s) {
        Unit unit;
        List list = (List) ((HashMap) c.getValue()).remove(c2672h.s());
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final Te te = (Te) ((WeakReference) it.next()).get();
                if (te != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.Se$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            Se.a(Te.this, c2672h, z, s);
                        }
                    });
                } else {
                    Intrinsics.checkNotNullExpressionValue("Se", "TAG");
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Intrinsics.checkNotNullExpressionValue("Se", "TAG");
        }
    }

    public static final void a(Te te, C2672h ad, boolean z, short s) {
        Intrinsics.checkNotNullParameter(ad, "$ad");
        te.a(ad, z, s);
    }
}
