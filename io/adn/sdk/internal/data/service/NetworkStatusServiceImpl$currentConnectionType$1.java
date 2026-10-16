package io.adn.sdk.internal.data.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: NetworkStatusService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.service.NetworkStatusServiceImpl", f = "NetworkStatusService.kt", i = {}, l = {45}, m = "currentConnectionType", n = {}, s = {})
/* loaded from: classes7.dex */
final class NetworkStatusServiceImpl$currentConnectionType$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkStatusServiceImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkStatusServiceImpl$currentConnectionType$1(NetworkStatusServiceImpl networkStatusServiceImpl, Continuation<? super NetworkStatusServiceImpl$currentConnectionType$1> continuation) {
        super(continuation);
        this.this$0 = networkStatusServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.currentConnectionType(this);
    }
}
