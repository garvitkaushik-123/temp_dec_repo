package com.bytedance.sdk.openadsdk.eli;

import android.text.TextUtils;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.settings.FC;
import com.bytedance.sdk.openadsdk.dV.Os;
import com.bytedance.sdk.openadsdk.dV.aGH;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.Constants;
import java.util.Map;

/* loaded from: classes3.dex */
public class eli {
    public static boolean eli(PAGLoadListener pAGLoadListener) {
        if (FC.eli()) {
            return false;
        }
        if (pAGLoadListener == null) {
            return true;
        }
        pAGLoadListener.onError(1000, "Ad request is temporarily paused, Please contact your AM");
        return true;
    }

    public static void eli(final wC wCVar, final PAGLoadListener pAGLoadListener, final AdSlot adSlot) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.eli.1
            @Override // java.lang.Runnable
            public void run() {
                if (!nn.ui()) {
                    PAGLoadListener pAGLoadListener2 = PAGLoadListener.this;
                    if (pAGLoadListener2 != null) {
                        pAGLoadListener2.onError(10000, "Please exec TTAdSdk.init before load ad");
                        return;
                    }
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.FC.DbA().nlS()) {
                    PAGLoadListener pAGLoadListener3 = PAGLoadListener.this;
                    if (pAGLoadListener3 != null) {
                        pAGLoadListener3.onError(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, com.bytedance.sdk.openadsdk.core.wC.eli(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED));
                        return;
                    }
                    return;
                }
                Os.eli(new aGH() { // from class: com.bytedance.sdk.openadsdk.eli.eli.1.1
                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                        eliVar.DbA(Constants.LOAD_AD);
                        eliVar.Os(adSlot.getCodeId());
                        eliVar.aGH(dZ.Os(adSlot.getDurationSlotType()));
                        eliVar.eli(BuildConfig.VERSION_NAME);
                        eliVar.kb(dZ.eli(adSlot).toString());
                        return eliVar;
                    }
                });
                cyF.aGH(wCVar);
            }
        };
        if (nn.ui()) {
            runnable.run();
        } else {
            nn.DbA().post(runnable);
        }
    }

    public static void eli(AdSlot.Builder builder, PAGRequest pAGRequest) {
        Map<String, Object> extraInfo;
        if (!nn.ui() || pAGRequest == null || builder == null || (extraInfo = pAGRequest.getExtraInfo()) == null) {
            return;
        }
        if (extraInfo.containsKey("ad_id") && extraInfo.get("ad_id") != null) {
            builder.setAdId(extraInfo.get("ad_id").toString());
        }
        if (extraInfo.containsKey(CampaignEx.JSON_KEY_CREATIVE_ID) && extraInfo.get(CampaignEx.JSON_KEY_CREATIVE_ID) != null) {
            builder.setCreativeId(extraInfo.get(CampaignEx.JSON_KEY_CREATIVE_ID).toString());
        }
        if (extraInfo.containsKey("ext") && extraInfo.get("ext") != null) {
            builder.setExt(extraInfo.get("ext").toString());
        }
        if (!extraInfo.containsKey("media_extra") || extraInfo.get("media_extra") == null) {
            return;
        }
        builder.setMediaExtra(extraInfo.get("media_extra").toString());
    }

    public static boolean eli(String str, PAGRequest pAGRequest, PAGLoadListener pAGLoadListener) {
        if (TextUtils.isEmpty(str) && pAGLoadListener != null) {
            pAGLoadListener.onError(1, PAGErrorCode.PAGAdErrorCodeSlotIdNULLMsg);
            return true;
        }
        if (pAGRequest != null || pAGLoadListener == null) {
            return false;
        }
        pAGLoadListener.onError(2, PAGErrorCode.PAGAdErrorCodeRequestNULLMsg);
        return true;
    }
}
