package io.adn.sdk.internal.domain.management;

import io.adn.sdk.publisher.AdnInitializationStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: SdkInitializer.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lio/adn/sdk/publisher/AdnInitializationStatus;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.management.SdkInitializer$awaitInitializationComplete$2", f = "SdkInitializer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class SdkInitializer$awaitInitializationComplete$2 extends SuspendLambda implements Function2<AdnInitializationStatus, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    SdkInitializer$awaitInitializationComplete$2(Continuation<? super SdkInitializer$awaitInitializationComplete$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SdkInitializer$awaitInitializationComplete$2 sdkInitializer$awaitInitializationComplete$2 = new SdkInitializer$awaitInitializationComplete$2(continuation);
        sdkInitializer$awaitInitializationComplete$2.L$0 = obj;
        return sdkInitializer$awaitInitializationComplete$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AdnInitializationStatus adnInitializationStatus, Continuation<? super Boolean> continuation) {
        return ((SdkInitializer$awaitInitializationComplete$2) create(adnInitializationStatus, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        AdnInitializationStatus adnInitializationStatus = (AdnInitializationStatus) this.L$0;
        return Boxing.boxBoolean(adnInitializationStatus == AdnInitializationStatus.INITIALIZED_FAILURE || adnInitializationStatus == AdnInitializationStatus.INITIALIZED_SUCCESS);
    }
}
