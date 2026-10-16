package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public class M1 implements InterfaceC3144j7 {

    /* renamed from: a, reason: collision with root package name */
    private final E7 f2949a;
    private N1 b;

    public static final class a {
        public final N1 a(K1 k1, E7 featureAvailabilityService) {
            Intrinsics.checkNotNullParameter(featureAvailabilityService, "featureAvailabilityService");
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("isAndroidxApplicationLifecycleAvailable: " + featureAvailabilityService.a());
            ironLog.verbose("isAndroidxApplicationLifecycleEnabled: " + (k1 != null ? Boolean.valueOf(k1.k()) : null));
            boolean z = false;
            if (featureAvailabilityService.a()) {
                Id.i().a(new C3413z5(A5.TROUBLESHOOTING_ANDROIDX_PROCESS_LIFECYCLE_OWNER_AVAILABLE, IronSourceUtils.getMediationAdditionalData(false)));
            }
            if ((k1 != null ? k1.k() : false) && featureAvailabilityService.a()) {
                z = true;
            }
            ironLog.verbose("isAndroidxEnabled: " + z);
            return z ? new C3324u1() : new T7();
        }
    }

    public M1(E7 featureAvailabilityService) {
        Intrinsics.checkNotNullParameter(featureAvailabilityService, "featureAvailabilityService");
        this.f2949a = featureAvailabilityService;
    }

    @Override // com.ironsource.InterfaceC3144j7
    public void a(K1 k1) {
        if (this.b == null) {
            this.b = new a().a(k1, this.f2949a);
        }
    }

    @Override // com.ironsource.N1
    public void b(W9 observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        N1 n1 = this.b;
        if (n1 != null) {
            n1.b(observer);
        }
    }

    @Override // com.ironsource.N1
    public void a(W9 observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        N1 n1 = this.b;
        if (n1 != null) {
            n1.a(observer);
        }
    }
}
