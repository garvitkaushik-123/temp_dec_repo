package com.inmobi.media;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.Constants;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Z8 implements InterfaceC2914w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2562a9 f2506a;

    public Z8(C2562a9 c2562a9) {
        this.f2506a = c2562a9;
    }

    @Override // com.inmobi.media.InterfaceC2914w
    public final void a() {
        Intrinsics.checkNotNullExpressionValue(this.f2506a.X, "access$getTAG$p(...)");
        P0 p0 = this.f2506a.w;
        if (p0 != null) {
            p0.c();
        }
    }

    @Override // com.inmobi.media.InterfaceC2914w
    public final void b(Object obj) {
        Xe viewableAd;
        Intrinsics.checkNotNullExpressionValue(this.f2506a.X, "access$getTAG$p(...)");
        C2597c9 c2597c9 = obj instanceof C2597c9 ? (C2597c9) obj : null;
        if (c2597c9 != null) {
            HashMap hashMap = c2597c9.t;
            Boolean bool = Boolean.FALSE;
            hashMap.put("didRequestFullScreen", bool);
            hashMap.put("isFullScreen", bool);
            c2597c9.w = null;
            HashMap hashMap2 = c2597c9.t;
            hashMap2.put("didRequestFullScreen", bool);
            hashMap2.put("isFullScreen", bool);
            c2597c9.w = null;
        }
        C2562a9 c2562a9 = this.f2506a;
        if (c2562a9.f2437a == 0) {
            Xe viewableAd2 = c2562a9.getViewableAd();
            if (viewableAd2 != null) {
                viewableAd2.a((byte) 2);
            }
            T7 t7 = this.f2506a.v;
            if (t7 != null && (viewableAd = t7.getViewableAd()) != null) {
                viewableAd.a(Ascii.DLE);
            }
            if (c2597c9 != null) {
                c2597c9.a("exitFullscreen", this.f2506a.j(c2597c9), (L7) null, this.f2506a.W);
            }
        } else {
            Xe viewableAd3 = c2562a9.getViewableAd();
            if (viewableAd3 != null) {
                viewableAd3.a((byte) 3);
            }
        }
        P0 p0 = this.f2506a.w;
        if (p0 != null) {
            p0.b();
        }
        InterfaceC2971z5 interfaceC2971z5 = this.f2506a.W;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a();
        }
    }

    @Override // com.inmobi.media.InterfaceC2914w
    public final void a(Object obj) {
        if (this.f2506a.f() == null) {
            return;
        }
        C2597c9 c2597c9 = obj instanceof C2597c9 ? (C2597c9) obj : null;
        Intrinsics.checkNotNullExpressionValue(this.f2506a.X, "access$getTAG$p(...)");
        if (c2597c9 != null) {
            HashMap hashMap = c2597c9.t;
            Boolean bool = Boolean.TRUE;
            hashMap.put("didRequestFullScreen", bool);
            hashMap.put("isFullScreen", bool);
            hashMap.put("shouldAutoPlay", bool);
            C2613d8 c2613d8 = c2597c9.w;
            if (c2613d8 != null) {
                HashMap hashMap2 = c2613d8.t;
                hashMap2.put("didRequestFullScreen", bool);
                hashMap2.put("isFullScreen", bool);
                hashMap2.put("shouldAutoPlay", bool);
            }
        }
        C2562a9 c2562a9 = this.f2506a;
        if (c2562a9.f2437a == 0) {
            Xe viewableAd = c2562a9.getViewableAd();
            if (viewableAd != null) {
                viewableAd.a((byte) 1);
            }
            if (c2597c9 != null) {
                c2597c9.a(Constants.TEMPLATE_TYPE_FULLSCREEN, this.f2506a.j(c2597c9), (L7) null, this.f2506a.W);
            }
        }
        P0 p0 = this.f2506a.w;
        if (p0 != null) {
            p0.d();
        }
    }
}
