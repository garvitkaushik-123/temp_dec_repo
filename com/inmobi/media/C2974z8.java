package com.inmobi.media;

import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.z8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2974z8 implements InterfaceC2682h9 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ D8 f2773a;
    public final /* synthetic */ C2597c9 b;

    public C2974z8(D8 d8, C2597c9 c2597c9) {
        this.f2773a = d8;
        this.b = c2597c9;
    }

    public final void a(byte b) {
        T7 t7 = this.f2773a.b;
        if (t7.t || !(t7 instanceof C2562a9)) {
            return;
        }
        C2562a9 c2562a9 = (C2562a9) t7;
        C2597c9 videoAsset = this.b;
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (!c2562a9.t) {
            if (b == 0) {
                videoAsset.a("firstQuartile", c2562a9.j(videoAsset), (L7) null, c2562a9.W);
                InterfaceC2971z5 interfaceC2971z5 = c2562a9.W;
                if (interfaceC2971z5 != null) {
                    String TAG = c2562a9.X;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).c(TAG, "onVideoQuartileEvent(Q1)");
                }
                We we = c2562a9.p;
                if (we != null) {
                    we.a((byte) 9);
                }
            } else if (b == 1) {
                videoAsset.a(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT, c2562a9.j(videoAsset), (L7) null, c2562a9.W);
                InterfaceC2971z5 interfaceC2971z52 = c2562a9.W;
                if (interfaceC2971z52 != null) {
                    String TAG2 = c2562a9.X;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) interfaceC2971z52).c(TAG2, "onVideoQuartileEvent(Q2)");
                }
                We we2 = c2562a9.p;
                if (we2 != null) {
                    we2.a((byte) 10);
                }
            } else if (b == 2) {
                videoAsset.a("thirdQuartile", c2562a9.j(videoAsset), (L7) null, c2562a9.W);
                InterfaceC2971z5 interfaceC2971z53 = c2562a9.W;
                if (interfaceC2971z53 != null) {
                    String TAG3 = c2562a9.X;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((A5) interfaceC2971z53).c(TAG3, "onVideoQuartileEvent(Q3)");
                }
                We we3 = c2562a9.p;
                if (we3 != null) {
                    we3.a(Ascii.VT);
                }
            } else if (b == 3) {
                Object obj = videoAsset.t.get("didQ4Fire");
                if (Intrinsics.areEqual(obj instanceof Boolean ? (Boolean) obj : null, Boolean.FALSE)) {
                    c2562a9.d(videoAsset);
                }
            } else {
                InterfaceC2971z5 interfaceC2971z54 = c2562a9.W;
                if (interfaceC2971z54 != null) {
                    String TAG4 = c2562a9.X;
                    Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                    ((A5) interfaceC2971z54).b(TAG4, "Unhandled quartileEvent ( " + ((int) b) + " ) for Native Video");
                }
            }
        }
        if (3 == b) {
            try {
                ((C2562a9) this.f2773a.b).c(this.b);
            } catch (Exception e) {
                D8 d8 = this.f2773a;
                InterfaceC2971z5 interfaceC2971z55 = d8.f;
                if (interfaceC2971z55 != null) {
                    String str = d8.g;
                    ((A5) interfaceC2971z55).b(str, rf.a(e, H6.a(str, "access$getTAG$p(...)", "SDK encountered unexpected error in handling the onVideoCompleted event; ")));
                }
            }
        }
    }
}
