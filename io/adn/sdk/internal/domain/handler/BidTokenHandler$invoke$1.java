package io.adn.sdk.internal.domain.handler;

import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.data.utils.BidTokenUtilsKt;
import io.adn.sdk.internal.di.DependencyInjectorKt;
import io.adn.sdk.internal.di.modules.SdkModule;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.management.SdkInitializer;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.AdnBidTokenCallback;
import io.adn.sdk.publisher.AdnInitializationStatus;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BidTokenHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.handler.BidTokenHandler$invoke$1", f = "BidTokenHandler.kt", i = {}, l = {28, 30}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class BidTokenHandler$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BidTokenHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BidTokenHandler$invoke$1(BidTokenHandler bidTokenHandler, Continuation<? super BidTokenHandler$invoke$1> continuation) {
        super(2, continuation);
        this.this$0 = bidTokenHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BidTokenHandler$invoke$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BidTokenHandler$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        if (r5 == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        if (r5 == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SdkInitializer sdkInitializer;
        AdnBidTokenCallback adnBidTokenCallback;
        AdnAdPlacement adnAdPlacement;
        Object m9506invokeIoAF18A;
        AdnBidTokenCallback adnBidTokenCallback2;
        AdnBidTokenCallback adnBidTokenCallback3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sdkInitializer = this.this$0.sdkInitializer;
            this.label = 1;
            obj = sdkInitializer.awaitInitializationComplete(this);
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                m9506invokeIoAF18A = ((Result) obj).getValue();
                BidTokenHandler bidTokenHandler = this.this$0;
                Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m9506invokeIoAF18A);
                if (m10244exceptionOrNullimpl == null) {
                    adnBidTokenCallback3 = bidTokenHandler.callback;
                    adnBidTokenCallback3.onComplete((String) m9506invokeIoAF18A);
                } else {
                    Logger.INSTANCE.e("BidTokenHandler", m10244exceptionOrNullimpl);
                    adnBidTokenCallback2 = bidTokenHandler.callback;
                    adnBidTokenCallback2.onComplete(BidTokenUtilsKt.bidTokenError(m10244exceptionOrNullimpl));
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((AdnInitializationStatus) obj) != AdnInitializationStatus.INITIALIZED_SUCCESS) {
            adnBidTokenCallback = this.this$0.callback;
            adnBidTokenCallback.onComplete(BidTokenUtilsKt.bidTokenError(AdError.SdkInitError));
            return Unit.INSTANCE;
        }
        SdkModule sdkComponents = DependencyInjectorKt.sdkComponents();
        adnAdPlacement = this.this$0.placement;
        this.label = 2;
        m9506invokeIoAF18A = sdkComponents.getBidTokenUseCase(adnAdPlacement).m9506invokeIoAF18A(this);
    }
}
