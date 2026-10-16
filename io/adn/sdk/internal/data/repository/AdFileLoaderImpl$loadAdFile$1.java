package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AdFileLoaderImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.AdFileLoaderImpl", f = "AdFileLoaderImpl.kt", i = {}, l = {40}, m = "loadAdFile-0E7RQCE", n = {}, s = {})
/* loaded from: classes7.dex */
final class AdFileLoaderImpl$loadAdFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdFileLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdFileLoaderImpl$loadAdFile$1(AdFileLoaderImpl adFileLoaderImpl, Continuation<? super AdFileLoaderImpl$loadAdFile$1> continuation) {
        super(continuation);
        this.this$0 = adFileLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo9478loadAdFile0E7RQCE = this.this$0.mo9478loadAdFile0E7RQCE(null, null, this);
        return mo9478loadAdFile0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo9478loadAdFile0E7RQCE : Result.m10240boximpl(mo9478loadAdFile0E7RQCE);
    }
}
