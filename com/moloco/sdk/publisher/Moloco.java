package com.moloco.sdk.publisher;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.InitConfig;
import com.moloco.sdk.acm.UpdateConfig;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.publisher.C3428b;
import com.moloco.sdk.internal.publisher.C3429c;
import com.moloco.sdk.internal.publisher.v;
import com.moloco.sdk.internal.publisher.w;
import com.moloco.sdk.internal.scheduling.b;
import com.moloco.sdk.internal.scheduling.c;
import com.moloco.sdk.internal.services.bidtoken.h;
import com.moloco.sdk.internal.services.bidtoken.i;
import com.moloco.sdk.internal.services.bidtoken.n;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.init.MolocoInitParams;
import com.moloco.sdk.service_locator.a;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013Jk\u0010 \u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`\u001eH\u0007¢\u0006\u0004\b \u0010!Jk\u0010\"\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`\u001eH\u0007¢\u0006\u0004\b\"\u0010!Jk\u0010#\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`\u001eH\u0007¢\u0006\u0004\b#\u0010!Jk\u0010'\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`&H\u0007¢\u0006\u0004\b'\u0010!Jk\u0010+\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010(¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b()\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`*H\u0007¢\u0006\u0004\b+\u0010!Jk\u0010/\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010,¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(-\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`.H\u0007¢\u0006\u0004\b/\u0010!J\u0017\u00102\u001a\u00020\b2\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\bH\u0082@¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0004H\u0002¢\u0006\u0004\b7\u0010\fJ\u000f\u00108\u001a\u00020\bH\u0002¢\u0006\u0004\b8\u0010\u0003J\u0010\u0010:\u001a\u00020\bH\u0081@¢\u0006\u0004\b9\u00105R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010=\u001a\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010=\u001a\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR*\u0010O\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bO\u0010P\u0012\u0004\bU\u0010\u0003\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR*\u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b6\u0010V\u0012\u0004\bZ\u0010\u0003\u001a\u0004\bW\u0010X\"\u0004\bY\u0010\fR\u001a\u0010\\\u001a\u00020[8FX\u0087\u0004¢\u0006\f\u0012\u0004\b^\u0010\u0003\u001a\u0004\b\\\u0010]R\u001c\u0010b\u001a\u0004\u0018\u00010\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010\u0003\u001a\u0004\b_\u0010`R\u0016\u0010d\u001a\u0004\u0018\u00010\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bc\u0010`¨\u0006e"}, d2 = {"Lcom/moloco/sdk/publisher/Moloco;", "", "<init>", "()V", "Lcom/moloco/sdk/publisher/init/MolocoInitParams;", "initParam", "Lcom/moloco/sdk/publisher/MolocoInitializationListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", MobileAdsBridgeBase.initializeMethodName, "(Lcom/moloco/sdk/publisher/init/MolocoInitParams;Lcom/moloco/sdk/publisher/MolocoInitializationListener;)V", "logMolocoInfo", "(Lcom/moloco/sdk/publisher/init/MolocoInitParams;)V", "Lcom/moloco/sdk/publisher/MediationInfo;", "mediationInfo", "Landroid/content/Context;", "context", "Lcom/moloco/sdk/publisher/MolocoBidTokenListener;", "getBidToken", "(Lcom/moloco/sdk/publisher/MediationInfo;Landroid/content/Context;Lcom/moloco/sdk/publisher/MolocoBidTokenListener;)V", "", "adUnitId", "watermarkString", "Lkotlin/Function2;", "Lcom/moloco/sdk/publisher/Banner;", "Lkotlin/ParameterName;", "name", "banner", "Lcom/moloco/sdk/publisher/MolocoAdError$AdCreateError;", "error", "Lcom/moloco/sdk/publisher/CreateBannerCallback;", "callback", "createBanner", "(Lcom/moloco/sdk/publisher/MediationInfo;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "createBannerTablet", "createMREC", "Lcom/moloco/sdk/publisher/NativeAd;", "nativeAd", "Lcom/moloco/sdk/publisher/CreateNativeAdCallback;", "createNativeAd", "Lcom/moloco/sdk/publisher/InterstitialAd;", "interstitialAd", "Lcom/moloco/sdk/publisher/CreateInterstitialAdCallback;", "createInterstitial", "Lcom/moloco/sdk/publisher/RewardedInterstitialAd;", "rewardedInterstitialAd", "Lcom/moloco/sdk/publisher/CreateRewardedInterstitialAdCallback;", "createRewardedInterstitial", "Lcom/moloco/sdk/Init$SDKInitResponse;", "sdkInitResponse", "processInitConfigs", "(Lcom/moloco/sdk/Init$SDKInitResponse;)V", "updateAndroidClientMetricsOnInitSuccess", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initParams", "initializeAndroidClientMetrics", "initializeILRD", "clearState$moloco_sdk_release", "clearState", "Lcom/moloco/sdk/internal/publisher/v;", "initializationHandler$delegate", "Lkotlin/Lazy;", "getInitializationHandler", "()Lcom/moloco/sdk/internal/publisher/v;", "initializationHandler", "Lcom/moloco/sdk/internal/services/bidtoken/h;", "bidTokenHandler$delegate", "getBidTokenHandler", "()Lcom/moloco/sdk/internal/services/bidtoken/h;", "bidTokenHandler", "Lcom/moloco/sdk/internal/publisher/b;", "adCreator$delegate", "getAdCreator", "()Lcom/moloco/sdk/internal/publisher/b;", "adCreator", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "initJob", "Lkotlinx/coroutines/Job;", "getInitJob", "()Lkotlinx/coroutines/Job;", "setInitJob", "(Lkotlinx/coroutines/Job;)V", "getInitJob$annotations", "Lcom/moloco/sdk/publisher/init/MolocoInitParams;", "getInitParams", "()Lcom/moloco/sdk/publisher/init/MolocoInitParams;", "setInitParams", "getInitParams$annotations", "", "isInitialized", "()Z", "isInitialized$annotations", "getBidRequestEndpoint", "()Ljava/lang/String;", "getBidRequestEndpoint$annotations", "bidRequestEndpoint", "getAppKey$moloco_sdk_release", "appKey", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class Moloco {
    private static Job initJob;
    private static MolocoInitParams initParams;
    public static final Moloco INSTANCE = new Moloco();

    /* renamed from: initializationHandler$delegate, reason: from kotlin metadata */
    private static final Lazy initializationHandler = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.publisher.Moloco$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            v initializationHandler_delegate$lambda$4;
            initializationHandler_delegate$lambda$4 = Moloco.initializationHandler_delegate$lambda$4();
            return initializationHandler_delegate$lambda$4;
        }
    });

    /* renamed from: bidTokenHandler$delegate, reason: from kotlin metadata */
    private static final Lazy bidTokenHandler = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.publisher.Moloco$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            i bidTokenHandler_delegate$lambda$5;
            bidTokenHandler_delegate$lambda$5 = Moloco.bidTokenHandler_delegate$lambda$5();
            return bidTokenHandler_delegate$lambda$5;
        }
    });

    /* renamed from: adCreator$delegate, reason: from kotlin metadata */
    private static final Lazy adCreator = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.publisher.Moloco$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            C3428b adCreator_delegate$lambda$6;
            adCreator_delegate$lambda$6 = Moloco.adCreator_delegate$lambda$6();
            return adCreator_delegate$lambda$6;
        }
    });
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(b.a().getMain());
    public static final int $stable = 8;

    private Moloco() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C3428b adCreator_delegate$lambda$6() {
        return new C3428b(INSTANCE.getInitializationHandler().d(), a.h.f5756a.h(), new C3429c(null, 0L, 3, null), new Moloco$adCreator$2$1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i bidTokenHandler_delegate$lambda$5() {
        return new i(n.a(), INSTANCE.getInitializationHandler(), a.h.f5756a.h());
    }

    @JvmStatic
    public static final void createBanner(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new Moloco$createBanner$1(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createBanner$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createBanner(mediationInfo, str, str2, function2);
    }

    @JvmStatic
    public static final void createBannerTablet(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner tablet async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new Moloco$createBannerTablet$1(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createBannerTablet$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createBannerTablet(mediationInfo, str, str2, function2);
    }

    @JvmStatic
    public static final void createInterstitial(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super InterstitialAd, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating interstitial ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new Moloco$createInterstitial$1(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createInterstitial$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createInterstitial(mediationInfo, str, str2, function2);
    }

    @JvmStatic
    public static final void createMREC(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner MREC async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new Moloco$createMREC$1(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createMREC$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createMREC(mediationInfo, str, str2, function2);
    }

    @JvmStatic
    public static final void createNativeAd(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super NativeAd, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating native ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new Moloco$createNativeAd$1(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createNativeAd$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createNativeAd(mediationInfo, str, str2, function2);
    }

    @JvmStatic
    public static final void createRewardedInterstitial(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super RewardedInterstitialAd, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating rewarded ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new Moloco$createRewardedInterstitial$1(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createRewardedInterstitial$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createRewardedInterstitial(mediationInfo, str, str2, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3428b getAdCreator() {
        return (C3428b) adCreator.getValue();
    }

    public static final String getBidRequestEndpoint() {
        String adServerUrl;
        Init.SDKInitResponse e = INSTANCE.getInitializationHandler().e();
        if (e == null || (adServerUrl = e.getAdServerUrl()) == null) {
            return null;
        }
        return (StringsKt.startsWith$default(adServerUrl, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(adServerUrl, "https://", false, 2, (Object) null)) ? adServerUrl : "https://" + adServerUrl;
    }

    @JvmStatic
    public static /* synthetic */ void getBidRequestEndpoint$annotations() {
    }

    @JvmStatic
    public static final void getBidToken(MediationInfo mediationInfo, Context context, MolocoBidTokenListener listener) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.moloco.sdk.internal.android_context.b.a(context);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Fetching bid token", null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(c.f5599a.b(), null, null, new Moloco$getBidToken$1(MetricsRecorder.INSTANCE.create(mediationInfo.getName()), listener, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h getBidTokenHandler() {
        return (h) bidTokenHandler.getValue();
    }

    public static /* synthetic */ void getInitJob$annotations() {
    }

    public static /* synthetic */ void getInitParams$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final v getInitializationHandler() {
        return (v) initializationHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v initializationHandler_delegate$lambda$4() {
        return new v(a.h.f5756a.h());
    }

    @JvmStatic
    public static final void initialize(MolocoInitParams initParam) {
        Intrinsics.checkNotNullParameter(initParam, "initParam");
        initialize$default(initParam, null, 2, null);
    }

    public static /* synthetic */ void initialize$default(MolocoInitParams molocoInitParams, MolocoInitializationListener molocoInitializationListener, int i, Object obj) {
        if ((i & 2) != 0) {
            molocoInitializationListener = null;
        }
        initialize(molocoInitParams, molocoInitializationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeAndroidClientMetrics(MolocoInitParams initParams2) {
        if (!getInitializationHandler().c()) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "Moloco", "ACM cannot be initialized as Moloco SDK cannot be initialized", null, false, 12, null);
            return;
        }
        com.moloco.sdk.internal.configs.a c = com.moloco.sdk.internal.configs.b.c();
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        String appKey = initParams2.getAppKey();
        String d = c.d();
        Context appContext = initParams2.getAppContext();
        long c2 = c.c();
        Pair pair = TuplesKt.to(com.moloco.sdk.acm.b.e, initParams2.getAppKey());
        a.e eVar = a.e.f5753a;
        AndroidClientMetrics.initialize$default(androidClientMetrics, new InitConfig(appKey, d, appContext, c2, MapsKt.mapOf(pair, TuplesKt.to(com.moloco.sdk.acm.b.f, eVar.h().invoke().b()), TuplesKt.to(com.moloco.sdk.acm.b.g, eVar.h().invoke().c()), TuplesKt.to(com.moloco.sdk.acm.b.h, BuildConfig.SDK_VERSION_NAME), TuplesKt.to(com.moloco.sdk.acm.b.d, eVar.l().invoke().w()), TuplesKt.to("osv", eVar.l().invoke().x()))), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeILRD() {
        Init.SDKInitResponse e = getInitializationHandler().e();
        if (e == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "Moloco", "ILRD cannot be initialized as Moloco SDK is not initialized", null, false, 12, null);
            return;
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a.b.f5750a.g().b(e));
        if (m10244exceptionOrNullimpl != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "ILRD initialization failed. " + m10244exceptionOrNullimpl.getMessage(), null, false, 12, null);
        }
    }

    public static final boolean isInitialized() {
        return INSTANCE.getInitializationHandler().d().getValue() == Initialization.SUCCESS;
    }

    @JvmStatic
    public static /* synthetic */ void isInitialized$annotations() {
    }

    private final void logMolocoInfo(MolocoInitParams initParam) {
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, "Moloco", "=====================================", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "Moloco SDK initializing", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "SDK Version: 4.0.0", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "Mediation: " + initParam.getMediationInfo().getName(), null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "isInitialized: " + isInitialized(), null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "=====================================", null, false, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processInitConfigs(Init.SDKInitResponse sdkInitResponse) {
        if (sdkInitResponse.hasEventCollectionConfig()) {
            Init.SDKInitResponse.EventCollectionConfig eventCollectionConfig = sdkInitResponse.getEventCollectionConfig();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.debug$default(molocoLogger, "Moloco", "Init response has eventCollectionConfig", false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "eventCollectionConfig:", false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "eventCollectionEnabled: " + eventCollectionConfig.getEventCollectionEnabled(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "mrefCollectionEnabled: " + eventCollectionConfig.getMrefCollectionEnabled(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "appFgUrl: " + eventCollectionConfig.getAppForegroundTrackingUrl(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "appBgUrl: " + eventCollectionConfig.getAppBackgroundTrackingUrl(), false, 4, null);
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c c = a.k.f5759a.c();
            boolean eventCollectionEnabled = eventCollectionConfig.getEventCollectionEnabled();
            boolean mrefCollectionEnabled = eventCollectionConfig.getMrefCollectionEnabled();
            String appForegroundTrackingUrl = eventCollectionConfig.getAppForegroundTrackingUrl();
            Intrinsics.checkNotNullExpressionValue(appForegroundTrackingUrl, "getAppForegroundTrackingUrl(...)");
            String appBackgroundTrackingUrl = eventCollectionConfig.getAppBackgroundTrackingUrl();
            Intrinsics.checkNotNullExpressionValue(appBackgroundTrackingUrl, "getAppBackgroundTrackingUrl(...)");
            c.a(eventCollectionEnabled, mrefCollectionEnabled, appForegroundTrackingUrl, appBackgroundTrackingUrl);
            if (eventCollectionConfig.getEventCollectionEnabled()) {
                a.b.f5750a.e().a();
            }
        } else {
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, "Moloco", "Init response does not have eventCollectionConfig", false, 4, null);
        }
        a.c.f5751a.b().a(sdkInitResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateAndroidClientMetricsOnInitSuccess(Continuation<? super Unit> continuation) {
        Object updateConfig = AndroidClientMetrics.INSTANCE.updateConfig(new UpdateConfig(((com.moloco.sdk.internal.configs.a) a.c.f5751a.b().a(com.moloco.sdk.internal.configs.a.class, com.moloco.sdk.internal.configs.b.c())).d(), Boxing.boxLong(r0.c())), continuation);
        return updateConfig == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateConfig : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
    
        if (r13.b(r0) != r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        if (kotlinx.coroutines.JobKt.cancelAndJoin(r13, r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearState$moloco_sdk_release(Continuation<? super Unit> continuation) {
        Moloco$clearState$1 moloco$clearState$1;
        int i;
        Moloco moloco;
        if (continuation instanceof Moloco$clearState$1) {
            moloco$clearState$1 = (Moloco$clearState$1) continuation;
            int i2 = moloco$clearState$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                moloco$clearState$1.label = i2 - Integer.MIN_VALUE;
                Object obj = moloco$clearState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = moloco$clearState$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MolocoLogger.debug$default(MolocoLogger.INSTANCE, "Moloco", "clearState() unit testing function called", false, 4, null);
                    initParams = null;
                    Job job = initJob;
                    if (job != null) {
                        moloco$clearState$1.L$0 = this;
                        moloco$clearState$1.label = 1;
                    }
                    moloco = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    moloco = (Moloco) moloco$clearState$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                initJob = null;
                v initializationHandler2 = moloco.getInitializationHandler();
                moloco$clearState$1.L$0 = null;
                moloco$clearState$1.label = 2;
            }
        }
        moloco$clearState$1 = new Moloco$clearState$1(this, continuation);
        Object obj2 = moloco$clearState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = moloco$clearState$1.label;
        if (i != 0) {
        }
        initJob = null;
        v initializationHandler22 = moloco.getInitializationHandler();
        moloco$clearState$1.L$0 = null;
        moloco$clearState$1.label = 2;
    }

    public final String getAppKey$moloco_sdk_release() {
        MolocoInitParams molocoInitParams = initParams;
        if (molocoInitParams != null) {
            return molocoInitParams.getAppKey();
        }
        return null;
    }

    public final Job getInitJob() {
        return initJob;
    }

    public final MolocoInitParams getInitParams() {
        return initParams;
    }

    public final void setInitJob(Job job) {
        initJob = job;
    }

    public final void setInitParams(MolocoInitParams molocoInitParams) {
        initParams = molocoInitParams;
    }

    @JvmStatic
    public static final synchronized void initialize(MolocoInitParams initParam, MolocoInitializationListener listener) {
        Job launch$default;
        synchronized (Moloco.class) {
            Intrinsics.checkNotNullParameter(initParam, "initParam");
            Moloco moloco = INSTANCE;
            moloco.logMolocoInfo(initParam);
            if (initParam.getAppKey().length() == 0) {
                throw new IllegalArgumentException("Moloco SDK initialized with empty appKey");
            }
            if (isInitialized()) {
                if (Intrinsics.areEqual(initParam.getAppKey(), moloco.getAppKey$moloco_sdk_release())) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Already initialized. Returning and notifying listener", null, false, 12, null);
                    if (listener != null) {
                        w.a(listener, v.f.a());
                    }
                } else {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Already initialized but with different appKey. Returning error and notifying listener", null, false, 12, null);
                    if (listener != null) {
                        w.a(listener, v.f.a(v.k));
                    }
                }
                return;
            }
            Job job = initJob;
            if (job == null || !job.isActive()) {
                initParams = initParam;
                com.moloco.sdk.internal.android_context.b.a(initParam.getAppContext());
                launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(b.a().getIo()), null, null, new Moloco$initialize$1(initParam, listener, null), 3, null);
                initJob = launch$default;
                return;
            }
            String appKey = initParam.getAppKey();
            MolocoInitParams molocoInitParams = initParams;
            if (Intrinsics.areEqual(appKey, molocoInitParams != null ? molocoInitParams.getAppKey() : null)) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Init Job active with same appKey. Returning", null, false, 12, null);
            } else {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Init Job active with different appKey. Notifying listener and avoiding init", null, false, 12, null);
                if (listener != null) {
                    w.a(listener, v.f.a(v.k));
                }
            }
        }
    }
}
