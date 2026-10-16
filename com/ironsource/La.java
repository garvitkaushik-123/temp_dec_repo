package com.ironsource;

import com.ironsource.C3117hd;
import com.ironsource.C3288s;
import com.ironsource.InterfaceC3346v6;
import com.ironsource.Ka;
import com.ironsource.U2;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class La extends Sd {

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2942a;

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
            f2942a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public La(Sd sdkConfig) {
        super(sdkConfig);
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
    }

    public final boolean a(String adUnitId, LevelPlay.AdFormat adFormat) {
        Map<String, C3117hd.b> a2;
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        C3117hd.a aVar = g().d().a().get(adFormat);
        return (aVar == null || (a2 = aVar.a()) == null || !a2.containsKey(adUnitId)) ? false : true;
    }

    public final InterfaceC3346v6.a b(LevelPlay.AdFormat adFormat, String adUnitId) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        return new InterfaceC3346v6.a(a(adFormat, adUnitId));
    }

    public final List<C3116hc> c(LevelPlay.AdFormat adFormat) {
        Map<String, C3117hd.b> a2;
        Set<String> keySet;
        List<C3116hc> distinct;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        C3117hd.a aVar = g().d().a().get(adFormat);
        if (aVar != null && (a2 = aVar.a()) != null && (keySet = a2.keySet()) != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(keySet, 10));
            Iterator<T> it = keySet.iterator();
            while (it.hasNext()) {
                arrayList.add(d(adFormat, (String) it.next()));
            }
            List flatten = CollectionsKt.flatten(arrayList);
            if (flatten != null && (distinct = CollectionsKt.distinct(flatten)) != null) {
                return distinct;
            }
        }
        return CollectionsKt.emptyList();
    }

    public final List<C3116hc> d(LevelPlay.AdFormat adFormat, String adUnitId) {
        Map<String, C3117hd.b> a2;
        C3117hd.b bVar;
        List<String> a3;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        C3117hd.a aVar = g().d().a().get(adFormat);
        if (aVar == null || (a2 = aVar.a()) == null || (bVar = a2.get(adUnitId)) == null || (a3 = bVar.a()) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = a3.iterator();
        while (it.hasNext()) {
            C3116hc c3116hc = g().e().a().get((String) it.next());
            if (c3116hc != null) {
                arrayList.add(c3116hc);
            }
        }
        return arrayList;
    }

    public final List<LevelPlayAdSize> h() {
        List<String> a2 = g().a().c().b().a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        Iterator<T> it = a2.iterator();
        while (it.hasNext()) {
            arrayList.add(LevelPlayAdSize.Companion.createAdSize$mediationsdk_release((String) it.next()));
        }
        return arrayList;
    }

    public final float i() {
        return g().a().c().b().b();
    }

    public final boolean j() {
        com.ironsource.mediationsdk.adquality.a a2 = d().c().a();
        return a2 != null && a2.b();
    }

    public final boolean k() {
        return g().a().b().d();
    }

    public final Vc b(C3047db tools) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        return new Vc(tools, g().a().a());
    }

    public final long b(LevelPlay.AdFormat adFormat) {
        C3288s.d b;
        Long d;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        C3288s c3288s = g().a().a().get(adFormat);
        long longValue = (c3288s == null || (b = c3288s.b()) == null || (d = b.d()) == null) ? 60L : d.longValue();
        return longValue > 0 ? TimeUnit.MINUTES.toMillis(longValue) : longValue;
    }

    public final Ka.a a(String adUnitId) {
        long d;
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        U2 c = g().a().c();
        U2.b bVar = c.a().get(adUnitId);
        int c2 = bVar != null ? bVar.c() : c.b().c();
        boolean e = bVar != null ? bVar.e() : c.b().e();
        if (bVar != null) {
            d = bVar.d();
        } else {
            d = c.b().d();
        }
        return new Ka.a(e, c2, d);
    }

    public final List<String> a(LevelPlay.AdFormat adFormat) {
        Map<String, C3117hd.b> a2;
        Set<String> keySet;
        List<String> list;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        C3117hd.a aVar = g().d().a().get(adFormat);
        return (aVar == null || (a2 = aVar.a()) == null || (keySet = a2.keySet()) == null || (list = CollectionsKt.toList(keySet)) == null) ? CollectionsKt.emptyList() : list;
    }

    public final C3306t0 a(C3047db tools) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        return new C3306t0(tools, g().a().a());
    }

    private final InterfaceC3346v6.c a(LevelPlay.AdFormat adFormat, String str) {
        C3288s.d b;
        C3066ed g;
        Map<String, C3288s.d> a2;
        C3288s.d dVar;
        C3066ed g2;
        boolean z = adFormat == LevelPlay.AdFormat.REWARDED;
        C3288s c3288s = g().a().a().get(adFormat);
        InterfaceC3346v6.c cVar = null;
        InterfaceC3346v6.c a3 = (c3288s == null || (a2 = c3288s.a()) == null || (dVar = a2.get(str)) == null || (g2 = dVar.g()) == null) ? null : g2.a();
        if (c3288s != null && (b = c3288s.b()) != null && (g = b.g()) != null) {
            cVar = g.a();
        }
        if (a3 == null) {
            a3 = cVar;
        }
        if (a3 != null) {
            return a3;
        }
        if (z) {
            return InterfaceC3346v6.c.PROGRESSIVE_ON_SHOW_SUCCESS;
        }
        return InterfaceC3346v6.c.SINGLE;
    }

    public final Placement c(LevelPlay.AdFormat adFormat, String str) {
        Placement a2;
        InterstitialPlacement a3;
        String str2;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        int i = a.f2942a[adFormat.ordinal()];
        if (i == 1) {
            Gd f = d().c().f();
            if (f == null || (a2 = f.a(str)) == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(a2, "getRewardedVideoPlacement(placementName)");
            return new Placement(a2.getPlacementId(), a2.getPlacementName(), a2.isDefault(), a2.getRewardName(), a2.getRewardAmount(), a2.getPlacementAvailabilitySettings());
        }
        if (i == 2) {
            C3366w9 d = d().c().d();
            if (d == null || (a3 = d.a(str)) == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(a3, "getInterstitialPlacement(placementName)");
            return new Placement(a3);
        }
        if (i == 3) {
            V2 c = d().c().c();
            if (c != null) {
                C3124i3 a4 = c.a(str);
                if (a4 == null) {
                    a4 = c.i();
                    str2 = "config.defaultBannerPlacement";
                } else {
                    str2 = "config.getBannerPlacemen…ig.defaultBannerPlacement";
                }
                Intrinsics.checkNotNullExpressionValue(a4, str2);
                return new Placement(a4);
            }
            throw new IllegalStateException("Error getting " + adFormat + " configurations");
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        C3419zb e = d().c().e();
        if (e != null && str != null) {
            Kb a5 = e.a(str);
            if (a5 == null) {
                a5 = e.e();
            }
            if (a5 != null) {
                return new Placement(a5);
            }
        }
        throw new IllegalStateException("Error getting " + adFormat + " configurations");
    }

    public final C3269qd c(C3047db tools) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        C3288s c3288s = g().a().a().get(LevelPlay.AdFormat.REWARDED);
        return new C3269qd(tools, c3288s != null ? c3288s.a() : null, c3288s != null ? c3288s.c() : null);
    }
}
