package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.s1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2851s1 implements InterfaceC2771n1 {
    @Override // com.inmobi.media.InterfaceC2771n1
    public final void a(P9 response, String locationOnDisk, C2705j asset) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(locationOnDisk, "locationOnDisk");
        Intrinsics.checkNotNullParameter(asset, "asset");
        C2868t1 c2868t1 = C2868t1.f2707a;
        Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
        AdConfig.AssetCacheConfig assetCacheConfig = C2868t1.c;
        if (assetCacheConfig != null) {
            C2688i a2 = new C2688i().a(asset.b, locationOnDisk, response, assetCacheConfig.getMaxRetries(), assetCacheConfig.getTimeToLive());
            int i = a2.f2591a;
            String str = a2.c;
            if (str == null) {
                str = "";
            }
            C2705j c2705j = new C2705j(i, str, a2.d, a2.b, a2.e, a2.f, a2.g, a2.h);
            Nc.a().a(c2705j);
            c2705j.j = asset.j;
            c2705j.k = asset.k;
            C2868t1.f2707a.a(c2705j, (byte) -1);
        }
        try {
            C2868t1 c2868t12 = C2868t1.f2707a;
            if (C2868t1.j.get()) {
                return;
            }
            c2868t12.c();
        } catch (Exception e) {
            C2868t1 c2868t13 = C2868t1.f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    @Override // com.inmobi.media.InterfaceC2771n1
    public final void a(C2705j asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        C2868t1 c2868t1 = C2868t1.f2707a;
        Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
        String str = asset.b;
        C2868t1 c2868t12 = C2868t1.f2707a;
        C2868t1.k.remove(str);
        if (asset.d <= 0) {
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
            c2868t12.a(asset, asset.l);
            C2755m1 a2 = Nc.a();
            a2.getClass();
            Intrinsics.checkNotNullParameter(asset, "asset");
            a2.a("id = ?", new String[]{String.valueOf(asset.f2604a)});
        } else {
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
            asset.e = System.currentTimeMillis();
            Nc.a().a(asset);
            boolean z = T9.f2439a;
            if (T9.a(false) != null) {
                c2868t12.a(asset, asset.l);
            }
        }
        try {
            if (C2868t1.j.get()) {
                return;
            }
            c2868t12.c();
        } catch (Exception e) {
            C2868t1 c2868t13 = C2868t1.f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }
}
