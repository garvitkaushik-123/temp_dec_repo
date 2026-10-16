package com.unity3d.ads.adplayer;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import androidx.core.view.ViewCompat;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.ironsource.C3061e8;
import com.ironsource.C3207n2;
import com.unity3d.ads.adplayer.model.LoadEvent;
import com.unity3d.ads.core.data.datasource.LifecycleDataSource;
import com.unity3d.ads.core.data.manager.ScarManager;
import com.unity3d.ads.core.data.model.OfferwallShowEvent;
import com.unity3d.ads.core.data.model.ScarEvent;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.ads.offerwall.OfferwallEvent;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.BannerViewCache;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.banners.bridge.BannerBridge;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;

/* compiled from: AndroidEmbeddableWebViewAdPlayer.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0011\u0010$\u001a\u00020%H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\t\u0010'\u001a\u00020%H\u0096\u0001J\u0019\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010+J\u0019\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020\u0006H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010.J)\u0010/\u001a\u00020%2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101H\u0096Aø\u0001\u0000¢\u0006\u0002\u00103J\u0011\u00104\u001a\u00020%H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u00105\u001a\u00020%2\u0006\u00106\u001a\u000207H\u0096Aø\u0001\u0000¢\u0006\u0002\u00108J\u0019\u00109\u001a\u00020%2\u0006\u0010-\u001a\u00020:H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010;J\u0019\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u000207H\u0096Aø\u0001\u0000¢\u0006\u0002\u00108J\u0019\u0010>\u001a\u00020%2\u0006\u0010-\u001a\u00020?H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010@J\u0019\u0010A\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010+J\u0019\u0010B\u001a\u00020%2\u0006\u0010-\u001a\u00020CH\u0096Aø\u0001\u0000¢\u0006\u0002\u0010DJ\u0019\u0010E\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010+J\u0019\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u000207H\u0096Aø\u0001\u0000¢\u0006\u0002\u00108J\u0019\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020JH\u0096Aø\u0001\u0000¢\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020NH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006O"}, d2 = {"Lcom/unity3d/ads/adplayer/AndroidEmbeddableWebViewAdPlayer;", "Lcom/unity3d/ads/adplayer/AdPlayer;", "Lcom/unity3d/ads/adplayer/EmbeddableAdPlayer;", "webViewAdPlayer", "Lcom/unity3d/ads/adplayer/WebViewAdPlayer;", "opportunityId", "", "webViewContainer", "Lcom/unity3d/ads/adplayer/AndroidWebViewContainer;", "openMeasurementRepository", "Lcom/unity3d/ads/core/data/repository/OpenMeasurementRepository;", "scarManager", "Lcom/unity3d/ads/core/data/manager/ScarManager;", "lifecycleDataSource", "Lcom/unity3d/ads/core/data/datasource/LifecycleDataSource;", "(Lcom/unity3d/ads/adplayer/WebViewAdPlayer;Ljava/lang/String;Lcom/unity3d/ads/adplayer/AndroidWebViewContainer;Lcom/unity3d/ads/core/data/repository/OpenMeasurementRepository;Lcom/unity3d/ads/core/data/manager/ScarManager;Lcom/unity3d/ads/core/data/datasource/LifecycleDataSource;)V", "onLoadEvent", "Lkotlinx/coroutines/flow/Flow;", "Lcom/unity3d/ads/adplayer/model/LoadEvent;", "getOnLoadEvent", "()Lkotlinx/coroutines/flow/Flow;", "onOfferwallEvent", "Lcom/unity3d/ads/core/data/model/OfferwallShowEvent;", "getOnOfferwallEvent", "onScarEvent", "Lcom/unity3d/ads/core/data/model/ScarEvent;", "getOnScarEvent", "onShowEvent", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "getOnShowEvent", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getWebViewContainer", "()Lcom/unity3d/ads/adplayer/AndroidWebViewContainer;", "destroy", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchShowCompleted", "onAllowedPiiChange", "value", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBroadcastEvent", "event", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestShow", "unityAdsShowOptions", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendActivityDestroyed", "sendFocusChange", "isFocused", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendGmaEvent", "Lcom/unity3d/scar/adapter/common/GMAEvent;", "(Lcom/unity3d/scar/adapter/common/GMAEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMuteChange", "isMuted", "sendOfferwallEvent", "Lcom/unity3d/services/ads/offerwall/OfferwallEvent;", "(Lcom/unity3d/services/ads/offerwall/OfferwallEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPrivacyFsmChange", "sendScarBannerEvent", "Lcom/unity3d/services/banners/bridge/BannerBridge$BannerEvent;", "(Lcom/unity3d/services/banners/bridge/BannerBridge$BannerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendUserConsentChange", "sendVisibilityChange", C3061e8.k, "sendVolumeChange", "volume", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", C3207n2.v, "showOptions", "Lcom/unity3d/ads/adplayer/ShowOptions;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AndroidEmbeddableWebViewAdPlayer implements AdPlayer, EmbeddableAdPlayer {
    private final LifecycleDataSource lifecycleDataSource;
    private final OpenMeasurementRepository openMeasurementRepository;
    private final String opportunityId;
    private final ScarManager scarManager;
    private final WebViewAdPlayer webViewAdPlayer;
    private final AndroidWebViewContainer webViewContainer;

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void dispatchShowCompleted() {
        this.webViewAdPlayer.dispatchShowCompleted();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Flow<LoadEvent> getOnLoadEvent() {
        return this.webViewAdPlayer.getOnLoadEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Flow<OfferwallShowEvent> getOnOfferwallEvent() {
        return this.webViewAdPlayer.getOnOfferwallEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Flow<ScarEvent> getOnScarEvent() {
        return this.webViewAdPlayer.getOnScarEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Flow<ShowEvent> getOnShowEvent() {
        return this.webViewAdPlayer.getOnShowEvent();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public CoroutineScope getScope() {
        return this.webViewAdPlayer.getScope();
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object onAllowedPiiChange(byte[] bArr, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.onAllowedPiiChange(bArr, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object onBroadcastEvent(String str, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.onBroadcastEvent(str, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object requestShow(Map<String, ? extends Object> map, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.requestShow(map, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendActivityDestroyed(Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendActivityDestroyed(continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendFocusChange(boolean z, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendFocusChange(z, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendGmaEvent(GMAEvent gMAEvent, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendGmaEvent(gMAEvent, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendMuteChange(boolean z, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendMuteChange(z, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendOfferwallEvent(OfferwallEvent offerwallEvent, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendOfferwallEvent(offerwallEvent, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendPrivacyFsmChange(byte[] bArr, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendPrivacyFsmChange(bArr, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendScarBannerEvent(BannerBridge.BannerEvent bannerEvent, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendScarBannerEvent(bannerEvent, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendUserConsentChange(byte[] bArr, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendUserConsentChange(bArr, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendVisibilityChange(boolean z, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendVisibilityChange(z, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendVolumeChange(double d, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendVolumeChange(d, continuation);
    }

    public AndroidEmbeddableWebViewAdPlayer(WebViewAdPlayer webViewAdPlayer, String opportunityId, AndroidWebViewContainer webViewContainer, OpenMeasurementRepository openMeasurementRepository, ScarManager scarManager, LifecycleDataSource lifecycleDataSource) {
        Intrinsics.checkNotNullParameter(webViewAdPlayer, "webViewAdPlayer");
        Intrinsics.checkNotNullParameter(opportunityId, "opportunityId");
        Intrinsics.checkNotNullParameter(webViewContainer, "webViewContainer");
        Intrinsics.checkNotNullParameter(openMeasurementRepository, "openMeasurementRepository");
        Intrinsics.checkNotNullParameter(scarManager, "scarManager");
        Intrinsics.checkNotNullParameter(lifecycleDataSource, "lifecycleDataSource");
        this.webViewAdPlayer = webViewAdPlayer;
        this.opportunityId = opportunityId;
        this.webViewContainer = webViewContainer;
        this.openMeasurementRepository = openMeasurementRepository;
        this.scarManager = scarManager;
        this.lifecycleDataSource = lifecycleDataSource;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public AndroidWebViewContainer getWebViewContainer() {
        return this.webViewContainer;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void show(final ShowOptions showOptions) {
        String str;
        Intrinsics.checkNotNullParameter(showOptions, "showOptions");
        if (!(showOptions instanceof AndroidShowOptions)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        AndroidShowOptions androidShowOptions = (AndroidShowOptions) showOptions;
        Activity activity = androidShowOptions.getActivity().get();
        if (activity == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        BannerViewCache bannerViewCache = BannerViewCache.getInstance();
        final BannerView bannerView = bannerViewCache.getBannerView(this.opportunityId);
        if (bannerView == null) {
            if (bannerViewCache.isBannerViewDeleted(this.opportunityId)) {
                str = "BannerView has been deleted";
            } else {
                str = "BannerView not found";
            }
            throw new IllegalStateException(str.toString());
        }
        if (!androidShowOptions.isScarAd()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AndroidEmbeddableWebViewAdPlayer$show$2(this, activity, bannerView, null), 3, null);
            final WebView webView = getWebViewContainer().getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                BuildersKt__Builders_commonKt.launch$default(this.webViewAdPlayer.getScope(), null, null, new AndroidEmbeddableWebViewAdPlayer$show$3$1(this, showOptions, null), 3, null);
                if (!ViewCompat.isAttachedToWindow(webView)) {
                    BuildersKt__Builders_commonKt.launch$default(this.webViewAdPlayer.getScope(), null, null, new AndroidEmbeddableWebViewAdPlayer$show$3$2$1(this, null), 3, null);
                } else {
                    webView.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$show$lambda$4$$inlined$doOnDetach$1(webView, this));
                }
            } else {
                webView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$$inlined$doOnAttach$2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        Intrinsics.checkNotNullParameter(view, "view");
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        Intrinsics.checkNotNullParameter(view, "view");
                        webView.removeOnAttachStateChangeListener(this);
                        BuildersKt__Builders_commonKt.launch$default(this.webViewAdPlayer.getScope(), null, null, new AndroidEmbeddableWebViewAdPlayer$show$3$1(this, showOptions, null), 3, null);
                        if (!ViewCompat.isAttachedToWindow(view)) {
                            BuildersKt__Builders_commonKt.launch$default(this.webViewAdPlayer.getScope(), null, null, new AndroidEmbeddableWebViewAdPlayer$show$3$2$1(this, null), 3, null);
                        } else {
                            view.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$show$lambda$4$$inlined$doOnDetach$1(view, this));
                        }
                    }
                });
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AndroidEmbeddableWebViewAdPlayer$show$4(bannerView, this, null), 3, null);
            return;
        }
        String placementId = androidShowOptions.getPlacementId();
        if (placementId == null) {
            placementId = "";
        }
        String scarQueryId = androidShowOptions.getScarQueryId();
        if (scarQueryId == null) {
            scarQueryId = "";
        }
        String scarAdUnitId = androidShowOptions.getScarAdUnitId();
        if (scarAdUnitId == null) {
            scarAdUnitId = "";
        }
        String scarAdString = androidShowOptions.getScarAdString();
        ScarAdMetadata scarAdMetadata = new ScarAdMetadata(placementId, scarQueryId, scarAdUnitId, scarAdString == null ? "" : scarAdString, 0);
        UnityBannerSize size = bannerView.getSize();
        Intrinsics.checkNotNullExpressionValue(size, "bannerView.size");
        final SharedFlow shareIn = FlowKt.shareIn(this.scarManager.loadBannerAd(activity, bannerView, scarAdMetadata, size, this.opportunityId), getScope(), SharingStarted.INSTANCE.getEagerly(), 10);
        final BannerView bannerView2 = bannerView;
        if (ViewCompat.isAttachedToWindow(bannerView2)) {
            BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new AndroidEmbeddableWebViewAdPlayer$show$1$1(this, shareIn, showOptions, null), 3, null);
            if (!ViewCompat.isAttachedToWindow(bannerView2)) {
                BuildersKt__Builders_commonKt.launch$default(this.webViewAdPlayer.getScope(), null, null, new AndroidEmbeddableWebViewAdPlayer$show$1$2$1(this, null), 3, null);
                return;
            } else {
                bannerView2.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1(bannerView2, this));
                return;
            }
        }
        bannerView2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$$inlined$doOnAttach$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                bannerView2.removeOnAttachStateChangeListener(this);
                BuildersKt__Builders_commonKt.launch$default(this.getScope(), null, null, new AndroidEmbeddableWebViewAdPlayer$show$1$1(this, shareIn, showOptions, null), 3, null);
                BannerView bannerView3 = bannerView;
                if (!ViewCompat.isAttachedToWindow(bannerView3)) {
                    BuildersKt__Builders_commonKt.launch$default(this.webViewAdPlayer.getScope(), null, null, new AndroidEmbeddableWebViewAdPlayer$show$1$2$1(this, null), 3, null);
                } else {
                    bannerView3.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1(bannerView3, this));
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0084, code lost:
    
        if (com.unity3d.ads.adplayer.AdPlayer.DefaultImpls.destroy(r2, r0) == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0086, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        if (r8.destroy(r0) != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(1000, r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.unity3d.ads.adplayer.AdPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object destroy(Continuation<? super Unit> continuation) {
        AndroidEmbeddableWebViewAdPlayer$destroy$1 androidEmbeddableWebViewAdPlayer$destroy$1;
        int i;
        AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer;
        if (continuation instanceof AndroidEmbeddableWebViewAdPlayer$destroy$1) {
            androidEmbeddableWebViewAdPlayer$destroy$1 = (AndroidEmbeddableWebViewAdPlayer$destroy$1) continuation;
            if ((androidEmbeddableWebViewAdPlayer$destroy$1.label & Integer.MIN_VALUE) != 0) {
                androidEmbeddableWebViewAdPlayer$destroy$1.label -= Integer.MIN_VALUE;
                Object obj = androidEmbeddableWebViewAdPlayer$destroy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidEmbeddableWebViewAdPlayer$destroy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    this.webViewAdPlayer.dispatchShowCompleted();
                    if (this.openMeasurementRepository.hasSessionFinished(ByteStringsKt.toByteStringUtf8(this.opportunityId))) {
                        androidEmbeddableWebViewAdPlayer$destroy$1.L$0 = this;
                        androidEmbeddableWebViewAdPlayer$destroy$1.label = 1;
                    }
                    androidEmbeddableWebViewAdPlayer = this;
                } else if (i == 1) {
                    androidEmbeddableWebViewAdPlayer = (AndroidEmbeddableWebViewAdPlayer) androidEmbeddableWebViewAdPlayer$destroy$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    androidEmbeddableWebViewAdPlayer = (AndroidEmbeddableWebViewAdPlayer) androidEmbeddableWebViewAdPlayer$destroy$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    androidEmbeddableWebViewAdPlayer$destroy$1.L$0 = null;
                    androidEmbeddableWebViewAdPlayer$destroy$1.label = 3;
                }
                AndroidWebViewContainer webViewContainer = androidEmbeddableWebViewAdPlayer.getWebViewContainer();
                androidEmbeddableWebViewAdPlayer$destroy$1.L$0 = androidEmbeddableWebViewAdPlayer;
                androidEmbeddableWebViewAdPlayer$destroy$1.label = 2;
            }
        }
        androidEmbeddableWebViewAdPlayer$destroy$1 = new AndroidEmbeddableWebViewAdPlayer$destroy$1(this, continuation);
        Object obj2 = androidEmbeddableWebViewAdPlayer$destroy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidEmbeddableWebViewAdPlayer$destroy$1.label;
        if (i != 0) {
        }
        AndroidWebViewContainer webViewContainer2 = androidEmbeddableWebViewAdPlayer.getWebViewContainer();
        androidEmbeddableWebViewAdPlayer$destroy$1.L$0 = androidEmbeddableWebViewAdPlayer;
        androidEmbeddableWebViewAdPlayer$destroy$1.label = 2;
    }
}
