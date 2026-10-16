package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AdFileLoaderImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.AdFileLoaderImpl", f = "AdFileLoaderImpl.kt", i = {}, l = {78}, m = "getOrDownloadAdFile-0E7RQCE", n = {}, s = {})
/* loaded from: classes7.dex */
final class AdFileLoaderImpl$getOrDownloadAdFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdFileLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdFileLoaderImpl$getOrDownloadAdFile$1(AdFileLoaderImpl adFileLoaderImpl, Continuation<? super AdFileLoaderImpl$getOrDownloadAdFile$1> continuation) {
        super(continuation);
        this.this$0 = adFileLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9477getOrDownloadAdFile0E7RQCE;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m9477getOrDownloadAdFile0E7RQCE = this.this$0.m9477getOrDownloadAdFile0E7RQCE(null, null, this);
        return m9477getOrDownloadAdFile0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9477getOrDownloadAdFile0E7RQCE : Result.m10240boximpl(m9477getOrDownloadAdFile0E7RQCE);
    }
}
