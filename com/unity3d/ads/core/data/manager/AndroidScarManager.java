package com.unity3d.ads.core.data.manager;

import android.content.Context;
import com.ironsource.C3207n2;
import com.ironsource.L2;
import com.unity3d.ads.core.data.model.exception.LoadException;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.scar.CommonScarEventReceiver;
import com.unity3d.ads.core.domain.scar.GmaEventData;
import com.unity3d.ads.core.domain.scar.ScarTimeHackFixer;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;
import com.unity3d.services.ads.gmascar.GMAScarAdapterBridge;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.di.ServiceProvider;
import com.vungle.ads.internal.protos.Sdk;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: AndroidScarManager.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011JA\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ6\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0010H\u0016J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/unity3d/ads/core/data/manager/AndroidScarManager;", "Lcom/unity3d/ads/core/data/manager/ScarManager;", "scarEventReceiver", "Lcom/unity3d/ads/core/domain/scar/CommonScarEventReceiver;", "gmaBridge", "Lcom/unity3d/services/ads/gmascar/GMAScarAdapterBridge;", "scarTimeHackFixer", "Lcom/unity3d/ads/core/domain/scar/ScarTimeHackFixer;", "(Lcom/unity3d/ads/core/domain/scar/CommonScarEventReceiver;Lcom/unity3d/services/ads/gmascar/GMAScarAdapterBridge;Lcom/unity3d/ads/core/domain/scar/ScarTimeHackFixer;)V", "getSignals", "Lcom/unity3d/services/ads/gmascar/models/BiddingSignals;", "adFormat", "", "Lgatewayprotocol/v1/InitializationResponseOuterClass$AdFormat;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVersion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAd", "", "placementId", HandleInvocationsFromAdViewer.KEY_AD_STRING, "adUnitId", HandleInvocationsFromAdViewer.KEY_QUERY_ID, "videoLength", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBannerAd", "Lkotlinx/coroutines/flow/Flow;", "Lcom/unity3d/ads/core/domain/scar/GmaEventData;", "context", "Landroid/content/Context;", "bannerView", "Lcom/unity3d/services/banners/BannerView;", "scarAdMetadata", "Lcom/unity3d/scar/adapter/common/scarads/ScarAdMetadata;", L2.u, "Lcom/unity3d/services/banners/UnityBannerSize;", "opportunityId", C3207n2.v, "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidScarManager implements ScarManager {
    private final GMAScarAdapterBridge gmaBridge;
    private final CommonScarEventReceiver scarEventReceiver;
    private final ScarTimeHackFixer scarTimeHackFixer;

    public AndroidScarManager(CommonScarEventReceiver scarEventReceiver, GMAScarAdapterBridge gmaBridge, ScarTimeHackFixer scarTimeHackFixer) {
        Intrinsics.checkNotNullParameter(scarEventReceiver, "scarEventReceiver");
        Intrinsics.checkNotNullParameter(gmaBridge, "gmaBridge");
        Intrinsics.checkNotNullParameter(scarTimeHackFixer, "scarTimeHackFixer");
        this.scarEventReceiver = scarEventReceiver;
        this.gmaBridge = gmaBridge;
        this.scarTimeHackFixer = scarTimeHackFixer;
    }

    @Override // com.unity3d.ads.core.data.manager.ScarManager
    public Object getVersion(Continuation<? super String> continuation) {
        return TimeoutKt.withTimeoutOrNull(5000L, new AndroidScarManager$getVersion$2(this, null), continuation);
    }

    @Override // com.unity3d.ads.core.data.manager.ScarManager
    public Object getSignals(List<? extends InitializationResponseOuterClass.AdFormat> list, Continuation<? super BiddingSignals> continuation) {
        return TimeoutKt.withTimeoutOrNull(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT, new AndroidScarManager$getSignals$2(list, this, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.unity3d.ads.core.data.manager.ScarManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadAd(String str, String str2, String str3, String str4, String str5, int i, Continuation<? super Unit> continuation) {
        AndroidScarManager$loadAd$1 androidScarManager$loadAd$1;
        int i2;
        GmaEventData gmaEventData;
        if (continuation instanceof AndroidScarManager$loadAd$1) {
            androidScarManager$loadAd$1 = (AndroidScarManager$loadAd$1) continuation;
            if ((androidScarManager$loadAd$1.label & Integer.MIN_VALUE) != 0) {
                androidScarManager$loadAd$1.label -= Integer.MIN_VALUE;
                AndroidScarManager$loadAd$1 androidScarManager$loadAd$12 = androidScarManager$loadAd$1;
                Object obj = androidScarManager$loadAd$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = androidScarManager$loadAd$12.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    SharedFlow onSubscription = FlowKt.onSubscription(this.scarEventReceiver.getGmaEventFlow(), new AndroidScarManager$loadAd$2(this, StringsKt.equals(str, UnityAdFormat.INTERSTITIAL.toString(), true), str2, str5, str3, str4, i, null));
                    AndroidScarManager$loadAd$3 androidScarManager$loadAd$3 = new AndroidScarManager$loadAd$3(str2, null);
                    androidScarManager$loadAd$12.label = 1;
                    obj = FlowKt.first(onSubscription, androidScarManager$loadAd$3, androidScarManager$loadAd$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                gmaEventData = (GmaEventData) (((GmaEventData) obj).getGmaEvent() != GMAEvent.AD_LOADED ? obj : null);
                if (gmaEventData == null) {
                    StringBuilder sb = new StringBuilder("Error loading SCAR ad: ");
                    Object errorMessage = gmaEventData.getErrorMessage();
                    if (errorMessage == null) {
                        errorMessage = gmaEventData.getGmaEvent();
                    }
                    throw new LoadException(0, sb.append(errorMessage).toString());
                }
                return Unit.INSTANCE;
            }
        }
        androidScarManager$loadAd$1 = new AndroidScarManager$loadAd$1(this, continuation);
        AndroidScarManager$loadAd$1 androidScarManager$loadAd$122 = androidScarManager$loadAd$1;
        Object obj2 = androidScarManager$loadAd$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = androidScarManager$loadAd$122.label;
        if (i2 != 0) {
        }
        gmaEventData = (GmaEventData) (((GmaEventData) obj2).getGmaEvent() != GMAEvent.AD_LOADED ? obj2 : null);
        if (gmaEventData == null) {
        }
    }

    @Override // com.unity3d.ads.core.data.manager.ScarManager
    public Flow<GmaEventData> loadBannerAd(Context context, BannerView bannerView, ScarAdMetadata scarAdMetadata, UnityBannerSize bannerSize, final String opportunityId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bannerView, "bannerView");
        Intrinsics.checkNotNullParameter(scarAdMetadata, "scarAdMetadata");
        Intrinsics.checkNotNullParameter(bannerSize, "bannerSize");
        Intrinsics.checkNotNullParameter(opportunityId, "opportunityId");
        final Flow onStart = FlowKt.onStart(this.scarEventReceiver.getGmaEventFlow(), new AndroidScarManager$loadBannerAd$1(this, context, bannerView, opportunityId, scarAdMetadata, bannerSize, null));
        return new Flow<GmaEventData>() { // from class: com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ String $opportunityId$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1$2", f = "AndroidScarManager.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                /* renamed from: com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$$inlined$filter$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, String str) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$opportunityId$inlined = str;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                GmaEventData gmaEventData = (GmaEventData) obj;
                                if (gmaEventData.getGmaEvent() == GMAEvent.BANNER && Intrinsics.areEqual(gmaEventData.getOpportunityId(), this.$opportunityId$inlined)) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super GmaEventData> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, opportunityId), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    @Override // com.unity3d.ads.core.data.manager.ScarManager
    public Flow<GmaEventData> show(String placementId, String queryId) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        return FlowKt.transformWhile(FlowKt.onSubscription(this.scarEventReceiver.getGmaEventFlow(), new AndroidScarManager$show$1(this, placementId, queryId, null)), new AndroidScarManager$show$2(null));
    }
}
