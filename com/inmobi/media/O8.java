package com.inmobi.media;

import android.media.MediaMetadataRetriever;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class O8 {

    /* renamed from: a, reason: collision with root package name */
    public final long f2384a;
    public final long b;
    public final String c;
    public final C2811p8 d;

    public O8(long j, long j2, String referencedAssetId, C2811p8 nativeDataModel) {
        Intrinsics.checkNotNullParameter(referencedAssetId, "referencedAssetId");
        Intrinsics.checkNotNullParameter(nativeDataModel, "nativeDataModel");
        this.f2384a = j;
        this.b = j2;
        this.c = referencedAssetId;
        this.d = nativeDataModel;
        Intrinsics.checkNotNullExpressionValue("P8", "getSimpleName(...)");
    }

    public final long a() {
        long j = this.f2384a;
        C2613d8 m = this.d.m(this.c);
        try {
            if (m instanceof C2597c9) {
                Ve d = ((C2597c9) m).d();
                String b = d != null ? ((Ue) d).b() : null;
                if (b != null) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(b);
                    j += (long) ((this.b / 100.0d) * ((mediaMetadataRetriever.extractMetadata(9) != null ? Long.parseLong(r2) : 0L) / 1000));
                    mediaMetadataRetriever.release();
                }
            }
        } catch (Exception unused) {
        }
        return Math.max(j, 0L);
    }
}
