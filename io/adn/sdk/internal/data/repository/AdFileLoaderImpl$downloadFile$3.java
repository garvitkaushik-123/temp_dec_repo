package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AdFileLoaderImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.AdFileLoaderImpl", f = "AdFileLoaderImpl.kt", i = {0}, l = {114, 115, 116}, m = "downloadFile", n = {"destinationFile"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class AdFileLoaderImpl$downloadFile$3 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdFileLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdFileLoaderImpl$downloadFile$3(AdFileLoaderImpl adFileLoaderImpl, Continuation<? super AdFileLoaderImpl$downloadFile$3> continuation) {
        super(continuation);
        this.this$0 = adFileLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object downloadFile;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        downloadFile = this.this$0.downloadFile(null, null, this);
        return downloadFile;
    }
}
