package io.adn.sdk.internal.data.api.remote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RemoteDataSource.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.api.remote.RemoteDataSource", f = "RemoteDataSource.kt", i = {}, l = {86, 43}, m = "loadAdContent", n = {}, s = {})
/* loaded from: classes7.dex */
final class RemoteDataSource$loadAdContent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteDataSource$loadAdContent$1(RemoteDataSource remoteDataSource, Continuation<? super RemoteDataSource$loadAdContent$1> continuation) {
        super(continuation);
        this.this$0 = remoteDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadAdContent(null, this);
    }
}
