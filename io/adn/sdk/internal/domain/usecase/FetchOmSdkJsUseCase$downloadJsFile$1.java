package io.adn.sdk.internal.domain.usecase;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FetchOmSdkJsUseCase.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.FetchOmSdkJsUseCase", f = "FetchOmSdkJsUseCase.kt", i = {0, 0}, l = {26}, m = "downloadJsFile-gIAlu-s", n = {"this", "url"}, s = {"L$0", "L$1"})
/* loaded from: classes7.dex */
final class FetchOmSdkJsUseCase$downloadJsFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FetchOmSdkJsUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FetchOmSdkJsUseCase$downloadJsFile$1(FetchOmSdkJsUseCase fetchOmSdkJsUseCase, Continuation<? super FetchOmSdkJsUseCase$downloadJsFile$1> continuation) {
        super(continuation);
        this.this$0 = fetchOmSdkJsUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9505downloadJsFilegIAlus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m9505downloadJsFilegIAlus = this.this$0.m9505downloadJsFilegIAlus(null, this);
        return m9505downloadJsFilegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9505downloadJsFilegIAlus : Result.m10240boximpl(m9505downloadJsFilegIAlus);
    }
}
