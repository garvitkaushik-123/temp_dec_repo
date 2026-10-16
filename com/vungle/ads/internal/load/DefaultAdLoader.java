package com.vungle.ads.internal.load;

import android.content.Context;
import com.ironsource.C3040d4;
import com.vungle.ads.AdRetryActiveError;
import com.vungle.ads.NetworkTimeoutError;
import com.vungle.ads.NetworkUnreachable;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.util.PathProvider;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultAdLoader.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002¨\u0006\u001d"}, d2 = {"Lcom/vungle/ads/internal/load/DefaultAdLoader;", "Lcom/vungle/ads/internal/load/BaseAdLoader;", "context", "Landroid/content/Context;", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "sdkExecutors", "Lcom/vungle/ads/internal/executor/Executors;", "omInjector", "Lcom/vungle/ads/internal/omsdk/OMInjector;", "downloader", "Lcom/vungle/ads/internal/downloader/Downloader;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "adRequest", "Lcom/vungle/ads/internal/load/AdRequest;", "(Landroid/content/Context;Lcom/vungle/ads/internal/network/VungleApiClient;Lcom/vungle/ads/internal/executor/Executors;Lcom/vungle/ads/internal/omsdk/OMInjector;Lcom/vungle/ads/internal/downloader/Downloader;Lcom/vungle/ads/internal/util/PathProvider;Lcom/vungle/ads/internal/load/AdRequest;)V", "fetchAdMetadata", "", C3040d4.h.O, "Lcom/vungle/ads/VungleAdSize;", "placement", "Lcom/vungle/ads/internal/model/Placement;", "onAdLoadReady", "requestAd", "retrofitToVungleError", "Lcom/vungle/ads/VungleError;", "throwable", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class DefaultAdLoader extends BaseAdLoader {
    @Override // com.vungle.ads.internal.load.BaseAdLoader
    public void onAdLoadReady() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultAdLoader(Context context, VungleApiClient vungleApiClient, Executors sdkExecutors, OMInjector omInjector, Downloader downloader, PathProvider pathProvider, AdRequest adRequest) {
        super(context, vungleApiClient, sdkExecutors, omInjector, downloader, pathProvider, adRequest);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vungleApiClient, "vungleApiClient");
        Intrinsics.checkNotNullParameter(sdkExecutors, "sdkExecutors");
        Intrinsics.checkNotNullParameter(omInjector, "omInjector");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
    }

    @Override // com.vungle.ads.internal.load.BaseAdLoader
    protected void requestAd() {
        fetchAdMetadata(getAdRequest().getRequestAdSize(), getAdRequest().getPlacement());
    }

    private final void fetchAdMetadata(VungleAdSize adSize, Placement placement) {
        if (getVungleApiClient().checkIsRetryAfterActive(placement.getReferenceId())) {
            onAdLoadFailed(new AdRetryActiveError().setLogEntry$vungle_ads_release(getLogEntry()).logError$vungle_ads_release());
            return;
        }
        Call<AdPayload> requestAd = getVungleApiClient().requestAd(placement.getReferenceId(), adSize);
        if (requestAd == null) {
            onAdLoadFailed(new NetworkUnreachable("adsCall is null").setLogEntry$vungle_ads_release(getLogEntry()).logError$vungle_ads_release());
        } else {
            requestAd.enqueue(new DefaultAdLoader$fetchAdMetadata$1(this, placement));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VungleError retrofitToVungleError(Throwable throwable) {
        if (throwable instanceof SocketTimeoutException) {
            return new NetworkTimeoutError();
        }
        return new NetworkUnreachable("ads request fail: " + (throwable != null ? throwable.getMessage() : null));
    }
}
