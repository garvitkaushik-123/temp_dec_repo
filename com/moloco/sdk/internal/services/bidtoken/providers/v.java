package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class v implements j<MolocoPrivacy.PrivacySettings> {
    public static final int e = 8;
    public final com.moloco.sdk.internal.services.bidtoken.u b;
    public final String c;
    public MolocoPrivacy.PrivacySettings d;

    public v(com.moloco.sdk.internal.services.bidtoken.u privacyProvider) {
        Intrinsics.checkNotNullParameter(privacyProvider, "privacyProvider");
        this.b = privacyProvider;
        this.c = "PrivacyStateSignalProvider";
        this.d = privacyProvider.getPrivacy();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.d = this.b.getPrivacy();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        boolean areEqual = Intrinsics.areEqual(this.d, this.b.getPrivacy());
        boolean z = !areEqual;
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.c, !areEqual ? "[CBT] privacy updated" : "[CBT] privacy didn't change", false, 4, null);
        return z;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return this.c;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MolocoPrivacy.PrivacySettings d() {
        return this.d;
    }
}
