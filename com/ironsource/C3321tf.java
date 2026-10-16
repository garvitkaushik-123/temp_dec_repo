package com.ironsource;

import android.app.Activity;
import android.content.Context;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* renamed from: com.ironsource.tf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3321tf {

    /* renamed from: a, reason: collision with root package name */
    public static final C3321tf f3849a = new C3321tf();

    private C3321tf() {
    }

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return C1.a(context, c(context));
    }

    public final String b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return C1.b(context, c(context));
    }

    public final String c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return C1.g(context);
    }

    public final ConcurrentHashMap<String, List<String>> d() {
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.putAll(com.ironsource.mediationsdk.c.b().d());
        concurrentHashMap.putAll(Z9.b().c());
        return concurrentHashMap;
    }

    public final boolean e() {
        return IronSource.isInterstitialReady();
    }

    public final boolean f() {
        return IronSource.isRewardedVideoAvailable();
    }

    public final void g() {
        IronSource.loadInterstitial();
    }

    public final void h() {
        IronSource.loadRewardedVideo();
    }

    public final void i() {
        com.ironsource.mediationsdk.p.j().P();
    }

    public final JSONObject a(boolean z) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z);
        Intrinsics.checkNotNullExpressionValue(mediationAdditionalData, "getMediationAdditionalData(isDemandOnlyMode)");
        return mediationAdditionalData;
    }

    public final JSONObject b() {
        JSONObject b = K6.a().b();
        Intrinsics.checkNotNullExpressionValue(b, "getProperties().toJSON()");
        return b;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            ConcurrentHashMap<String, AdapterBaseWrapper> networkAdaptersMap = com.ironsource.mediationsdk.c.b().e();
            Intrinsics.checkNotNullExpressionValue(networkAdaptersMap, "networkAdaptersMap");
            for (Map.Entry<String, AdapterBaseWrapper> entry : networkAdaptersMap.entrySet()) {
                if (entry.getValue().getAdapterBaseInterface() != null) {
                    C3321tf c3321tf = f3849a;
                    String key = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                    String a2 = c3321tf.a(key);
                    AdapterBaseInterface adapterBaseInterface = entry.getValue().getAdapterBaseInterface();
                    Intrinsics.checkNotNullExpressionValue(adapterBaseInterface, "entry.value.adapterBaseInterface");
                    String adapterVersion = adapterBaseInterface.getAdapterVersion();
                    Intrinsics.checkNotNullExpressionValue(adapterVersion, "adapterBaseInterface.adapterVersion");
                    jSONObject.putOpt(a2, c3321tf.a(adapterVersion, adapterBaseInterface.getNetworkSDKVersion()));
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
        }
        return jSONObject;
    }

    public final void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        C3024c8.a().b(levelPlayInterstitialListener);
    }

    public final void b(Activity activity) {
        if (activity != null) {
            IronSource.showRewardedVideo(activity);
        } else {
            IronSource.showRewardedVideo();
        }
    }

    public final void a(LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        C3184ld.a().b(levelPlayRewardedVideoBaseListener);
    }

    public final void a(LevelPlayBannerListener levelPlayBannerListener) {
        C3325u2.a().b(levelPlayBannerListener);
    }

    public final void a(IronSource.AD_UNIT adUnit, C3203mf loadAdConfig) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(loadAdConfig, "loadAdConfig");
        com.ironsource.mediationsdk.p.j().a(adUnit, loadAdConfig);
    }

    public final LevelPlayAdSize b(String str, int i, int i2) {
        if (str != null && str.length() != 0 && !Intrinsics.areEqual(str, "CUSTOM")) {
            if (Intrinsics.areEqual(str, "RECTANGLE")) {
                return LevelPlayAdSize.MEDIUM_RECTANGLE;
            }
            return LevelPlayAdSize.Companion.createAdSize$mediationsdk_release(str);
        }
        return LevelPlayAdSize.Companion.createCustomSize(i, i2);
    }

    public final int a() {
        return C3334ub.s.d().i().c();
    }

    public final String a(Placement placement) {
        String placementName;
        return (placement == null || (placementName = placement.getPlacementName()) == null) ? new String() : placementName;
    }

    public final String a(NetworkSettings networkSettings) {
        Intrinsics.checkNotNullParameter(networkSettings, "networkSettings");
        String providerDefaultInstance = networkSettings.getProviderDefaultInstance();
        return providerDefaultInstance == null ? new String() : providerDefaultInstance;
    }

    public final boolean a(NetworkSettings networkSettings, IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(networkSettings, "networkSettings");
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        return networkSettings.isBidder(adUnit);
    }

    public final void a(Activity activity) {
        if (activity != null) {
            IronSource.showInterstitial(activity);
        } else {
            IronSource.showInterstitial();
        }
    }

    public final ISBannerSize a(String str, int i, int i2) {
        return new ISBannerSize(str, i, i2);
    }

    public final IronSourceBannerLayout a(Activity activity, ISBannerSize size) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(size, "size");
        IronSourceBannerLayout b = com.ironsource.mediationsdk.p.j().b(activity, size);
        Intrinsics.checkNotNullExpressionValue(b, "getInstance().createBanner(activity, size)");
        return b;
    }

    public final void a(IronSourceBannerLayout ironSourceBannerLayout) {
        IronSource.destroyBanner(ironSourceBannerLayout);
    }

    public final void b(IronSourceBannerLayout ironSourceBannerLayout) {
        IronSource.loadBanner(ironSourceBannerLayout);
    }

    public final void a(A5 event, JSONObject data) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        Id.i().a(new C3413z5(event, data));
    }

    public final void b(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        IronLog.INTERNAL.error(message);
    }

    private final JSONObject a(String str, String str2) {
        return new JSONObject(MapsKt.mapOf(TuplesKt.to(C3152jf.b, str), TuplesKt.to("sdkVersion", str2)));
    }

    public final String a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
        } catch (Exception e) {
            e = e;
        }
        try {
            if (!StringsKt.contains$default((CharSequence) key, (CharSequence) "-", false, 2, (Object) null)) {
                return !StringsKt.contains$default((CharSequence) key, (CharSequence) "_", false, 2, (Object) null) ? key : (String) CollectionsKt.first(StringsKt.split$default((CharSequence) key, new String[]{"_"}, false, 0, 6, (Object) null));
            }
            String str = (String) CollectionsKt.last(StringsKt.split$default((CharSequence) key, new String[]{"-"}, false, 0, 6, (Object) null));
            return !StringsKt.contains$default((CharSequence) str, (CharSequence) "_", false, 2, (Object) null) ? str : (String) CollectionsKt.first(StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null));
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            C3260q4.d().a(exc);
            IronLog.INTERNAL.error(exc.getMessage());
            return key;
        }
    }
}
