package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LegacyLoadUseCase.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase", f = "LegacyLoadUseCase.kt", i = {0, 0, 0}, l = {98}, m = "invoke", n = {"this", "placement", "opportunityId"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes7.dex */
final class LegacyLoadUseCase$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LegacyLoadUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LegacyLoadUseCase$invoke$1(LegacyLoadUseCase legacyLoadUseCase, Continuation<? super LegacyLoadUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = legacyLoadUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, null, null, null, null, this);
    }
}
