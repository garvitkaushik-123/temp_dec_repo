package io.adn.unityplugin.internal.listeners;

import android.util.Log;
import com.ironsource.C3040d4;
import com.ironsource.C3355vf;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import io.adn.sdk.publisher.AdnAdError;
import io.adn.sdk.publisher.AdnAdInfo;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.AdnFullscreenAdListener;
import io.adn.unityplugin.publisher.AdnUnityCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: FullscreenAdListener.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J@\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0002J:\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lio/adn/unityplugin/internal/listeners/FullscreenAdListener;", "Lio/adn/sdk/publisher/AdnFullscreenAdListener;", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "unityCallback", "Lio/adn/unityplugin/publisher/AdnUnityCallback;", "onComplete", "Lkotlin/Function0;", "", "<init>", "(Lio/adn/sdk/publisher/AdnAdPlacement;Lio/adn/unityplugin/publisher/AdnUnityCallback;Lkotlin/jvm/functions/Function0;)V", C3355vf.j, "adInfo", "Lio/adn/sdk/publisher/AdnAdInfo;", C3355vf.b, "error", "Lio/adn/sdk/publisher/AdnAdError;", "onAdShown", C3355vf.g, "onAdImpression", C3355vf.f, C3355vf.e, "forwardUnityEvent", C3040d4.h.j0, "", "additionalParams", "", "", "buildEventArgs", "Lorg/json/JSONObject;", "getEventNameByPlacement", "adn-unityplugin_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdListener implements AdnFullscreenAdListener {
    private final Function0<Unit> onComplete;
    private final AdnAdPlacement placement;
    private final AdnUnityCallback unityCallback;

    /* compiled from: FullscreenAdListener.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdnAdPlacement.values().length];
            try {
                iArr[AdnAdPlacement.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdnAdPlacement.REWARDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AdnAdPlacement.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdShowFailed(AdnAdInfo adInfo, AdnAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    public FullscreenAdListener(AdnAdPlacement placement, AdnUnityCallback adnUnityCallback, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        this.placement = placement;
        this.unityCallback = adnUnityCallback;
        this.onComplete = onComplete;
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdRewarded(AdnAdInfo adnAdInfo) {
        AdnFullscreenAdListener.DefaultImpls.onAdRewarded(this, adnAdInfo);
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdLoaded(AdnAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        forwardUnityEvent$default(this, "LoadedEvent", adInfo, null, null, 12, null);
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdLoadFailed(AdnAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        forwardUnityEvent$default(this, "LoadFailedEvent", null, error, null, 10, null);
        this.onComplete.invoke();
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdShown(AdnAdInfo adInfo) {
        forwardUnityEvent$default(this, "DisplayedEvent", adInfo, null, null, 12, null);
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdClosed(AdnAdInfo adInfo) {
        forwardUnityEvent$default(this, "HiddenEvent", adInfo, null, MapsKt.mapOf(TuplesKt.to("rewardUser", true)), 4, null);
        this.onComplete.invoke();
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdImpression(AdnAdInfo adInfo) {
        forwardUnityEvent$default(this, "ImpressionEvent", adInfo, null, null, 12, null);
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdClicked(AdnAdInfo adInfo) {
        forwardUnityEvent$default(this, "ClickedEvent", adInfo, null, null, 12, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void forwardUnityEvent$default(FullscreenAdListener fullscreenAdListener, String str, AdnAdInfo adnAdInfo, AdnAdError adnAdError, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            adnAdInfo = null;
        }
        if ((i & 4) != 0) {
            adnAdError = null;
        }
        if ((i & 8) != 0) {
            map = null;
        }
        fullscreenAdListener.forwardUnityEvent(str, adnAdInfo, adnAdError, map);
    }

    private final void forwardUnityEvent(String eventName, AdnAdInfo adInfo, AdnAdError error, Map<String, ? extends Object> additionalParams) {
        Object m10241constructorimpl;
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            FullscreenAdListener fullscreenAdListener = this;
            AdnUnityCallback adnUnityCallback = this.unityCallback;
            if (adnUnityCallback != null) {
                String jSONObject = buildEventArgs(eventName, adInfo, error, additionalParams).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
                adnUnityCallback.onEvent(jSONObject);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            m10241constructorimpl = Result.m10241constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            Log.e("AdnSdk", "[AdnUnityPlugin] ERROR: Failed to forward unity event " + eventName + " - " + m10244exceptionOrNullimpl.getMessage());
        }
    }

    private final JSONObject buildEventArgs(String eventName, AdnAdInfo adInfo, AdnAdError error, Map<String, ? extends Object> additionalParams) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", getEventNameByPlacement(eventName));
        if (adInfo != null) {
            jSONObject.put("id", adInfo.getId());
            jSONObject.put("adFormat", this.placement.getValue());
            jSONObject.put("revenue", adInfo.getPrice());
            jSONObject.put("creativeId", adInfo.getCreativeId());
        }
        if (error != null) {
            jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, error.getErrorCode());
            jSONObject.put("errorMessage", error.getErrorMessage());
        }
        if (additionalParams != null) {
            for (Map.Entry<String, ? extends Object> entry : additionalParams.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    private final String getEventNameByPlacement(String eventName) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.placement.ordinal()];
        if (i == 1) {
            return "OnInterstitial" + eventName;
        }
        if (i == 2) {
            return "OnRewardedAd" + eventName;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "OnNativeAd" + eventName;
    }
}
