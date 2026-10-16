package com.ironsource;

import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.unity3d.mediation.LevelPlay;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* renamed from: com.ironsource.fd, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3083fd {

    /* renamed from: a, reason: collision with root package name */
    private final V0 f3302a;
    private final List<C3116hc> b;
    private final AbstractC3340v0 c;
    private final IronSource.AD_UNIT d;

    /* renamed from: com.ironsource.fd$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3303a;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LevelPlay.AdFormat.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3303a = iArr;
        }
    }

    /* renamed from: com.ironsource.fd$b */
    public static final class b extends Pd {
        final /* synthetic */ NetworkSettings c;
        final /* synthetic */ AdapterBaseInterface d;
        final /* synthetic */ AdData e;

        b(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface, AdData adData) {
            this.c = networkSettings;
            this.d = adapterBaseInterface;
            this.e = adData;
        }

        @Override // com.ironsource.Pd
        public void a() {
            C3083fd c3083fd = C3083fd.this;
            NetworkSettings networkSettings = this.c;
            AdapterBaseInterface networkAdapter = this.d;
            Intrinsics.checkNotNullExpressionValue(networkAdapter, "networkAdapter");
            c3083fd.a(networkSettings, networkAdapter, this.e);
        }

        @Override // com.ironsource.Pd
        public void a(Throwable t) {
            Intrinsics.checkNotNullParameter(t, "t");
            C3083fd.this.f3302a.e().h().g("initProvider - exception while calling networkAdapter.init with " + this.c.getProviderName() + " - " + t);
        }
    }

    public C3083fd(V0 adUnitTools, LevelPlay.AdFormat adFormat, List<C3116hc> providers, AbstractC3340v0 adUnitData) {
        Intrinsics.checkNotNullParameter(adUnitTools, "adUnitTools");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(providers, "providers");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.f3302a = adUnitTools;
        this.b = providers;
        this.c = adUnitData;
        this.d = a(adFormat);
    }

    public final void a() {
        IronLog.INTERNAL.verbose(C3205n0.a(this.f3302a, (String) null, (String) null, 3, (Object) null));
        UUID randomUUID = UUID.randomUUID();
        Iterator<C3116hc> it = this.b.iterator();
        while (it.hasNext()) {
            NetworkSettings f = it.next().f();
            AdapterBaseInterface b2 = com.ironsource.mediationsdk.c.b().b(f, this.d, randomUUID);
            if (a(f, b2)) {
                C3068ef.a(C3068ef.f3275a, new b(f, b2, this.c.a(f)), 0L, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface, AdData adData) {
        a("Start initializing provider %s on thread %s", networkSettings);
        adapterBaseInterface.init(adData, ContextProvider.getInstance().getApplicationContext(), null);
        a("Done initializing provider %s on thread %s", networkSettings);
    }

    private final void a(String str, NetworkSettings networkSettings) {
        IronLog ironLog = IronLog.INTERNAL;
        V0 v0 = this.f3302a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(str, Arrays.copyOf(new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        ironLog.verbose(C3205n0.a(v0, format, (String) null, 2, (Object) null));
    }

    private final boolean a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        if (adapterBaseInterface == null) {
            return false;
        }
        V0 v0 = this.f3302a;
        IronSource.AD_UNIT ad_unit = this.d;
        String providerInstanceName = networkSettings.getProviderInstanceName();
        Intrinsics.checkNotNullExpressionValue(providerInstanceName, "providerSettings.providerInstanceName");
        return !v0.a(adapterBaseInterface, ad_unit, providerInstanceName) && (networkSettings.shouldEarlyInit() || networkSettings.isIronSource() || networkSettings.isBidder(this.d));
    }

    private final IronSource.AD_UNIT a(LevelPlay.AdFormat adFormat) {
        int i = a.f3303a[adFormat.ordinal()];
        if (i == 1) {
            return IronSource.AD_UNIT.REWARDED_VIDEO;
        }
        if (i == 2) {
            return IronSource.AD_UNIT.INTERSTITIAL;
        }
        if (i == 3) {
            return IronSource.AD_UNIT.BANNER;
        }
        if (i == 4) {
            return IronSource.AD_UNIT.NATIVE_AD;
        }
        throw new NoWhenBranchMatchedException();
    }
}
