package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.F;
import com.moloco.sdk.internal.services.y;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class o implements j<n> {
    public static final a e = new a(null);
    public static final int f = 8;
    public static final String g = "DSignalProvider";
    public final y b;
    public final F c;
    public n d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public o(y deviceInfoService, F screenInfoService) {
        Intrinsics.checkNotNullParameter(deviceInfoService, "deviceInfoService");
        Intrinsics.checkNotNullParameter(screenInfoService, "screenInfoService");
        this.b = deviceInfoService;
        this.c = screenInfoService;
        this.d = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.d = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        n e2 = e();
        boolean z = !Intrinsics.areEqual(e2, this.d);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, g, "[CBT] DSP needsRefresh: " + z + ", with current: " + e2 + ", cached: " + this.d, false, 4, null);
        return z;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return g;
    }

    public final n e() {
        try {
            return new n(this.c.b(), this.b.c(), this.b.d());
        } catch (Exception e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, g, "[CBT] DSP Error", e2, false, 8, null);
            return new n(null, null, null, 7, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public n d() {
        return this.d;
    }
}
