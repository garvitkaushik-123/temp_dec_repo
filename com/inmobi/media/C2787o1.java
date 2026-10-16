package com.inmobi.media;

import android.os.Message;
import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.o1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2787o1 implements InterfaceC2771n1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HandlerC2804p1 f2656a;

    public C2787o1(HandlerC2804p1 handlerC2804p1) {
        this.f2656a = handlerC2804p1;
    }

    @Override // com.inmobi.media.InterfaceC2771n1
    public final void a(P9 response, String locationOnDisk, C2705j asset) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(locationOnDisk, "locationOnDisk");
        Intrinsics.checkNotNullParameter(asset, "asset");
        C2868t1 c2868t1 = (C2868t1) this.f2656a.f2666a.get();
        AdConfig.AssetCacheConfig assetCacheConfig = c2868t1 != null ? C2868t1.c : null;
        if (assetCacheConfig == null) {
            C2868t1 c2868t12 = C2868t1.f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
            return;
        }
        C2868t1 c2868t13 = C2868t1.f2707a;
        Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
        AdConfig.AssetCacheConfig assetCacheConfig2 = assetCacheConfig;
        C2688i a2 = new C2688i().a(asset.b, locationOnDisk, response, assetCacheConfig2.getMaxRetries(), assetCacheConfig2.getTimeToLive());
        int i = a2.f2591a;
        String str = a2.c;
        if (str == null) {
            str = "";
        }
        C2705j c2705j = new C2705j(i, str, a2.d, a2.b, a2.e, a2.f, a2.g, a2.h);
        Nc.a().a(c2705j);
        c2705j.j = asset.j;
        c2705j.k = asset.k;
        c2868t1.a(c2705j, (byte) -1);
        HandlerC2804p1 handlerC2804p1 = this.f2656a;
        handlerC2804p1.getClass();
        try {
            handlerC2804p1.sendEmptyMessage(3);
        } catch (Exception unused) {
            C2868t1 c2868t14 = C2868t1.f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
        }
    }

    @Override // com.inmobi.media.InterfaceC2771n1
    public final void a(C2705j asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        C2868t1 c2868t1 = (C2868t1) this.f2656a.f2666a.get();
        if (c2868t1 != null) {
            C2868t1 c2868t12 = C2868t1.f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
            C2868t1.k.remove(asset.b);
            int i = asset.d;
            if (i > 0) {
                asset.d = i - 1;
                asset.e = System.currentTimeMillis();
                Nc.a().a(asset);
                this.f2656a.a();
                return;
            }
            c2868t1.a(asset, asset.l);
            HandlerC2804p1 handlerC2804p1 = this.f2656a;
            handlerC2804p1.getClass();
            try {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = asset;
                handlerC2804p1.sendMessage(obtain);
                return;
            } catch (Exception unused) {
                C2868t1 c2868t13 = C2868t1.f2707a;
                Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
                return;
            }
        }
        C2868t1 c2868t14 = C2868t1.f2707a;
        Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
    }
}
