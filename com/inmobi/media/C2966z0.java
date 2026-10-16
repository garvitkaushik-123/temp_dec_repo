package com.inmobi.media;

import android.net.Uri;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.z0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2966z0 implements InterfaceC2884u1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B0 f2768a;

    public C2966z0(B0 b0) {
        this.f2768a = b0;
    }

    @Override // com.inmobi.media.InterfaceC2884u1
    public final void a(C2721k assetBatch, byte b) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        B0 b0 = this.f2768a;
        InterfaceC2971z5 interfaceC2971z5 = b0.f;
        if (interfaceC2971z5 != null) {
            String str = b0.d;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).b(str, "onAssetsFetchFailure of batch " + assetBatch);
        }
    }

    @Override // com.inmobi.media.InterfaceC2884u1
    public final void a(C2721k assetBatch) {
        String str;
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        B0 b0 = this.f2768a;
        InterfaceC2971z5 interfaceC2971z5 = b0.f;
        if (interfaceC2971z5 != null) {
            String str2 = b0.d;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "onAssetsFetchSuccess of batch " + assetBatch);
        }
        Set set = assetBatch.h;
        Iterator it = assetBatch.g.iterator();
        while (it.hasNext()) {
            C2705j c2705j = (C2705j) it.next();
            if (!c2705j.i) {
                this.f2768a.getClass();
                Iterator it2 = set.iterator();
                while (true) {
                    str = "";
                    if (!it2.hasNext()) {
                        break;
                    }
                    C2942xb c2942xb = (C2942xb) it2.next();
                    if (Intrinsics.areEqual(c2942xb.b, c2705j.b)) {
                        byte b = c2942xb.f2753a;
                        if (b == 2) {
                            str = "image";
                        } else if (b == 1) {
                            str = "gif";
                        } else if (b == 0) {
                            str = "video";
                        }
                    }
                }
                Pair pair = TuplesKt.to("latency", Long.valueOf(c2705j.k));
                long j = 0;
                try {
                    String path = Uri.parse(c2705j.c).getPath();
                    if (path != null) {
                        File file = new File(path);
                        if (file.exists()) {
                            j = file.length();
                        }
                    }
                } catch (Exception unused) {
                    Intrinsics.checkNotNullExpressionValue("F4", "TAG");
                }
                Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(pair, TuplesKt.to(ContentDisposition.Parameters.Size, Float.valueOf((j * 1.0f) / 1024)), TuplesKt.to("assetType", str), TuplesKt.to("networkType", L3.q()));
                String b2 = this.f2768a.c.b();
                if (b2 != null) {
                    mutableMapOf.put("adType", b2);
                }
                this.f2768a.b.b("AssetDownloaded", mutableMapOf);
            }
        }
        B0 b02 = this.f2768a;
        InterfaceC2971z5 interfaceC2971z52 = b02.f;
        if (interfaceC2971z52 != null) {
            String str3 = b02.d;
            ((A5) interfaceC2971z52).a(str3, H6.a(str3, "access$getTAG$p(...)", "Notifying ad unit with placement ID (").append(this.f2768a.c).append(')').toString());
        }
    }
}
