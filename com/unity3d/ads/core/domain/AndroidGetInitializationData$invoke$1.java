package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidGetInitializationData.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidGetInitializationData", f = "AndroidGetInitializationData.kt", i = {0, 0}, l = {10, 11}, m = "invoke", n = {"this", "$this$invoke_u24lambda_u240"}, s = {"L$0", "L$2"})
/* loaded from: classes7.dex */
final class AndroidGetInitializationData$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidGetInitializationData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidGetInitializationData$invoke$1(AndroidGetInitializationData androidGetInitializationData, Continuation<? super AndroidGetInitializationData$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidGetInitializationData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
