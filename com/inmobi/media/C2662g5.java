package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import io.bidmachine.iab.utils.VisibilityTracker;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.g5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2662g5 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakHashMap f2577a;
    public final WeakHashMap b;
    public final lf c;
    public final String d;
    public final Handler e;
    public final RunnableC2643f5 f;
    public final long g;
    public final InterfaceC2610d5 h;

    public C2662g5(AdConfig.ViewabilityConfig viewabilityConfig, lf visibilityTracker, InterfaceC2610d5 listener) {
        Intrinsics.checkNotNullParameter(viewabilityConfig, "viewabilityConfig");
        Intrinsics.checkNotNullParameter(visibilityTracker, "visibilityTracker");
        Intrinsics.checkNotNullParameter(listener, "listener");
        WeakHashMap weakHashMap = new WeakHashMap();
        WeakHashMap weakHashMap2 = new WeakHashMap();
        Handler handler = new Handler(Looper.getMainLooper());
        this.f2577a = weakHashMap;
        this.b = weakHashMap2;
        this.c = visibilityTracker;
        this.d = "g5";
        this.g = viewabilityConfig.getImpressionPollIntervalMillis();
        C2593c5 c2593c5 = new C2593c5(this);
        InterfaceC2971z5 interfaceC2971z5 = visibilityTracker.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c(VisibilityTracker.TAG, "setVisibilityTrackerListener logger");
        }
        visibilityTracker.j = c2593c5;
        this.e = handler;
        this.f = new RunnableC2643f5(this);
        this.h = listener;
    }

    public final void a(View view, Object token, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(token, "token");
        C2627e5 c2627e5 = (C2627e5) this.f2577a.get(view);
        if (Intrinsics.areEqual(c2627e5 != null ? c2627e5.f2557a : null, token)) {
            return;
        }
        a(view);
        this.f2577a.put(view, new C2627e5(token, i, i2));
        this.c.a(view, token, i);
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f2577a.remove(view);
        this.b.remove(view);
        this.c.a(view);
    }
}
