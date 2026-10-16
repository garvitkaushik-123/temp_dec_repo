package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetLatestWebViewConfiguration.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.GetLatestWebViewConfiguration", f = "GetLatestWebViewConfiguration.kt", i = {0, 0, 0, 0, 0, 1}, l = {17, 33}, m = "invoke", n = {"this", "receivedEntryPoint", "receivedVersion", "receivedAdditionalFiles", "receivedType", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0"})
/* loaded from: classes7.dex */
final class GetLatestWebViewConfiguration$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetLatestWebViewConfiguration this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetLatestWebViewConfiguration$invoke$1(GetLatestWebViewConfiguration getLatestWebViewConfiguration, Continuation<? super GetLatestWebViewConfiguration$invoke$1> continuation) {
        super(continuation);
        this.this$0 = getLatestWebViewConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, null, null, null, this);
    }
}
