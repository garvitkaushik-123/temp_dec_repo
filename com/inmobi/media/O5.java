package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class O5 extends Xe {
    public final C2750lc e;
    public final S4 f;
    public final InterfaceC2971z5 g;
    public final String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O5(C2750lc container, C2750lc renderView, S4 htmlAdTracker, InterfaceC2971z5 interfaceC2971z5) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(htmlAdTracker, "htmlAdTracker");
        this.e = renderView;
        this.f = htmlAdTracker;
        this.g = interfaceC2971z5;
        this.h = "O5";
    }

    @Override // com.inmobi.media.Xe
    public final View a(View view, ViewGroup parent, boolean z) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return d();
    }

    @Override // com.inmobi.media.Xe
    public final void a(byte b) {
    }

    @Override // com.inmobi.media.Xe
    public final View d() {
        this.c = new WeakReference(this.e);
        return this.e;
    }

    @Override // com.inmobi.media.Xe
    public final void e() {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "stopTrackingForImpression");
        }
        InterfaceC2971z5 interfaceC2971z52 = this.g;
        if (interfaceC2971z52 != null) {
            String TAG2 = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).a(TAG2, "stopTrackingForVisibility");
        }
        S4 s4 = this.f;
        View b = b();
        if (b == null) {
            return;
        }
        s4.b(b);
    }

    @Override // com.inmobi.media.Xe
    public final void a(Map map) {
        View b;
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String str = this.h;
            ((A5) interfaceC2971z5).a(str, H6.a(str, "TAG", "startTrackingForImpression with ").append(map != null ? Integer.valueOf(map.size()) : null).append(" friendly views").toString());
        }
        this.e.setFriendlyViews(map);
        InterfaceC2971z5 interfaceC2971z52 = this.g;
        if (interfaceC2971z52 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z52).a(TAG, "startTrackingVisibility");
        }
        InterfaceC2930x interfaceC2930x = this.f2487a;
        C2750lc c2750lc = interfaceC2930x instanceof C2750lc ? (C2750lc) interfaceC2930x : null;
        if (c2750lc == null) {
            return;
        }
        S4 s4 = this.f;
        View b2 = b();
        if (b2 == null || (b = b()) == null) {
            return;
        }
        s4.a(b2, b, c2750lc.getVISIBILITY_CHANGE_LISTENER(), this.d.getViewability(), true);
    }

    @Override // com.inmobi.media.Xe
    public final void a(View view, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(view, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "addFriendlyView - childView: " + view + ", obstructionCode: " + obstructionCode);
        }
        Map<View, FriendlyObstructionPurpose> friendlyViews = this.e.getFriendlyViews();
        if (friendlyViews != null) {
            friendlyViews.put(view, obstructionCode);
        }
        I exposureTracker = this.e.getExposureTracker();
        if (exposureTracker != null) {
            Intrinsics.checkNotNullParameter(view, "view");
            InterfaceC2971z5 interfaceC2971z52 = exposureTracker.e;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).c("AdExposureTracker", "Adding friendly view: " + view);
            }
            Set set = exposureTracker.b;
            if (set != null) {
                set.add(view);
            }
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "childView");
        Map<View, FriendlyObstructionPurpose> friendlyViews = this.e.getFriendlyViews();
        if (friendlyViews != null) {
            friendlyViews.remove(view);
        }
        I exposureTracker = this.e.getExposureTracker();
        if (exposureTracker != null) {
            Intrinsics.checkNotNullParameter(view, "view");
            InterfaceC2971z5 interfaceC2971z5 = exposureTracker.e;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).c("AdExposureTracker", "Removing friendly view: " + view);
            }
            Set set = exposureTracker.b;
            if (set != null) {
                set.remove(view);
            }
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(Context context, byte b) {
        Intrinsics.checkNotNullParameter(context, "context");
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String str = this.h;
            ((A5) interfaceC2971z5).a(str, X8.a(str, "TAG", "onActivityStateChanged - state - ", b));
        }
        try {
            if (b == 0) {
                S4 s4 = this.f;
                InterfaceC2971z5 interfaceC2971z52 = s4.f;
                if (interfaceC2971z52 != null) {
                    ((A5) interfaceC2971z52).c("HtmlAdTracker", "onActivityStarted");
                }
                C2662g5 c2662g5 = s4.g;
                if (c2662g5 != null) {
                    String TAG = c2662g5.d;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    for (Map.Entry entry : c2662g5.f2577a.entrySet()) {
                        View view = (View) entry.getKey();
                        C2627e5 c2627e5 = (C2627e5) entry.getValue();
                        c2662g5.c.a(view, c2627e5.f2557a, c2627e5.b);
                    }
                    if (!c2662g5.e.hasMessages(0)) {
                        c2662g5.e.postDelayed(c2662g5.f, c2662g5.g);
                    }
                    c2662g5.c.f();
                }
                X4 x4 = s4.h;
                if (x4 != null) {
                    x4.f();
                    return;
                }
                return;
            }
            if (b == 1) {
                S4 s42 = this.f;
                InterfaceC2971z5 interfaceC2971z53 = s42.f;
                if (interfaceC2971z53 != null) {
                    ((A5) interfaceC2971z53).c("HtmlAdTracker", "onActivityStopped");
                }
                C2662g5 c2662g52 = s42.g;
                if (c2662g52 != null) {
                    String TAG2 = c2662g52.d;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    c2662g52.c.a();
                    c2662g52.e.removeCallbacksAndMessages(null);
                    c2662g52.b.clear();
                }
                X4 x42 = s42.h;
                if (x42 != null) {
                    x42.e();
                    return;
                }
                return;
            }
            if (b == 2) {
                S4 s43 = this.f;
                InterfaceC2971z5 interfaceC2971z54 = s43.f;
                if (interfaceC2971z54 != null) {
                    ((A5) interfaceC2971z54).c("HtmlAdTracker", "onActivityDestroyed");
                }
                C2662g5 c2662g53 = s43.g;
                if (c2662g53 != null) {
                    c2662g53.f2577a.clear();
                    c2662g53.b.clear();
                    c2662g53.c.a();
                    c2662g53.e.removeMessages(0);
                    c2662g53.c.b();
                }
                s43.g = null;
                X4 x43 = s43.h;
                if (x43 != null) {
                    x43.b();
                }
                s43.h = null;
                return;
            }
            String TAG3 = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z55 = this.g;
            if (interfaceC2971z55 != null) {
                String str2 = this.h;
                ((A5) interfaceC2971z55).b(str2, rf.a(e, H6.a(str2, "TAG", "Exception in onActivityStateChanged with message : ")));
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "destroy");
        }
        if (b() != null) {
            InterfaceC2971z5 interfaceC2971z52 = this.g;
            if (interfaceC2971z52 != null) {
                String TAG2 = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).a(TAG2, "stopTrackingForVisibility");
            }
            S4 s4 = this.f;
            View b = b();
            if (b != null) {
                s4.b(b);
            }
        }
        super.a();
    }
}
