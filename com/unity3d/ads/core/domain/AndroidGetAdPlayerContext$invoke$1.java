package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidGetAdPlayerContext.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidGetAdPlayerContext", f = "AndroidGetAdPlayerContext.kt", i = {0}, l = {15}, m = "invoke", n = {"this"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class AndroidGetAdPlayerContext$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidGetAdPlayerContext this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidGetAdPlayerContext$invoke$1(AndroidGetAdPlayerContext androidGetAdPlayerContext, Continuation<? super AndroidGetAdPlayerContext$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidGetAdPlayerContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
