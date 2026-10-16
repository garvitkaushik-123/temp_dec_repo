package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.L7;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.BasePlacement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class Wc implements L7, L7.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3112a = "CappingManager.IS_DELIVERY_ENABLED";
    private static final String b = "CappingManager.IS_CAPPING_ENABLED";
    private static final String c = "CappingManager.IS_PACING_ENABLED";
    private static final String d = "CappingManager.MAX_NUMBER_OF_SHOWS";
    private static final String e = "CappingManager.CAPPING_TYPE";
    private static final String f = "CappingManager.SECONDS_BETWEEN_SHOWS";
    private static final String g = "CappingManager.CURRENT_NUMBER_OF_SHOWS";
    private static final String h = "CappingManager.CAPPING_TIME_THRESHOLD";
    private static final String i = "CappingManager.TIME_OF_THE_PREVIOUS_SHOW";

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3113a;

        static {
            int[] iArr = new int[Xc.values().length];
            f3113a = iArr;
            try {
                iArr[Xc.PER_DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3113a[Xc.PER_HOUR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        CAPPED_PER_DELIVERY,
        CAPPED_PER_COUNT,
        CAPPED_PER_PACE,
        NOT_CAPPED
    }

    @Override // com.ironsource.L7
    public synchronized b a(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit) {
        if (context == null) {
            return b.NOT_CAPPED;
        }
        if (basePlacement == null) {
            return b.NOT_CAPPED;
        }
        String a2 = a(ad_unit);
        if (basePlacement.getPlacementName() == null) {
            return b.NOT_CAPPED;
        }
        if (basePlacement.getPlacementAvailabilitySettings() == null) {
            return b.NOT_CAPPED;
        }
        return b(context, a2, basePlacement.getPlacementName());
    }

    @Override // com.ironsource.L7.a
    public synchronized void b(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit) {
        if (context == null || basePlacement == null) {
            return;
        }
        Tc placementAvailabilitySettings = basePlacement.getPlacementAvailabilitySettings();
        if (placementAvailabilitySettings == null) {
            return;
        }
        a(context, a(ad_unit), basePlacement.getPlacementName(), placementAvailabilitySettings);
    }

    @Override // com.ironsource.L7
    public synchronized boolean c(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit) {
        return a(context, basePlacement, ad_unit) != b.NOT_CAPPED;
    }

    private b b(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, f3112a, str2), true)) {
            return b.CAPPED_PER_DELIVERY;
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, c, str2), false)) {
            if (currentTimeMillis - IronSourceUtils.getLongFromSharedPrefs(context, a(str, i, str2), 0L) < IronSourceUtils.getIntFromSharedPrefs(context, a(str, f, str2), 0) * 1000) {
                return b.CAPPED_PER_PACE;
            }
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, b, str2), false)) {
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, a(str, d, str2), 0);
            String a2 = a(str, g, str2);
            int intFromSharedPrefs2 = IronSourceUtils.getIntFromSharedPrefs(context, a2, 0);
            String a3 = a(str, h, str2);
            if (currentTimeMillis >= IronSourceUtils.getLongFromSharedPrefs(context, a3, 0L)) {
                IronSourceUtils.saveIntToSharedPrefs(context, a2, 0);
                IronSourceUtils.saveLongToSharedPrefs(context, a3, 0L);
            } else if (intFromSharedPrefs2 >= intFromSharedPrefs) {
                return b.CAPPED_PER_COUNT;
            }
        }
        return b.NOT_CAPPED;
    }

    @Override // com.ironsource.L7.a
    public synchronized void a(Context context, String str, IronSource.AD_UNIT ad_unit) {
        if (context == null) {
            return;
        }
        if (str == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(context, a(ad_unit), str);
    }

    private String a(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    private void a(Context context, String str, String str2) {
        Xc xc;
        int i2 = 0;
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, c, str2), false)) {
            IronSourceUtils.saveLongToSharedPrefs(context, a(str, i, str2), System.currentTimeMillis());
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, b, str2), false)) {
            String a2 = a(str, g, str2);
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, a2, 0);
            if (intFromSharedPrefs == 0) {
                String stringFromSharedPrefs = IronSourceUtils.getStringFromSharedPrefs(context, a(str, e, str2), Xc.PER_DAY.toString());
                Xc[] values = Xc.values();
                int length = values.length;
                while (true) {
                    if (i2 >= length) {
                        xc = null;
                        break;
                    }
                    xc = values[i2];
                    if (xc.f3132a.equals(stringFromSharedPrefs)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                IronSourceUtils.saveLongToSharedPrefs(context, a(str, h, str2), a(xc));
            }
            IronSourceUtils.saveIntToSharedPrefs(context, a2, intFromSharedPrefs + 1);
        }
    }

    private long a(Xc xc) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int i2 = a.f3113a[xc.ordinal()];
        if (i2 == 1) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.set(11, 0);
            calendar.add(6, 1);
        } else if (i2 == 2) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.add(11, 1);
        }
        return calendar.getTimeInMillis();
    }

    private void a(Context context, String str, String str2, Tc tc) {
        boolean e2 = tc.e();
        IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, f3112a, str2), e2);
        if (e2) {
            boolean d2 = tc.d();
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, b, str2), d2);
            if (d2) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, d, str2), tc.b());
                IronSourceUtils.saveStringToSharedPrefs(context, a(str, e, str2), tc.a().toString());
            }
            boolean f2 = tc.f();
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, c, str2), f2);
            if (f2) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, f, str2), tc.c());
            }
        }
    }

    private String a(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return IronSourceConstants.REWARDED_VIDEO_AD_UNIT;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return "Interstitial";
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return "Banner";
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return IronSourceConstants.NATIVE_AD_UNIT;
        }
        return ad_unit.toString();
    }
}
