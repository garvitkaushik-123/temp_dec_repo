package com.unity3d.ads.core.data.manager;

import com.unity3d.ads.core.extensions.AdFormatExtensions;
import com.unity3d.services.ads.gmascar.GMAScarAdapterBridge;
import com.unity3d.services.ads.gmascar.handlers.BiddingSignalsHandler;
import com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidScarManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/services/ads/gmascar/models/BiddingSignals;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$getSignals$2", f = "AndroidScarManager.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidScarManager$getSignals$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BiddingSignals>, Object> {
    final /* synthetic */ List<InitializationResponseOuterClass.AdFormat> $adFormat;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AndroidScarManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AndroidScarManager$getSignals$2(List<? extends InitializationResponseOuterClass.AdFormat> list, AndroidScarManager androidScarManager, Continuation<? super AndroidScarManager$getSignals$2> continuation) {
        super(2, continuation);
        this.$adFormat = list;
        this.this$0 = androidScarManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidScarManager$getSignals$2(this.$adFormat, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BiddingSignals> continuation) {
        return ((AndroidScarManager$getSignals$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        GMAScarAdapterBridge gMAScarAdapterBridge;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        List<InitializationResponseOuterClass.AdFormat> list = this.$adFormat;
        AndroidScarManager androidScarManager = this.this$0;
        this.L$0 = list;
        this.L$1 = androidScarManager;
        this.label = 1;
        AndroidScarManager$getSignals$2 androidScarManager$getSignals$2 = this;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(androidScarManager$getSignals$2), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (list != null) {
            List<InitializationResponseOuterClass.AdFormat> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(AdFormatExtensions.toUnityAdFormat((InitializationResponseOuterClass.AdFormat) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        gMAScarAdapterBridge = androidScarManager.gmaBridge;
        gMAScarAdapterBridge.getSCARBiddingSignals(arrayList, new BiddingSignalsHandler(true, new IBiddingSignalsListener() { // from class: com.unity3d.ads.core.data.manager.AndroidScarManager$getSignals$2$1$1
            @Override // com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener
            public void onSignalsReady(BiddingSignals signals) {
                CancellableContinuation<BiddingSignals> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m10241constructorimpl(signals));
            }

            @Override // com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener
            public void onSignalsFailure(String msg) {
                CancellableContinuation<BiddingSignals> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(new Exception(msg))));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(androidScarManager$getSignals$2);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
