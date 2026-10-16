package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidGetUniversalRequestForPayLoad.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidGetUniversalRequestForPayLoad", f = "AndroidGetUniversalRequestForPayLoad.kt", i = {0, 0}, l = {14}, m = "invoke", n = {"payload", "$this$invoke_u24lambda_u240"}, s = {"L$0", "L$2"})
/* loaded from: classes7.dex */
final class AndroidGetUniversalRequestForPayLoad$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidGetUniversalRequestForPayLoad this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidGetUniversalRequestForPayLoad$invoke$1(AndroidGetUniversalRequestForPayLoad androidGetUniversalRequestForPayLoad, Continuation<? super AndroidGetUniversalRequestForPayLoad$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidGetUniversalRequestForPayLoad;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}
