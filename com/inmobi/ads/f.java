package com.inmobi.ads;

import android.content.Context;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.media.AbstractC2680h7;
import com.inmobi.media.C2776n6;
import com.inmobi.media.C2792o6;
import com.inmobi.media.Wa;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class f implements PreloadManager {

    /* renamed from: a, reason: collision with root package name */
    public final C2776n6 f2222a;
    public final /* synthetic */ InMobiInterstitial b;

    public f(InMobiInterstitial inMobiInterstitial) {
        this.b = inMobiInterstitial;
        this.f2222a = new C2776n6(inMobiInterstitial);
    }

    @Override // com.inmobi.ads.PreloadManager
    public final void load() {
        try {
            this.b.getMAdManager$media_release().D();
        } catch (IllegalStateException e) {
            String access$getTAG$cp = InMobiInterstitial.access$getTAG$cp();
            Intrinsics.checkNotNullExpressionValue(access$getTAG$cp, "access$getTAG$cp(...)");
            AbstractC2680h7.a((byte) 1, access$getTAG$cp, e.getMessage());
            this.b.getMPubListener$media_release().a(this.b, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
        }
    }

    @Override // com.inmobi.ads.PreloadManager
    public final void preload() {
        Wa wa;
        Wa wa2;
        Context context;
        this.b.b = true;
        wa = this.b.d;
        wa.e = "Preload";
        C2792o6 mAdManager$media_release = this.b.getMAdManager$media_release();
        wa2 = this.b.d;
        context = this.b.f2215a;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        C2792o6.a(mAdManager$media_release, wa2, context, false, null, 12, null);
        this.b.getMAdManager$media_release().c(this.f2222a);
    }
}
