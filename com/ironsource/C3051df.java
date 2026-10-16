package com.ironsource;

import android.text.TextUtils;
import com.ironsource.AbstractC3326u3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.df, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3051df {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<IronSource.AD_UNIT, C3239p0> f3256a = new HashMap();

    /* renamed from: com.ironsource.df$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3257a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            b = iArr;
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[LevelPlay.AdFormat.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[IronSource.AD_UNIT.values().length];
            f3257a = iArr2;
            try {
                iArr2[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3257a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3257a[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3257a[IronSource.AD_UNIT.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static R0 a(AbstractC3340v0 abstractC3340v0, int i) {
        return a(abstractC3340v0).a(abstractC3340v0.b().c(), abstractC3340v0.m(), i);
    }

    public static int b(IronSource.AD_UNIT ad_unit) {
        int i = a.f3257a[ad_unit.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? AbstractC3326u3.e.NOT_SUPPORTED.b() : AbstractC3326u3.e.BANNER.b() : AbstractC3326u3.e.NATIVE_AD.b() : AbstractC3326u3.e.INTERSTITIAL.b() : AbstractC3326u3.e.REWARDED_VIDEO.b();
    }

    private static C3239p0 a(AbstractC3340v0 abstractC3340v0) {
        Map<IronSource.AD_UNIT, C3239p0> map = f3256a;
        if (map.containsKey(abstractC3340v0.b().a())) {
            return map.get(abstractC3340v0.b().a());
        }
        C3239p0 c3239p0 = new C3239p0();
        map.put(abstractC3340v0.b().a(), c3239p0);
        return c3239p0;
    }

    /* renamed from: com.ironsource.df$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final IronSource.AD_UNIT f3258a;

        public b(IronSource.AD_UNIT ad_unit) {
            this.f3258a = ad_unit;
        }

        private String b() {
            IronSource.AD_UNIT ad_unit = this.f3258a;
            return ad_unit != null ? ad_unit.name() : "";
        }

        public String a(String str, String str2) {
            String str3 = b() + (TextUtils.isEmpty(str2) ? "" : " - " + str2);
            return TextUtils.isEmpty(str) ? str3 : str3 + " - " + str;
        }

        public String a(String str) {
            return a(str, null);
        }

        public String a() {
            return a(null);
        }
    }

    public static b a(IronSource.AD_UNIT ad_unit) {
        return new b(ad_unit);
    }

    public static IronSourceSegment a() {
        return com.ironsource.mediationsdk.p.j().q();
    }

    public static void a(Throwable th) {
        IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "SafeRunnable", th);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reason", th.getMessage());
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        a(A5.TROUBLESHOOTING_SDK_INTERNAL_ERROR, jSONObject);
    }

    public static void a(Exception exc) {
        IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "Exception", exc);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reason", exc.getMessage());
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        a(A5.TROUBLESHOOTING_LOAD_ARM_DATA_PARSE_ERROR, jSONObject);
    }

    public static void a(A5 a5, JSONObject jSONObject) {
        C3334ub.U().q().a(new C3413z5(a5, V9.a(IronSourceUtils.getMediationAdditionalData(false), jSONObject)));
    }

    public static boolean a(AdapterBaseInterface adapterBaseInterface, IronSource.AD_UNIT ad_unit, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !(adapterBaseInterface instanceof AdapterSettingsInterface) || !((AdapterSettingsInterface) adapterBaseInterface).isUsingActivityBeforeImpression(ad_unit)) {
            return false;
        }
        ironLog.verbose(str + " - is using activity before impression and activity is null");
        return true;
    }

    public static String a(LevelPlay.AdFormat adFormat) {
        int i = a.b[adFormat.ordinal()];
        if (i == 1) {
            return "rewarded";
        }
        if (i == 2) {
            return "interstitial";
        }
        if (i == 3) {
            return "banner";
        }
        if (i != 4) {
            return "";
        }
        return "nativeAd";
    }
}
