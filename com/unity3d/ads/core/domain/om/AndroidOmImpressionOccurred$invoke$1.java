package com.unity3d.ads.core.domain.om;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidOmImpressionOccurred.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.om.AndroidOmImpressionOccurred", f = "AndroidOmImpressionOccurred.kt", i = {0, 0}, l = {15}, m = "invoke", n = {"this", "adObject"}, s = {"L$0", "L$1"})
/* loaded from: classes7.dex */
final class AndroidOmImpressionOccurred$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidOmImpressionOccurred this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidOmImpressionOccurred$invoke$1(AndroidOmImpressionOccurred androidOmImpressionOccurred, Continuation<? super AndroidOmImpressionOccurred$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidOmImpressionOccurred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, false, this);
    }
}
