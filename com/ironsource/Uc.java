package com.ironsource;

import com.ironsource.J7;
import com.unity3d.mediation.LevelPlay;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Uc implements J7, J7.a {

    /* renamed from: a, reason: collision with root package name */
    private final L3 f3078a;
    private final R4 b;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3079a;

        static {
            int[] iArr = new int[P3.values().length];
            try {
                iArr[P3.Delivery.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[P3.Pacing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[P3.ShowCount.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3079a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Uc() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.J7
    public synchronized N3 a(String placementName, LevelPlay.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        String a2 = new Zc(placementName, adFormat).a();
        N3 a3 = this.b.a(a2);
        if (a3.d()) {
            return a3;
        }
        return this.f3078a.a(a2);
    }

    @Override // com.ironsource.J7.a
    public synchronized void b(String placementName, LevelPlay.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        String a2 = new Zc(placementName, adFormat).a();
        if (!this.b.a(a2).d()) {
            this.f3078a.b(a2);
        }
    }

    public Uc(L3 cappingService, R4 deliveryHandler) {
        Intrinsics.checkNotNullParameter(cappingService, "cappingService");
        Intrinsics.checkNotNullParameter(deliveryHandler, "deliveryHandler");
        this.f3078a = cappingService;
        this.b = deliveryHandler;
    }

    public /* synthetic */ Uc(L3 l3, R4 r4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new L3(null, null, null, 7, null) : l3, (i & 2) != 0 ? new R4() : r4);
    }

    @Override // com.ironsource.J7.a
    public synchronized Object a(String placementName, LevelPlay.AdFormat adFormat, P3 cappingType, InterfaceC3212n7 cappingConfig) {
        Object a2;
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(cappingType, "cappingType");
        Intrinsics.checkNotNullParameter(cappingConfig, "cappingConfig");
        String a3 = new Zc(placementName, adFormat).a();
        int i = a.f3079a[cappingType.ordinal()];
        if (i != 1) {
            if (i != 2 && i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            a2 = this.f3078a.a(a3, cappingType, cappingConfig);
        } else {
            a2 = this.b.a(a3, cappingType, cappingConfig);
        }
        return a2;
    }
}
