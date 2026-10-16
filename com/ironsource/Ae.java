package com.ironsource;

import com.ironsource.K8;
import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlay;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
class Ae implements K8, K8.a {
    private static final int c = 1;

    /* renamed from: a, reason: collision with root package name */
    private final Map<IronSource.AD_UNIT, Integer> f2792a = new HashMap();
    private final Q9 b = new Q9();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2793a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            f2793a = iArr;
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2793a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2793a[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2793a[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    Ae() {
        for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
            a(ad_unit, 1);
        }
    }

    private void a(IronSource.AD_UNIT ad_unit, int i) {
        this.f2792a.put(ad_unit, Integer.valueOf(i));
        int i2 = a.f2793a[ad_unit.ordinal()];
        if (i2 == 1) {
            this.b.d(i);
            return;
        }
        if (i2 == 2) {
            this.b.b(i);
        } else if (i2 == 3) {
            this.b.a(i);
        } else {
            if (i2 != 4) {
                return;
            }
            this.b.c(i);
        }
    }

    @Override // com.ironsource.K8.a
    public synchronized void b(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == null) {
            return;
        }
        a(ad_unit, this.f2792a.get(ad_unit).intValue() + 1);
    }

    @Override // com.ironsource.K8
    public synchronized int a(IronSource.AD_UNIT ad_unit) {
        int i = -1;
        if (ad_unit == null) {
            return -1;
        }
        Integer num = this.f2792a.get(ad_unit);
        if (num != null) {
            i = num.intValue();
        }
        return i;
    }

    @Override // com.ironsource.K8
    public int a(LevelPlay.AdFormat adFormat) {
        if (adFormat == null) {
            return -1;
        }
        return a(com.unity3d.mediation.a.a(adFormat)) - 1;
    }
}
