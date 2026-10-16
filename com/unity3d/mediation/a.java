package com.unity3d.mediation;

import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlay;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6448a = new a();

    /* renamed from: com.unity3d.mediation.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0580a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6449a;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            try {
                iArr[LevelPlay.AdFormat.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f6449a = iArr;
        }
    }

    private a() {
    }

    @JvmStatic
    public static final IronSource.AD_UNIT a(LevelPlay.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "<this>");
        int i = C0580a.f6449a[adFormat.ordinal()];
        if (i == 1) {
            return IronSource.AD_UNIT.BANNER;
        }
        if (i == 2) {
            return IronSource.AD_UNIT.INTERSTITIAL;
        }
        if (i == 3) {
            return IronSource.AD_UNIT.REWARDED_VIDEO;
        }
        if (i == 4) {
            return IronSource.AD_UNIT.NATIVE_AD;
        }
        throw new NoWhenBranchMatchedException();
    }
}
