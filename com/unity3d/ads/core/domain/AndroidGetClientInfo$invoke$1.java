package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidGetClientInfo.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidGetClientInfo", f = "AndroidGetClientInfo.kt", i = {0, 0, 1, 1}, l = {40, 43}, m = "invoke", n = {"this", "$this$invoke_u24lambda_u245", "this", "$this$invoke_u24lambda_u245"}, s = {"L$0", "L$2", "L$0", "L$2"})
/* loaded from: classes7.dex */
final class AndroidGetClientInfo$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidGetClientInfo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidGetClientInfo$invoke$1(AndroidGetClientInfo androidGetClientInfo, Continuation<? super AndroidGetClientInfo$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidGetClientInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
