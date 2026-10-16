package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AdFileLoaderImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.AdFileLoaderImpl", f = "AdFileLoaderImpl.kt", i = {0, 0, 0, 0}, l = {92}, m = "downloadAndCacheFile-BWLJW6A", n = {"url", "destinationFile", "contentType", "tempFile"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes7.dex */
final class AdFileLoaderImpl$downloadAndCacheFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdFileLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdFileLoaderImpl$downloadAndCacheFile$1(AdFileLoaderImpl adFileLoaderImpl, Continuation<? super AdFileLoaderImpl$downloadAndCacheFile$1> continuation) {
        super(continuation);
        this.this$0 = adFileLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9476downloadAndCacheFileBWLJW6A;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m9476downloadAndCacheFileBWLJW6A = this.this$0.m9476downloadAndCacheFileBWLJW6A(null, null, null, this);
        return m9476downloadAndCacheFileBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9476downloadAndCacheFileBWLJW6A : Result.m10240boximpl(m9476downloadAndCacheFileBWLJW6A);
    }
}
