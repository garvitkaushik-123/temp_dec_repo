package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastLoader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.VastLoaderImpl", f = "VastLoader.kt", i = {0, 0, 1}, l = {44, 45}, m = "invoke", n = {"this", "$this$invoke_u24lambda_u240", "this"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes7.dex */
final class VastLoaderImpl$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VastLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VastLoaderImpl$invoke$1(VastLoaderImpl vastLoaderImpl, Continuation<? super VastLoaderImpl$invoke$1> continuation) {
        super(continuation);
        this.this$0 = vastLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}
