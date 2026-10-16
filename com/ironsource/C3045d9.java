package com.ironsource;

import com.ironsource.C3337ue;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.ironsourceads.IronSourceAds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.d9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3045d9 {

    /* renamed from: com.ironsource.d9$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3253a;

        static {
            int[] iArr = new int[IronSourceAds.AdFormat.values().length];
            try {
                iArr[IronSourceAds.AdFormat.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSourceAds.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSourceAds.AdFormat.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3253a = iArr;
        }
    }

    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        R7.a(R7.f3025a, runnable, 0L, 2, (Object) null);
    }

    public final void b(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        R7.f3025a.a(callback);
    }

    public final IronSource.AD_UNIT[] a(List<? extends IronSourceAds.AdFormat> adFormats) {
        Intrinsics.checkNotNullParameter(adFormats, "adFormats");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends IronSourceAds.AdFormat> it = adFormats.iterator();
        while (it.hasNext()) {
            int i = a.f3253a[it.next().ordinal()];
            if (i == 1) {
                arrayList.add(IronSource.AD_UNIT.BANNER);
            } else if (i == 2) {
                arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
            } else if (i == 3) {
                arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
            }
        }
        return (IronSource.AD_UNIT[]) arrayList.toArray(new IronSource.AD_UNIT[0]);
    }

    public final IronSourceError a(Ud error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (error.c() != 2070 && error.c() != 2110) {
            if (error.c() != 2080 && error.c() != 2100) {
                if (error.c() == 2090) {
                    return C3362w5.f3920a.a();
                }
                return new IronSourceError(510, error.d());
            }
            return C3362w5.f3920a.c();
        }
        return C3362w5.f3920a.b();
    }

    public final void a(long j, C3337ue.a responseOrigin) {
        Intrinsics.checkNotNullParameter(responseOrigin, "responseOrigin");
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(true);
        try {
            mediationAdditionalData.put("isMultipleAdObjects", 1);
            mediationAdditionalData.put("duration", j);
            mediationAdditionalData.put(IronSourceConstants.EVENTS_EXT1, responseOrigin.b());
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        C3334ub.s.d().q().a(new C3413z5(A5.SDK_INIT_SUCCESS, mediationAdditionalData));
    }

    public final void a(Ud error, long j) {
        Intrinsics.checkNotNullParameter(error, "error");
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(true);
        try {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, error.c());
            mediationAdditionalData.put("reason", error.d());
            mediationAdditionalData.put("duration", j);
            mediationAdditionalData.put("isMultipleAdObjects", 1);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        C3334ub.s.d().q().a(new C3413z5(A5.SDK_INIT_FAILED, mediationAdditionalData));
    }
}
