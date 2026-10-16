package com.moloco.sdk.internal.unity_bridge;

import android.content.Context;
import com.ironsource.C3040d4;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.android_context.b;
import com.moloco.sdk.internal.unity_bridge.internal.a;
import com.moloco.sdk.publisher.Initialization;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.MolocoInitStatus;
import com.moloco.sdk.publisher.MolocoInitializationListener;
import com.moloco.sdk.publisher.init.MolocoInitParams;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/moloco/sdk/internal/unity_bridge/MolocoUnityPlugin;", "", "<init>", "()V", "", "appKey", "mediationName", "Lcom/moloco/sdk/internal/unity_bridge/MolocoUnityInitCallback;", "callback", "", "initializeSdk", "(Ljava/lang/String;Ljava/lang/String;Lcom/moloco/sdk/internal/unity_bridge/MolocoUnityInitCallback;)V", "mediation", "adUnitId", "bidResponse", "Lcom/moloco/sdk/internal/unity_bridge/MolocoUnityLoadCallback;", C3040d4.g.E, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/moloco/sdk/internal/unity_bridge/MolocoUnityLoadCallback;)V", "Lcom/moloco/sdk/internal/unity_bridge/MolocoUnityShowCallback;", C3040d4.g.H, "(Ljava/lang/String;Lcom/moloco/sdk/internal/unity_bridge/MolocoUnityShowCallback;)V", "callingMethod", "logUninitializedAccessError", "(Ljava/lang/String;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "initState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "context", "Lcom/moloco/sdk/internal/unity_bridge/internal/a;", "adManager$delegate", "getAdManager", "()Lcom/moloco/sdk/internal/unity_bridge/internal/a;", "adManager", "TAG", "Ljava/lang/String;", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class MolocoUnityPlugin {
    private static final String TAG = "MolocoUnityPlugin";
    public static final MolocoUnityPlugin INSTANCE = new MolocoUnityPlugin();
    private static final MutableStateFlow<Boolean> initState = StateFlowKt.MutableStateFlow(Boolean.FALSE);

    /* renamed from: context$delegate, reason: from kotlin metadata */
    private static final Lazy context = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.unity_bridge.MolocoUnityPlugin$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Context context_delegate$lambda$0;
            context_delegate$lambda$0 = MolocoUnityPlugin.context_delegate$lambda$0();
            return context_delegate$lambda$0;
        }
    });

    /* renamed from: adManager$delegate, reason: from kotlin metadata */
    private static final Lazy adManager = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.unity_bridge.MolocoUnityPlugin$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a adManager_delegate$lambda$1;
            adManager_delegate$lambda$1 = MolocoUnityPlugin.adManager_delegate$lambda$1();
            return adManager_delegate$lambda$1;
        }
    });
    public static final int $stable = 8;

    private MolocoUnityPlugin() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a adManager_delegate$lambda$1() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context context_delegate$lambda$0() {
        return b.a(null, 1, null);
    }

    private final a getAdManager() {
        return (a) adManager.getValue();
    }

    private final Context getContext() {
        return (Context) context.getValue();
    }

    @JvmStatic
    public static final void initializeSdk(final String appKey, final String mediationName, final MolocoUnityInitCallback callback) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(mediationName, "mediationName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Moloco.initialize(new MolocoInitParams(INSTANCE.getContext(), appKey, new MediationInfo(mediationName)), new MolocoInitializationListener() { // from class: com.moloco.sdk.internal.unity_bridge.MolocoUnityPlugin$$ExternalSyntheticLambda0
            @Override // com.moloco.sdk.publisher.MolocoInitializationListener
            public final void onMolocoInitializationStatus(MolocoInitStatus molocoInitStatus) {
                MolocoUnityPlugin.initializeSdk$lambda$3(appKey, mediationName, callback, molocoInitStatus);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeSdk$lambda$3(String str, String str2, MolocoUnityInitCallback molocoUnityInitCallback, MolocoInitStatus initStatus) {
        Intrinsics.checkNotNullParameter(initStatus, "initStatus");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, TAG, "initialized " + str + ' ' + str2 + ' ' + initStatus.getInitialization(), null, false, 12, null);
        boolean z = initStatus.getInitialization() == Initialization.SUCCESS;
        initState.setValue(Boolean.valueOf(z));
        molocoUnityInitCallback.onInitialized(z);
    }

    @JvmStatic
    public static final void loadInterstitial(String mediation, String adUnitId, String bidResponse, MolocoUnityLoadCallback callback) {
        Intrinsics.checkNotNullParameter(mediation, "mediation");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(bidResponse, "bidResponse");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (initState.getValue().booleanValue()) {
            INSTANCE.getAdManager().a(StringsKt.trim((CharSequence) mediation).toString(), StringsKt.trim((CharSequence) adUnitId).toString(), bidResponse, callback);
        } else {
            INSTANCE.logUninitializedAccessError(C3040d4.g.E);
        }
    }

    private final void logUninitializedAccessError(String callingMethod) {
        MolocoLogger.error$default(MolocoLogger.INSTANCE, TAG, "ERROR: Failed to execute " + callingMethod + "() - please ensure the Moloco Unity Plugin has been initialized by calling 'MolocoSdk.InitializeSdk();'!", null, false, 12, null);
    }

    @JvmStatic
    public static final void showInterstitial(String adUnitId, MolocoUnityShowCallback callback) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (initState.getValue().booleanValue()) {
            INSTANCE.getAdManager().a(StringsKt.trim((CharSequence) adUnitId).toString(), callback);
        } else {
            INSTANCE.logUninitializedAccessError(C3040d4.g.H);
        }
    }
}
