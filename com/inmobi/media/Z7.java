package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import io.bidmachine.iab.utils.VisibilityTracker;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Z7 {

    /* renamed from: a, reason: collision with root package name */
    public final byte f2505a;
    public final InterfaceC2971z5 b;
    public final String c = "Z7";
    public final WeakHashMap d = new WeakHashMap();
    public final WeakHashMap e = new WeakHashMap();
    public final LinkedHashMap f = new LinkedHashMap();
    public final W7 g = new W7();
    public final Y7 h = new Y7(this);
    public final X7 i = new X7();

    public Z7(byte b, InterfaceC2971z5 interfaceC2971z5) {
        this.f2505a = b;
        this.b = interfaceC2971z5;
    }

    public final void a(Context context, View view, T7 token, AdConfig.ViewabilityConfig viewabilityConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(viewabilityConfig, "viewabilityConfig");
        C2662g5 c2662g5 = (C2662g5) this.d.get(context);
        if (c2662g5 == null) {
            c2662g5 = context instanceof Activity ? new C2662g5(viewabilityConfig, new B3(this.i, (Activity) context, this.b), this.g) : new C2662g5(viewabilityConfig, new Ra(this.i, viewabilityConfig, (byte) 1, this.b), this.g);
            this.d.put(context, c2662g5);
        }
        byte b = this.f2505a;
        if (b == 0) {
            c2662g5.a(view, token, viewabilityConfig.getVideoImpressionMinPercentageViewed(), viewabilityConfig.getVideoImpressionMinTimeViewed());
        } else if (b == 1) {
            c2662g5.a(view, token, viewabilityConfig.getImpressionMinPercentageViewed(), viewabilityConfig.getImpressionMinTimeViewed());
        } else {
            c2662g5.a(view, token, viewabilityConfig.getImpressionMinPercentageViewed(), viewabilityConfig.getImpressionMinTimeViewed());
        }
    }

    public final void a(Context context, T7 token) {
        View view;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        C2662g5 c2662g5 = (C2662g5) this.d.get(context);
        if (c2662g5 != null) {
            Intrinsics.checkNotNullParameter(token, "token");
            Iterator it = c2662g5.f2577a.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    view = null;
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (Intrinsics.areEqual(((C2627e5) entry.getValue()).f2557a, token)) {
                    view = (View) entry.getKey();
                    break;
                }
            }
            if (view != null) {
                Intrinsics.checkNotNullParameter(view, "view");
                c2662g5.f2577a.remove(view);
                c2662g5.b.remove(view);
                c2662g5.c.a(view);
            }
            if (c2662g5.f2577a.isEmpty()) {
                InterfaceC2971z5 interfaceC2971z5 = this.b;
                if (interfaceC2971z5 != null) {
                    String TAG = this.c;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).a(TAG, "Impression tracker is free, removing it");
                }
                C2662g5 c2662g52 = (C2662g5) this.d.remove(context);
                if (c2662g52 != null) {
                    c2662g52.f2577a.clear();
                    c2662g52.b.clear();
                    c2662g52.c.a();
                    c2662g52.e.removeMessages(0);
                    c2662g52.c.b();
                }
                if (context instanceof Activity) {
                    this.d.isEmpty();
                }
            }
        }
    }

    public final void a(Context context, View view, T7 token) {
        View view2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(token, "token");
        lf lfVar = (lf) this.e.get(context);
        if (lfVar != null) {
            if (token != null) {
                Iterator it = lfVar.f2635a.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        view2 = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (Intrinsics.areEqual(((Cif) entry.getValue()).d, token)) {
                        view2 = (View) entry.getKey();
                        break;
                    }
                }
                if (view2 != null) {
                    lfVar.a(view2);
                }
            }
            if (lfVar.f2635a.isEmpty()) {
                InterfaceC2971z5 interfaceC2971z5 = this.b;
                if (interfaceC2971z5 != null) {
                    String TAG = this.c;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).a(TAG, "Impression tracker is free, removing it");
                }
                lf lfVar2 = (lf) this.e.remove(context);
                if (lfVar2 != null) {
                    lfVar2.b();
                }
                if (context instanceof Activity) {
                    this.e.isEmpty();
                }
            }
        }
        this.f.remove(view);
    }

    public final void a(Context context, View view, T7 token, ef listener, AdConfig.ViewabilityConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(config, "config");
        lf lfVar = (lf) this.e.get(context);
        if (lfVar == null) {
            if (context instanceof Activity) {
                lfVar = new B3(this.i, (Activity) context, this.b);
            } else {
                lfVar = new Ra(this.i, config, (byte) 1, this.b);
            }
            Y7 y7 = this.h;
            InterfaceC2971z5 interfaceC2971z5 = lfVar.e;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).c(VisibilityTracker.TAG, "setVisibilityTrackerListener logger");
            }
            lfVar.j = y7;
            this.e.put(context, lfVar);
        }
        this.f.put(view, listener);
        byte b = this.f2505a;
        if (b == 0) {
            lfVar.a(view, token, config.getVideoMinPercentagePlay());
        } else if (b == 1) {
            lfVar.a(view, token, config.getDisplayMinPercentageAnimate());
        } else {
            lfVar.a(view, token, config.getDisplayMinPercentageAnimate());
        }
    }
}
