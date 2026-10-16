package com.vungle.ads.internal.load;

import androidx.core.app.NotificationCompat;
import com.ironsource.C3337ue;
import com.vungle.ads.APIFailedStatusCodeError;
import com.vungle.ads.AdResponseEmptyError;
import com.vungle.ads.AdRetryError;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.Callback;
import com.vungle.ads.internal.network.Response;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultAdLoader.kt */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\t\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/vungle/ads/internal/load/DefaultAdLoader$fetchAdMetadata$1", "Lcom/vungle/ads/internal/network/Callback;", "Lcom/vungle/ads/internal/model/AdPayload;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lcom/vungle/ads/internal/network/Call;", "t", "", "onResponse", C3337ue.n, "Lcom/vungle/ads/internal/network/Response;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class DefaultAdLoader$fetchAdMetadata$1 implements Callback<AdPayload> {
    final /* synthetic */ Placement $placement;
    final /* synthetic */ DefaultAdLoader this$0;

    DefaultAdLoader$fetchAdMetadata$1(DefaultAdLoader defaultAdLoader, Placement placement) {
        this.this$0 = defaultAdLoader;
        this.$placement = placement;
    }

    @Override // com.vungle.ads.internal.network.Callback
    public void onResponse(Call<AdPayload> call, final Response<AdPayload> response) {
        VungleThreadPoolExecutor background_executor = this.this$0.getSdkExecutors().getBACKGROUND_EXECUTOR();
        final DefaultAdLoader defaultAdLoader = this.this$0;
        final Placement placement = this.$placement;
        background_executor.execute(new Runnable() { // from class: com.vungle.ads.internal.load.DefaultAdLoader$fetchAdMetadata$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DefaultAdLoader$fetchAdMetadata$1.m9353onResponse$lambda0(DefaultAdLoader.this, placement, response);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onResponse$lambda-0, reason: not valid java name */
    public static final void m9353onResponse$lambda0(DefaultAdLoader this$0, Placement placement, Response response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(placement, "$placement");
        if (this$0.getVungleApiClient().getRetryAfterHeaderValue(placement.getReferenceId()) > 0) {
            this$0.onAdLoadFailed(new AdRetryError().setLogEntry$vungle_ads_release(this$0.getLogEntry()).logError$vungle_ads_release());
            return;
        }
        if (response != null && !response.isSuccessful()) {
            this$0.onAdLoadFailed(new APIFailedStatusCodeError("ads API: " + response.code()).setLogEntry$vungle_ads_release(this$0.getLogEntry()).logError$vungle_ads_release());
            return;
        }
        AdPayload adPayload = response != null ? (AdPayload) response.body() : null;
        if ((adPayload != null ? adPayload.adUnit() : null) == null) {
            this$0.onAdLoadFailed(new AdResponseEmptyError("Ad response is empty").setLogEntry$vungle_ads_release(this$0.getLogEntry()).logError$vungle_ads_release());
        } else {
            this$0.handleAdMetaData$vungle_ads_release(adPayload, new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.CONFIG_LOADED_FROM_AD_LOAD));
        }
    }

    @Override // com.vungle.ads.internal.network.Callback
    public void onFailure(Call<AdPayload> call, final Throwable t) {
        VungleThreadPoolExecutor background_executor = this.this$0.getSdkExecutors().getBACKGROUND_EXECUTOR();
        final DefaultAdLoader defaultAdLoader = this.this$0;
        background_executor.execute(new Runnable() { // from class: com.vungle.ads.internal.load.DefaultAdLoader$fetchAdMetadata$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DefaultAdLoader$fetchAdMetadata$1.m9352onFailure$lambda1(DefaultAdLoader.this, t);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onFailure$lambda-1, reason: not valid java name */
    public static final void m9352onFailure$lambda1(DefaultAdLoader this$0, Throwable th) {
        VungleError retrofitToVungleError;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        retrofitToVungleError = this$0.retrofitToVungleError(th);
        this$0.onAdLoadFailed(retrofitToVungleError.setLogEntry$vungle_ads_release(this$0.getLogEntry()).logError$vungle_ads_release());
    }
}
