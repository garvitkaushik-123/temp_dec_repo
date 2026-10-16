package com.unity3d.ads.core.domain;

import com.ironsource.C3040d4;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LegacyShowUseCase.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyShowUseCase", f = "LegacyShowUseCase.kt", i = {5, 5, 9}, l = {Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 129, 134, 142, 147, 153, 160, 165, 196}, m = "invoke", n = {"this", "opportunityIdByteString", C3040d4.v}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes7.dex */
final class LegacyShowUseCase$invoke$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LegacyShowUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LegacyShowUseCase$invoke$1(LegacyShowUseCase legacyShowUseCase, Continuation<? super LegacyShowUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = legacyShowUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, null, null, null, this);
    }
}
