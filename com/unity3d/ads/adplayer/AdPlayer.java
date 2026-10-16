package com.unity3d.ads.adplayer;

import com.ironsource.C3061e8;
import com.ironsource.C3207n2;
import com.unity3d.ads.adplayer.model.LoadEvent;
import com.unity3d.ads.core.data.model.OfferwallShowEvent;
import com.unity3d.ads.core.data.model.ScarEvent;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.services.ads.offerwall.OfferwallEvent;
import com.unity3d.services.banners.bridge.BannerBridge;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: AdPlayer.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 C2\u00020\u0001:\u0001CJ\u0011\u0010\u0018\u001a\u00020\u0019H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0019H&J\u0019\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H¦@ø\u0001\u0000¢\u0006\u0002\u0010#J)\u0010$\u001a\u00020\u00192\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&H¦@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0011\u0010(\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+H¦@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u0010-\u001a\u00020\u00192\u0006\u0010!\u001a\u00020.H¦@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0019\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020+H¦@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u00102\u001a\u00020\u00192\u0006\u0010!\u001a\u000203H¦@ø\u0001\u0000¢\u0006\u0002\u00104J\u0019\u00105\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0019\u00106\u001a\u00020\u00192\u0006\u0010!\u001a\u000207H¦@ø\u0001\u0000¢\u0006\u0002\u00108J\u0019\u00109\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0019\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020+H¦@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020>H¦@ø\u0001\u0000¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020BH\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006D"}, d2 = {"Lcom/unity3d/ads/adplayer/AdPlayer;", "", "onLoadEvent", "Lkotlinx/coroutines/flow/Flow;", "Lcom/unity3d/ads/adplayer/model/LoadEvent;", "getOnLoadEvent", "()Lkotlinx/coroutines/flow/Flow;", "onOfferwallEvent", "Lcom/unity3d/ads/core/data/model/OfferwallShowEvent;", "getOnOfferwallEvent", "onScarEvent", "Lcom/unity3d/ads/core/data/model/ScarEvent;", "getOnScarEvent", "onShowEvent", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "getOnShowEvent", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "webViewContainer", "Lcom/unity3d/ads/adplayer/WebViewContainer;", "getWebViewContainer", "()Lcom/unity3d/ads/adplayer/WebViewContainer;", "destroy", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchShowCompleted", "onAllowedPiiChange", "value", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBroadcastEvent", "event", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestShow", "unityAdsShowOptions", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendActivityDestroyed", "sendFocusChange", "isFocused", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendGmaEvent", "Lcom/unity3d/scar/adapter/common/GMAEvent;", "(Lcom/unity3d/scar/adapter/common/GMAEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMuteChange", "isMuted", "sendOfferwallEvent", "Lcom/unity3d/services/ads/offerwall/OfferwallEvent;", "(Lcom/unity3d/services/ads/offerwall/OfferwallEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPrivacyFsmChange", "sendScarBannerEvent", "Lcom/unity3d/services/banners/bridge/BannerBridge$BannerEvent;", "(Lcom/unity3d/services/banners/bridge/BannerBridge$BannerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendUserConsentChange", "sendVisibilityChange", C3061e8.k, "sendVolumeChange", "volume", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", C3207n2.v, "showOptions", "Lcom/unity3d/ads/adplayer/ShowOptions;", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface AdPlayer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int OFFERWALL_EVENT_QUEUE_SIZE = 5;
    public static final int SCAR_EVENT_QUEUE_SIZE = 10;

    Object destroy(Continuation<? super Unit> continuation);

    void dispatchShowCompleted();

    Flow<LoadEvent> getOnLoadEvent();

    Flow<OfferwallShowEvent> getOnOfferwallEvent();

    Flow<ScarEvent> getOnScarEvent();

    Flow<ShowEvent> getOnShowEvent();

    CoroutineScope getScope();

    WebViewContainer getWebViewContainer();

    Object onAllowedPiiChange(byte[] bArr, Continuation<? super Unit> continuation);

    Object onBroadcastEvent(String str, Continuation<? super Unit> continuation);

    Object requestShow(Map<String, ? extends Object> map, Continuation<? super Unit> continuation);

    Object sendActivityDestroyed(Continuation<? super Unit> continuation);

    Object sendFocusChange(boolean z, Continuation<? super Unit> continuation);

    Object sendGmaEvent(GMAEvent gMAEvent, Continuation<? super Unit> continuation);

    Object sendMuteChange(boolean z, Continuation<? super Unit> continuation);

    Object sendOfferwallEvent(OfferwallEvent offerwallEvent, Continuation<? super Unit> continuation);

    Object sendPrivacyFsmChange(byte[] bArr, Continuation<? super Unit> continuation);

    Object sendScarBannerEvent(BannerBridge.BannerEvent bannerEvent, Continuation<? super Unit> continuation);

    Object sendUserConsentChange(byte[] bArr, Continuation<? super Unit> continuation);

    Object sendVisibilityChange(boolean z, Continuation<? super Unit> continuation);

    Object sendVolumeChange(double d, Continuation<? super Unit> continuation);

    void show(ShowOptions showOptions);

    /* compiled from: AdPlayer.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void show(AdPlayer adPlayer, ShowOptions showOptions) {
            Intrinsics.checkNotNullParameter(showOptions, "showOptions");
            throw new NotImplementedError(null, 1, null);
        }

        public static Object destroy(AdPlayer adPlayer, Continuation<? super Unit> continuation) {
            CoroutineScopeKt.cancel$default(adPlayer.getScope(), null, 1, null);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AdPlayer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/unity3d/ads/adplayer/AdPlayer$Companion;", "", "()V", "OFFERWALL_EVENT_QUEUE_SIZE", "", "SCAR_EVENT_QUEUE_SIZE", "broadcastEventChannel", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getBroadcastEventChannel", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public static final int OFFERWALL_EVENT_QUEUE_SIZE = 5;
        public static final int SCAR_EVENT_QUEUE_SIZE = 10;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final MutableSharedFlow<String> broadcastEventChannel = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);

        private Companion() {
        }

        public final MutableSharedFlow<String> getBroadcastEventChannel() {
            return broadcastEventChannel;
        }
    }
}
