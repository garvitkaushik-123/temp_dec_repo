package com.unity3d.ads.core.domain.events;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: UniversalRequestEventSender.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.events.UniversalRequestEventSender", f = "UniversalRequestEventSender.kt", i = {0}, l = {21, 35}, m = "invoke", n = {"this"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class UniversalRequestEventSender$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UniversalRequestEventSender this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UniversalRequestEventSender$invoke$1(UniversalRequestEventSender universalRequestEventSender, Continuation<? super UniversalRequestEventSender$invoke$1> continuation) {
        super(continuation);
        this.this$0 = universalRequestEventSender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, null, this);
    }
}
