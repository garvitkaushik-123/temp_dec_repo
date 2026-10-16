package com.inmobi.ads;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.media.AbstractC2680h7;
import com.inmobi.media.H1;
import com.inmobi.media.O1;
import com.inmobi.media.R1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class e implements PreloadManager {

    /* renamed from: a, reason: collision with root package name */
    public final O1 f2221a;
    public final /* synthetic */ InMobiBanner b;

    public e(InMobiBanner inMobiBanner) {
        this.b = inMobiBanner;
        this.f2221a = new O1(inMobiBanner);
    }

    @Override // com.inmobi.ads.PreloadManager
    public final void load() {
        try {
            R1 mAdManager = this.b.getMAdManager();
            if (mAdManager != null) {
                mAdManager.G();
            }
        } catch (IllegalStateException e) {
            String access$getTAG$cp = InMobiBanner.access$getTAG$cp();
            Intrinsics.checkNotNullExpressionValue(access$getTAG$cp, "access$getTAG$cp(...)");
            AbstractC2680h7.a((byte) 1, access$getTAG$cp, e.getMessage());
            H1 mPubListener = this.b.getMPubListener();
            if (mPubListener != null) {
                mPubListener.a(this.b, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
        }
    }

    @Override // com.inmobi.ads.PreloadManager
    public final void preload() {
        this.b.setEnableAutoRefresh(false);
        this.b.a(this.f2221a, "Preload", false);
    }
}
