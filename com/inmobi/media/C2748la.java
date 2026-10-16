package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.Omid;
import com.iab.omid.library.inmobi.adsession.AdEvents;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.la, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2748la extends We {
    public final We e;
    public C2667ga f;
    public final InterfaceC2971z5 g;
    public final String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2748la(T7 adContainer, We mViewableAd, C2667ga c2667ga, InterfaceC2971z5 interfaceC2971z5) {
        super(adContainer);
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(mViewableAd, "mViewableAd");
        this.e = mViewableAd;
        this.f = c2667ga;
        this.g = interfaceC2971z5;
        this.h = "la";
    }

    @Override // com.inmobi.media.Xe
    public final View a(View view, ViewGroup parent, boolean z) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return this.e.a(view, parent, z);
    }

    @Override // com.inmobi.media.Xe
    public final View b() {
        return this.e.b();
    }

    @Override // com.inmobi.media.Xe
    public final View d() {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "inflateView");
        }
        return this.e.d();
    }

    @Override // com.inmobi.media.Xe
    public final void e() {
        try {
            try {
                InterfaceC2971z5 interfaceC2971z5 = this.g;
                if (interfaceC2971z5 != null) {
                    String TAG = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).c(TAG, "stopTrackingForImpression");
                }
                C2667ga c2667ga = this.f;
                if (c2667ga != null && C2667ga.a(c2667ga.e, (byte) 2)) {
                    AdSession adSession = c2667ga.f;
                    if (adSession != null) {
                        adSession.finish();
                    }
                    c2667ga.f = null;
                    c2667ga.e = (byte) 3;
                }
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z52 = this.g;
                if (interfaceC2971z52 != null) {
                    String TAG2 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) interfaceC2971z52).b(TAG2, "Exception in stopTrackingForImpression with message : " + e.getMessage());
                }
            }
        } finally {
            this.e.e();
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        this.e.a(childView, obstructionCode);
    }

    public final void b(Map map) {
        View g;
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "registerView");
        }
        InterfaceC2930x interfaceC2930x = this.f2487a;
        if (!(interfaceC2930x instanceof T7) || (g = ((T7) interfaceC2930x).g()) == null) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.g;
        if (interfaceC2971z52 != null) {
            String TAG2 = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).a(TAG2, "creating AD session");
        }
        C2667ga c2667ga = this.f;
        if (c2667ga != null) {
            c2667ga.a(g, map, this.e.b());
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        this.e.a(childView);
    }

    @Override // com.inmobi.media.Xe
    public final void a(Map map) {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "startTrackingForImpression");
        }
        try {
            try {
                if (this.d.getViewability().getOmidConfig().isOmidEnabled()) {
                    AbstractC2780na.f2651a.getClass();
                    if (Omid.isActive()) {
                        InterfaceC2971z5 interfaceC2971z52 = this.g;
                        if (interfaceC2971z52 != null) {
                            String TAG2 = this.h;
                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                            ((A5) interfaceC2971z52).a(TAG2, "OMID enabled and initialised");
                        }
                        b(map);
                        a((byte) 19);
                    }
                }
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z53 = this.g;
                if (interfaceC2971z53 != null) {
                    String TAG3 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((A5) interfaceC2971z53).b(TAG3, "Exception in startTrackingForImpression with message : " + e.getMessage());
                }
            }
        } finally {
            this.e.a(map);
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(byte b) {
        C2946y c2946y;
        AdEvents adEvents;
        AdEvents adEvents2;
        try {
            try {
                InterfaceC2971z5 interfaceC2971z5 = this.g;
                if (interfaceC2971z5 != null) {
                    String TAG = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).c(TAG, "onAdEvent - event - " + ((int) b));
                }
                C2667ga c2667ga = this.f;
                if (c2667ga != null && C2667ga.a(c2667ga.e, (byte) 2)) {
                    byte b2 = b;
                    if (b2 == 0) {
                        C2946y c2946y2 = c2667ga.g;
                        if (c2946y2 != null && (adEvents2 = c2946y2.f2757a) != null) {
                            adEvents2.impressionOccurred();
                        }
                    } else if (b2 == 19 && (c2946y = c2667ga.g) != null && (adEvents = c2946y.f2757a) != null) {
                        adEvents.loaded();
                    }
                }
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z52 = this.g;
                if (interfaceC2971z52 != null) {
                    String TAG2 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) interfaceC2971z52).b(TAG2, "Exception in onAdEvent with message : " + e.getMessage());
                }
            }
        } finally {
            this.e.a(b);
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(Context context, byte b) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.e.a(context, b);
    }

    @Override // com.inmobi.media.Xe
    public final void a() {
        super.a();
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "destroy");
        }
        try {
            this.f = null;
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z52 = this.g;
            if (interfaceC2971z52 != null) {
                String TAG2 = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).b(TAG2, "Exception in destroy with message : " + e.getMessage());
            }
        } finally {
            this.e.a();
        }
    }
}
