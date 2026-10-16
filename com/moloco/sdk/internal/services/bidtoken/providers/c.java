package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.AbstractC3439c;
import com.moloco.sdk.internal.services.InterfaceC3440d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c implements j<AbstractC3439c> {
    public static final a d = new a(null);
    public static final int e = 8;
    public static final String f = "AdvertisingSignalProvider";
    public final InterfaceC3440d b;
    public AbstractC3439c c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public c(InterfaceC3440d advertisingService) {
        Intrinsics.checkNotNullParameter(advertisingService, "advertisingService");
        this.b = advertisingService;
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        boolean z = !Intrinsics.areEqual(this.c, e());
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, f, "[CBT][ASP]: needsRefresh: " + z, false, 4, null);
        return z;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return f;
    }

    public final AbstractC3439c e() {
        AbstractC3439c a2 = this.b.a();
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, f, "[CBT][ASP]: adData: " + a2, false, 4, null);
        return a2;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public AbstractC3439c d() {
        return e();
    }
}
