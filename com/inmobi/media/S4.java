package com.inmobi.media;

import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import io.bidmachine.iab.utils.VisibilityTracker;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class S4 {
    public static final P4 k = new P4();

    /* renamed from: a, reason: collision with root package name */
    public final byte f2424a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final InterfaceC2971z5 f;
    public C2662g5 g;
    public X4 h;
    public final LinkedHashMap i = new LinkedHashMap();
    public final Q4 j = new Q4(this);

    public S4(byte b, String str, int i, int i2, int i3, InterfaceC2971z5 interfaceC2971z5) {
        this.f2424a = b;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = interfaceC2971z5;
    }

    public final void a(View view) {
        C2662g5 c2662g5;
        Intrinsics.checkNotNullParameter(view, "view");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("HtmlAdTracker", "stopTrackingForImpression");
        }
        if (Intrinsics.areEqual(this.b, "video") || Intrinsics.areEqual(this.b, "audio") || (c2662g5 = this.g) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        c2662g5.f2577a.remove(view);
        c2662g5.b.remove(view);
        c2662g5.c.a(view);
        if (c2662g5.f2577a.isEmpty()) {
            InterfaceC2971z5 interfaceC2971z52 = this.f;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).a("HtmlAdTracker", "Impression tracker is free, removing it");
            }
            C2662g5 c2662g52 = this.g;
            if (c2662g52 != null) {
                c2662g52.f2577a.clear();
                c2662g52.b.clear();
                c2662g52.c.a();
                c2662g52.e.removeMessages(0);
                c2662g52.c.b();
            }
            this.g = null;
        }
    }

    public final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("HtmlAdTracker", "stopTrackingForVisibility");
        }
        X4 x4 = this.h;
        if (x4 != null) {
            x4.a(view);
            if (x4.f2635a.isEmpty()) {
                InterfaceC2971z5 interfaceC2971z52 = this.f;
                if (interfaceC2971z52 != null) {
                    ((A5) interfaceC2971z52).a("HtmlAdTracker", "Visibility tracker is free, removing it");
                }
                X4 x42 = this.h;
                if (x42 != null) {
                    x42.b();
                }
                this.h = null;
            }
        }
        this.i.remove(view);
    }

    public final void a(View view, View token, ef listener, AdConfig.ViewabilityConfig config, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(config, "config");
        InterfaceC2971z5 interfaceC2971z5 = this.f;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("HtmlAdTracker", "startTrackingForVisibility");
        }
        X4 x4 = this.h;
        if (x4 == null) {
            if (z) {
                x4 = new D2(config, this.f);
            } else {
                x4 = new X4(config, (byte) 1, this.f);
            }
            this.h = x4;
        }
        R4 r4 = new R4(this);
        InterfaceC2971z5 interfaceC2971z52 = x4.e;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).c(VisibilityTracker.TAG, "setVisibilityTrackerListener logger");
        }
        x4.j = r4;
        this.i.put(view, listener);
        if (z) {
            i = config.getCompanionVisibilityMinPercentageViewed();
        } else {
            i = this.e;
        }
        x4.a(view, token, i);
    }
}
