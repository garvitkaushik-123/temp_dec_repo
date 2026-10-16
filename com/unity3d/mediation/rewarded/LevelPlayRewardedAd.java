package com.unity3d.mediation.rewarded;

import android.app.Activity;
import com.ironsource.C2993ab;
import com.ironsource.C3076f6;
import com.ironsource.C3205n0;
import com.ironsource.C3334ub;
import com.ironsource.C3347v7;
import com.ironsource.D0;
import com.ironsource.InterfaceC3293s4;
import com.ironsource.Na;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlay;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class LevelPlayRewardedAd {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f6458a;
    private final C2993ab b;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isPlacementCapped(String placementName) {
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            return Na.n.a(placementName, LevelPlay.AdFormat.REWARDED);
        }

        private Companion() {
        }
    }

    public static final class Config implements Na.b {
        public static final Companion Companion = new Companion(null);

        /* renamed from: a, reason: collision with root package name */
        private final Double f6459a;

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            private Double f6460a;

            public final Config build() {
                return new Config(this.f6460a);
            }

            public final Builder setBidFloor(double d) {
                this.f6460a = Double.valueOf(d);
                return this;
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Config empty() {
                return new Config(null, 1, 0 == true ? 1 : 0);
            }

            private Companion() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Config() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Config copy$default(Config config, Double d, int i, Object obj) {
            if ((i & 1) != 0) {
                d = config.f6459a;
            }
            return config.copy(d);
        }

        public final Double component1() {
            return this.f6459a;
        }

        public final Config copy(Double d) {
            return new Config(d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Config) && Intrinsics.areEqual((Object) this.f6459a, (Object) ((Config) obj).f6459a);
        }

        @Override // com.ironsource.Na.b
        public Double getBidFloor() {
            return this.f6459a;
        }

        public int hashCode() {
            Double d = this.f6459a;
            if (d == null) {
                return 0;
            }
            return d.hashCode();
        }

        public String toString() {
            return "Config(bidFloor=" + this.f6459a + ")";
        }

        public Config(Double d) {
            this.f6459a = d;
        }

        public /* synthetic */ Config(Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : d);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayRewardedAd(String adUnitId) {
        this(adUnitId, Config.Companion.empty());
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
    }

    @JvmStatic
    public static final boolean isPlacementCapped(String str) {
        return Companion.isPlacementCapped(str);
    }

    public static /* synthetic */ void showAd$default(LevelPlayRewardedAd levelPlayRewardedAd, Activity activity, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        levelPlayRewardedAd.showAd(activity, str);
    }

    public final String getAdId() {
        return this.b.a();
    }

    public final String getAdUnitId() {
        return this.f6458a;
    }

    public final boolean isAdReady() {
        return this.b.b();
    }

    public final void loadAd() {
        this.b.c();
    }

    public final void setListener(LevelPlayRewardedAdListener levelPlayRewardedAdListener) {
        this.b.a(levelPlayRewardedAdListener);
    }

    public final void showAd(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showAd$default(this, activity, null, 2, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayRewardedAd(String adUnitId, Config config) {
        this(adUnitId, new Na.c(new C3205n0(IronSource.AD_UNIT.REWARDED_VIDEO, D0.b.MEDIATION), new C3076f6(), C3334ub.s.d(), new InterfaceC3293s4.a(), C3347v7.f3910a, config));
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(config, "config");
    }

    public final void showAd(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b.a(activity, str);
    }

    public LevelPlayRewardedAd(String adUnitId, Na.c payload) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(payload, "payload");
        IronLog.API.info("adUnitId: " + adUnitId + ", config: " + payload.c());
        this.f6458a = adUnitId;
        this.b = new C2993ab(adUnitId, payload.c(), payload.b(), payload.a(), payload.f(), payload.d(), payload.e());
    }
}
