package io.adn.sdk.internal.domain.handler;

import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.domain.error.AdExceptionKt;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntity;
import io.adn.sdk.internal.domain.model.ad.NativeAdMetadata;
import io.adn.sdk.internal.domain.usecase.LoadNativeAdAssetsUseCase;
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

/* compiled from: NativeAdHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.handler.NativeAdHandler$onAdMetadataLoaded$1", f = "NativeAdHandler.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class NativeAdHandler$onAdMetadataLoaded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NativeAdMetadata $nativeAdMetadata;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NativeAdHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NativeAdHandler$onAdMetadataLoaded$1(NativeAdHandler nativeAdHandler, NativeAdMetadata nativeAdMetadata, Continuation<? super NativeAdHandler$onAdMetadataLoaded$1> continuation) {
        super(2, continuation);
        this.this$0 = nativeAdHandler;
        this.$nativeAdMetadata = nativeAdMetadata;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NativeAdHandler$onAdMetadataLoaded$1 nativeAdHandler$onAdMetadataLoaded$1 = new NativeAdHandler$onAdMetadataLoaded$1(this.this$0, this.$nativeAdMetadata, continuation);
        nativeAdHandler$onAdMetadataLoaded$1.L$0 = obj;
        return nativeAdHandler$onAdMetadataLoaded$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NativeAdHandler$onAdMetadataLoaded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m10241constructorimpl;
        LoadNativeAdAssetsUseCase loadNativeAdAssetsUseCase;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NativeAdHandler nativeAdHandler = this.this$0;
                NativeAdMetadata nativeAdMetadata = this.$nativeAdMetadata;
                Result.Companion companion = Result.INSTANCE;
                loadNativeAdAssetsUseCase = nativeAdHandler.loadAdAssetsUseCase;
                this.label = 1;
                obj = loadNativeAdAssetsUseCase.invoke(nativeAdMetadata, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            m10241constructorimpl = Result.m10241constructorimpl((NativeAdEntity) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        NativeAdHandler nativeAdHandler2 = this.this$0;
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl == null) {
            nativeAdHandler2.onAdLoaded((NativeAdEntity) m10241constructorimpl);
        } else {
            Logger.INSTANCE.e("NativeAdHandler", m10244exceptionOrNullimpl);
            nativeAdHandler2.onAdLoadFailed(AdExceptionKt.toAdException(m10244exceptionOrNullimpl));
        }
        return Unit.INSTANCE;
    }
}
