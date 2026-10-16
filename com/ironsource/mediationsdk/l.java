package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ironsource.A5;
import com.ironsource.C3124i3;
import com.ironsource.C3260q4;
import com.ironsource.C3400y9;
import com.ironsource.C3413z5;
import com.ironsource.D3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.adapters.levelplay.LevelPlayBaseAdapter;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3540a = "BANNER";
    public static final String b = "LARGE";
    public static final String c = "RECTANGLE";
    public static final String d = "LEADERBOARD";
    public static final String e = "SMART";
    public static final String f = "CUSTOM";
    public static final String g = "MEDIUM_RECTANGLE";
    public static final String h = "bannerAdSize";
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    public static final int m = 4;
    public static final int n = 5;
    public static final int o = 6;
    public static final int p = -1;
    public static final String q = "Adaptive=true";

    interface a {
        void a(Map<String, Object> map, List<String> list, StringBuilder sb);
    }

    interface b {
        void a();

        void a(String str);
    }

    static void a(IronSourceBannerLayout ironSourceBannerLayout, C3124i3 c3124i3, b bVar) {
        String str;
        if (c(ironSourceBannerLayout)) {
            str = null;
        } else {
            str = String.format("can't load banner - %s", ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed");
        }
        if (c3124i3 == null || TextUtils.isEmpty(c3124i3.getPlacementName())) {
            str = String.format("can't load banner - %s", c3124i3 == null ? "placement is null" : "placement name is empty");
        }
        if (TextUtils.isEmpty(str)) {
            bVar.a();
        } else {
            IronLog.INTERNAL.error(str);
            bVar.a(str);
        }
    }

    public static ISBannerSize b() {
        if (AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext())) {
            a("SMART", 728, 90);
        }
        return a("SMART", Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    }

    static boolean c(IronSourceBannerLayout ironSourceBannerLayout) {
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) ? false : true;
    }

    public static int b(int i2) {
        if (!p.j().M()) {
            IronLog.API.error("The mediation must be successfully initiated before calling this API");
            return -1;
        }
        return a(i2);
    }

    public static void b(IronSourceBannerLayout ironSourceBannerLayout) {
        ISBannerSize size;
        if (ironSourceBannerLayout == null || (size = ironSourceBannerLayout.getSize()) == null || !size.isSmart()) {
            return;
        }
        ISBannerSize b2 = b();
        b2.setContainerParams(size.containerParams);
        b2.setAdaptive(size.isAdaptive());
        ironSourceBannerLayout.setBannerSize(b2);
    }

    static void a(IronSourceBannerLayout ironSourceBannerLayout, b bVar) {
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            bVar.a();
        } else {
            bVar.a(String.format("can't destroy banner - %s", ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed"));
        }
    }

    static long a(long j2, long j3) {
        return j3 - (new Date().getTime() - j2);
    }

    public static ISBannerSize a(String str, int i2, int i3) {
        return new ISBannerSize(str, i2, i3);
    }

    public static ISBannerSize a() {
        return new ISBannerSize("LEADERBOARD", 728, 90);
    }

    public static void a(IronSourceBannerLayout ironSourceBannerLayout) {
        if (ironSourceBannerLayout != null) {
            ironSourceBannerLayout.a();
        }
    }

    public static void a(final IronSourceBannerLayout ironSourceBannerLayout, final View view, final FrameLayout.LayoutParams layoutParams, final D3 d3) {
        if (ironSourceBannerLayout == null || view == null || layoutParams == null) {
            return;
        }
        final Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        final ISBannerSize size = ironSourceBannerLayout.getSize();
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() { // from class: com.ironsource.mediationsdk.l$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                l.a(IronSourceBannerLayout.this, view, size, applicationContext, layoutParams, d3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IronSourceBannerLayout ironSourceBannerLayout, View view, ISBannerSize iSBannerSize, Context context, FrameLayout.LayoutParams layoutParams, D3 d3) {
        try {
            ironSourceBannerLayout.removeAllViews();
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            if (iSBannerSize != null) {
                if (iSBannerSize.isAdaptive()) {
                    a(ironSourceBannerLayout, view, context, iSBannerSize);
                } else {
                    ironSourceBannerLayout.addView(view, 0, layoutParams);
                }
            }
            if (d3 != null) {
                d3.a();
            }
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error("Error while binding a banner - " + Log.getStackTraceString(e2));
        }
    }

    public static void a(IronSourceBannerLayout ironSourceBannerLayout, View view, FrameLayout.LayoutParams layoutParams) {
        a(ironSourceBannerLayout, view, layoutParams, (D3) null);
    }

    private static void a(IronSourceBannerLayout ironSourceBannerLayout, View view, Context context, ISBannerSize iSBannerSize) {
        int dpToPixels = AdapterUtils.dpToPixels(context, iSBannerSize.containerParams.getWidth());
        int dpToPixels2 = AdapterUtils.dpToPixels(context, iSBannerSize.containerParams.getHeight());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPixels, dpToPixels2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setGravity(17);
        relativeLayout.addView(view, 0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) ironSourceBannerLayout.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(dpToPixels, dpToPixels2);
        }
        layoutParams2.height = dpToPixels2;
        layoutParams2.width = dpToPixels;
        layoutParams2.gravity = 17;
        ironSourceBannerLayout.setLayoutParams(layoutParams2);
        IronLog.INTERNAL.verbose("containerParams height - " + iSBannerSize.containerParams.getHeight() + " width - " + iSBannerSize.containerParams.getWidth());
        ironSourceBannerLayout.addView(relativeLayout, 0, layoutParams2);
    }

    public static int a(int i2) {
        int i3 = -1;
        try {
            i3 = a(a(c.b()), i2);
            a(i2, i3);
            IronLog.API.verbose("Maximal height - " + i3 + " for width - " + i2);
            return i3;
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error("Failed to get adaptive height: " + e2.getMessage());
            return i3;
        }
    }

    private static Map<String, Object> a(c cVar) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(cVar.a());
        concurrentHashMap.putAll(cVar.c());
        return concurrentHashMap;
    }

    private static int a(Map<String, Object> map, int i2) {
        int i3 = -1;
        for (Object obj : map.values()) {
            try {
                i3 = Math.max(i3, a(obj, i2));
            } catch (Throwable th) {
                a(obj, th);
            }
        }
        return i3;
    }

    private static int a(Object obj, int i2) {
        if (obj instanceof AbstractAdapter) {
            return ((AbstractAdapter) obj).getAdaptiveHeight(i2);
        }
        if (obj instanceof LevelPlayBaseAdapter) {
            return ((LevelPlayBaseAdapter) obj).getAdaptiveHeight(i2);
        }
        return -1;
    }

    private static void a(Object obj, Throwable th) {
        String simpleName = obj != null ? obj.getClass().getSimpleName() : "unknown";
        C3260q4.d().a(th);
        IronLog.INTERNAL.error("Exception while calling getAdaptiveHeight for adapter - " + simpleName + ": " + th.getMessage());
    }

    private static void a(int i2, int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
            if (i3 == -1) {
                jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, 2);
                jSONObject.put("reason", "No networks found supporting adaptive banners");
            } else {
                jSONObject.put(IronSourceConstants.EVENTS_EXT1, "w:" + i2 + ",h:" + i3);
            }
            C3400y9.i().a(new C3413z5(A5.BN_GET_MAXIMAL_ADAPTIVE_HEIGHT, jSONObject));
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    public static void a(Map<String, Object> map, ISBannerSize iSBannerSize) {
        char c2;
        if (iSBannerSize != null) {
            try {
                String description = iSBannerSize.getDescription();
                switch (description.hashCode()) {
                    case -387072689:
                        if (description.equals("RECTANGLE")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 72205083:
                        if (description.equals("LARGE")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 79011241:
                        if (description.equals("SMART")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 446888797:
                        if (description.equals("LEADERBOARD")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1951953708:
                        if (description.equals("BANNER")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1999208305:
                        if (description.equals("CUSTOM")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    map.put(h, 1);
                } else if (c2 == 1) {
                    map.put(h, 2);
                } else if (c2 == 2) {
                    map.put(h, 3);
                } else if (c2 == 3) {
                    map.put(h, 4);
                } else if (c2 == 4) {
                    map.put(h, 5);
                } else if (c2 == 5) {
                    map.put(h, 6);
                    map.put("custom_banner_size", iSBannerSize.getWidth() + VastAttributes.HORIZONTAL_POSITION + iSBannerSize.getHeight());
                }
                if (iSBannerSize.isAdaptive()) {
                    String a2 = a(iSBannerSize);
                    if (map.containsKey(IronSourceConstants.EVENTS_EXT1)) {
                        a2 = map.get(IronSourceConstants.EVENTS_EXT1) + " , " + a(iSBannerSize);
                    }
                    map.put(IronSourceConstants.EVENTS_EXT1, a2);
                }
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error(Log.getStackTraceString(e2));
            }
        }
    }

    public static String a(ISBannerSize iSBannerSize) {
        return "Adaptive=true, size: " + iSBannerSize.containerParams.getWidth() + VastAttributes.HORIZONTAL_POSITION + iSBannerSize.containerParams.getHeight() + "; fallback: " + iSBannerSize.getDescription() + ", size: " + iSBannerSize.getWidth() + VastAttributes.HORIZONTAL_POSITION + iSBannerSize.getHeight() + ";";
    }

    public static boolean a(ISContainerParams iSContainerParams, int i2, int i3) {
        if (iSContainerParams != null && iSContainerParams.getWidth() > 0 && iSContainerParams.getHeight() > 0) {
            if (iSContainerParams.getWidth() >= i2 && iSContainerParams.getHeight() >= i3) {
                return true;
            }
            IronLog.API.warning("Container size too small: Banner may not display correctly.");
            return true;
        }
        IronLog.API.warning("Container size is invalid: Default banner size will be used.");
        return false;
    }
}
