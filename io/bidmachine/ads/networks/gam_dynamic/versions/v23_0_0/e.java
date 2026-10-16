package io.bidmachine.ads.networks.gam_dynamic.versions.v23_0_0;

import android.text.TextUtils;
import com.explorestack.protobuf.DoubleValue;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.UInt32Value;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.ads.networks.gam_dynamic.InternalAdLoadData;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.ReflectionUtils;
import java.util.Map;

/* loaded from: classes7.dex */
class e {
    static BMError a(BMError baseBMError, AdError adError) {
        return new BMError(baseBMError, adError.getCode(), adError.getMessage());
    }

    static AdManagerAdRequest a(Waterfall.Configuration.AdUnit adUnit) {
        AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
        String requestAgent = adUnit.getRequestAgent();
        if (!TextUtils.isEmpty(requestAgent)) {
            builder.setRequestAgent(requestAgent);
        }
        for (Map.Entry<String, String> entry : adUnit.getCustomTargetingMap().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                builder.addCustomTargeting(key, value);
            }
        }
        return builder.build();
    }

    static InternalAdLoadData a(BaseAdView baseAdView) {
        if (baseAdView == null) {
            return null;
        }
        Waterfall.Result.EstimatedPrice a2 = a(baseAdView, new String[]{"zza", "zzj", "zza", "a", "a", CampaignEx.JSON_KEY_AD_K, "ae"});
        ResponseInfo responseInfo = baseAdView.getResponseInfo();
        String responseInfo2 = responseInfo != null ? responseInfo.toString() : null;
        if (a2 == null && responseInfo2 == null) {
            return null;
        }
        return new InternalAdLoadData(a2, responseInfo2);
    }

    static InternalAdLoadData a(InterstitialAd interstitialAd) {
        if (interstitialAd == null) {
            return null;
        }
        return new InternalAdLoadData(a(interstitialAd, new String[]{"zzc", "zza", "a", "a", CampaignEx.JSON_KEY_AD_K, "ae"}), interstitialAd.getResponseInfo().toString());
    }

    static InternalAdLoadData a(RewardedAd rewardedAd) {
        if (rewardedAd == null) {
            return null;
        }
        return new InternalAdLoadData(a(rewardedAd, new String[]{"zzb", "zza", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, CampaignEx.JSON_KEY_AD_K, "ae"}), rewardedAd.getResponseInfo().toString());
    }

    static Waterfall.Result.EstimatedPrice a(Object object, String[] path) {
        try {
            Object findValueByPath = ReflectionUtils.findValueByPath(object, path);
            if (findValueByPath == null) {
                return null;
            }
            Integer num = (Integer) ReflectionUtils.findValue(findValueByPath, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            String str = (String) ReflectionUtils.findValue(findValueByPath, "c");
            Number number = (Number) ReflectionUtils.findValue(findValueByPath, "d");
            Double valueOf = number != null ? Double.valueOf(number.doubleValue()) : null;
            if (num == null && str == null && valueOf == null) {
                return null;
            }
            Waterfall.Result.EstimatedPrice.Builder newBuilder = Waterfall.Result.EstimatedPrice.newBuilder();
            if (valueOf != null) {
                newBuilder.setValue(DoubleValue.newBuilder().setValue(valueOf.doubleValue()).build());
            }
            if (str != null) {
                newBuilder.setCurrency(StringValue.newBuilder().setValue(str).build());
            }
            if (num != null) {
                newBuilder.setPrecision(UInt32Value.newBuilder().setValue(num.intValue()).build());
            }
            return newBuilder.build();
        } catch (Throwable unused) {
            return null;
        }
    }

    static Waterfall.Result.EstimatedPrice a(AdValue adValue) {
        return Waterfall.Result.EstimatedPrice.newBuilder().setValue(DoubleValue.newBuilder().setValue(adValue.getValueMicros()).build()).setCurrency(StringValue.newBuilder().setValue(adValue.getCurrencyCode()).build()).setPrecision(UInt32Value.newBuilder().setValue(adValue.getPrecisionType()).build()).build();
    }
}
