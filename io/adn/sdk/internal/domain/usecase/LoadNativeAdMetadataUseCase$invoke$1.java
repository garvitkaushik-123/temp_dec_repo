package io.adn.sdk.internal.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LoadNativeAdMetadataUseCase.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.LoadNativeAdMetadataUseCase", f = "LoadNativeAdMetadataUseCase.kt", i = {}, l = {13}, m = "invoke", n = {}, s = {})
/* loaded from: classes7.dex */
final class LoadNativeAdMetadataUseCase$invoke$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadNativeAdMetadataUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoadNativeAdMetadataUseCase$invoke$1(LoadNativeAdMetadataUseCase loadNativeAdMetadataUseCase, Continuation<? super LoadNativeAdMetadataUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = loadNativeAdMetadataUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}
