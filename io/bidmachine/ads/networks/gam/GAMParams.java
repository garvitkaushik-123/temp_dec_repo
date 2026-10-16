package io.bidmachine.ads.networks.gam;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.bidmachine.unified.UnifiedAdCallback;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.unified.UnifiedParams;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
class GAMParams extends UnifiedParams {
    final String adUnitId;
    final String price;
    final String score;

    GAMParams(UnifiedMediationParams mediationParams) {
        super(mediationParams);
        this.adUnitId = mediationParams.getStringOrNull("ad_unit_id");
        this.score = mediationParams.getStringOrNull(FirebaseAnalytics.Param.SCORE);
        this.price = mediationParams.getStringOrNull("price");
    }

    @Override // io.bidmachine.unified.UnifiedParams
    public boolean isValid(UnifiedAdCallback callback) {
        if (TextUtils.isEmpty(this.adUnitId)) {
            callback.onAdLoadFailed(BMError.notFound("ad_unit_id"));
            return false;
        }
        if (TextUtils.isEmpty(this.score)) {
            callback.onAdLoadFailed(BMError.notFound(FirebaseAnalytics.Param.SCORE));
            return false;
        }
        if (!TextUtils.isEmpty(this.price)) {
            return true;
        }
        callback.onAdLoadFailed(BMError.notFound("price"));
        return false;
    }
}
